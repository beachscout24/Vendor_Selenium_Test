package io.eric.vendorseleniumtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Page {
	
	@Autowired
	WebDriver webDriver;
	
	@Autowired
	HomePage homePage;
	
	@Autowired
	AddAVendorPage addAVendorPage;
	
	@Autowired
	EditVendorPage editVendorPage;
	
	@Value("${app.url}")
	String appUrl;
	
	public void getHomePage() throws InterruptedException {
		webDriver.navigate().to(appUrl);
		pause();
	}
	
	public void getAboutPage() throws InterruptedException {
		homePage.clickAbout();
		pause();
	}
	
	public void pause() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public void getAddVendorPage() throws InterruptedException {
		homePage.clickAddVendor();
		pause();
	}
	
	public void addAVendor() throws InterruptedException {
		addAVendorPage.addVendor("Test Test", "123 Test Lane", "Test", "TS", "12345", "111-111-1111","test@test.com");
		pause();
		addAVendorPage.clickAddVendor();
		pause();
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public void getEditVendorPage() throws InterruptedException {
		pause();
		scrollToBottomOfPage();
		pause();
		homePage.getLastPage();
		pause();
		homePage.clickLastEditElement();
		pause();
	}
	
	private void scrollToBottomOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void editVendorError() throws InterruptedException {
		editVendorPage.editVendor("Test Test", "123 Test Lane", "Test", "TS", "", "111-111-1111","test@test.com");
		pause();
		editVendorPage.clickEditVendor();
	}
	
	public String getZipCodeError() {
		return editVendorPage.txtZipCodeError.getText();
	}
	
	public void editVendor() throws InterruptedException {
		editVendorPage.editVendor("Test Test", "123 Test Lane", "Test", "TS", "23456", "111-111-1111","test@test.com");
		pause();
		editVendorPage.clickEditVendor();
	}
	
	public void deleteVendor() throws InterruptedException {
		pause();
		scrollToBottomOfPage();
		pause();
		homePage.getLastPage();
		pause();
		homePage.getLastDeleteElement();
		pause();
		
	}
	
	public void quit(){
		webDriver.quit();
	}
}
