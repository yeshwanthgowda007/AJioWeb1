package com.ajioweb.test;

import org.testng.annotations.Test;

import com.ajioweb.pages.AddtocartTestPage;
import com.ajioweb.pages.AjiohomeTestPage;
import com.ajioweb.pages.ProductdetailsTestPage;
import com.ajioweb.pages.SearchresultTestPage;

public class TestFlipkartOrderVerification {
	
	@Test
	public void verifyFlipkartOrder()
	{
		AjiohomeTestPage home=new AjiohomeTestPage();
		home.openApp();
		home.HandlePopup();
		home.verifyHomePage();
		home.clickCategory("MEN");
		home.clickSubCategory("Shirts");
		
		SearchresultTestPage result=new SearchresultTestPage();
		result.verifySearchResultTestPage();
		result.clickSortBy("Price (lowest first)");
		result.verifySortedByPriceLowToHigh();
		result.clickByIndex(1);
		
		ProductdetailsTestPage product=new ProductdetailsTestPage();
		product.verifyProductDetailsTestPage();
		product.selectSize();
		product.clickAddToBad();
		
		AddtocartTestPage cart=new AddtocartTestPage();
		cart.clickAddToCart();
		cart.verifyAddToCartPage();
		
	}

}
