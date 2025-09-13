package tests;

import org.testng.annotations.Test;

//import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		
		Log.info("Start Test...");
		test = ExtentReportManager.createTest("Test 1 test Valid Login ");
		
		Log.info("Enter Credentials");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		
		Log.info("Click Login");
		loginPage.clickLogin();
		
		Log.info("Login Pass");
	
	}

}
