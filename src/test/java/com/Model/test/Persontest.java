package com.Model.test;

import com.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class PersonTest{

    @Test
    public void testConstructor() {
        // valid inputs
        Person person = new Person("ali", "han", "guney", 0, "123 sokak", 5551234);
        Assertions.assertEquals("ali", person.getGivenName());
        Assertions.assertEquals("han", person.getMiddleName());
        Assertions.assertEquals("guney", person.getFamilyName());
        Assertions.assertEquals(0, person.getGender());
        Assertions.assertEquals("123 sokak", person.getHomeAddress());
        Assertions.assertEquals(5551234, person.getPhoneNumber());

        // invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person("aaa_123", "han", "guney", 0, "123 sokak", 5551234));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person("ali", "han", "guney", -1, "123 sokak", 5551234));
    }

}