package demoQa.core;

import static demoQa.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String idCampo, String texto) {
		escrever(By.id(idCampo), texto);
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();

	}

	public void clicar(String id) {
		clicar(By.id(id));
	}

	public String capturarUrl() {
		String url = getDriver().getCurrentUrl();
		return url;
	}
}
