package com.Model.test;

import com.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    public void testConstructor(){

        //valid inputs
        Customer customer = new Customer("emre", "can", "dost", 0, "1200 sokak", 5151970, 1,1);
        Assertions.assertEquals(1, customer.getID_Number());
        Assertions.assertEquals(1,customer.getAccount_number());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Customer("emre", "can", "dost", 0, "1200 sokak", 5151970, -1,1));
    }
}
