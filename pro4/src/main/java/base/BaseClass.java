package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import pages.BasePage;
import pages.Home;
import pages.ProductPage;
import pages.SearchResults;
import pages.TodaysDeals;
import utils.CommonMethods;
import utils.WaitUtils;

public class BaseClass {
	public static WebDriver dr;
	public static Actions actions;
	public static BasePage basePage;
	public static Home home;
	public static ProductPage productPage;
	public static SearchResults searchResults;
	public static TodaysDeals todaysDeals;
	public static CommonMethods commonMethods;
	public static WaitUtils waitYtils;
	public static Properties p;
	public static ChromeOptions options;
	//public static WebElement lastInteracted;
	//public static boolean testFailed = false;
	
	public static void setUp() {
		p = new Properties();
		try {
			p.load(new FileInputStream("src/main/resources/urls.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Selenium/TempProfile");
        options.addArguments("--no-first-run");
		dr = new ChromeDriver(options);
		dr.manage().window().maximize();
		basePage = new BasePage(dr);
		home = new Home(dr);
		productPage = new ProductPage(dr);
		searchResults = new SearchResults(dr);
		todaysDeals = new TodaysDeals(dr);
	}
}
