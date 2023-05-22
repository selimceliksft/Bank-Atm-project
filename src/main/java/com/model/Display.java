package com.model;
import java.util.Scanner;
public class Display {
	
	Scanner keyboard = new Scanner(System.in);

	public Display() {

	}
	
	public void display(String message) { //display the given message content
		System.out.println(message);
	}

	public int readPIN(String prompt) { // ask for pin and read pin, return it.
		System.out.print(prompt);
		return keyboard.nextInt();
	}

	public int readMenuChoice(String prompt, String[] menu) { //display menu, read choice and return it
		System.out.println(prompt);
		for (String string : menu) {
			System.out.println(string);
		}
		int choice = keyboard.nextInt();
		if(choice < 1 || choice > 6){
			throw new IllegalArgumentException("incorrect input");
		}else {
			return choice;
		}
	}

	public Money readAmount(String prompt) {// reads the amount of money and returns it
		System.out.println(prompt);
		int amount =  keyboard.nextInt();
		return new Money(amount, "dollar");
	}

	public int readChoice(String message){
		System.out.println(message);
		return keyboard.nextInt();
	}

	public int readAccount(String message){
		System.out.println(message);
		return keyboard.nextInt();
	}

	public void wait(int miliseconds){
		try {
			Thread.sleep(miliseconds); // wait for 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}