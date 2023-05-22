package com.model;

import java.util.Scanner;

public class CashDispenser {

	private Log log;
	private Money cashOnHand;

	public CashDispenser(Log log) {
		this.log = log;
	}

	public void setInitialCash(Money initialCash, Money amount) {
		 //call this function to calculate cash on atm after withdraw
		 initialCash.setAmount(initialCash.getAmount() - amount.getAmount());
	}

	public void setInitialCashPositive(Money initialCash, Money amount) {
		//call this function to calculate cash on atm after deposit
		initialCash.setAmount(initialCash.getAmount() + amount.getAmount());
	}
	
	public boolean checkCashOnHand(Money initialCash, Money amount) { //call this function before accepting a withdrawal!
		//check if cash on atm is sufficient to withdraw amount
		return (initialCash.getAmount() > amount.getAmount());
	}

	public void dispenseCash(Money amount) {
		//dispense the given amount of cash. ---this will be done by sensors.
		System.out.println(amount.getAmount() + " " + amount.getType() + " dispensed.");
	}

	public Money putCash() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("cover opened. Please put the money(and enter the amount agian. This will be done by sensors.)");
		return new Money(keyboard.nextInt(), "dollar");//type is set to dollar as a default. this will be checked by sensors.
	}

}