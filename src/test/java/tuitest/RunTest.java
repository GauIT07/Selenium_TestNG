package tuitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunTest {
    public static void main(String[] args) {
      //  System.out.println("hello");

        WebDriver driver;
        WebDriverManager.chromedriver().setup(); // gọi phiên bản browser

        driver = new ChromeDriver(); // khởi tạo giá trị cho browser

       // WebDriverManager.edgedriver().setup();
      //  driver = new EdgeDriver();

        driver.get ("https://google.com");
    }
}
