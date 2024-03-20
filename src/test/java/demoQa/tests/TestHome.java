package demoQa.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import demoQa.core.BaseTest;
import demoQa.core.DSL;
import demoQa.core.DriverFactory;
import demonQa.pages.HomePage;

public class TestHome extends BaseTest {

	private HomePage page;
	private DSL dsl;

	@Before
	public void inicializa() {
		DriverFactory.getDriver().get("https://demoqa.com/");
		page = new HomePage();
		dsl = new DSL();

		WebElement anuncio = DriverFactory.getDriver().findElement(By.id("fixedban"));
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].style.visibility='hidden';",
				anuncio);
	}

	@Test
	public void validarAcessoElements() {
		page.moverAteElemento("Elements");
		page.clickElements();
		assertEquals("https://demoqa.com/elements", dsl.capturarUrl());
	}

	@Test
	public void validarAcessoForms() {
		page.moverAteElemento("Forms");
		page.clickForms();
		assertEquals("https://demoqa.com/forms", dsl.capturarUrl());
	}

	@Test
	public void validarAcessoAlertsFrameWindows() {
		page.moverAteElemento("Alerts, Frame & Windows");
		page.clickAlertsFrameWindows();
		assertEquals("https://demoqa.com/alertsWindows", dsl.capturarUrl());
	}

	@Test
	public void validarAcessoWidgets() {
		page.moverAteElemento("Widgets");
		page.clickWidgets();
		assertEquals("https://demoqa.com/widgets", dsl.capturarUrl());
	}

	@Test
	public void validarAcessoInteractions() {
		page.moverAteElemento("Interactions");
		page.clickInteractions();
		assertEquals("https://demoqa.com/interaction", dsl.capturarUrl());
	}

	@Test
	public void validarAcessoBookStore() {
		page.moverAteElemento("Book Store Application");
		page.clickBookStoreApplication();
		assertEquals("https://demoqa.com/books", dsl.capturarUrl());
	}

}
