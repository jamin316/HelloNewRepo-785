package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;


public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
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

	}
	
	
	//@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Rahul Shetty Academy", "Home Page Title DOES NOT match");
	}
	
	//@Test(priority=2)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifyUserNameLabel(), "UserName Label is Missing");
	}

	//@Test(priority=3)
	public void verifyHomePageBtnTest() {
		homePage.verifyHomePageLink();
	}
	
	@Test(priority=4)
	public void verifyFooterLinkLocationTest() {
		homePage.verifyFooterLinksSection();
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
















