package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test002PrintLinks extends BaseTest {
    @Test
    public void printAllLinks() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }

        driver.quit();
    }
}
