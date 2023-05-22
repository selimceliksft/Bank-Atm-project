package com.model;
import java.sql.Time;
import java.util.Objects;
import java.util.Scanner;


public class ATM {

	private final Bank bank;
	private final int limitTimeForOperation;
	private int totalFundInATM; //t
	private int maxWithdrawalPerDay; //k
	private int maxWithdrawalPerTransaction; //m
	private int minCashInATM; //n

	public ATM(Bank bank, int limitTimeForOperation, int totalFundInATM, int maxWithdrawalPerDay, int maxWithdrawalPerTransaction, int minCashInATM){
		if(limitTimeForOperation < 30000){
			throw new IllegalArgumentException("limit time too short.");
		}else if(limitTimeForOperation > 90000){
			throw new IllegalArgumentException("limit time too long.");
		}else if(totalFundInATM < 10000){
			throw new IllegalArgumentException("ATM cannot start with this amount of money.");
		}else if(maxWithdrawalPerDay > 2000){
			throw new IllegalArgumentException("too much amount for withdrawal per day.");
		}else if(maxWithdrawalPerDay < 500){
			throw new IllegalArgumentException("not enough amount for withdrawal per day");
		}else if(maxWithdrawalPerTransaction > 1000){
			throw new IllegalArgumentException("too much amount for withdrawal per day");
		} else {
			this.bank = bank;
			this.limitTimeForOperation = limitTimeForOperation;
			this.totalFundInATM = totalFundInATM;
			this.maxWithdrawalPerDay = maxWithdrawalPerDay;
			this.maxWithdrawalPerTransaction = maxWithdrawalPerTransaction;
			this.minCashInATM = minCashInATM;
		}
	}

