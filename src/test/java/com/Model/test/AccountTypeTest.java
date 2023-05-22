package com.Model.test;

import com.model.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class AccountTypeTest {

    @Test
    public void testConstructor(){

        //valid inputs
        AccountType accountType = new AccountType(0);
        Assertions.assertEquals("regular", accountType.getTypeName());
        accountType = new AccountType(1);
        Assertions.assertEquals("credit", accountType.getTypeName());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AccountType(3));
    }
}
