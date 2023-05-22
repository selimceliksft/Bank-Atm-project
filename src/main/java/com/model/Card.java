package com.model;
public class Card {


	private final int number;
	private  int wrongPasswordCounter = 0;

	private final int accountNumber;

	public Card(int accountNumber, int number) {
		if(accountNumber <= 0){
			throw new IllegalArgumentException("account number must be initialized carefully. Fatal error");
		}else if(number <= 0){
			throw new IllegalArgumentException("card number must be initailized carefully. Fatal error");
		}else {
			this.number = number;
			this.accountNumber = accountNumber;
		}
	}

	public int getNumber() {
		return this.number;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void wrongPasswordEntered(){
		wrongPasswordCounter++;
	}

	public void correctPasswordEntered(){
		wrongPasswordCounter = 0;
	}
	public int getWrongPasswordCounter(){
		return wrongPasswordCounter;
	}
}