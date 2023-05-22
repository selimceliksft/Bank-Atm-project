package com.Model.test;

import com.model.DatabaseProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.model.*;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

public class BankTest {

    private Bank bank;
    @Mock
    private Card card;
    @Mock
    private Account account;
    @Mock
    private InterfaceOfTransactions transaction;


    @BeforeEach
    public void setUp(){
        DatabaseProxy databaseProxy = new DatabaseProxy();
        bank = new Bank(databaseProxy);
        card = mock(Card.class);
        account = mock(Account.class);
        transaction = mock(Transaction.class);
        databaseProxy.addToRegisteredAccounts(account);
        databaseProxy.addToRegisteredCards(card);
        when(account.getAccountNumber()).thenReturn(1);
        when(account.getPassword()).thenReturn(9989);
        when(account.getBalance()).thenReturn(1000.0);
        when(card.getAccountNumber()).thenReturn(1);
        when(card.getNumber()).thenReturn(2);
        when(transaction.getCard()).thenReturn(card);

    }

    @Test
    public void testSelectPasswordByAccountNumber(){

        int expectedPassword = 9989;
        Assertions.assertEquals(expectedPassword, bank.selectPasswordByAccountNum(card.getAccountNumber()));

    }

    @Test
    public void testChangePassword(){

        int newPassword = 3333;
        bank.changePassword(newPassword, card.getAccountNumber());
        verify(account).setPassword(newPassword);

    }

    @Test
    public void testMinusBalance(){

        Money money = new Money(100, "dollar");
        bank.minusBalance(card.getAccountNumber(), money);
        verify(account).setBalance(account.getBalance() - money.getAmount());

    }

    @Test
    public void testPlusBalance(){

        Money money = new Money(100, "dollar");
        bank.plusBalance(card.getAccountNumber(), money);
        verify(account).setBalance(account.getBalance() + money.getAmount());

    }

    @Test
    public void testCheckTheBalance(){

        Assertions.assertTrue(bank.checkTheBalance(card.getAccountNumber(), new Money(500, "dollar")));

    }

    @Test
    public void testGetTransactionAndSaveTransaction(){//this method tests two methods since they need each other to be tested properly

        bank.saveTransaction(transaction);
        InterfaceOfTransactions actualTransaction = bank.getTransactions(card.getAccountNumber())[0];
        Assertions.assertEquals(transaction.getCard().getAccountNumber(), actualTransaction.getCard().getAccountNumber());

    }

    @Test
    public void testGetBalance(){

        double expectedBalance = 1000.0;
        double actualBalance = bank.getBalance(card.getAccountNumber());
        Assertions.assertEquals(expectedBalance, actualBalance);

    }

    @Test
    public void testCheckIfCardRegistered(){

        //valid input
        Assertions.assertEquals(card.getNumber(), bank.checkIfCardRegistered(card.getNumber()).getNumber());

        //invalid input
        Assertions.assertNull(bank.checkIfCardRegistered(3));

    }

}
