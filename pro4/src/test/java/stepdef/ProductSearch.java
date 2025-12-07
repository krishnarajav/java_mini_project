package stepdef;

import org.testng.Assert;
import org.testng.asserts.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WaitUtils;

public class ProductSearch extends base.BaseClass {
	@When("the user searches for {string}")
	public void the_user_searches_for(String string) {
	    WaitUtils.waitForClickable(dr, home.searchBox, 5);
	    home.searchBox.sendKeys(string);
	    home.searchButton.click();
	}
	@Then("first product's title should contain {string}")
	public void first_product_s_title_should_contain(String string) {
		String title = "";
		try {
			title = WaitUtils.waitForVisible(dr, searchResults.row1P1Title, 5).getText();
			try {
				title = WaitUtils.waitForVisible(dr, searchResults.altFirstProductTitle, 5).getText();
			}
			catch(Exception e) {
				
			}
		}
		catch(Exception e1) {
			
		}
	    Assert.assertTrue(title.toLowerCase().contains(string));
	}

}
