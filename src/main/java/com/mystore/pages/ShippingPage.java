package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass
{
 @FindBy(xpath = "//input[@id=\"cgv\"]")
 WebElement terms;
 
 @FindBy(xpath="//button[@name=\"processCarrier\"]")
 WebElement Checkoutbutton;
 
 public ShippingPage() {
	 PageFactory.initElements(getDriver(), this);
 }
 
 public void checkterms() {
	 terms.click();
 }
 public PaymentPage ClickProceedCHeckoutButton() {
	 Checkoutbutton.click();
	 return new PaymentPage();
 }
}
