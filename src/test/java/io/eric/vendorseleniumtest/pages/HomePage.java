package io.eric.vendorseleniumtest.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomePage {
	
	@Autowired
	WebDriver webDriver;
	
	@PostConstruct
	public void init(){
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "About")
	public WebElement lnkAbout;
	
	@FindBy(how = How.NAME, using="AddaVendor")
	public WebElement linkAddVendor;
	
	@FindBy(how = How.ID, using = "current-page")
	WebElement page;
	
	@FindBy(how= How.ID, using = "page")
	List<WebElement> pages;
	
	@FindBy(how=How.ID, using="editVendors")
	public List<WebElement> editVendors;
	
	@FindBy(how=How.ID, using="deleteVendors")
	public List<WebElement> deleteVendors;
	
	public void clickAbout(){
		lnkAbout.click();
	}
	
	public void clickAddVendor() {
		linkAddVendor.click();
	}
	
	public void getLastPage() throws InterruptedException {
		List<WebElement> clickPages = pages;
		if(clickPages.size() < 1)
		{
			WebElement currentPage = page;
			Thread.sleep(2000);
			currentPage.click();
		}
		else{
			WebElement pageElement = clickPages.get(clickPages.size() - 1);
			Thread.sleep(2000);
			pageElement.click();
		}
	}
	
	public void clickLastEditElement() throws InterruptedException {
		List<WebElement> clickEditVendors = editVendors;
		WebElement element = clickEditVendors.get(clickEditVendors.size() - 1);
		Thread.sleep(2000);
		element.click();
	}
	
	public void getLastDeleteElement() throws InterruptedException {
		List<WebElement> clickDeleteVendors = deleteVendors;
		WebElement element = clickDeleteVendors.get(clickDeleteVendors.size() - 1);
		Thread.sleep(2000);
		element.click();
	}
}
