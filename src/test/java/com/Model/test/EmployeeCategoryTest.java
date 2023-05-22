package com.Model.test;

import com.model.EmployeeCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class EmployeeCategoryTest{
    @Test
    public void testConstructor(){

        //valid inputs
        EmployeeCategory category = new EmployeeCategory(0);
        Assertions.assertEquals("Administrative Staff", category.getCategoryName());
        category = new EmployeeCategory(1);
        Assertions.assertEquals("Operation Staff", category.getCategoryName());
        category = new EmployeeCategory(2);
        Assertions.assertEquals("Technical Staff", category.getCategoryName());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, () -> new EmployeeCategory(3));


    }
}
