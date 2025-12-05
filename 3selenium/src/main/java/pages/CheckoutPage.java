package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class CheckoutPage {
	WebDriver driver;
    @FindBy(id="first-name") WebElement fn;
    @FindBy(id="last-name") WebElement ln;
    @FindBy(id="postal-code") WebElement zip;
    @FindBy(id="continue") WebElement cont;

    public CheckoutPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillDetails(String f, String l, String z){
    	WaitUtils.waitForVisible(driver, fn, 10).sendKeys(f);
    	WaitUtils.waitForVisible(driver, ln, 10).sendKeys(l);
    	WaitUtils.waitForVisible(driver, zip, 10).sendKeys(z);
    	WaitUtils.waitForClickable(driver, cont, 10).click();
    }
}

