package com.example.demo;

import com.model.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import com.example.demo.*;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testFindMax(){
		//Assertions.assertEquals(4, App.findMax(new int[]{1,3,4,2}));
		//assertEquals(-1,App.findMax(new int[]{-12,-1,-3,-4,-2}));
	}

}
