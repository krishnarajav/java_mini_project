package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutCompletePage {
	WebDriver driver;
	 
    @FindBy(className="complete-header")
    WebElement successMsg;

    public CheckoutCompletePage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getSuccessMsg(){
        return WaitUtils.waitForVisible(driver, successMsg, 10).getText();
    }
}
