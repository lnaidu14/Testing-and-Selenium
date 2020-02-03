package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeSuite //1
	public void setUp() {
		System.out.println("Setup system property for Chrome");
	}
	
	@BeforeTest //2
	public void launchBrowser() {
		System.out.println("launchBrowser");
	}
	
	@BeforeClass //3
	public void login() {
		System.out.println("loginToApp");
	}
	
	@BeforeMethod //4
	public void enterURL() {
		System.out.println("Enter URL");
	}
	
	
	@Test //5
	public void googleTitleTest() {
		System.out.println("Google title test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("Search test");
	}
	
	@AfterMethod //6
	public void logOut() {
		System.out.println("Logout from app");
	}
	
	@AfterClass //7
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	
	

}
