package com.model;
import java.util.Date;

public class Employee extends Person {

	private final int employeeID;
	private final Date joined;
	private EmployeeCategory Category;

    public Employee(String givenName, String middleName, String familyName, int gender, String homeAddress, int phoneNumber, int employeeID, Date joined, EmployeeCategory Category) {
        super(givenName, middleName, familyName, gender, homeAddress, phoneNumber);
        if(employeeID < 0){
            throw new IllegalArgumentException("employee ID must be initialized carefully");
        }else {
            this.employeeID = employeeID;
            this.joined = joined;
            this.Category = Category;
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Date getJoined() {
        return joined;
    }

    public EmployeeCategory getCategory() {
        return Category;
    }
    public void setCategory(EmployeeCategory category) {
        Category = category;
    }
}