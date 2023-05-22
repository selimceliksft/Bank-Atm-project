package com.model;

public interface InterfaceOfInquiry extends InterfaceOfTransactions{

    @Override
    Message getSpecificsFromCustomer();
    Receipt completeTransaction(int choice, Bank bank, Display screen);

}
