package io.eric.vendorseleniumtest.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddAVendorPage {
	
	@Autowired
	WebDriver webDriver;
	
	@PostConstruct
	public void init(){
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(how = How.NAME, using="name")
	public WebElement txtName;
	
	@FindBy(how = How.NAME, using="address")
	public WebElement txtAddress;
	
	@FindBy(how = How.NAME, using="city")
	public WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	public WebElement txtState;
	
	@FindBy(how = How.NAME, using="zipCode")
	public WebElement txtZipCode;
	
	@FindBy(how = How.NAME, using="phoneNumber")
	public WebElement txtPhoneNumber;
	
	@FindBy(how = How.NAME, using="email")
	public WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="addVendor")
	public WebElement btnAddVendor;
	
	public void addVendor(String name, String address, String city, String state, String zipCode, String phoneNumber, String email){
		txtName.sendKeys(name);
		txtAddress.sendKeys(address);
		txtCity.sendKeys(city);
		txtState.sendKeys(state);
		txtZipCode.sendKeys(zipCode);
		txtPhoneNumber.sendKeys(phoneNumber);
		txtEmail.sendKeys(email);
		txtEmail.sendKeys(Keys.TAB);
	}
	
	public void clickAddVendor(){
		btnAddVendor.click();
	}
}
