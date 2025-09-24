package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummeryPage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderButton;
	
	public OrderSummeryPage() {
		PageFactory.initElements(getDriver(), this);
		
		
	}
	public OrderConfirmationPage OrderConfirmation() {
		confirmOrderButton.click();
		return new OrderConfirmationPage();
	}

}
