package com.Model.test;

import com.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class CardTest {

    @Test
    public void testCard(){

        //creating card object
        Card card = new Card(10,25);

        //valid inpuuts
        Assertions.assertEquals(10, card.getAccountNumber());
        Assertions.assertEquals(25, card.getNumber());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Card(0,1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Card(1,0));

        //testing password counter
        Assertions.assertEquals(0, card.getWrongPasswordCounter());
        card.wrongPasswordEntered();
        Assertions.assertEquals(1, card.getWrongPasswordCounter());
        card.correctPasswordEntered();
        Assertions.assertEquals(0,card.getWrongPasswordCounter());

    }
}
