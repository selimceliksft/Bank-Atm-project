package com.model;
import java.util.ArrayList;
public class Log {

	private int  sessionID;
	private ArrayList<String> logs = new ArrayList<String>();

	public Log(){

	}

	public Log(Session session) { 
		//create a log when sending msg, dispensing cash waiting an answer
		sessionID = session.getSessionID();
		logs.add(sessionID + "numbered session logged.");
	}

	public void logSerialNumber(int serialNumber){
		logs.add(serialNumber + "serial numbered card logged in.");
	}

	public void logSend(Message message) { // confirm that the message send
		logs.add(message.getContent() + "sent");
	}

	
	public void logCashDispensed(Money amount) { // dispense cash.
		logs.add(amount.getAmount() + "dispensed.");
	}

	public ArrayList<String> getLogs(){
		return logs;
	}

}