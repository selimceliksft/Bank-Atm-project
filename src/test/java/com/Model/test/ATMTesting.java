package com.Model.test;

import com.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ATMTesting {

    @Mock
    private Bank bank;

    private ATM atm;
    @Mock
    private Card card;

    @BeforeEach
    public void setUp(){
        atm = new ATM(bank, 60000, 100000,1000,1000,1000);
        bank = mock(Bank.class);
        card =  mock(Card.class);
        when(card.getAccountNumber()).thenReturn(1);
        when(bank.selectPasswordByAccountNum(card.getAccountNumber())).thenReturn(9989);
    }

    @Test
    public void testATM(){

        //testing .verify()
        int expectedPassword = 9989;
        Assertions.assertTrue(atm.verify(expectedPassword, card.getAccountNumber(), bank));

        //testing verifyInputAmount()
        Money money1 = new Money(100, "dollar");
        Money money2 = new Money(100, "dollar");
        Assertions.assertTrue(atm.verifyInputAmount(money1, money2));

        //testing changePassword() not being tested due to: it is not recommended to test private methods directly.

        //cannot test atmStarting. Too complex.

    }
}
