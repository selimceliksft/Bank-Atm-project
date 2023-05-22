package com.model;
public class Money {

    private double amount;
    private String type;

    public Money(double amount, String type){
        if(amount <= 0){
            throw new IllegalArgumentException("amount cannot be zero or negative.");
        }
        else if(!type.equals("dollar")){
            throw new IllegalArgumentException("invalid currency");
        }
        else{
            this.amount = amount;
            this.type = type;
        }
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

}
