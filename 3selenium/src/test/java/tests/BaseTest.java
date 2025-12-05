package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentManager;

public class BaseTest {
	WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
	
	@BeforeSuite
    public void setup() {
        extent = ExtentManager.getInstance();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
	
	@AfterSuite
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
