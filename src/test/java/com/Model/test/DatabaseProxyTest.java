package com.Model.test;

import com.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DatabaseProxyTest {

    private DatabaseProxy databaseProxy;
    @Mock
    private Customer customer;
    @Mock
    private Employee employee;
    @Mock
    private Card card;
    @Mock
    private InterfaceOfTransactions transaction;
    @Mock
    private Account account;

    @BeforeEach
    public void setUp(){
        databaseProxy = new DatabaseProxy();
        customer = mock(Customer.class);
        employee = mock(Employee.class);
        card = mock(Card.class);
        transaction = mock(InterfaceOfTransactions.class);
        account = mock(Account.class);
        when(transaction.getCard()).thenReturn(card);
    }

    @Test
    public void testDatabaseProxy(){

        //testing registeredToBank methods
        databaseProxy.addToRegisteredToBank(customer);
        Assertions.assertEquals(customer.getAccount_number(), databaseProxy.getRegisteredToBank().get(0).getAccount_number());
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> databaseProxy.addToRegisteredToBank(customer));

        //testing registeredEmployees methods
        databaseProxy.addToRegisteredEmployees(employee);
        Assertions.assertEquals(employee.getFamilyName(), databaseProxy.getRegisteredEmployees().get(0).getFamilyName());
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> databaseProxy.addToRegisteredEmployees(employee));

        //checking registeredCards methods
        databaseProxy.addToRegisteredCards(card);
        Assertions.assertEquals(card.getNumber(), databaseProxy.getRegisteredCards().get(0).getNumber());
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> databaseProxy.addToRegisteredCards(card));

        //checking transactionsOfBank methods
        databaseProxy.addToTransactionsOfBank(transaction);
        Assertions.assertEquals(transaction.getCard().getAccountNumber(), databaseProxy.getTransactionsOfBank().get(0).getCard().getAccountNumber());
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> databaseProxy.addToTransactionsOfBank(transaction));

        //checking registeredAccounts methods
        databaseProxy.addToRegisteredAccounts(account);
        Assertions.assertEquals(account.getPassword(), databaseProxy.getRegisteredAccounts().get(0).getPassword());
        Assertions.assertThrows(UnsupportedOperationException.class, ()-> databaseProxy.addToRegisteredAccounts(account));

    }

}
