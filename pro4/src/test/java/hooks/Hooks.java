package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	@Before
	public void launchBrowser() {
		setUp();
	}
	
	@After
	public void closeBrowser() {
		if (dr != null) {
			dr.quit();
		}
	}
}
