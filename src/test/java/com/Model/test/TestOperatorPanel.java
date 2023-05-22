package com.Model.test;

import com.model.ATM;
import com.model.Money;
import com.model.OperatorPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TestOperatorPanel {

    @Mock
    private ATM atm;

    @Test
    public void testOperatorPanel(){

        OperatorPanel operatorPanel = new OperatorPanel(atm);
        int totalFundInATM = 10000;
        Money money = new Money(9000, "dollar");
        Assertions.assertEquals(money.getAmount(), operatorPanel.getInitialCash(totalFundInATM).getAmount());

    }

}
