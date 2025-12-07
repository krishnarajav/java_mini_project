package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends base.BaseClass {
	// Wait for WebElement to be clickable
    public static WebElement waitForClickable(WebDriver dr, WebElement element, int timeOutSeconds) {
        return new WebDriverWait(dr, Duration.ofSeconds(timeOutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for WebElement to be visible
    public static WebElement waitForVisible(WebDriver dr, WebElement element, int timeOutSeconds) {
        return new WebDriverWait(dr, Duration.ofSeconds(timeOutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }
    
    // Wait for page title
    public static void waitForTitleContains(WebDriver dr, String expectedTitle, int timeOutSeconds) {
        new WebDriverWait(dr, Duration.ofSeconds(timeOutSeconds))
                .until(ExpectedConditions.titleContains(expectedTitle));
    }
}
