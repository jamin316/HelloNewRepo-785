package com.practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.practice.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath = "//span[contains(text(),'jinal amin')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement homePagebtn;
	
	@FindBy(xpath = "//div[@class='row clearfix']")
	WebElement footerLinks;
	
	// Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public FirstPageofWebsite verifyHomePageLink() {
		
		homePagebtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Rahul Shetty Academy"));

		
		return new FirstPageofWebsite();
	}
	
	public Point verifyFooterLinksSection() {
		
		Point location = footerLinks.getLocation();
		System.out.println(location);
		return location;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}














