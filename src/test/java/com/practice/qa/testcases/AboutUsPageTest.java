package com.practice.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.AboutUsPage;
import com.practice.qa.pages.FooterLinksPage;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;

public class AboutUsPageTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	FooterLinksPage footerLinks;
	AboutUsPage aboutUsPage;
	
	public AboutUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		footerLinks = new FooterLinksPage();
		footerLinks.scrollPageToViewLinks();
		aboutUsPage = footerLinks.verifyAboutUsLink();
		
	}
	
	@Test(priority=1)
	public void verifyAboutUsLinkTest() {
		
		footerLinks.scrollPageToViewLinks();
		aboutUsPage.verifyAboutUsLink();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
