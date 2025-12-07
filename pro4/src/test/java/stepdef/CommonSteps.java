package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends base.BaseClass {
	@Given("Browser is open")
	public void browser_is_open() {
		if(dr == null) {
			setUp();
		}
	}
	
	@When("url is launched")
	public void url_is_launched() {
		dr.get(p.getProperty("baseUrl").toString());
	}
	
	@Then("browser is closed")
	public void browser_is_closed() {
	    if(dr != null) {
	    	dr.quit();
	    }
	}
}
