package com.email;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEmail {
	WebDriver driver;
	

	@Test(priority = 1)
	@Parameters({ "url" })
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/Lalit/Downloads/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(priority = 2, dependsOnMethods = "setUp")
	@Parameters({ "emailID", "pWord" })
	public void loginTest(String emailID, String pWord) {
		// Entering email ID
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(emailID);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();

		// Entering password
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pWord);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
	}

	// Composing email
	@Test(priority = 3, dependsOnMethods = "loginTest")
	@Parameters({ "emailID", "subject", "body" })
	public void composeEmail(String emailID, String subject, String body) {
		driver.findElement(By.xpath("//*[contains(text(), 'Compose')]")).click();// Clicking compose
		driver.findElement(By.name("to")).clear();
		driver.findElement(By.name("to")).sendKeys(emailID);// Entering recipient
		driver.findElement(By.name("subjectbox")).clear();
		driver.findElement(By.name("subjectbox")).sendKeys(subject);// Entering subject
		driver.findElement(By.xpath("//div[@class = 'Am Al editable LW-avf tS-tW']")).clear();
		driver.findElement(By.xpath("//div[@class = 'Am Al editable LW-avf tS-tW']")).sendKeys(body);// Entering body
		driver.findElement(By.xpath("//div[@class='J-JN-M-I J-J5-Ji Xv L3 T-I-ax7 T-I']//div[@class='J-J5-Ji J-JN-M-I-JG']")).click();// Pressing extra options triple dot button
		driver.findElement(By.xpath("//div[@class='J-N-Jz'][contains(text(),'Label')]")).click(); //Click Label
		driver.findElement(By.xpath("//div[@class='J-LC-Jz'][contains(text(),'Social')]")).click();// Clicking on Social																							// "Social"
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();// Pressing SEND key
	}

	// Starring and verification
	@Test (priority = 4, dependsOnMethods = "composeEmail") 
	public void verificationStage() {
		driver.findElement(By.xpath("//div[@class='aKz'][contains(text(),'Social')]")).click();//Switching to Social tab 
		boolean staleElement = true; //Catching staleElementException and then clicking both the star symbol and also opening the mail
		
		while(staleElement) {
			try {
				driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")).click();
				driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]")).click();
				staleElement = false;
			} catch(StaleElementReferenceException e) {
				staleElement = true;
			}
		}
		

		}
	
	@Test (priority =5, dependsOnMethods = "verificationStage")
	public void tearDown() {
		//driver.quit();
	}
		
	}


		   
	
