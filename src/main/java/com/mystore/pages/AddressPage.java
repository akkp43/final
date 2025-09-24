package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtochecout;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage ClickonCheckout() {
		proceedtochecout.click();
		return new ShippingPage();
	}
}