	public  void atmStarting(ATM atm) {
		//initializing the atm
		Log log = new Log();
		Scanner keyboard =  new Scanner(System.in); //initialized because of the absence of sensors.
		CardReader cardReader = new CardReader(atm, keyboard);
		ReceiptPrinter receiptPrinter = new ReceiptPrinter();
		CashDispenser cashDispenser = new CashDispenser(log);
		OperatorPanel operatorPanel = new OperatorPanel(atm);
		Display screen = new Display();
		TicketMachine ticketMachine = new TicketMachine();
		DatabaseProxy databaseProxy = new DatabaseProxy();
		//NetworkToBank networkToBank = new NetworkToBank(log, null); hasn't written yet. ####
		String[] menu = {"1:Change password", "2:Transfer money to another account", "3:Get inquiry", "4:Withdraw money", "5:Deposit money", "6:Eject card"};
		Money initialCash = operatorPanel.getInitialCash(totalFundInATM);
		ticketMachine.resetTicketMachine();

		//starting service
		while(true){//main body of program
			if(initialCash.getAmount() < maxWithdrawalPerDay || initialCash.getAmount() < minCashInATM){//shut down atm if money is not enough.
				screen.display(new Message("endOfTheDay").getContent());
				break;
			}
			Message message = new Message("idle");
			screen.display(message.getContent());
			log.logSend(message);
			keyboard.next();
			screen.display("ticket number: " + ticketMachine.getNumber());
			Card card = cardReader.readCard(bank);
			if(card == null){
				screen.display("card is not valid. Ejected.");
				screen.wait(5000);
				continue;
			}
			log.logSerialNumber(card.getNumber());
			Session session = new Session();
			log = new Log(session);
			boolean retain = false;
			boolean result = false;
			while(!result){ //check how many times user has to reach correct password.
				message = new Message("askpsw");
				int psw = screen.readPIN(message.getContent());
				result = atm.verify(psw, card.getAccountNumber(), bank);
				if(!result){
					screen.display(new Message("wrngpsw").getContent());
					screen.wait(5000);
					card.wrongPasswordEntered();
				}else{
					card.correctPasswordEntered();
					break;
				}
				if(card.getWrongPasswordCounter() == 3){
					cardReader.retainCard();
					retain = true;
					break;
				}
			}
			if(retain){
				continue;
			}
			message = new Message("menu");
			int choice;
			try {
				choice = screen.readMenuChoice(message.getContent(), menu);
			}catch (IllegalArgumentException e){
				screen.display(e.getMessage());
				screen.wait(5000);
				continue;
			}
			log.logSend(message);
			switch(choice){
				case 1:
					//change password
					result = atm.changePassword(screen, bank, card.getAccountNumber());
					Receipt receipt = new Receipt(result);	
					receiptPrinter.printReceipt(receipt);
					cardReader.ejectCard();
					session.SessionEnd();
					break;
				case 2:
					//if the user s chooses transfer
					InterfaceOfTransfer transfer = new Transfer(atm, session, card);
					message = transfer.getSpecificsFromCustomer();
					log.logSend(message);
					int to = screen.readAccount(message.getContent());
					message = transfer.getSpecificsFromCustomer2();
					Money amount;
					try {
						amount = screen.readAmount(message.getContent());
					}catch (IllegalArgumentException e){
						screen.display(e.getMessage());
						screen.wait(5000);
						continue;
					}
					receipt = transfer.completeTransaction(to, amount, bank);
					receiptPrinter.printReceipt(receipt);
					bank.saveTransaction(transfer); //save transaction to Bank
					cardReader.ejectCard();
					session.SessionEnd();
					break;
				case 3: //
					// if the users chooses inquiry
					InterfaceOfInquiry inquiry  = new Inquiry(atm, session, card);
					message = inquiry.getSpecificsFromCustomer();
					log.logSend(message);
					choice = screen.readChoice(message.getContent());
					receipt  = inquiry.completeTransaction(choice, bank, screen);
					receiptPrinter.printReceipt(receipt);
					bank.saveTransaction(inquiry);
					cardReader.ejectCard();
					session.SessionEnd();
					break;
				case 4:
					//if the users chooses withdrawal
					InterfaceOfDepositWithdraw withdrawal = new Withdrawal(atm, session, card);
					message = withdrawal.getSpecificsFromCustomer();
					try {
						amount = screen.readAmount(message.getContent());
						if(amount.getAmount() > maxWithdrawalPerTransaction){
							screen.display(new Message("tooMuchWithdraw").getContent());
							screen.wait(5000);
							continue;
						}
					}catch (IllegalArgumentException e){
						screen.display(e.getMessage());
						screen.wait(5000);
						continue;
					}
					log.logSend(message);
					if(cashDispenser.checkCashOnHand(initialCash, amount)){
						receipt = withdrawal.completeTransaction(amount, bank);
						cardReader.ejectCard();
						cashDispenser.dispenseCash(amount);
						cashDispenser.setInitialCash(initialCash, amount);
						log.logCashDispensed(amount);
						bank.saveTransaction(withdrawal);
					}else{
						receipt = new Receipt(false);
						cardReader.ejectCard();
					}	
					receiptPrinter.printReceipt(receipt);
					session.SessionEnd();
					break;
				case 5:
					//if the users chooses deposit
					InterfaceOfDepositWithdraw deposit = new Deposit(atm, session, card);
					message = deposit.getSpecificsFromCustomer();
					try {
						amount = screen.readAmount(message.getContent());
					}catch(IllegalArgumentException e){
						screen.display(e.getMessage());
						screen.wait(5000);
						continue;
					}
					log.logSend(message);
					Money counted;
					try{
						counted = cashDispenser.putCash();
					}catch (IllegalArgumentException e){
						screen.display(e.getMessage());
						screen.wait(5000);
						continue;
					}
					//user puts the money in.
					if(verifyInputAmount(counted, amount)){
						cashDispenser.setInitialCashPositive(initialCash, amount);
						receipt = deposit.completeTransaction(amount, bank);
					}else{
						receipt = new Receipt(false);
					}
					receiptPrinter.printReceipt(receipt);
					cashDispenser.setInitialCash(initialCash, amount);
					bank.saveTransaction(deposit);
					cardReader.ejectCard();
					session.SessionEnd();
					break;
				case 6:
					cardReader.ejectCard();
					session.SessionEnd();
				
			}


		}

	}

	public boolean verify(int password, int accountNumber, Bank bank) { // check if psw is correct
		return password == bank.selectPasswordByAccountNum(accountNumber);
	}

	public void readAccountNum(Card card) {  // ?????
		// call readCard() find account number, if the account-card valid, continue??
	}

	public boolean verifyInputAmount(Money counted, Money amount) {
		return counted.getAmount() == amount.getAmount() && Objects.equals(counted.getType(), amount.getType());
	}

	public Time checkTime() { 
		// check for the session,if its over 60 seconds, call retainCard();

		return new Time(limitTimeForOperation); //fix this
	}

	private boolean changePassword(Display screen, Bank bank, int accountNumber){
		Message message = new Message("askpsw");
		int psw = screen.readPIN(message.getContent());
		boolean result = verify(psw, accountNumber, bank);
		if(result){
			message = new Message("newpsw");
			psw = screen.readPIN(message.getContent());
			bank.changePassword(psw, accountNumber);
		}
		return result;		
	}

}