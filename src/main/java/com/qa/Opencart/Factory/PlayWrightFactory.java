package com.qa.Opencart.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
    Properties prop;

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser Name is : " + browserName);
		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Please Provide the correct Browser Name.......");
			System.exit(0);
			break;
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		
		page.navigate(prop.getProperty("url"));
		
		return page;

	}
	
	/* 
	 * This Method Initialize the Properties file From Config File
	 */
	public Properties init_prop()  {
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/Config/Config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	
	
	
}
