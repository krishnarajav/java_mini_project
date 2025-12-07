package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDeals {
	WebDriver dr;
	
	@FindBy(xpath="//div[@data-index=0]/div/div/div[@data-test-index=0]/div[2]/a/p/span/span/span[2]")
	public WebElement row1P1;
	
	@FindBy(xpath="//div[@data-index=0]/div/div/div[@data-test-index=1]/div[2]/a/p/span/span/span[2]")
	public WebElement row1P2;
	
	public TodaysDeals(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
}
