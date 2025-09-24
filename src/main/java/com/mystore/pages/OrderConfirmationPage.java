package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath = "//p[@class=\"alert alert-success\"]")
	WebElement ConfirmationMessage;

	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
}
	public String finalValidation() {
		String msg=ConfirmationMessage.getText();
		return msg;
		
	}
}
