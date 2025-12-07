package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver dr;
	
	@FindBy(xpath="//a[@href='/deals?ref_=nav_cs_gb']")
	public WebElement todaysDeals;
	
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	public WebElement searchBox;
	
	@FindBy(xpath="//span[@id=\"nav-search-submit-text\"]/input[@type=\"submit\"]")
	public WebElement searchButton;
	
	public Home(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
}
