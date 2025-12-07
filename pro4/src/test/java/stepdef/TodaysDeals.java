package stepdef;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WaitUtils;

public class TodaysDeals extends base.BaseClass {
	StringBuffer expectedText = new StringBuffer();
	
	@Then("title and url of the page should be verfied")
	public void title_and_url_of_the_page_should_be_verfied() {
		WaitUtils.waitForVisible(dr, home.todaysDeals, 5);
	    Assert.assertEquals(dr.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	    Assert.assertEquals(dr.getCurrentUrl(), "https://www.amazon.in/");
	}
	@When("the user clicks on Today's Deals")
	public void the_user_clicks_on_today_s_deals() {
		WaitUtils.waitForClickable(dr, home.todaysDeals, 5);
		home.todaysDeals.click();
	}
	@Then("the page contains the title Today's Deals")
	public void the_page_contains_the_title_today_s_deals() {
		WaitUtils.waitForTitleContains(dr, "Amazon.in - Deals", 5);
		Assert.assertEquals(basePage.getPageTitle(), "Amazon.in - Deals");
	}
	@When("first item of Today's Deals is clicked")
	public void first_item_of_today_s_deals_is_clicked() {
		WaitUtils.waitForClickable(dr, todaysDeals.row1P1, 5);
		expectedText.append(todaysDeals.row1P1.getText());
		todaysDeals.row1P1.click();
	}
	@Then("same product name should be displayed and verified")
	public void same_product_name_should_be_displayed_and_verified() {
		WaitUtils.waitForVisible(dr, productPage.productTitle, 5);
	    Assert.assertTrue(productPage.productTitle.getText().contains(expectedText.toString().replaceAll("[^a-zA-Z0-9]+$", "")));
	    expectedText.setLength(0);
	}
	@When("second item of Today's Deals is clicked")
	public void second_item_of_today_s_deals_is_clicked() {
	   dr.navigate().back();
	   WaitUtils.waitForClickable(dr, todaysDeals.row1P2, 5);
	   expectedText.append(todaysDeals.row1P2.getText());
	   todaysDeals.row1P2.click();
	}
}
