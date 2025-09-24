package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.AddressPage;
import com.mystore.pages.Index;
import com.mystore.pages.LoginPage;
import com.mystore.pages.OrderConfirmationPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.OrderSummeryPage;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.pages.ShippingPage;

import org.testng.Assert;

public class End2EndTest extends BaseClass{

	Index indexpage;

	SearchResultPage searchresultpageObject;
	AddToCartPage AddtocartPageObject;
	OrderPage orderpageobject;
	LoginPage loginpage;
	AddressPage addrPage;
	ShippingPage shipPage;
	PaymentPage payPage;
	OrderSummeryPage ordersumPage;
	OrderConfirmationPage orderconfirm;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) { // we are caalling launch app as we need to launch the app for every test
		launchbrowser(browser);
		}
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void teardown() {
		getDriver().quit();
	}

	@Test(groups="regression")
	public void EndToEndtest() {

		indexpage= new Index();
		searchresultpageObject=indexpage.searchProduct("Printed Summer Dress");
		AddtocartPageObject=searchresultpageObject.clickOnProduct();
		AddtocartPageObject.SelectSize("2");
		//AddtocartPageObject.enterqty("1");
		AddtocartPageObject.SelectColor();
		AddtocartPageObject.ClickOnAddToCart();
		orderpageobject=AddtocartPageObject.checkout();
		loginpage=orderpageobject.clickonCheckout();
	
		addrPage= loginpage.login1((prop.getProperty("username")),prop.getProperty("password"));
		shipPage=addrPage.ClickonCheckout();
		shipPage.checkterms();
		payPage=shipPage.ClickProceedCHeckoutButton();
		ordersumPage=payPage.clickOnPayment();
		orderconfirm=ordersumPage.OrderConfirmation();
		String actualMessage=orderconfirm.finalValidation();
		String ExpectedMessage="Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, ExpectedMessage);
	}
}
