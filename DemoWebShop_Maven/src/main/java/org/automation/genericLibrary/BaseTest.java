package org.automation.genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.RegistrationPage;
import org.automation.elementRepository.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
	public WebDriver driver;
	public DataUtility data_utility=new DataUtility();
	static WebDriver listenersDriver;
	public WelcomePage welcome_page;
	public LoginPage login_page;
	public CommonUtility common_utility=new CommonUtility();
	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome")String BrowserName) throws IOException
	{
		if(BrowserName.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		listenersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_utility.getDataFromProperties("url"));
	}

	@BeforeMethod(alwaysRun = true)
	public void performLogin() throws IOException {
		welcome_page=new WelcomePage(driver);
		welcome_page.getLoginbutton().click();
		String email = data_utility.getDataFromProperties("email");
		String pwd = data_utility.getDataFromProperties("pwd");

		login_page=new LoginPage(driver);
		login_page.getEmailTextField().sendKeys(email);
		login_page.getPasswordTextField().sendKeys(pwd);
		login_page.getLoginButton().click();


	}
	@AfterMethod(alwaysRun = true)
	public void performLogout() {
		login_page.getLogoutButton().click();
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}

}
