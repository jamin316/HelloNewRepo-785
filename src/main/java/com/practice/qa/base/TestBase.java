package com.practice.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.practice.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("C:\\SELENIUM\\Selenium_WorkSpace\\POMTestAutomation"
					+ "\\src\\main\\java\\com\\practice\\qa\\config\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");

		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/SELENIUM/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/SELENIUM/SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.safari.driver", "C:/SELENIUM/SeleniumJars/safaridriver.exe");
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait_Time));
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}
}
