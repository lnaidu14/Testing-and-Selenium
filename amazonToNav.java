package com.mobiuxTestAssignmentAmazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazonToNav {
	
	WebDriver driver; 
	@Test(priority=1)
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","/Users/Lalit/Downloads/chromedriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://amazon.in");
	}
	
	@Test(priority = 2, dependsOnMethods = "setUp")
	public void navAmazon() {
	driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Wrist Watches");//Entering "Wrist Watches" into search bar
	driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();//Clicking the search button
	driver.findElement(By.xpath("//body[@class='a-aui_157141-c a-aui_72554-c a-aui_dropdown_187959-c a-aui_pci_risk_banner_210084-c a-aui_perf_130093-c a-aui_tnr_v2_180836-c a-aui_ux_145937-c a-meter-animate']/div/div[@class='s-desktop-container']/div[@class='s-desktop-width-max s-desktop-content sg-row']/div[@class='sg-col-4-of-24 sg-col-4-of-12 sg-col-4-of-36 sg-col-4-of-28 sg-col-4-of-16 sg-col sg-col-4-of-20 sg-col-4-of-32']/div[@class='sg-col-inner']/div[@class='a-section a-spacing-double-large']/span[@class='rush-component']/div[@class='a-section']/div[@class='a-section a-spacing-none']/ul[3]/li[1]/span[1]/a[1]/span[1]")).click();//Clicking the "Analogue" category
	driver.findElement(By.xpath("//li[@id='p_n_material_browse/1480907031']//span[@class='a-size-base a-color-base'][contains(text(),'Leather')]")).click(); // Clicking "Leather" category
	driver.findElement(By.xpath("//span[@class='a-expander-prompt']")).click();//Clicking "See more" because "Titan" category is hidden
	driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'Titan')]")).click();//Clicking "Titan" category
	driver.findElement(By.xpath("//span[contains(text(),'25% Off or more')]")).click();//Choosing category for discount "25% Off or more"
	driver.findElement(By.xpath("//div[@data-cel-widget = 'search_result_4']")).click();//Choosing the fifth element out of the results
}
	
	@Test(priority =3)
	public void tearDown() {
		//driver.quit();
	}
}
