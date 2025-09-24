package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystoer.dataprovider.DataProvider1;
import com.mystore.base.BaseClass;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.Index;
import com.mystore.pages.OrderPage;
import com.mystore.pages.SearchResultPage;

public class orderpagetest extends BaseClass{
	Index indexpage;

	SearchResultPage searchresultpageObject;
	AddToCartPage AddtocartPageObject;
	OrderPage orderpageobject;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
		}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void teardown() {
		getDriver().quit();
	}


	@Test(groups="regression",dataProvider = "getProduct", dataProviderClass =DataProvider1.class )
	public void  verifyTotalPrice(String productName, String qty, String size) {
		indexpage= new Index();
		searchresultpageObject=indexpage.searchProduct(productName);
		AddtocartPageObject=searchresultpageObject.clickOnProduct();
		AddtocartPageObject.SelectSize(size);
		AddtocartPageObject.enterqty(qty);
		AddtocartPageObject.SelectColor();
		AddtocartPageObject.ClickOnAddToCart();
		orderpageobject=AddtocartPageObject.checkout();
		Double unitPrice = orderpageobject.getunitprice();
		System.out.println(unitPrice);
		Double TotalPrice = orderpageobject.gettotal();
		Double GrandTotal= (unitPrice*(Double.parseDouble(qty)))+7; // converting qty to double
		Assert.assertEquals(GrandTotal, TotalPrice);

	}
}
