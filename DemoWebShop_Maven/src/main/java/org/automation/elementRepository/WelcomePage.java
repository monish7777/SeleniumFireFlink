package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerbutton;
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginbutton;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[5]/a")
	private WebElement digitalDownloadTab;
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	@FindBy(xpath = "//ul[1][@class='top-menu']//a[contains(text(),'Books')]")
	private WebElement books;
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListBucket;

	public WebElement getWishListBucket() {
		return wishListBucket;
	}

	public WebElement getBooks() {
		return books;
	}

	public WebElement getDigitalDownloadTab() {
		return digitalDownloadTab;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterbutton() {
		return registerbutton;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

}
