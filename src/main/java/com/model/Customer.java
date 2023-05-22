package com.model;
public class Customer extends Person {

	private final int ID_Number;
	private final int account_number;

    public Customer(String givenName, String middleName, String familyName, int gender, String homeAddress, int phoneNumber, int idNumber, int accountNumber ) {
        super(givenName, middleName, familyName, gender, homeAddress, phoneNumber);
        if(idNumber < 0){
            throw new IllegalArgumentException("ID number must be initialized carefully. Fatal error");
        }else {
            ID_Number = idNumber;
            account_number = accountNumber;
        }
    }

    public int getID_Number() {
        return ID_Number;
    }

    public int getAccount_number() {
        return account_number;
    }
   
}