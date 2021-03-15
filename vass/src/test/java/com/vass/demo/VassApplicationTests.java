package com.vass.demo;

import org.junit.jupiter.api.Assertions;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.vass.demo.model.cliente;



//import com.vass.demo.controller.cliente;


@SpringBootTest
public class VassApplicationTests {

	@Test
	public void contextLoads() {
		cliente clien = new cliente();
		Assertions.assertEquals("joseh", clien.equals(clien));
	}

}
