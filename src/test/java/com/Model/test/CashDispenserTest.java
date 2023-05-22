package com.Model.test;

import com.model.CashDispenser;
import com.model.Log;
import com.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CashDispenserTest {

    @Mock
    private Log log;
    private Money cashOnHand;


    @BeforeEach
    public void setUp(){
        cashOnHand = new Money(10000, "dollar");

    }

    @Test
    public void testCashDispenser(){

        CashDispenser cashDispenser = new CashDispenser(log);

        //check setInitialCash
        cashDispenser.setInitialCash(cashOnHand, new Money(1000, "dollar"));
        Assertions.assertEquals(new Money(9000, "dollar").getAmount(), cashOnHand.getAmount());

        //check setInitialCashPositive
        cashDispenser.setInitialCashPositive(cashOnHand, new Money(2000, "dollar"));
        Assertions.assertEquals(new Money(11000, "dollar").getAmount(), cashOnHand.getAmount());

        //check checkCashOnHand
        Assertions.assertEquals(false, cashDispenser.checkCashOnHand(cashOnHand, new Money(100000, "dollar")));

        //check putCash: missing due to input testing problems

    }

}
