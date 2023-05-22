package com.model;
public class ReceiptPrinter {

	public ReceiptPrinter() {
	}

	public void printReceipt(Receipt receipt) {
		//print the current receipt
		System.out.println(receipt.getContent());
	}
  
}