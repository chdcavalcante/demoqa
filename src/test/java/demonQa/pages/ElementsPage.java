package demonQa.pages;

import demoQa.core.BasePage;

public class ElementsPage extends BasePage {

	public void setUserName(String name) {
		dsl.escrever("userName", name);
	}

	public void setEmail(String email) {
		dsl.escrever("userEmail", "teste@email.com");
	}

	public void setCurrentAddress(String address) {
		dsl.escrever("currentAddress", address);
	}

	public void setPermanentAddress(String Address) {
		dsl.escrever("permanentAddress", Address);

	}
	
	public void clickElements() {
		dsl.clicar("item-0");
	}
	
	public void clickSubmit() {
		dsl.clicar("submit");
	}
	
}
