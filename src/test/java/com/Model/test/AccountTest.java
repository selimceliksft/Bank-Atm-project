package com.Model.test;

import com.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class AccountTest {

    @Test
    public void testConstructor(){
        //valid input
        Account account = new Account(65,1089,0.0,0);
        Assertions.assertEquals(65, account.getAccountNumber());
        Assertions.assertEquals(1089,account.getPassword());
        Assertions.assertEquals(0,account.getBalance());
        Assertions.assertEquals(0,account.getAccountType());

        //invalid input
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(0, 1089, 0.0,0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(1, -1089, 0.0,0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(1, 1089, -190.0,0));

    }
}
