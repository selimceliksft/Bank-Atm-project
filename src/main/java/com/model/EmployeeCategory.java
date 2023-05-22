package com.model;
public class EmployeeCategory {

	private int categoryID;
	private String categoryName;

	public EmployeeCategory(int categoryID){
		this.categoryID = categoryID;
		if(this.categoryID == 0){
			this.categoryName = "Administrative Staff";
		}else if(this.categoryID == 1){
			this.categoryName = "Operation Staff";
		}else if(this.categoryID == 2){
			this.categoryName = "Technical Staff";
		}else{
			throw new IllegalArgumentException("invalid category type.");
		}
	}

	public int getCategoryID(){
		return categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}

}