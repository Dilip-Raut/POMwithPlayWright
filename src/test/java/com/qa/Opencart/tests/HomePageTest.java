package com.qa.Opencart.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import com.qa.Opencart.base.BaseTest;
import com.qa.Opencart.constants.AppConstants;

public class HomePageTest extends BaseTest {

	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		AssertJUnit.assertEquals(actualTitle, AppConstants.Login_Page_Title);
	}
	
	@Test
	public void homePageUrlTest() {
		String actualUrl = homePage.getHomePageUrl();
		AssertJUnit.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"macbook"},
			{"iMac"},
			{"samsung"}
		};
	}
	
	
	
	@Test(dataProvider = "getProductData")
	public void searchProduct(String productName) {
		String actualHeader = homePage.doSearchProduct(productName);
		AssertJUnit.assertEquals(actualHeader, "Search - "+productName);
	}
	
}
