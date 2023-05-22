package com.Model.test;

import com.model.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.sql.Date;

class SessionTest {

    @Mock
    private Date date;
    private Session session;

    @BeforeEach
    public void setUp(){
        date = new Date(System.currentTimeMillis());
    }

    @Test
    public void testSession(){

        session = new Session();
        Assertions.assertEquals(date.toString(), session.getSessionStart().toString());
        Assertions.assertThrows(IllegalStateException.class, ()-> session.getSessionEnd());
        session.SessionEnd();
        Assertions.assertEquals(new Date(System.currentTimeMillis()).toString(), session.getSessionEnd().toString());

    }



}
