package com.model;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class CardReader {

	private ATM atm;
	Scanner keyboard;
	
	public CardReader(ATM atm, Scanner keyboard) {
		this.atm = atm;
		this.keyboard = keyboard;
	}

	public Card readCard(Bank bank) { //read card number from card. check if the card is valid
		//---done by sensors. No need for error handling.
		System.out.println("enter card number. ---this will be done by sensors.---");
		int cardNumber = keyboard.nextInt();
		//---done by sensors

		return bank.checkIfCardRegistered(cardNumber);
	}

	public void ejectCard() { // eject card if the card is not registered or cannot connect to bank
		System.out.println("card ejected. ---this will be done by sensors---");
	}

	public void retainCard() { // call this function if psw is incorrect for three times or 60 seconds passed.
		System.out.println("card retained. Call customer services. ---this will be done by sensors---");
	}

}

