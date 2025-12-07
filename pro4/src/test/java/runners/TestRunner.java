package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, 
glue = {"stepdef", "hooks"},
plugin = {"pretty", "html:target/htmlreports/report.html"},
tags = "@scenario2"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}