package com.model;
public class Message {

    private String content;

    public Message(String type){
        switch (type) {
            case "idle" -> this.content = "welcome to IZBANK! (pressing any key will count as a card inserted)";
            case "askpsw" -> this.content = "please enter password";
            case "wrngpsw" -> this.content = "wrong password";
            case "newpsw" -> this.content = "please enter new password";
            case "menu" -> this.content = "make a choice by entering a number between 1-6";
            case "inquiry" -> this.content = "press 1 for detailed inquiry\npress 2 for balance inquiry";
            case "withdrawal" -> this.content = "please enter the amount of money you want to withdraw";
            case "deposit" -> this.content = "please put the money in the cover, enter the amount of money you put";
            case "transferAccount" -> this.content = "please enter the account number of receiver";
            case "transferAmount" -> this.content = "please enter the amount you want to send";
            case "endOfTheDay" -> this.content ="This ATM is currently not working.";
            case "tooMuchWithdraw" -> this.content = "you cannot withdraw this amount.";
        }
        if(this.content == null){
            throw new IllegalArgumentException("Fatal error");
        }
    }

    public String getContent() { 
        return content;
    }

}