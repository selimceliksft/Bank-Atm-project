package com.model;
public class Account {

	private final int accountNumber;
	private int password;
	private double balance;
	private final int accountType;

	public Account(int accountNumber, int password, double balance, int accountType) {

		if(accountNumber <= 0){
			throw new IllegalArgumentException("account number must be initialized carefully. Fatal Error");
		}else if(password <= 0){
			throw new IllegalArgumentException("password cannot be a negative number");
		}else if(balance < 0){
			throw new IllegalArgumentException("balance cannot be negative on a new account");
		}
		else {
			this.accountNumber = accountNumber;
			this.password = password;
			this.balance = balance;
			this.accountType = accountType;
		}
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		if(password <= 0){
			throw new IllegalArgumentException("password cannot be a negative number");
		}
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountType() {
		return accountType;
	}
	
}