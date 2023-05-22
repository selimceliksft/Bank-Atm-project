package com.Model.test;

import com.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class DepositTest {

    @Mock
    private Bank bank;
    private ATM atm;
    @Mock
    private Card card;
    private Session session;
    private Money money;

    @Test
    public void testDeposit(){

        //creating deposit object
        InterfaceOfDepositWithdraw deposit = new Deposit(atm, session, card);

        //testing getSpecificsFromCustomer()
        Message expectedMessage = new Message("deposit");
        Message actualMessage = deposit.getSpecificsFromCustomer();
        Assertions.assertEquals(expectedMessage.getContent(), actualMessage.getContent());

        //testing completeTransaction()
        Receipt expectedReceipt = new Receipt(true);
        Receipt actualReceipt = deposit.completeTransaction(money, bank);
        Assertions.assertEquals(expectedReceipt.getContent(), actualReceipt.getContent());

    }



}
