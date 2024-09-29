package com.qa.Opencart.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.Opencart.Factory.PlayWrightFactory;
import com.qa.Opencart.pages.HomePage;

public class HomePageTest {

	PlayWrightFactory pf;
	Page page;
	HomePage homePage;
	
	@BeforeTest
	public void setup() {
		pf = new PlayWrightFactory();
		page = pf.initBrowser("chromium");
		homePage=new HomePage(page);
	}
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");
	}
	
	@Test
	public void homePageUrlTest() {
		String actualUrl = homePage.getHomePageUrl();
		Assert.assertEquals(actualUrl, "https://naveenautomationlabs.com/opencart/");
	}
	
	@Test
	public void searchProduct() {
		String actualHeader = homePage.doSearchProduct("macbook");
		Assert.assertEquals(actualHeader, "Search - macbook");
	}
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
