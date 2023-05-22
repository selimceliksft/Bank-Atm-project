package com.model;

import java.util.Date;

public class App {

    public static void  main(String[] args){

        DatabaseProxy databaseProxy = new DatabaseProxy();
        Bank bank = new Bank(databaseProxy);
        ATM atm = null;
        try {
            atm = new ATM(bank, 60000, 100000,1000,1000,1000);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        /*
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/atmDatabase";
            String username = "root";
            String password = "firstsql";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        //example: employee
        databaseProxy.addToRegisteredEmployees(new AdministrativeStaff("emre", "ali", "ustere", 0, "bursa", 0, 0, new Date(), new EmployeeCategory(0)));

        //example: firstCustomer
        Customer firstCustomer = new Customer("ihsan", "selim", "celik", 0, "denizli", 0, 0, 1);
        Account account = new Account(1, 1089, 0, 0);
        Card card =  new Card(account.getAccountNumber(), 1);
        databaseProxy.addToRegisteredToBank(firstCustomer);
        databaseProxy.addToRegisteredAccounts(account);
        databaseProxy.addToRegisteredCards(card);

        //example: secondCustomer
        Customer secondCustomer = new Customer("osman", "anil", "hicyilmaz", 0, "izmir", 0, 1, 2);
        account = new Account(2, 9980, 1000, 0);
        card =  new Card(account.getAccountNumber(), 2);
        databaseProxy.addToRegisteredToBank(secondCustomer);
        databaseProxy.addToRegisteredAccounts(account);
        databaseProxy.addToRegisteredCards(card);

        //first transaction to initialize the array list.
        Session session = new Session();
        Transaction transaction = new Transaction(atm, session, card);
        databaseProxy.addToTransactionsOfBank(transaction);

        //here, initializing and starting all atm's.
        assert atm != null;
        atm.atmStarting(atm);

    }
}

