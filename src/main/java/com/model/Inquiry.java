package com.model;

public class Inquiry extends Transaction implements InterfaceOfInquiry {

	private final int from;

	public Inquiry(ATM atm, Session session, Card card) {
		super(atm, session, card);
		from = card.getAccountNumber();
	}

	public Message getSpecificsFromCustomer() {

		return new Message("inquiry");

	}

	public Receipt completeTransaction(int choice, Bank bank, Display screen) {

		if(choice == 1){
			InterfaceOfTransactions[] lastTransactions = new Transaction[10];
			for(int i = 0; i < bank.getTransactions(from).length; i++){
				lastTransactions[i] = bank.getTransactions(from)[i];
			}
			for (InterfaceOfTransactions lastTransaction : lastTransactions){
				if(lastTransaction == null){
					continue;
				}
				screen.display(lastTransaction.getCard().getAccountNumber() + " " + lastTransaction.getSession().getSessionStart());
				//details about transactions can be continued here...
			}
		}
		else if(choice == 2){
			double balance = bank.getBalance(from);
			screen.display(String.valueOf(balance));
		}else{
			throw new IllegalArgumentException("wrong input");
		}
		return new Receipt(true);
	}

}