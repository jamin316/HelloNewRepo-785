package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super(); // will call TestBase class - super class - parent class
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();

	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Rahul Shetty Academy");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void emptyEmailAndPasswordTest() throws InterruptedException {
		
		loginPage.login("", "");
		Assert.assertEquals(loginPage.emptyEmailandPass(), "Your email or password is incorrect.");
	
	}
	
	@Test(priority=4)
	public void emptyEmailTest() throws InterruptedException {
		
		loginPage.login("", "Rajipa@1612$");
		Assert.assertEquals(loginPage.emptyEmail(), "Your email or password is incorrect.");
	}
	
	@Test(priority=5)
	public void emptyPasswordTest() throws InterruptedException {
		
		loginPage.login("jinalamin3796@gmail.com", "");
		Assert.assertEquals(loginPage.emptyPass(), "Your email or password is incorrect.");
	}
	
	@Test(priority=6)
	public void wrongEmailTest() throws InterruptedException {
		
		loginPage.login("asfdg@ugyas.adkghs", "Rajipa@1612$");
		Assert.assertEquals(loginPage.wrongEmail(), "Your email or password is incorrect.");
	}
	
	@Test(priority=7)
	public void wrongPasswordTest() throws InterruptedException {
	
		loginPage.login("jinalamin3796@gmail.com", "hsafdiyskdga@6ewdt");
		Assert.assertEquals(loginPage.wrongPass(), "Your email or password is incorrect.");
	}
	
	@Test(priority=8)
	public void wrongEmailAndPasswordTest() throws InterruptedException {
		
		loginPage.login("asfdg@ugyas.adkghs", "hsafdiyskdga@6ewdt");
		Assert.assertEquals(loginPage.wrongEmailAndPass(), "Your email or password is incorrect.");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}



