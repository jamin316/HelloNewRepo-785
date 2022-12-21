package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

public class AboutUsPage extends TestBase{

	@FindBy(xpath = "//ul[@class='footer-nav']//li[1]")
	WebElement aboutbtn;
	
	
	
	// Initializing Page Objects
	public AboutUsPage() {
			PageFactory.initElements(driver, this);
	}
	
	
	public void verifyAboutUsLink() {
		
		aboutbtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
