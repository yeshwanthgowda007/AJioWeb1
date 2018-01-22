/**
 * 
 */
package com.ajioweb;

import com.ajioweb.pages.AddtocartTestPage;
import com.ajioweb.pages.AjiohomeTestPage;
import com.ajioweb.pages.ProductdetailsTestPage;
import com.ajioweb.pages.SearchresultTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

public class StepsBackLog {
	
	AjiohomeTestPage home=new AjiohomeTestPage();
	SearchresultTestPage result=new SearchresultTestPage();
	ProductdetailsTestPage product=new ProductdetailsTestPage();
	AddtocartTestPage cart=new AddtocartTestPage();

	@QAFTestStep(description = "user opens ajio application")
	public void userOpensAjioApplication() {
		home.openApp();
		home.HandlePopup();
	}

	@QAFTestStep(description = "user should gets ajio homepage")
	public void userShouldGetsAjioHomepage() {
		home.verifyHomePage();
	}

	@QAFTestStep(description = "user selects sort by {0}")
	public void userSelectsSortBy(String sortBy) {
		result.clickSortBy("Price (lowest first)");
	}

	@QAFTestStep(description = "user should gets search result page")
	public void userShouldGetsSearchResultPage() {
		result.verifySearchResultTestPage();
	}

	@QAFTestStep(description = "user verifies the product list is sorted or not")
	public void userVerifiesTheProductListIsSortedOrNot() {
		result.verifySortedByPriceLowToHigh();
	}

	@QAFTestStep(description = "user selects the product by index {0}")
	public void userSelectsTheProductByIndex(String index) {
		result.clickByIndex(Integer.parseInt(index));
	}

	@QAFTestStep(description = "user should gets the product details page")
	public void userShouldGetsTheProductDetailsPage() {
		product.verifyProductDetailsTestPage();
	}

	@QAFTestStep(description = "user selects the size")
	public void userSelectsTheSize() {
		product.selectSize();
	}

	@QAFTestStep(description = "user clicks on Add to cart link")
	public void userClicksOnAddToCartLink() {
		product.clickAddToBad();
	}

	@QAFTestStep(description = "the product should be added to the cart")
	public void theProductShouldBeAddedToTheCart() {
		cart.clickAddToCart();
		cart.verifyAddToCartPage();
	}

	@QAFTestStep(description = "user selects {0} in the menu bar")
	public void userSelectsInTheMenuBar(String menu) {
		home.clickCategory(menu);
	}

	@QAFTestStep(description = "user selects {0} from the menu")
	public void userSelectsFromTheMenu(String subMenu) {
		home.clickSubCategory(subMenu);
	}

}
