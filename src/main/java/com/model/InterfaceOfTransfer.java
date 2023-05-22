package com.model;

public interface InterfaceOfTransfer extends InterfaceOfTransactions {

    @Override
    Message getSpecificsFromCustomer();

    Message getSpecificsFromCustomer2();

    Receipt completeTransaction(int to, Money amount, Bank bank);
}