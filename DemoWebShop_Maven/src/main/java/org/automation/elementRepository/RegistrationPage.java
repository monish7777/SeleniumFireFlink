package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	@FindBy(id = "gender-male")
	private WebElement maleRadioButton;
	@FindBy(id = "gender-female")
	private WebElement femaleRadioButton;
	@FindBy(id = "FirstName")
	private WebElement firstNameTextField;
	@FindBy(id = "LastName")
	private WebElement lastNameTextField;
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextField;
	@FindBy(id = "Password")
	private WebElement passwordtextField;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmtextField;
	@FindBy(id = "register-button")
	private WebElement registerButton;
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registrationCompletedText;
	
	public RegistrationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordtextField() {
		return passwordtextField;
	}

	public WebElement getConfirmtextField() {
		return confirmtextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getRegistrationCompletedText() {
		return registrationCompletedText;
	}
	
	
	
}
