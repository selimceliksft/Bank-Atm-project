package com.model;
public class AccountType {

	private final int typeID;
	private final String typeName;

	public AccountType(int typeID) {
		this.typeID = typeID;
		if(this.typeID == 0){
			typeName = "regular";
		}else if(this.typeID == 1) {
			typeName = "credit";
		}else{
			throw new IllegalArgumentException("invalid account type");
		}

	}

	public String getTypeName() {
		return typeName;
	}
	
}