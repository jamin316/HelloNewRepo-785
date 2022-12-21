package com.practice.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

public class FooterLinksPage extends TestBase{
	

	@FindBy(xpath = "//a[contains(text(),'About Us')]")
	WebElement aboutbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	WebElement contactUsbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicybtn;
	
	@FindBy(xpath = "//div[contains(text(), 'All Right Reserved ')]")
	WebElement copyRightText;


	// Initializing Page Objects
	public FooterLinksPage() {
			PageFactory.initElements(driver, this);
	}
	
	public void scrollPageToViewLinks() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(375, 5805)");
	}
	
	
	public AboutUsPage verifyAboutUsLink() {
		
		aboutbtn.click();
		return new AboutUsPage();
		
	}
	

	public ContactUsPage verifyContactUsLink() {
		
		contactUsbtn.click();
		return new ContactUsPage();
		
	}
	

	public PrivacyPolicyPage verifyPrivacyPolicyLink() {
		
		privacyPolicybtn.click();
		return new PrivacyPolicyPage();
	}
	
	
	public boolean verifyCopyRightText() {
		
		String text = copyRightText.getText();
		System.out.println(text);
		
		return copyRightText.isDisplayed();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
