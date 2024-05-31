package demonQa.pages;

import org.openqa.selenium.By;

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
	
	public void clickRadioButton() {
		dsl.clicar(By.xpath("//span[contains(.,'Radio Button')]"));
		
	}
	
	public void clicarWebTables() {
		dsl.clicar("item-3");
	}
	
	public void clickRadioBtn(String radioButton) {
		dsl.clicar(By.xpath("//label[contains(.,'"+radioButton+"')]"));
		
	}
	
	public void clickAddWebTables() {
		dsl.clicar("addNewRecordButton");
	}
	
	public void escreverSearchBox(String texto) {
		dsl.escrever("searchBox", texto);
	}
	
	public void clickSubmit() {
		dsl.clicar("submit");
	}
	
	public void preencherCadastroWebTables(String firstName, String lastName, String email, String age, String salary, String department) {
		dsl.escrever("firstName", firstName);
		dsl.escrever("lastName", lastName);
		dsl.escrever("userEmail", email);
		dsl.escrever("age", age);
		dsl.escrever("salary", salary);
		dsl.escrever("department", department);
		dsl.clicar("submit");
		
		
		
	}
	
}
