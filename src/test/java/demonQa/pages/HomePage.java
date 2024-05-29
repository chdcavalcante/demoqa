package demonQa.pages;

import static demoQa.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import demoQa.core.BasePage;

public class HomePage extends BasePage {

	public void clickElements() {
		dsl.clicar(By.xpath("//h5[contains(.,'Elements')]"));
	}

	public void clickForms() {
		dsl.clicar(By.xpath("//h5[contains(.,'Forms')]"));
	}

	public void clickAlertsFrameWindows() {
		dsl.clicar(By.xpath("//h5[contains(.,'Alerts, Frame & Windows')]"));
	}

	public void clickWidgets() {
		dsl.clicar(By.xpath("//h5[contains(.,'Widgets')]"));
	}

	public void clickInteractions() {
		dsl.clicar(By.xpath("//h5[contains(.,'Interactions')]"));
	}

	public void clickBookStoreApplication() {
		dsl.clicar(By.xpath("//h5[contains(.,'Book Store Application')]"));
	}

	public void moverAteElemento(String elemento) {
		WebElement element = getDriver().findElement(By.xpath("//h5[contains(.,'" + elemento + "')]"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
