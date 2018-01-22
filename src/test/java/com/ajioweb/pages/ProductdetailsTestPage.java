package com.ajioweb.pages;

import org.hamcrest.Matchers;

import com.ajioweb.Bean.ProductInfoBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "lnk.productbrand.productdetailspage")
	private QAFWebElement lnkProductbrandProductdetailspage;
	@FindBy(locator = "lnk.productname.productdetailspage")
	private QAFWebElement lnkProductnameProductdetailspage;
	@FindBy(locator = "lnk.productprice.producdetailspage")
	private QAFWebElement lnkProductpriceProducdetailspage;
	@FindBy(locator = "lnk.productsize.productdetailspage")
	private QAFWebElement lnkProductsizeProductdetailspage;
	@FindBy(locator = "lnk.addtobag.productdetailspage")
	private QAFWebElement lnkAddtobagProductdetailspage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLnkProductbrandProductdetailspage() {
		return lnkProductbrandProductdetailspage;
	}

	public QAFWebElement getLnkProductnameProductdetailspage() {
		return lnkProductnameProductdetailspage;
	}

	public QAFWebElement getLnkProductpriceProducdetailspage() {
		return lnkProductpriceProducdetailspage;
	}


	public QAFWebElement getLnkProductsizeProductdetailspage() {
		return lnkProductsizeProductdetailspage;
	}

	public QAFWebElement getLnkAddtobagProductdetailspage() {
		return lnkAddtobagProductdetailspage;
	}
	
	public void verifyProductDetailsTestPage() {
		ProductInfoBean details = (ProductInfoBean) ConfigurationManager.getBundle()
				.getProperty("product.information");
		Validator.verifyThat(getLnkProductbrandProductdetailspage().getText().toUpperCase(),
				Matchers.containsString(details.productBrand.toUpperCase()));
		Validator.verifyThat(getLnkProductnameProductdetailspage().getText().toUpperCase(),
				Matchers.containsString(details.productName.toUpperCase()));
		Validator.verifyThat(getLnkProductpriceProducdetailspage().getText().toUpperCase(),
				Matchers.containsString(details.productPrice.toUpperCase()));
	}
	
	public void selectSize()
	{
		getLnkProductsizeProductdetailspage().click();
	}
	
	public void clickAddToBad()
	{
		getLnkAddtobagProductdetailspage().click();
	}
}
