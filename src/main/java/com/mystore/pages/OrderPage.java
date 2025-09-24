package com.mystore.pages;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy(xpath = "//li[contains(text(),\"$29\")]")
	WebElement unitprice;
	@FindBy(xpath  = "//span[@id=\"total_price\"]")
	WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement ProceedToCheckout;


	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public double getunitprice() {
		String UnitPrice= unitprice.getText();
		String regex = "[^a-zA-Z0-9]";
		String Unit= UnitPrice.replaceAll(regex, "");
		Double FinalUnitPrice=Double.parseDouble(Unit);
		System.out.println(FinalUnitPrice);
		return FinalUnitPrice;
	}
	public double gettotal() {
		String TotalPrice= totalPrice.getText();
		String regex = "[^a-zA-Z0-9]";
		String tot= TotalPrice.replaceAll(regex, "");	
		Double FinalTotalPrice=Double.parseDouble(tot);
		return FinalTotalPrice;
	}

	public LoginPage clickonCheckout() {
		ProceedToCheckout.click();
		return new LoginPage();
	}

}
