package com.Model.test;

import com.model.ATM;
import com.model.Bank;
import com.model.Card;
import com.model.CardReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

class CardReaderTest {

     @Mock
     private ATM atm;
     @Mock
     private Bank bank;
     @Mock
     private  Card card;
     @Mock
     private CardReader cardReader;

     @BeforeEach
     public void setUp(){
         card = mock(Card.class);
         cardReader = mock(CardReader.class);
         when(card.getNumber()).thenReturn(1);
         //when(cardReader.readCard(bank)).thenReturn(bank.checkIfCardRegistered(card.getNumber()));
         //when(bank.checkIfCardRegistered(card.getNumber())).thenReturn(card);
         when(cardReader.readCard(bank)).thenReturn(card);
     }

     @Test
     public void testCardReader(){
         //cardReader = new CardReader(atm, new Scanner(System.in));//Scanner is not mock because it is final
         //Assertions.assertEquals(card.getNumber(), cardReader.readCard(bank).getNumber());

     }


}




