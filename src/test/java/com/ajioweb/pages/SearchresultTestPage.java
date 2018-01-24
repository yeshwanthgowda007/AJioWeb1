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
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
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
	@FindBy(locator = "lnk.discountpercentage.searchresultpage")
	private QAFWebElement lnkDiscountpercentageSearchresultpage;
	@FindBy(locator = "lnk.discount.searchresultpage")
	private QAFWebElement lnkDiscountSearchresultpage;
	@FindBy(locator = "lnk.brands.searchresultpage")
	private QAFWebElement lnkBrandsSearchresultpage;

	public void setLnkBrandsSearchresultpage(QAFWebElement lnkBrandsSearchresultpage) {
		this.lnkBrandsSearchresultpage = lnkBrandsSearchresultpage;
	}

	public void setLnkDiscountpercentageSearchresultpage(
			QAFWebElement lnkDiscountpercentageSearchresultpage) {
		this.lnkDiscountpercentageSearchresultpage =
				lnkDiscountpercentageSearchresultpage;
	}

	public void setLnkDiscountSearchresultpage(
			QAFWebElement lnkDiscountSearchresultpage) {
		this.lnkDiscountSearchresultpage = lnkDiscountSearchresultpage;
	}

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
	
	public QAFWebElement getLnkBrandsSearchresultpage() {
		return lnkBrandsSearchresultpage;
	}

	public List<ProductComponent> getlnkProductDivisionSearchresultpage() {
		return lnkProductDivisionSearchresultpage;
	}

	public QAFWebElement getLnkDiscountpercentageSearchresultpage() {
		return lnkDiscountpercentageSearchresultpage;
	}

	public QAFWebElement getLnkDiscountSearchresultpage() {
		return lnkDiscountSearchresultpage;
	}

	public void verifySearchResultTestPage() {
		//Validator.verifyThat("SearchResultTestPage Verification",driver.getTitle(),Matchers.containsString("Shirts Online: upto 70%+ Off on Formal & Casual Shirts for Men - AJIO"));
		Validator.verifyThat("verifying the products ",
				getlnkProductDivisionSearchresultpage().size(), Matchers.greaterThan(0));
	}

	public void clickSortBy(String visibleText) {
		Select select = new Select(getDrpSortbySearchresultpage());
		select.selectByVisibleText(visibleText);
		QAFTestBase.pause(2000);
	}

	public void clickByIndex(int index) {

		ProductInfoBean bean = new ProductInfoBean();
		bean.setProductBrand(getlnkProductDivisionSearchresultpage().get(index)
				.getLnkProductbrandSearchresultpage().getText());
		bean.setProductName(getlnkProductDivisionSearchresultpage().get(index)
				.getLnkProductnameSearchresultpage().getText());
		bean.setProductPrice(getlnkProductDivisionSearchresultpage().get(index)
				.getLnkProductpriceSearchresultpage().getText());

		ConfigurationManager.getBundle().addProperty("product.information", bean);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()",
				getlnkProductDivisionSearchresultpage().get(index)
						.getLnkProductnameSearchresultpage());
	}

	public void verifySortedByPriceLowToHigh() {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (ProductComponent p : getlnkProductDivisionSearchresultpage()) {
			String price = p.getLnkProductpriceSearchresultpage().getText();
			String pr = price.substring(4, price.length());
			tree.add(Integer.parseInt(pr));
		}
		String str = getlnkProductDivisionSearchresultpage().get(0)
				.getLnkProductpriceSearchresultpage().getText();
		String s = str.substring(4, str.length());
		if (tree.first() == Integer.parseInt(s)) {
			Reporter.log(tree.first() + " It is sorted ", true);
		} else {
			Reporter.log(tree.first() + " it is not sorted ", true);
		}
	}

	public void clickDiscountFilter(String discount) {
		QAFExtendedWebElement discountCheckBox =
				new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle()
						.getString("lnk.discountpercentage.searchresultpage"), discount));
		Validator.verifyThat(discountCheckBox.isEnabled(), Matchers.equalTo(true));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", discountCheckBox);
		QAFTestBase.pause(2000);
	}

	public void verifyDiscountDisplayed(String discount) {
		for (ProductComponent p : getlnkProductDivisionSearchresultpage()) {
			int start = 0;
			int end = 0;
			if (discount.length() > 5) {
				start = Integer.parseInt(discount.substring(0, 2));
				end = Integer.parseInt(discount.substring(3, 5));
			} else {
				start = Integer.parseInt(discount.substring(0, 1));
				end = Integer.parseInt(discount.substring(2, 4));
			}

			int disc1 = Integer.parseInt(
					p.getLnkDiscountSearchresultpage().getText().substring(1, 3));
			if (disc1 >= start && disc1 <= end) {
				Reporter.log("Sorted by Discount", true);
			} else {
				Reporter.log("Not sorted by discount", true);
			}
		}
	}
	
	public void clickBrandFilter(String brand)
	{
		QAFExtendedWebElement brandCheckBox=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("lnk.brands.searchresultpage"), brand));
		Validator.verifyThat(brandCheckBox.isEnabled(), Matchers.equalTo(true));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", brandCheckBox);
		QAFTestBase.pause(2000);
		
	}
	
	public void verifyBrandNameDisplayed(String brand)
	{
		for (ProductComponent p : getlnkProductDivisionSearchresultpage()) {
			if(p.getLnkProductbrandSearchresultpage().getText().equalsIgnoreCase(brand))
			{
				Reporter.log("Filtered according to brand",true);
			}
			else
			{
				Reporter.log("Not filtered according to brand",true);
			}
		}		
	}	
}
