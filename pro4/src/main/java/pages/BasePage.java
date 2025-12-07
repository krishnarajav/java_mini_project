package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver dr;
	
	public BasePage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	public String getPageTitle() {
		return dr.getTitle();
	}
	
	public String getCurrentURL() {
		return dr.getCurrentUrl();
	}
}
