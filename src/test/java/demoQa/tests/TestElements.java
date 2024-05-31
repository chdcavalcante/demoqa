package demoQa.tests;

import static demoQa.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import demoQa.core.BaseTest;
import demoQa.core.DSL;
import demoQa.core.DriverFactory;
import demonQa.pages.ElementsPage;

public class TestElements extends BaseTest {

	private DSL dsl;
	private ElementsPage page;

	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://demoqa.com/elements");
		dsl = new DSL();
		page = new ElementsPage();

		WebElement anuncio = DriverFactory.getDriver().findElement(By.id("fixedban"));
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].style.visibility='hidden';",
				anuncio);
	}

	@Test
	public void textBox() {
		page.clickElements();
		page.setUserName("Carlos");
		page.setEmail("teste@email.com");
		page.setCurrentAddress("Av. Almirante Alvoro Calheiros, nº2000");
		page.setPermanentAddress("Av. das Nações, nº1155");

		WebElement submitButton = DriverFactory.getDriver().findElement(By.id("submit"));
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

		page.clickSubmit();

		assertEquals("https://demoqa.com/text-box", dsl.capturarUrl());
		assertEquals("Name:Carlos", dsl.capturarTexto("name"));
		assertEquals("Email:teste@email.com", dsl.capturarTexto("email"));
		assertEquals("Current Address :Av. Almirante Alvoro Calheiros, nº2000",
				dsl.capturarTexto(By.xpath("//p[@id='currentAddress']")));
		assertEquals("Permananet Address :Av. das Nações, nº1155",
				dsl.capturarTexto(By.xpath("//p[@id='permanentAddress']")));

	}

	@Test
	public void validarRadioButton() {
		page.clickRadioButton();
		page.clickRadioBtn("Yes");
		assertEquals("You have selected Yes", dsl.capturarTexto(By.xpath("//p[contains(.,'You have selected Yes')]")));

		page.clickRadioBtn("Impressive");
		assertEquals("Impressive", dsl.capturarTexto(By.xpath("//span[@class='text-success']")));
		assertEquals("No", dsl.capturarTexto(By.xpath("//label[@class='custom-control-label disabled']")));

	}

	@Test
	public void validarWebTables() {
		page.clicarWebTables();
		assertEquals("Cierra", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Cierra')]")));
		assertEquals("Alden", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Alden')]")));
		assertEquals("Kierra", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Kierra')]")));

		page.escreverSearchBox("Cie");
		assertEquals("Cierra", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Cierra')]")));
	}

	@Test
	public void addCadastroWebTables() {
		page.clicarWebTables();
		page.clickAddWebTables();
		page.preencherCadastroWebTables("Carlos", "Henrique", "carlos@test.com", "30", "10000", "QA");

		assertEquals("Carlos", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Carlos')]")));
		assertEquals("Henrique", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Henrique')]")));
		assertEquals("carlos@test.com",dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'carlos@test.com')]")));
		assertEquals("30", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'30')]")));
		assertEquals("10000", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'10000')]")));
		assertEquals("QA", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'QA')]")));

	}
	@Test
	public void deleteCadastroWebTables() {
		page.clicarWebTables();
	
		assertEquals("Cierra", dsl.capturarTexto(By.xpath("//div[@class='rt-td'][contains(.,'Cierra')]")));
		
		dsl.clicar("delete-record-1");
		List<WebElement> element = getDriver().findElements(By.xpath("//div[@class='rt-td'][contains(.,'Cierra')]"));
		assertTrue(element.isEmpty());
		
	}

}
