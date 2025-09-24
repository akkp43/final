package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class Index extends BaseClass {

	@FindBy(xpath = "//a[@class=\"login\"]")
	WebElement signinButton;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement MystoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductbox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public Index() {
		PageFactory.initElements(getDriver(), this);
		
	}
	public LoginPage clickSignIn() {
		signinButton.click();
		return new LoginPage();
	}
	
	public boolean ValidateLogo() {
	return MystoreLogo.isDisplayed();
	}
	
	public String getmystoretitle() {
		String title=getDriver().getTitle();
		return title;
	}
	
	
	public SearchResultPage searchProduct(String product) {
		searchProductbox.sendKeys(product);
		searchButton.click();
		return new SearchResultPage();
	}
	
	
}
