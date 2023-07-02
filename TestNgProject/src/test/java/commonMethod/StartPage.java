package commonMethod;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.testng.selenium.TestNgProject.AppTest;

import utils.ExcelUtil;

public class StartPage extends AppTest{
	
	@BeforeMethod()
	public void login() throws IOException {

		oneMoreTest();
	}
	@DataProvider(name ="readExcelData")
	public Object[][] readExcelData() throws IOException {
		String testcaseFilename = "TestNG"; 
		String testcasename = "WindowsHandling";
		
		return utils.ExcelUtil.ExcelRead(testcaseFilename,testcasename);
	}
		
	}


