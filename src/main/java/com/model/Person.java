package com.model;
public class Person {

	private String givenName;
	private String middleName;
	private String familyName;
	private int gender; // 0 means male, 1 means female
	private String homeAddress;
	private int phoneNumber;

	public Person(String givenName, String middleName, String familyName, int gender, String homeAddress, int phoneNumber) {

		if(!givenName.matches("[a-zA-Z]+") || !middleName.matches("[a-zA-Z]+") || !familyName.matches("[a-zA-Z]+")){
			throw new IllegalArgumentException("a name cannot contain numbers or special characters.");
		} else if (gender < 0 || gender > 1) {
			throw new IllegalArgumentException("gender input wrong");
		}else {
			this.givenName = givenName;
			this.middleName = middleName;
			this.familyName = familyName;
			this.gender = gender;
			this.homeAddress = homeAddress;
			this.phoneNumber = phoneNumber;
		}
	}

	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName){
		if(!givenName.matches("[a-zA-Z]+")){
			throw new IllegalArgumentException("a name cannot contain numbers or special characters.");
		}else {
			this.givenName = givenName;
		}
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName){
		if(!middleName.matches("[a-zA-Z]+")){
			throw new IllegalArgumentException("a name cannot contain numbers or special characters.");
		}else {
			this.middleName = middleName;
		}
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		if(!familyName.matches("[a-zA-Z]+")){
			throw new IllegalArgumentException("a name cannot contain numbers or special characters.");
		}else {
			this.familyName = familyName;
		}
	}

	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		 if (gender != 0 ^ gender != 1) {
			throw new IllegalArgumentException("gender input wrong");
		}
		this.gender = gender;
	}

	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}