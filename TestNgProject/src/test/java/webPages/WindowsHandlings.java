package webPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testng.selenium.TestNgProject.AppTest;

public class WindowsHandlings  extends AppTest{

	WebDriver driver;

	public WindowsHandlings(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Bank Manager Login']")
	WebElement clickLogin;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement Firstname;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement Lastname;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postalCode;

	@FindBy(xpath = "//button[text()='Add Customer']")
	WebElement AddCustomer;

	public void banklogin(String fname, String lname, String postalcode) {
		try {
			
			clickLogin.click();

			WebDriverWait loadindAddAccount = new WebDriverWait(driver, Duration.ofSeconds(10));
			loadindAddAccount.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//button[@class='btn btn-lg tab'][@ng-class='btnClass1']")));

			driver.findElement(By.xpath("//button[@class='btn btn-lg tab'][@ng-class='btnClass1']")).click();
			
			Thread.sleep(5000);
			Firstname.sendKeys(fname);
			Lastname.sendKeys(lname);
			postalCode.sendKeys(postalcode);
			AddCustomer.click();
			Thread.sleep(5000);
			//driver.switchTo().alert().sendKeys("Jerry");
			// System.out.println(alrt);
			driver.switchTo().alert().accept();
			driver.findElement(By.xpath("//button[@ng-class='btnClass3']")).click();
			WebElement customerfieldselect = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Mano']")));
			System.out.println(customerfieldselect.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
