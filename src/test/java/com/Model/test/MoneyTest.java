package com.Model.test;

import com.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void testMoney(){

        //creating Money object
        Money money = new Money(100, "dollar");

        //valid inputs
        Assertions.assertEquals(100, money.getAmount());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, () ->new Money(0, "dollar"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->new Money(100, "apple"));

    }
}
