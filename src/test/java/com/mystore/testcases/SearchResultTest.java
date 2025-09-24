package com.mystore.testcases;


import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.Index;

import com.mystore.pages.SearchResultPage;

public class SearchResultTest extends BaseClass {
	Index indexpage;
	SearchResultPage searchresultpageObject;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression","a"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
		}
	@AfterMethod(groups= {"smoke","sanity","regression","a"})
public void teardown() {
		getDriver().quit();
}
	@Test(groups="a")
public void prodcutAvailabiltiy() {
	indexpage= new Index();
	searchresultpageObject=indexpage.searchProduct("printed summer dresses");
	boolean result= searchresultpageObject.isProductAvailable();
	Assert.assertTrue(result);

}

}
