package com.Model.test;

import com.model.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ReceiptTest {

    @Test
    public void testReceipt(){

        Receipt receipt = new Receipt(false);
        Assertions.assertEquals("Receipt: Operation failure!", receipt.getContent());
        receipt = new Receipt(true);
        Assertions.assertEquals("Receipt: Operation success!", receipt.getContent());

    }
}
