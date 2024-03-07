package com.trinity;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

	@Test
	public void verifyLastNameFieldIsRequiredOrNot() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
		String expectedErrmsg = "Last name is required.";
		driver.findElement(By.xpath("//input[@id=\"customer.firstName\"]")).sendKeys("Ashwini");
		driver.findElement(By.xpath("//input[@id=\"customer.address.street\"]")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@id=\"customer.address.city\"]")).sendKeys("Pune");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Element was not operation duting 60 sec");
		wait.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"customer.address.state\"]")));

		driver.findElement(By.xpath("//input[@id=\"customer.address.state\"]")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@id=\"customer.address.zipCode\"]")).sendKeys("4110061");
		driver.findElement(By.xpath("//input[@id=\"customer.phoneNumber\"]")).sendKeys("08830042617");
		driver.findElement(By.xpath("//input[@id=\"customer.ssn\"]")).sendKeys("gdgsjgd");
		driver.findElement(By.xpath("//input[@id=\"customer.username\"]")).sendKeys("ashh");
		driver.findElement(By.xpath("//input[@id=\"customer.password\"]")).sendKeys("ashu1234");
		driver.findElement(By.xpath("//input[@id=\"repeatedPassword\"]")).sendKeys("ashu1234");
		driver.findElement(By.xpath("//input[@value=\"Register\"]")).click();

		String errormsg = driver.findElement(By.xpath("//span[@class=\"error\"]")).getText();
		// System.out.println(errormsg);
		Assert.assertEquals(errormsg, expectedErrmsg);
	}

	
	//Using Keyword Driven Framework
	@Test
	public void verifyLastNameFieldIsRequired() {
		Keyword keyword = new Keyword();

		keyword.openBrowser("Chrome");
		//keyword.launchUrl(Config.APPURL);
		keyword.click(Locator.REGISTERLINK);
		String expectedErrmsg = "Last name is required.";
		keyword.enterText(Locator.FIRSTNAME, "ashwini");
		keyword.enterText(Locator.ADDRESS, "pune");
		keyword.enterText(Locator.CITY, "pune");
		keyword.enterText(Locator.STATE, "MAHARASHTA");
		keyword.enterText(Locator.ZIPCODE, "411061");
		keyword.enterText(Locator.PHONENO, "883002455");
		keyword.enterText(Locator.SSN, "hjgxjcgxuf");
		keyword.enterText(Locator.USERNAME, "ashh");
		keyword.enterText(Locator.PASSWORD, "fd56");
		keyword.enterText(Locator.CONFIRMPASS, "fd56");
		keyword.click(Locator.REGISTRBTN);
		String errormsg = keyword.getText(Locator.LASTNAMERROR);
		Assert.assertEquals(errormsg, expectedErrmsg);
	}
}
