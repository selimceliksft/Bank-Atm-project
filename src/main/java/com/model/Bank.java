package com.model;

public class Bank {

    DatabaseProxy databaseProxy;

    public Bank(DatabaseProxy databaseProxy){
        this.databaseProxy = databaseProxy;
    }

    public int selectPasswordByAccountNum(int accountNum) {
        //returns the given accounts password from database
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == accountNum){
                return  databaseProxy.getRegisteredAccounts().get(i).getPassword();
            }
        }
        return 0; //fatal error
    }

    public void changePassword(int newPassword, int accountNumber){
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == accountNumber){
                databaseProxy.getRegisteredAccounts().get(i).setPassword(newPassword);
            }
        }
    }

    public void minusBalance(int from, Money amount) {

        //tell bank to edit the amount to account
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == from){
                double currentBalance = databaseProxy.getRegisteredAccounts().get(i).getBalance();
                databaseProxy.getRegisteredAccounts().get(i).setBalance(currentBalance - amount.getAmount());
            }
        }

    }

    public void plusBalance(int to, Money amount) {

        //tell bank to add the amount to account.
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == to){
                double currentBalance = databaseProxy.getRegisteredAccounts().get(i).getBalance();
                databaseProxy.getRegisteredAccounts().get(i).setBalance(currentBalance + amount.getAmount());
            }
        }

    }

    public boolean checkTheBalance(int from, Money amount) {

        //check if the account has enough money
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == from ){
                if(databaseProxy.getRegisteredAccounts().get(i).getBalance() >= amount.getAmount()) {
                    return true;
                }
            }
        }
        return false;
    }

    public InterfaceOfTransactions[] getTransactions(int from){

        //return the last 10 transactions of 'from'
        int counter = 0;
        InterfaceOfTransactions[] lastTransactions = new InterfaceOfTransactions[10];
        for(int i = 0; i<databaseProxy.getTransactionsOfBank().size(); i++){
            if(databaseProxy.getTransactionsOfBank().get(i).getCard().getAccountNumber() == from){
                counter++;
                lastTransactions[counter-1] = databaseProxy.getTransactionsOfBank().get(i);
            }
            if(counter == 10){
                break;
            }
        }

        return lastTransactions;

    }

    public double getBalance(int from){

        //return the accounts balance
        for(int i = 0; i < databaseProxy.getRegisteredAccounts().size(); i++){
            if(databaseProxy.getRegisteredAccounts().get(i).getAccountNumber() == from){
                return databaseProxy.getRegisteredAccounts().get(i).getBalance();
            }
        }
        return 0;

    }

    public void saveTransaction(InterfaceOfTransactions transaction){

        //save transaction to transactions list
        databaseProxy.addToTransactionsOfBank(transaction);

    }

    public Card checkIfCardRegistered(int cardNumber){
        //check if the card is registered.
        for(int i = 0; i < databaseProxy.getRegisteredCards().size(); i++){
            if(databaseProxy.getRegisteredCards().get(i).getNumber() == cardNumber){
                return databaseProxy.getRegisteredCards().get(i);
            }
        }
        return null;
    }

}