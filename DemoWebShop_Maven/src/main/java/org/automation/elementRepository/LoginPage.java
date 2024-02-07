package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "Email")
	private WebElement emailTextField;
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckBox;
	@FindBy(linkText ="Forgot password?")
	private WebElement forgotpasswordLink;
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement loginButton;
	@FindBy(xpath ="//input[@value='Register']")
	private WebElement registerButton;
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutButton;
	@FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]")
	private WebElement digitalDowloads;


	public WebElement getDigitalDowloads() {
		return digitalDowloads;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}
	public WebElement getForgotpasswordLink() {
		return forgotpasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	public WebElement getRegisterButton() {
		return registerButton;
	}


}
