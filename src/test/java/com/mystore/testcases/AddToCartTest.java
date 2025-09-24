package com.mystore.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.Index;
import com.mystore.pages.SearchResultPage;

public class AddToCartTest extends BaseClass {

Index indexpage;
SearchResultPage searchresultpageObject;
AddToCartPage AddtocartPageObject;
@Parameters("browser")
@BeforeMethod(groups= {"smoke","sanity","regression"})
public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
	launchbrowser(browser);
	}

@AfterMethod(groups= {"smoke","sanity","regression"})
public void teardown() {
	getDriver().quit();
}

@Test(groups={"regression","sanity"})
public void AddToCart() {
	
	indexpage= new Index();
	searchresultpageObject=indexpage.searchProduct("Printed Summer Dress");
	AddtocartPageObject=searchresultpageObject.clickOnProduct();

	AddtocartPageObject.SelectSize("2");
	AddtocartPageObject.SelectColor();
	AddtocartPageObject.enterqty("1");

	AddtocartPageObject.ClickOnAddToCart();
	boolean result=AddtocartPageObject.checkAddToCart(); 
	Assert.assertTrue(result);
	}

}