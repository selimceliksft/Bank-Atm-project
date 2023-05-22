package com.Model.test;

import org.junit.jupiter.api.*;
import com.model.Receipt;
import com.model.ReceiptPrinter;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ReceiptPrinterTest {

    private Receipt receipt;

    @BeforeEach
    public void setUp(){
        receipt = Mockito.mock(Receipt.class);
        Mockito.when(receipt.getContent()).thenReturn("Receipt: Operation success!");
    }

    @Test
    public void testPrintReceipt() {

        //creating ReceiptPrint object
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();

        //taken from chatgpt. This is the way for testing screen outputs.
        // Redirect System.out to a ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        receiptPrinter.printReceipt(receipt);

        // Reset System.out
        System.setOut(System.out);

        // Verify that the expected output was printed to the console
        Assertions.assertEquals("Receipt: Operation success!\n", outContent.toString());
    }
}
