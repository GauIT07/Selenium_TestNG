import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DemoCodeGPT {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable (update with your path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void switchToNewTabAndFindElement() {
        // Navigate to the initial web page
        driver.get("https://example.com");

        // Open a new tab using JavaScript
        ((ChromeDriver) driver).executeScript("window.open()");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Index 1 represents the new tab

        // Navigate to a new URL in the new tab
        driver.get("https://newurl.com");

        // Find and interact with elements on the new URL
        WebElement element = driver.findElement(By.id("elementId")); // Replace with the appropriate locator
        element.click();

        // You can perform more actions on the new URL as needed

        // Switch back to the original tab if necessary
        driver.switchTo().window(tabs.get(0)); // Index 0 represents the original tab
    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver when the test is finished
        if (driver != null) {
            driver.quit();
        }
    }
}
