package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id="email")
	WebElement UserName;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signinbutton;
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement CreateNewAccountButton;
	
		public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public Homepage Mainlogin(String Uname,String pwd) {
		UserName.sendKeys(Uname);
		password.sendKeys(pwd);
		signinbutton.click();
		return new Homepage();
		
	}
	
	public AddressPage login1(String Uname,String pwd) {
		UserName.sendKeys(Uname);
		password.sendKeys(pwd);
		signinbutton.click();
		return new AddressPage();
		
	}
	public CreateAccountPage createNewAccount(String Newmail) {
		emailForNewAccount.sendKeys(Newmail);
		CreateNewAccountButton.click();
		return new CreateAccountPage();
	}

}
