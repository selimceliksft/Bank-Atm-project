package com.model;
public class Transaction implements  InterfaceOfTransactions{

	protected ATM atm;
	protected Session session;
	protected Card card;

	public Transaction(ATM atm, Session session, Card card){
		this.atm = atm;
		this.session = session;
		this.card = card;
	}
	@Override
	public Message getSpecificsFromCustomer() {
		return null;
	}
	public ATM getAtm(){
		return atm;
	} 
	public Session getSession(){
		return session;
	}
	public Card getCard(){
		return card;
	}

}