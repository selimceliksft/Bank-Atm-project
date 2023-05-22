package com.Model.test;

import com.model.Display;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

class ScreenTest {

    @Mock
    private Display screen;

    @BeforeEach
    public void setUp(){

        screen = mock(Display.class);

    }

    @Test
    public void testDisplay() {

        //check .display()
        String expectedMessage = "Hello, world!";
        screen.display(expectedMessage);
        verify(screen).display(expectedMessage);

        //check .readPIN() missing due to input testing problems

        //rest of the Display methods missing due to input testing methods

    }
}

