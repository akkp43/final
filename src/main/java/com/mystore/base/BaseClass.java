
package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;


	//For parellel execution we used this thredlocal
	public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<RemoteWebDriver>();
	
	
	
	
	/**@BeforeTest(groups= {"smoke","sanity","regression","a"})
	try {
		prop = new Properties();
		System.out.println("Super constructore invoked");

		FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");

		prop.load(f);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	
	}	**/
	
		
	@BeforeSuite(groups= {"smoke","sanity","regression","a"})
	public void loadconfig() {
		ExtentManager.getInstance();
		DOMConfigurator.configure("C:\\Users\\sai\\eclipse-workspace\\MyStroreProject\\test-output\\log4j.xml");
		try {
			prop = new Properties();
			System.out.println("Super constructore invoked");

			FileInputStream f= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");

			prop.load(f);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}	
	}


	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	
	public static void launchbrowser(String Browsername) {

		if (Browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		getDriver().get(prop.getProperty("url"));


	}
	@AfterSuite
	public void aftersuit() {
		ExtentManager.endReport();
	}


}
