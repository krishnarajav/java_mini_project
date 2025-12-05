package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class CheckoutOverviewPage {
	WebDriver driver;
	@FindBy(id="finish") WebElement finish;

    public CheckoutOverviewPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinish() {
    	WaitUtils.waitForClickable(driver, finish, 10).click();
    }
}
