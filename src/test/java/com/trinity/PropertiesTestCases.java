package com.trinity;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.trinity.base.TestBase;
import com.trinity.pages.HomePage;
import com.trinity.utilities.PropUtil;

public class PropertiesTestCases extends TestBase {

	@Test
	public void verifyLastNameFieldIsRequiredOrNot() {

		keyword.driver.get("https://parabank.parasoft.com/parabank/index.htm");
		keyword.driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
		String expectedErrmsg = "Last name is required.";
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.firstName\"]")).sendKeys("Ashwini");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.street\"]")).sendKeys("Pune");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.city\"]")).sendKeys("Pune");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(keyword.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Element was not operation duting 60 sec");
		wait.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"customer.address.state\"]")));

		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.state\"]")).sendKeys("Maharashtra");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.address.zipCode\"]")).sendKeys("4110061");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.phoneNumber\"]")).sendKeys("08830042617");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.ssn\"]")).sendKeys("gdgsjgd");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.username\"]")).sendKeys("ashh");
		keyword.driver.findElement(By.xpath("//input[@id=\"customer.password\"]")).sendKeys("ashu1234");
		keyword.driver.findElement(By.xpath("//input[@id=\"repeatedPassword\"]")).sendKeys("ashu1234");
		keyword.driver.findElement(By.xpath("//input[@value=\"Register\"]")).click();

		String errormsg = keyword.driver.findElement(By.xpath("//span[@class=\"error\"]")).getText();
		// System.out.println(errormsg);
		Assert.assertEquals(errormsg, expectedErrmsg);
	}

	// Using Keyword Driven Framework
	@Test
	public void verifyLastNameFieldIsRequired() throws IOException {

		String expectedErrmsg = "Last name is required.";

		String dir = System.getProperty("user.dir");
		String filepath = dir + "/src/test/resources/Locators.properties";
		PropUtil prop = new PropUtil(filepath);

		String reglink = prop.getValue("REGISTERLINK");
		keyword.click(reglink);

		keyword.click(prop.getValue("REGISTERLINK"));

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
// Using page Object model
	@Test
	public void VerifyLastNameIsrequiredUsingPOM() {
		String expectedErrmsg = "Last name is required.";
		HomePage home = new HomePage();
		home.clickOnRegisterLink();
		home.enterFirstName("Ashwini");
		home.enterAddress("A103 Mumbai east");
		home.enterCity("Mumbai");
		home.enterState("Maharashtra");
		home.enterZipcode("411006");
		home.enterPhoneno("5245735457");
		home.enterSSN("gjdsgjg");
		home.enterUsername("ashh");
		home.enterPassword("ashu1234");
		home.enterConfirmpass("ashu1234");
		home.clickOnRegisterBTN();
		
		String errorMsg=home.getLastNameErrorMsg();
		Assert.assertEquals(errorMsg, expectedErrmsg);
		
	}
	

}
