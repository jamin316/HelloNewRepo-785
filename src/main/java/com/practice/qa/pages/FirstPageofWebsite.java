package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

public class FirstPageofWebsite extends TestBase {

	
	@FindBy(xpath = "//div[@class='col-md-6 text-left'] //a[contains(text(),'JOIN NOW')]")
	WebElement joinNowbtn;
	
	@FindBy(xpath = "//h3[contains(text(),'Access to All Courses')]")
	WebElement allAccessCoursesbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement learningPathsbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement mentorshipbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement jobSupportbtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement practicebtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement blogbtn;
	
	
	// Initializing Page Objects
	public FirstPageofWebsite() {
			PageFactory.initElements(driver, this);
	}

	// Actions
	public void verifyAllAccessPlanLink() {
		allAccessCoursesbtn.click();
	}
	
	public HomePage verifyJoinNowButtonLink() {
		
		joinNowbtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
	

}
