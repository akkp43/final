package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.Index;

public class IndexPageTest extends BaseClass {
	Index indexpage;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
		}
	@AfterMethod(groups= {"smoke","sanity","regression"})
public void teardown() {
		getDriver().quit();
}
	@Test (groups="smoke")
	public void VerifyLogo() {
		 indexpage= new Index();
		boolean result = indexpage.ValidateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="smoke")
	public void VerifyTitle() {
		String StoreTitle = indexpage.getmystoretitle();
		Assert.assertEquals(StoreTitle, "My Shop");
		
	}
	
}
