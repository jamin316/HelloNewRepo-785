package com.practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR[Object Repository]

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='bodySmall m-b-3-xs text-center-xs auth-flash-error']")
	WebElement emailErr;
	
	@FindBy(xpath = "//div[@class='bodySmall m-b-3-xs text-center-xs auth-flash-error']")
	WebElement passwordErr;
	
	@FindBy(xpath = "//div[@class='bodySmall m-b-3-xs text-center-xs auth-flash-error']")
	WebElement globalErr;

	// Initialize the Page Objects - this means pointing to current page
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String em, String pwd) throws InterruptedException {

		email.sendKeys(em);
		password.sendKeys(pwd);
		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Rahul Shetty Academy"));

		// After clicking on login button -> Redirects to HOME PAGE

		return new HomePage();
	}
	
	public String emptyEmailandPass() {

		String actual = globalErr.getText();
		System.out.println(actual);
		return actual;
	}
	
	public String emptyEmail() {
		
		String actual = emailErr.getText();
		System.out.println(actual);
		return actual;
		
	}
	
	public String emptyPass() {
		String actual = passwordErr.getText();
		System.out.println(actual);
		return actual;
		
	}
	
	public String wrongEmail() {
	
		String actual = emailErr.getText();
		System.out.println(actual);
		return actual;
	}
	
	public String wrongPass() {
	
		String actual = passwordErr.getText();
		System.out.println(actual);
		return actual;
		
	}
	
	public String wrongEmailAndPass() {
		
		String actual = globalErr.getText();
		System.out.println(actual);
		return actual;
		
	}
	
	
	

}
