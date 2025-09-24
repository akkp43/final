package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class CreateAccountPage extends BaseClass{

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;
	
	public CreateAccountPage ()
{
PageFactory.initElements(getDriver(), this);		
}
	
	public boolean createUserpageValidation() {
		return formTitle.isDisplayed();
	}
}
