/**
 * 
 */
package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * 
 */
public class Homepage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'Akshay k')]")
private WebElement UserInfo;
	
	@FindBy(xpath = "//a[@title='Credit slips']")
	private WebElement MyCreditSlips;
	 
	public Homepage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean userinfo() {
		return UserInfo.isDisplayed();
	}
	public boolean Orderhistory() {
		return MyCreditSlips.isDisplayed();
	}
	public String getHomepageUrl() {
		String homeUrl=getDriver().getCurrentUrl();
		return homeUrl;
	}
}
