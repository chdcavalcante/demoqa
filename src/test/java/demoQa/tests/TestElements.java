package demoQa.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import demoQa.core.DSL;
import demoQa.core.DriverFactory;

public class TestElements {

	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://demoqa.com/elements");
		dsl = new DSL();
	}
	
	@Test
	public void textBox() {
		dsl.clicar("item-0");
		assertEquals("https://demoqa.com/text-box", dsl.capturarUrl());
		
		dsl.escrever("userName", "Carlos");
		dsl.escrever("userEmail", "teste@email.com");
		dsl.escrever("currentAddress", "Av. Almirante Alvoro Calheiros, nº2000");
		dsl.escrever("permanentAddress", "Av. das Nações, nº1155)");                     
	}
}
