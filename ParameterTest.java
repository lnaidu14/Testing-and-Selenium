package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	

	@Test
	@Parameters({"browser","url","emailID"})
	public void yahooLoginTest(String browser, String url, String emailID) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/Lalit/Downloads/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		}else if(browser.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/Lalit/Downloads/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys(emailID);// enter user name
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();//click Next
		
	}

}
