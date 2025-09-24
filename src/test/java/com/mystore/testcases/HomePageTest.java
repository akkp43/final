package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.Homepage;
import com.mystore.pages.Index;
import com.mystore.pages.LoginPage;

public class HomePageTest extends BaseClass {
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
@Test(groups="smoke")
public void userinfo() {
	indexpage= new Index();
	loginpage=indexpage.clickSignIn();
	homepage=loginpage.Mainlogin(prop.getProperty("username"), prop.getProperty("password"));
	boolean result=homepage.userinfo();
	Assert.assertTrue(result);

}
/** @Test
public void OrderhistoryTest() {
	indexpage= new Index();
	loginpage=indexpage.clickSignIn();
	homepage=loginpage.Mainlogin(prop.getProperty("username"), prop.getProperty("password"));
	boolean result=homepage.Orderhistory();
	Assert.assertTrue(result);
	
} **/
}
