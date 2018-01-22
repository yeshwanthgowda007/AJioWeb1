package com.ajioweb.utils;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

public class CommonUtils {
	
	public static void switchWindow(QAFWebDriver driver)
	{
		for(String window:driver.getWindowHandles())
		{
			driver.switchTo().window(window);
		}
	}
}
