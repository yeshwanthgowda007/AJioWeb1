package com.ajioweb.pages;

import java.util.List;
import java.util.TreeSet;

import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ajioweb.Bean.ProductInfoBean;
import com.ajioweb.component.ProductComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "lnk.productname.searchresultpage")
	private QAFWebElement lnkProductnameSearchresultpage;
	@FindBy(locator = "lnk.productbrand.searchresultpage")
	private QAFWebElement lnkProductbrandSearchresultpage;
	@FindBy(locator = "lnk.productprice.searchresultpage")
	private QAFWebElement lnkProductpriceSearchresultpage;
	@FindBy(locator = "drp.sortby.searchresultpage")
	private QAFWebElement drpSortbySearchresultpage;
	@FindBy(locator = "lnk.productdivision.searchresultpage")
	private List<ProductComponent> lnkProductDivisionSearchresultpage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLnkProductnameSearchresultpage() {
		return lnkProductnameSearchresultpage;
	}

	public QAFWebElement getLnkProductbrandSearchresultpage() {
		return lnkProductbrandSearchresultpage;
	}

	public QAFWebElement getLnkProductpriceSearchresultpage() {
		return lnkProductpriceSearchresultpage;
	}

	public QAFWebElement getDrpSortbySearchresultpage() {
		return drpSortbySearchresultpage;
	}
	
	public List<ProductComponent> getlnkProductDivisionSearchresultpage() {
		return lnkProductDivisionSearchresultpage;
	}
	
	public void verifySearchResultTestPage()
	{
		//Validator.verifyThat("SearchResultTestPage Verification",driver.getTitle(),Matchers.containsString("Shirts Online: upto 70%+ Off on Formal & Casual Shirts for Men - AJIO"));
		Validator.verifyThat("verifying the products ", getlnkProductDivisionSearchresultpage().size(),Matchers.greaterThan(0));
	}
	
	public void clickSortBy(String visibleText)
	{
		Select select=new Select(getDrpSortbySearchresultpage());
		select.selectByVisibleText(visibleText);
		QAFTestBase.pause(2000);
	}
	
	public void clickByIndex(int index)
	{
		
		ProductInfoBean bean=new ProductInfoBean();
		bean.setProductBrand(getlnkProductDivisionSearchresultpage().get(index).getLnkProductbrandSearchresultpage().getText());
		bean.setProductName(getlnkProductDivisionSearchresultpage().get(index).getLnkProductnameSearchresultpage().getText());
		bean.setProductPrice(getlnkProductDivisionSearchresultpage().get(index).getLnkProductpriceSearchresultpage().getText());
		
		ConfigurationManager.getBundle().addProperty("product.information", bean);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", getlnkProductDivisionSearchresultpage().get(index).getLnkProductnameSearchresultpage());
	}
	
	public void verifySortedByPriceLowToHigh()
	{
		TreeSet<Integer>tree=new TreeSet<Integer>();
		for(ProductComponent p: getlnkProductDivisionSearchresultpage())
		{
			String price=p.getLnkProductpriceSearchresultpage().getText();
			String pr=price.substring(4,price.length());
			tree.add(Integer.parseInt(pr));
		}
		String str=getlnkProductDivisionSearchresultpage().get(0).getLnkProductpriceSearchresultpage().getText();
		String s=str.substring(4,str.length());
		if(tree.first()==Integer.parseInt(s))
		{
			Reporter.log(tree.first()+" It is sorted ",true);
		}
		else
		{
			Reporter.log(tree.first()+" it is not sorted ",true);
		}
	}
	
}
