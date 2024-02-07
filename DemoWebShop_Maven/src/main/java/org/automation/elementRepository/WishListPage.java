package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
		@FindBy(xpath = "//div[contains(text(),'The wishlist is empty!')]")
		private WebElement removedWishlist;
		

		public WishListPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getRemovedWishlist() {
			return removedWishlist;
		}
		
	}

