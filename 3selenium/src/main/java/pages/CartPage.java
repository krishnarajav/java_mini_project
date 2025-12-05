package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CartPage {
    WebDriver driver;

    @FindBy(className="inventory_item_name")
    WebElement cartItem;

    @FindBy(id="checkout")
    WebElement checkoutBtn;

    public CartPage(WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCartItemName(){
    	return WaitUtils.waitForVisible(driver, cartItem, 10).getText();
    }

    public void clickCheckout(){
    	WaitUtils.waitForClickable(driver, checkoutBtn, 10).click();
    }
}

