package com.Model.test;

import com.model.Log;
import com.model.Message;
import com.model.Money;
import com.model.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.ArrayList;


public class LogTest {

    @Mock
    private Session session;
    private Log log;

    @BeforeEach
    public void setup() {
        session = new Session();
        log = new Log(session);
    }

    @Test
    public void testLogSerialNumber() {
        log.logSerialNumber(456);
        ArrayList<String> expectedLogs = new ArrayList<>();
        expectedLogs.add(session.getSessionID() + "numbered session logged.");
        expectedLogs.add("456serial numbered card logged in.");
        Assertions.assertEquals(expectedLogs, log.getLogs());
    }

    @Test
    public void testLogSend() {
        Message message = new Message("endOfTheDay");
        log.logSend(message);
        ArrayList<String> expectedLogs = new ArrayList<>();
        expectedLogs.add(session.getSessionID() + "numbered session logged.");
        expectedLogs.add(message.getContent() + "sent");
        Assertions.assertEquals(expectedLogs, log.getLogs());
    }

    @Test
    public void testLogCashDispensed() {
        Money amount = new Money(100, "dollar");
        log.logCashDispensed(amount);
        ArrayList<String> expectedLogs = new ArrayList<>();
        expectedLogs.add(session.getSessionID() + "numbered session logged.");
        expectedLogs.add(amount.getAmount() + "dispensed.");
        Assertions.assertEquals(expectedLogs, log.getLogs());
    }
}
