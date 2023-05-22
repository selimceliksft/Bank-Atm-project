package com.model;
import java.net.InetAddress;
public class NetworkToBank { //mysql had some issues

	private Log log;
	private InetAddress bankAddress;
	private String ipAdress = "31.223.99.126";

	
	public NetworkToBank(Log log, InetAddress bankAddress) {
		/*
		try {
			bankAddress = InetAddress.getByName(ipAdress);
			Socket socket = new Socket(bankAddress, 8080);
			
			// use the socket to send and receive data to/from the bank
		} catch (IOException e) {
			// close atm
		}
		*/
	}

	public void openConnection() {
		// TODO - implement NetworkToBank.openConnection
		throw new UnsupportedOperationException();
	}

	public void closeConnection() {
		// TODO - implement NetworkToBank.closeConnection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 * @param balances
	 */
	/*
	public Status sendMessage(Message message, Balances balances) {
		// TODO - implement NetworkToBank.sendMessage
		throw new UnsupportedOperationException();
	}
	*/
}