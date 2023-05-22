package com.Model.test;


import com.model.TicketMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class TicketMachineTest {

    @Test
    public void testTicketNumberDesign(){


        TicketMachine ticketMachine = new TicketMachine();
        Assertions.assertEquals(1, ticketMachine.getNumber());
        Assertions.assertEquals(2, ticketMachine.getNumber());
        ticketMachine.resetTicketMachine();
        Assertions.assertEquals(1, ticketMachine.getNumber());

    }
}
