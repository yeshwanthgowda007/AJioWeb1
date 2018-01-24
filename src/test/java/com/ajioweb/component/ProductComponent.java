package com.ajioweb.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent extends QAFWebComponent {

	public ProductComponent(String locator) {
		super(locator);
	}

	@FindBy(locator = "lnk.productname.searchresultpage")
	private QAFWebElement lnkProductnameSearchresultpage;
	@FindBy(locator = "lnk.productbrand.searchresultpage")
	private QAFWebElement lnkProductbrandSearchresultpage;
	@FindBy(locator = "lnk.productprice.searchresultpage")
	private QAFWebElement lnkProductpriceSearchresultpage;
	@FindBy(locator = "lnk.discount.searchresultpage")
	private QAFWebElement lnkDiscountSearchresultpage;

	public QAFWebElement getLnkProductnameSearchresultpage() {
		return lnkProductnameSearchresultpage;
	}

	public QAFWebElement getLnkProductbrandSearchresultpage() {
		return lnkProductbrandSearchresultpage;
	}

	public QAFWebElement getLnkProductpriceSearchresultpage() {
		return lnkProductpriceSearchresultpage;
	}

	public QAFWebElement getLnkDiscountSearchresultpage() {
		return lnkDiscountSearchresultpage;
	}

}
