package com.qa.Opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.Opencart.Factory.PlayWrightFactory;
import com.qa.Opencart.pages.HomePage;

public class BaseTest {

	PlayWrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		pf = new PlayWrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
