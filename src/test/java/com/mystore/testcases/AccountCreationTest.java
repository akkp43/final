package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.mystore.base.BaseClass;
import com.mystore.pages.CreateAccountPage;
import com.mystore.pages.Index;
import com.mystore.pages.LoginPage;

public class AccountCreationTest extends BaseClass {
	
	Index indexpage;
	LoginPage loginpage;
	CreateAccountPage accountCreationpageObject;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})
public void teardown() {
		getDriver().quit();
}
	@Test(groups="sanity")
	public void Createaccounttest() {
		indexpage= new Index();
		loginpage=indexpage.clickSignIn();
		accountCreationpageObject=loginpage.createNewAccount("ballubhai@gmail.com");
		boolean result=accountCreationpageObject.createUserpageValidation();
		Assert.assertTrue(result);
		
		
	}
}
