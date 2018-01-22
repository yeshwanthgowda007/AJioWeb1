package com.ajioweb.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AjiohomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "lnk.category.homepage")
	private QAFWebElement lnkCategoryHomepage;
	@FindBy(locator = "lnk.subCategory.homepage")
	private QAFWebElement lnkSubCategoryHomepage;
	@FindBy(locator = "lnk.popup.homepage")
	private QAFWebElement lnkPopupHomepage;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLnkCategoryHomepage() {
		return lnkCategoryHomepage;
	}

	public QAFWebElement getLnkSubCategoryHomepage() {
		return lnkSubCategoryHomepage;
	}
	
	public QAFWebElement getLnkPopUpHomepage() {
		return lnkPopupHomepage;
	}
	
	@QAFTestStep(description = "user should gets ajio homepage")
	public void verifyHomePage()
	{
		Validator.verifyThat("Home Page verification", driver.getTitle(),Matchers.containsString("Online Shopping for Men: Clothes, Shoes, Tech & more - AJIO"));
	}
	
	@QAFTestStep(description = "user opens ajio application")
	public void openApp()
	{
		driver.get("/");
		driver.manage().window().maximize();
	}
	
	@QAFTestStep(description = "user selects {0} in the menu bar")
	public void clickCategory(String category)
	{
		QAFExtendedWebElement menu=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("lnk.category.homepage"), category));
		Actions action=new Actions(driver);
		action.moveToElement(menu).perform();
		
	}
	
	@QAFTestStep(description = "user selects {0} from the menu")
	public void clickSubCategory(String subCategory)
	{
		QAFExtendedWebElement subMenu=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("lnk.subCategory.homepage"), subCategory));
		subMenu.click();
	}
	
	public void HandlePopup()
	{
		getLnkPopUpHomepage().waitForVisible();
		try {
			if(getLnkPopUpHomepage().isDisplayed()&&getLnkPopUpHomepage().isPresent())
			{
				getLnkPopUpHomepage().click();
			}
		}
		catch(Exception e)
		{
			Reporter.log("Pop-up is not displayed",true);
		}
	}

}
