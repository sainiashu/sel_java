package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
		//String reportPath = ExtentReportManager.reportPath;
		//EmailUtils.sendTestReport(reportPath);
	}
	
	@BeforeMethod
	public void setup() {
		
		Log.info("Starting WebDriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Log.info("Navigate to url");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			Log.info("quit the browser");
			driver.quit();
		}
		
	}

}
