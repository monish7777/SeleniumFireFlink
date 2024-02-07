package org.automation.testScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MavenDataFromCmd {


	@Test
	public void testcase()
	{
		String url=System.getProperty("URl");
		String username=System.getProperty("USERNAME");
		String password=System.getProperty("PASSWORD");

		System.out.println("URL : "+ url);
		System.out.println("username : "+username);
		System.out.println("password : " +password);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
				

	}
}
