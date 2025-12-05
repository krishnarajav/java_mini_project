package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    @FindBy(className="product_sort_container")
    WebElement sortDropdown;

    @FindBy(className="inventory_item_name")
    List<WebElement> productNames;

    @FindBy(xpath="(//button[text()='Add to cart'])[1]")
    WebElement firstAddToCart;

    @FindBy(className="shopping_cart_link")
    WebElement cartLink;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sortZA(){
        new Select(WaitUtils.waitForVisible(driver, sortDropdown, 10)).selectByVisibleText("Name (Z to A)");
    }

    public void addFirstItem(){
    	WaitUtils.waitForClickable(driver, firstAddToCart, 10).click();
    }

    public void openCart(){
    	WaitUtils.waitForClickable(driver, cartLink, 10).click();
    }
}
