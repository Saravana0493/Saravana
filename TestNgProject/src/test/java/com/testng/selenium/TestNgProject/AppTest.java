package com.testng.selenium.TestNgProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ExcelUtil;

/**
 * Unit test for simple App.
 */
public class AppTest extends ExcelUtil implements FrameworkInterface{
	
	public WebDriver driver;
	
	
   
	public void oneMoreTest() throws IOException {

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
			// maximize the browser
			driver.manage().window().maximize();
			// Wait until page load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
