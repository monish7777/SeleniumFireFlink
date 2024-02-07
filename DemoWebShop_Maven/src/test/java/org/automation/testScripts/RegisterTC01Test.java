package org.automation.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.RegistrationPage;
import org.automation.genericLibrary.BaseTest;
import org.automation.genericLibrary.DataUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTC01Test extends BaseTest {
	@Test(dataProvider = "Registration")
	public void registertc(String fn,String ln,String email,String pwd,String Cpwd) throws EncryptedDocumentException, IOException
	{
		//logout
		login_page.getLogoutButton().click();
		//verify 
		welcome_page.getRegisterbutton().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/register","Register Page Not Displayed");		Reporter.log("Registration Page Displayed",true);


		RegistrationPage registration_page = new RegistrationPage(driver);

		registration_page.getMaleRadioButton().click();
		registration_page.getFirstNameTextField().sendKeys(fn);
		registration_page.getLastNameTextField().sendKeys(ln);
		registration_page.getEmailTextField().sendKeys(common_utility.toGenerateRandomNumber()+email);
		registration_page.getPasswordtextField().sendKeys(pwd);
		registration_page.getConfirmtextField().sendKeys(Cpwd);
		registration_page.getRegisterButton().click();
		boolean registerText = registration_page.getRegistrationCompletedText().isDisplayed();
		Assert.assertEquals(registerText, true,"Failed");
		Reporter.log("Test Case Pass",true);

	}
	
	@DataProvider(name="Registration")
	
		public Object[][] dataSupply() throws EncryptedDocumentException, IOException {
		return DataUtility.multipleData("RegisterTestData");
	}
	



}
