package com.model;
import java.util.Date;

public class TechnicalStaff extends Employee {
    
    private EmployeeCategory category;

    public TechnicalStaff(String givenName, String middleName, String familyName, int gender, String homeAddress, int phoneNumber, int employeeID, Date joined, EmployeeCategory Category){
        super(givenName, middleName, familyName, gender, homeAddress, phoneNumber, employeeID, joined, Category);
        this.category = Category;
    }

    @Override
    public EmployeeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeeCategory category) {
        this.category = category;
    }
}