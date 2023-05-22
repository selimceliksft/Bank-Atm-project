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


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class TransferTest{

    @Mock
    private Bank bank;

    private ATM atm;
    @Mock
    private Card card;
    private Session session;

    private Money money;
   @Mock
    private Account secondAccount;

    @BeforeEach
    public void setUp(){
        when(secondAccount.getAccountNumber()).thenReturn(1);
        when(bank.checkTheBalance(card.getAccountNumber(), money)).thenReturn(true);
    }

    @Test
    public  void testTransfer(){

        //creating transfer object
        InterfaceOfTransfer transfer = new Transfer(atm, session, card);

        //testing getSpecificsFromCustomer()
        Message expectedMessage = new Message("transferAccount");
        Message actualMessage = transfer.getSpecificsFromCustomer();
        Assertions.assertEquals(expectedMessage.getContent(), actualMessage.getContent());

        //testing getSpecificsFromCustomer2()
        Message expectedMessage2 = new Message("transferAmount");
        Message actualMessage2 = transfer.getSpecificsFromCustomer2();
        Assertions.assertEquals(expectedMessage.getContent(), actualMessage.getContent());

        //testing completeTransaction()
        Receipt expectedReceipt = new Receipt(true);
        Receipt actualReceipt = transfer.completeTransaction(secondAccount.getAccountNumber(), money, bank);
        Assertions.assertEquals(expectedReceipt.getContent(), actualReceipt.getContent());

    }

}
