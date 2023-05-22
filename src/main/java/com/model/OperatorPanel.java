package com.model;
public class OperatorPanel {

	private ATM atm;

	
	public OperatorPanel(ATM atm) {
		this.atm = atm;
	}

	public Money getInitialCash(int totalFundInATM) {//call at the start.
		//1000 dollars saved for just in case.
		return new Money(totalFundInATM-1000, "dollar");
	}

}