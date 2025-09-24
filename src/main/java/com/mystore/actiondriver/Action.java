package com.mystore.actiondriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	public static WebDriver driver;
    public static WebDriverWait wait;
	
	public static void JSClick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", ele);
		flag=true;
	}

	     public void WaitUtils(WebDriver driver, long timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    }
	    public static void implicitWait() {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	    }
	   
	    public static WebElement waitForElementClickable(WebElement element) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public boolean waitForTextPresentInElement(WebElement e, String text) {
	        return wait.until(ExpectedConditions.textToBePresentInElement(e, text));
	    }

	    public boolean waitForURLToContain(String partialUrl) {
	        return wait.until(ExpectedConditions.urlContains(partialUrl));
	    }

	    public boolean waitForTitleToContain(String title) {
	        return wait.until(ExpectedConditions.titleContains(title));
	    }

	    // Add more wait methods as needed...
	    
	    public static String screenShot(WebDriver driver, String filename) {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			
			// This new path for jenkins
			String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
					+ dateName + ".png";
			
			
			return destination;
		}
		
		public String getCurrentTime() {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
			return currentDate;
		}

	    
	}

	
