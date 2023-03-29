package io.eric.vendorseleniumtest;

import io.eric.vendorseleniumtest.pages.Page;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendorSeleniumTestApplicationTests {

	@Autowired
	WebDriver webDriver;
	
	@Autowired
	Page page;
	
	@Test
	void runTest() throws InterruptedException {
		page.getHomePage();
		assertEquals(page.getTitle(), "Vendor Portal");
		
		page.getAddVendorPage();
		assertEquals(page.getTitle(), "Add A Vendor");
		
		page.addAVendor();
		assertEquals(page.getTitle(), "Vendor Portal");
		
		page.getEditVendorPage();
		assertEquals(page.getTitle(), "Edit Vendor");
		
		page.editVendorError();
		assertEquals(page.getTitle(),"Edit Vendor");
		assertEquals(page.getZipCodeError(), "Zipcode is zip5 or zip9");
		
		page.editVendor();
		assertEquals(page.getTitle(),"Vendor Portal");
		
		page.deleteVendor();
		assertEquals(page.getTitle(),"Vendor Portal");
		
		page.getAboutPage();
		assertEquals(page.getTitle(), "About Us");
		
		page.quit();
	}
}
