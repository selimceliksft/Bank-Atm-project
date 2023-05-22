package com.model;

import java.util.ArrayList;

public class DatabaseProxy {

	private ArrayList<Customer> registeredToBank = new ArrayList<Customer>();
	private ArrayList<Employee> registeredEmployees = new ArrayList<Employee>();
	private ArrayList<Card> registeredCards = new ArrayList<Card>();
	private ArrayList<InterfaceOfTransactions> transactionsOfBank = new ArrayList<InterfaceOfTransactions>();
	private ArrayList<Account> registeredAccounts = new ArrayList<Account>();

	public DatabaseProxy(){

	}

	public ArrayList<Customer> getRegisteredToBank() {
		return registeredToBank;
	}

	public void addToRegisteredToBank(Customer customer) {
		if(registeredToBank.contains(customer)){
			throw new UnsupportedOperationException("customer already exists.");
		}else {
			registeredToBank.add(customer);
		}
	}

	public ArrayList<Employee> getRegisteredEmployees() {
		return registeredEmployees;
	}

	public void addToRegisteredEmployees(Employee employee) {
		if(registeredEmployees.contains(employee)){
			throw new UnsupportedOperationException("employee already exists.");
		}else {
			registeredEmployees.add(employee);
		}
	}

	public ArrayList<Card> getRegisteredCards() {
		return registeredCards;
	}

	public void addToRegisteredCards(Card card) {
		if(registeredCards.contains(card)){
			throw new UnsupportedOperationException("card already exists.");
		}else {
			registeredCards.add(card);
		}
	}

	public ArrayList<InterfaceOfTransactions> getTransactionsOfBank() {
		return transactionsOfBank;
	}

	public void addToTransactionsOfBank(InterfaceOfTransactions transaction){
		if(transactionsOfBank.contains(transaction)){
			throw new UnsupportedOperationException("transaction already saved.");
		}else {
			transactionsOfBank.add(transaction);
		}
	}

	public ArrayList<Account> getRegisteredAccounts(){
		return registeredAccounts;
	}

	public void addToRegisteredAccounts(Account account){
		if(registeredAccounts.contains(account)){
			throw new UnsupportedOperationException("account already exists.");
		}else {
			registeredAccounts.add(account);
		}
	}

}