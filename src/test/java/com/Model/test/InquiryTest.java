package com.Model.test;

import com.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class InquiryTest{

    @Mock
    private Bank bank;

    private ATM atm;
    @Mock
    private Card card;
    @Mock
    private Session session;

    @Mock
    private Display screen;

    private InterfaceOfTransactions transaction;

    @BeforeEach
    public void setUp(){
        transaction = mock(Transaction.class);
        when(transaction.getCard()).thenReturn(card);
        when(card.getAccountNumber()).thenReturn(1);
        when(transaction.getSession()).thenReturn(session);
        when(transaction.getSession().getSessionStart()).thenReturn(new Date(System.currentTimeMillis()));
        when(bank.getTransactions(card.getAccountNumber())).thenReturn(new InterfaceOfTransactions[]{transaction});
        when(bank.getBalance(card.getAccountNumber())).thenReturn(100.0);
    }

    @Test
    public  void testTransfer(){

        // Creating inquiry object
        InterfaceOfInquiry inquiry = new Inquiry(atm, session, card);

        //testing getSpecificsFromCustomer()
        Message expectedMessage = new Message("inquiry");
        Message actualMessage = inquiry.getSpecificsFromCustomer();
        Assertions.assertEquals(expectedMessage.getContent(), actualMessage.getContent());

        //testing completeTransaction() with choice == 1
        String expectedOutput = card.getAccountNumber() + " " + new Date(System.currentTimeMillis());
        inquiry.completeTransaction(1, bank, screen);
        verify(screen).display(expectedOutput);// checks if the display() method of the screen object was called with the expectedOutput argument.

        //Testing completeTransaction() with choice == 2
        double expectedBalance = 100.0;
        inquiry.completeTransaction(2, bank, screen);
        verify(screen).display(String.valueOf(expectedBalance));// checks if the display() method of the screen object was called with the expectedBalance argument.

    }

}
