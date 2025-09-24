
package com.mystore.actiondriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void selectByVisibleText(WebElement element , String visibletext) {
		
		
		Select s= new Select(element); 
		s.selectByVisibleText(visibletext);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s= new Select(element); 
		s.selectByIndex(index);
	}
	public static void selectByValue(WebElement element , String value) {
		Select s= new Select(element); 
		s.selectByValue(value);
	}
	
	public static String getselectedOption(WebElement element) {
		Select s= new Select(element);
		System.out.println(s.getFirstSelectedOption());
		return s.getFirstSelectedOption().getText();
	}
}
