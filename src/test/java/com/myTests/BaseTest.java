package com.myTests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public static final String USERNAME = "glsagarsggmailco1";
	public static final String AUTOMATE_KEY = "B6xKF8iG2ny4nkgRGxGc";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	
@Parameters({"browser", "browser_version", "os", "os_version"})
@BeforeMethod
public void setUp(String browserName, String browser_version, String os, String os_version, Method name) {
	String methodName = name.getName();
	System.out.println("Browser name is : "+browserName);
	//Here we set the MutableCapabilities for "sauce:options", which is required for newer versions of Selenium.

	DesiredCapabilities caps = new DesiredCapabilities();
    
	caps.setCapability("os", os);
	caps.setCapability("os_version", os_version);
	caps.setCapability("browser_version", browser_version);
	caps.setCapability("name", methodName);
	caps.setCapability("name", "glsagarsggmailco1's First Test");
	
	if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		caps.setCapability("browserName", browserName);
	} else if (browserName.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		caps.setCapability("browserName", "Firefox");
	}
	
	try {
		driver=new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	

	
}
