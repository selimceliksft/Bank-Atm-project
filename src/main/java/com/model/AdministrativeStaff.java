package com.model;
import java.util.Date;

public class AdministrativeStaff extends Employee {

    private EmployeeCategory category;

    public AdministrativeStaff(String givenName, String middleName, String familyName, int gender, String homeAddress, int phoneNumber, int employeeID, Date joined, EmployeeCategory Category){
        super(givenName, middleName, familyName, gender, homeAddress, phoneNumber, employeeID, joined, Category);
        category = Category;
    }

    public EmployeeCategory getEmployeeCategory(){
        return category;
    }
    public void setEmployeeCategory(int Category){
        category = new EmployeeCategory(Category);
    }

}