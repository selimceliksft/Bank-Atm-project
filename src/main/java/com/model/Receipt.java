package com.model;
public class Receipt {

    String content;

    public Receipt(boolean result){
        if(result){
            content = "Receipt: Operation success!";
        }else{
            content = "Receipt: Operation failure!";
        }
    }

    public String getContent(){
        return content;
    }

}