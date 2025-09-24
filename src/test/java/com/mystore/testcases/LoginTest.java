package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.mystoer.dataprovider.DataProvider1;
import com.mystore.base.BaseClass;
import com.mystore.pages.Homepage;
import com.mystore.pages.Index;
import com.mystore.pages.LoginPage;
import com.mystore.utility.Log;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginTest extends BaseClass {
	Index indexpage;
	LoginPage loginpage;
	Homepage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
		}
	@AfterMethod(groups= {"smoke","sanity","regression"})
public void teardown() {
		getDriver().quit();
}
	@Test(dataProvider = "Credentials",  dataProviderClass = DataProvider1.class,groups={"smoke","sanity"})
	public void Logintest(String Username, String Password) {
		Log.startTestCase("login test");
		indexpage= new Index();
		Log.info("User going to clic on sign in");
		loginpage=indexpage.clickSignIn(); // here it lands on login page sowe need to store it in loginpage object
		Log.info("User enters credentials");
		// homepage=loginpage.Mainlogin(prop.getProperty("username"), prop.getProperty("password")); //here it lands on home page so stored in homepage object
		homepage=loginpage.Mainlogin(Username,Password);
		String actualURL = homepage.getHomepageUrl();
		String expectedUrl="http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("Verify either user able to login");
		Assert.assertEquals(actualURL, expectedUrl);
		Log.info("login success");
		Log.endTestCase("Logintest");
	}
	
}
