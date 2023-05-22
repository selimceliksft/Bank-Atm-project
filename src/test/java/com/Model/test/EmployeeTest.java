package com.Model.test;

import com.model.Employee;
import com.model.EmployeeCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
class EmployeeTest {

    @Test
    public void testConstructor(){

        //valid inputs
        Employee employee = new Employee("emre", "can", "dost", 0, "1200 sokak", 5151970, 0, new Date(), new EmployeeCategory(2));
        Assertions.assertEquals(0, employee.getEmployeeID());

        //invalid inputs
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Employee("emre", "can", "dost", 0, "1200 sokak", 5151970, -1, new Date(), new EmployeeCategory(2)));

    }


}
