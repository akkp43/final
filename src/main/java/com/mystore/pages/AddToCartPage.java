package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.actiondriver.DropDown;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	Action action;
	@FindBy(xpath = "//input[@id=\"quantity_wanted\"]")
	WebElement qty;

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement size;

	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocart;

	@FindBy(xpath="//*[@id='layer_cart']//h2/i")
	WebElement Checkaddtocart;
	@FindBy(xpath = "//a[@id='color_14']")
	WebElement color;

	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterqty(String quantity)
	{	
		qty.click();
		qty.clear();
		qty.sendKeys(quantity);
	}

	public void SelectSize(String size1) {
		size.click();
		DropDown.selectByValue(size, size1);
		DropDown.getselectedOption(size);

	}
	public void SelectColor() {
		color.click();
	}
	
	public void ClickOnAddToCart() {
		addtocart.click();
	}
	public boolean checkAddToCart() {
		action = new Action();
		action.WaitUtils(getDriver(), 5);
		Action.waitForElementClickable(Checkaddtocart);
		return Checkaddtocart.isDisplayed();
	}

	public OrderPage checkout() {
		action = new Action();
		action.WaitUtils(getDriver(), 5);
		Action.waitForElementClickable(proceedToCheckout);
		Action.JSClick(getDriver(), proceedToCheckout);// here we did javascript click 
		return new OrderPage() ;
			
	}
}
