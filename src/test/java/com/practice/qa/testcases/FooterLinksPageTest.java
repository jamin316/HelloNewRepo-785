package com.practice.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.FooterLinksPage;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;

public class FooterLinksPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	FooterLinksPage footerLinks;
	
	public FooterLinksPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		footerLinks = new FooterLinksPage();
		footerLinks.scrollPageToViewLinks();
	}
	
	@Test(priority=1)
	public void verifyAboutUsLinkTest() {
		
		footerLinks.verifyAboutUsLink();
	}
	
	@Test(priority=2)
	public void verifyContacttUsLinkTest() {
		
		footerLinks.verifyContactUsLink();
	}
	
	@Test(priority=3)
	public void verifyPrivacyPolicyLinkTest() {
		
		footerLinks.verifyPrivacyPolicyLink();
	}
	
	@Test(priority=4)
	public void verifyCopyRightTextTest() {
		
		footerLinks.verifyCopyRightText();
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
