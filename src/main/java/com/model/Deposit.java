package com.model;
public class Deposit extends Transaction implements InterfaceOfDepositWithdraw{

	private final int to;
	private Money amount;

	public Deposit(ATM atm, Session session, Card card) {
		super(atm, session, card);
		to = card.getAccountNumber();
	}

	public Message getSpecificsFromCustomer() {
		return new Message("deposit");
	}

	public Receipt completeTransaction(Money amount, Bank bank) {

		//add money to account
		bank.plusBalance(to, amount);

		return new Receipt(true);
	}

}