package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Lalit/Downloads/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Google123", "Title didn't match");
	}
		
	@Test
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//*[@id ='hplogo']")).isDisplayed();
		
		Assert.assertTrue(b);
		//assertEquals can be used similarly to assertTrue
		Assert.assertEquals(b, true);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}