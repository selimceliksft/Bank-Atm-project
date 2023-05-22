package com.model;

public interface InterfaceOfDepositWithdraw extends InterfaceOfTransactions{

    @Override
    Message getSpecificsFromCustomer();
    Receipt completeTransaction(Money amount, Bank bank);
}
