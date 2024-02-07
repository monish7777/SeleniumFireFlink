package org.automation.testScripts;

import java.util.List;

import org.automation.elementRepository.BooksPage;
import org.automation.elementRepository.CartPage;
import org.automation.elementRepository.FictionExPage;
import org.automation.elementRepository.WelcomePage;
import org.automation.elementRepository.WishListPage;
import org.automation.genericLibrary.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WishListScriptsTest extends BaseTest
{
	public WelcomePage welcome_page;
	@Test
	public void wishListScripts()
	{
		//Step 1 : Clicking on Books Tab
		welcome_page = new WelcomePage(driver);
		welcome_page.getBooks().click();

		
		//Step 2 : Validating Whether Books Page Displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books" , "Books Page Not Displayed");
		Reporter.log("Books Page is Displayed " , true);

		
		
		
		//Step 3 : Clicking on FictionEx ProductLink
		BooksPage book_Page = new BooksPage(driver);
		book_Page.getFictionExlink().click();

		
		
		
		//Step 4 : Validating Whether FictionEx Product Displayed
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Fiction EX')]")).getText(),"Fiction EX" , "Product Not Displayed");
		Reporter.log("Fiction Ex Book Displayed" , true);

		
		
		//Step 5 : Adding Product To WishList Cart
		FictionExPage add_To_Wishlist = new FictionExPage(driver);
		add_To_Wishlist.getAddToWishlist().click();

		
		
		
		//Step 6 : Clicking on WishList Bucket
		welcome_page = new WelcomePage(driver);
		welcome_page.getWishListBucket().click();

		
		
		//Step 7 : Validating Whether FictionEx Displayed In WishList Page
		Assert.assertEquals(book_Page.getFictionExlink().getText(),"Fiction EX" , "FictionEx is Not Displayed In Wishlist Page");
		Reporter.log("FictionEx Displayed in Wishlist Page" , true);

		
		
		
		//Step 8 : Clicking on CheckBox
		List<WebElement> checkboxx = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for(WebElement checkboxxs : checkboxx)
		{
			checkboxxs.click();
		}

		
		
		
		//Step 9 : Clicking on UpdateWishlist
		CartPage cart_page= new CartPage(driver);
		cart_page.getUpdateCart().click();

		
		
		//Step 10 : Validating Whether FictionEx Removed From Cart
		WishListPage wishlist = new WishListPage(driver);
		Assert.assertEquals(wishlist.getRemovedWishlist().getText(),"The wishlist is empty!" , "TestCase Failed");
		Reporter.log("TestCase PASS", true);
	}
}

