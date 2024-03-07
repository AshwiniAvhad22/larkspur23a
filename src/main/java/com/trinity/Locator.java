package com.trinity;

import org.openqa.selenium.By;

public interface Locator {
	
	String REGISTERLINK="//a[contains(text(), 'Register')]";
    String FIRSTNAME ="//input[@id='customer.firstName']";
    String ADDRESS="//input[@id='customer.address.street']";
    String CITY="//input[@id='customer.address.city']";
    String STATE="//input[@id='customer.address.state']";
    String ZIPCODE="//input[@id='customer.address.zipCode']";
    String PHONENO="//input[@id='customer.phoneNumber']";
    String SSN="//input[@id='customer.ssn']";
    String USERNAME="//input[@id='customer.username']";
    String PASSWORD="//input[@id='customer.password']";
    String CONFIRMPASS="//input[@id='repeatedPassword']";
    String REGISTRBTN="//input[@value='Register']";
    String LASTNAMERROR="//span[@class='error']";
}

