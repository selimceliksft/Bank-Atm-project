package com.Model.test;

import com.model.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    public void testMessage(){

        //valid inputs
        Message message = new Message("idle");
        Assertions.assertEquals("welcome to IZBANK! (pressing any key will count as a card inserted)", message.getContent());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Message("random content"));

    }

}
