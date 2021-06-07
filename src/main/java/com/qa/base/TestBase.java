//package com.qa.base;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.qa.util.TestUtil;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//public class TestBase{
//
//	/* Initilize all my properties and launch browser */
//
//	public static WebDriver driver;
//	public static Properties prop;
//	
//	
//	public TestBase() {
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(
//					System.getProperty("user.dir") + "/src/main/java/com" + "/qa/properties/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void initialization() {
//		String browserName = prop.getProperty("browser");
//
//		if (browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			//System.setProperty("webdriver.chrome.driver", "/Users/swath/eclipse-workspace/SeleniumCloud_SauceLabs/ExternalJars/chromedriver.exe");
//			driver = new ChromeDriver();
//			
//		} else if (browserName.equals("FF")) {
////			WebDriverManager.firefoxdriver().setup();
////			driver=new FirefoxDriver();
//			System.out.println("FirefoxDriver");
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		
//		driver.get(prop.getProperty("url"));
//		
//	}
//	
//	
//	
//}