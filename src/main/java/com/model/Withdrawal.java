package com.model;
import java.util.ArrayList;

public class Withdrawal extends Transaction implements InterfaceOfDepositWithdraw {

	private final int from;
	private Money amount;

	public Withdrawal(ATM atm, Session session, Card card) {
		super(atm, session, card);
		from = card.getAccountNumber();
	}

	public Message getSpecificsFromCustomer() {
		return new Message("withdrawal");
	}

	public Receipt completeTransaction(Money amount, Bank bank) {

		boolean result;

		if(bank.checkTheBalance(from, amount)) {
			bank.minusBalance(from, amount);
			result = true;
		}
		else{
			result = false;
		}
		return new Receipt(result);
	}

}