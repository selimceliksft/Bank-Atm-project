package com.model;
public class Transfer extends Transaction implements InterfaceOfTransfer{

	private final int from;
	private int to;
	private Money amount;

	public Transfer(ATM atm, Session session, Card card) {
		super(atm, session, card);
		from = card.getAccountNumber();
	}

	public Message getSpecificsFromCustomer() {
		return new Message("transferAccount");
	}

	public Message getSpecificsFromCustomer2() {
		return new Message("transferAmount");
	}

	public Receipt completeTransaction(int to, Money amount, Bank bank ) {

		boolean result;

		if(bank.checkTheBalance(from, amount)){
			bank.minusBalance(from, amount);
			bank.plusBalance(to, amount);
			result = true;
		}else{
			result = false;
		}


		return new Receipt(result);

	}

}