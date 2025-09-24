package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath="//img[@src=\"http://www.automationpractice.pl/img/p/1/2/12-home_default.jpg\"]")
	WebElement productResult;
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	public boolean isProductAvailable() {
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() {
		productResult.click();
		return new AddToCartPage ();
	}
}
