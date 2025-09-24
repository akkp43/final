package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass
{
@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
WebElement bankwirePayment;
@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
WebElement checkPayment;

public PaymentPage() {
	PageFactory.initElements(getDriver(), this);
	
	
}
public OrderSummeryPage clickOnPayment() {
	bankwirePayment.click();
	return new OrderSummeryPage();
}
	
}
