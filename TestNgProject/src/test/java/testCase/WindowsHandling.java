package testCase;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethod.StartPage;
import webPages.WindowsHandlings;

public class WindowsHandling extends StartPage {

	/*WebDriver driver;

	public WindowsHandling(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}*/
	
	
	public String testCaseName = "WindowsHandling";

	@Test(dataProvider = "readExcelData")
	public void windowshandle(Map<String, String> data) {
		

			WindowsHandlings login = new WindowsHandlings(driver);
			
			login.banklogin(data.get("Firstname"), data.get("Lastname"), data.get("Postal code"));

			driver.quit();
		
	}

}
