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
class WithdrawalTest{

    @Mock
    private Bank bank;

    private ATM atm;
    @Mock
    private Card card;
    private Session session;

    private Money money;

    @BeforeEach
    public void setUp(){
        when(bank.checkTheBalance(card.getAccountNumber(), money)).thenReturn(true);
    }

    @Test
    public  void testWithdrawal(){

        //creating withdrawal object
        InterfaceOfDepositWithdraw withdraw = new Withdrawal(atm, session, card);

        //testing getSpecificsFromCustomer()
        Message expectedMessage = new Message("withdrawal");
        Message actualMessage = withdraw.getSpecificsFromCustomer();
        Assertions.assertEquals(expectedMessage.getContent(), actualMessage.getContent());

        //testing completeTransaction()
        Receipt expectedReceipt = new Receipt(true);
        Receipt actualReceipt = withdraw.completeTransaction(money, bank);
        Assertions.assertEquals(expectedReceipt.getContent(), actualReceipt.getContent());

    }

}
