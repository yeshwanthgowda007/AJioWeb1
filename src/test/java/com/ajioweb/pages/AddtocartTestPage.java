package com.ajioweb.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;

import com.ajioweb.Bean.ProductInfoBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AddtocartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "lnk.addtocart.addtocartpage")
	private QAFWebElement lnkAddtocartAddtocartpage;
	@FindBy(locator = "lnk.productname.addtocartpage")
	private QAFWebElement lnkProductnameAddtocartpage;
	@FindBy(locator = "lnk.productprice.addtocartpage")
	private QAFWebElement lnkProductpriceAddtocartpage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLnkAddtocartAddtocartpage() {
		return lnkAddtocartAddtocartpage;
	}

	public QAFWebElement getLnkProductnameAddtocartpage() {
		return lnkProductnameAddtocartpage;
	}

	public QAFWebElement getLnkProductpriceAddtocartpage() {
		return lnkProductpriceAddtocartpage;
	}
	
	public void verifyAddToCartPage()
	{
		getLnkProductnameAddtocartpage().waitForVisible();
		Validator.verifyThat("Verifying add to cart page", driver.getTitle(),Matchers.containsString("Your Shopping Bag | AJIO"));
		ProductInfoBean details2=(ProductInfoBean)ConfigurationManager.getBundle().getProperty("product.information");
		Validator.verifyThat(getLnkProductnameAddtocartpage().getText(), Matchers.containsString(details2.productName));
		Validator.verifyThat(getLnkProductpriceAddtocartpage().getText(), Matchers.containsString(details2.productPrice));
	}
	
	public void clickAddToCart()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", getLnkAddtocartAddtocartpage());
	
	}
	
	

}
