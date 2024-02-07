package org.automation.testScripts;
import java.util.List;

import org.automation.elementRepository.WelcomePage;
import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.CartPage;
import org.automation.genericLibrary.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(org.automation.genericLibrary.ListenersImplementation.class)
	public class CartTestScripts extends BaseTest
	{
		@Test
		public void cartTestScripts() throws InterruptedException
		{
			//Step 1 : Clicking Digital downloads in Login Page
			LoginPage login_Page = new LoginPage(driver);
			login_Page.getDigitalDowloads().click();

			//Step 2 : Validate
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/digital-downloads" , "Digital Download Page Not Displayed");
			Reporter.log("Digital Download Page Displayed" , true);

			//Step 3 : Adding Products To Shopping Cart
			List<WebElement> addToCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
			for(WebElement addToCarttt : addToCart)
			{

				addToCarttt.click();
				Thread.sleep(2000);
			}

			//Step 4 : Clicking on ShoppingCart Icon
			WelcomePage welcome_page=new WelcomePage(driver);
					welcome_page.getShoppingCartLink().click();

			//Step 5 : Validate Cart Page Displayed.
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart" , "Shopping Cart Page Not Displayed");
			Reporter.log("ShoppingCart Page Displayed" , true);

			//Step 6 : Validating Whether All the Products Are Added To Cart Or Not
			List<WebElement> productss = driver.findElements(By.xpath("//a[@class='product-name']"));
			if(addToCart.size()==productss.size())
			{
				Reporter.log("All Products Added To cart" , true);
			}
			else
				Reporter.log("try Again ,true");


			//Step 7 : Click on CheckBox
			List<WebElement> checkbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
			for(WebElement checkboxs : checkbox)
			{
				checkboxs.click();
			}

			//Step 8 : Click on UpdateCart in ShoppingCart Page
			CartPage shoppingCart = new CartPage(driver);
			shoppingCart.getUpdateCart().click();

			//Step 9 : Validate Whether All The Products Are Removed .
			Assert.assertEquals(shoppingCart.getRemovedMsg().getText(), "Your Shopping Cart is empty!" , "All The Products Not Removed");
			Reporter.log("Products  Removed" , true);

		}
	}

