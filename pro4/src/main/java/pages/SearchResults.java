package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults {
	WebDriver dr;
	
	@FindBy(xpath="//div[@data-index=4]/div/div/div/div/span/div/div/div/div[1]/a/h2")
	public WebElement row1P1Title;
	
	@FindBy(xpath="//div[@data-index=3]//div[@data-cy=\"title-recipe\"]/a/h2")
	public WebElement altFirstProductTitle;
	
	public SearchResults(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
}
