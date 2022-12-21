package com.practice.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.FirstPageofWebsite;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;


public class FirstPageofWebsiteTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	FirstPageofWebsite firstPage;
	
	public FirstPageofWebsiteTest() {
		super();
	}
	
	/*--------------------IMPORTANT--------------------*/
	// Test Cases should be Independent from each other
	// Before each Test Case -- Launch the browser
	// @Test -- Execute Test Cases
	// After each Test Case -- Close the Browser
	/*--------------------IMPORTANT--------------------*/
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		firstPage = homePage.verifyHomePageLink();
		
	}
		
	
	@Test(priority=1)
	public void verifyAllAccessPlanLinkTest() {
		firstPage.verifyJoinNowButtonLink();
	}
	
	//@Test(priority=3)
	public void verifyLearningPathsLinkTest() {
		homePage.verifyHomePageLink();
	}
	
	//@Test(priority=4)
	public void verifyMentorshipLinkTest() {
		homePage.verifyHomePageLink();
	}
	
	//@Test(priority=5)
	public void verifyJobSupportLinkTest() {
		homePage.verifyHomePageLink();
	}
	
	//@Test(priority=6)
	public void verifyPracticeLinkTest() {
		homePage.verifyHomePageLink();
	}
	
	//@Test(priority=7)
	public void verifyBlogLinkTest() {
		homePage.verifyHomePageLink();
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	

}
