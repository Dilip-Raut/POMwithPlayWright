package com.qa.Opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	//1 - String Locator - OR 
	private String search="//input[@name='search']";
	private String searchIconClick="div#search button";
	private String searchContentText="div#content h1";
	
	//2 - Page Constructor
	public HomePage(Page page) {
		this.page=page;
	}
	
	//3 - Page Actions/Methods
	public String getHomePageTitle() {
		String title=page.title();
		System.out.println("Page Title  : "+title);
		return title;
	}
	
	public String getHomePageUrl() {
		String url=page.url();
		System.out.println("Page Title  : "+url);
		return url;
	}
	
	public String doSearchProduct(String productName) {
		page.fill(search, productName);
		page.click(searchIconClick);
		String header =page.textContent(searchContentText);
		System.out.println("Header Text is : "+header);
		return header;
	}
}
