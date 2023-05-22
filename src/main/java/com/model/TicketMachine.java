package com.model;

public class TicketMachine {

	private int currentNumber = 0;

	public TicketMachine(){
		
	}

	public int getNumber() {
		currentNumber += 1;
		return currentNumber;
	}

	public void resetTicketMachine(){ //call this function when atm is disconnecting from bank.
		currentNumber = 0;
	}

}