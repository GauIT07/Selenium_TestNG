package TestNGTutorials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class DemoTestNG {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        // setup driver browser
        WebDriverManager.chromedriver().setup();

        // khai báo biến driver gán class ChromeDriver()
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void CloseBrowser() {
        //driver.quit();
    }

    @Test (priority = 1)
    public void TestRun_button () {

//       driver.get("https://auto.fresher.dev/");

        // Truy cập trang web theo tên url truyền vào
       driver.get("https://auto.fresher.dev/lessons/lession7/index.html");


        // đợi load 5s
      // sleep (5000);
//       List<WebElement> buttons = driver.findElements(By.className("btn-success"));
//       buttons.get(6).click();
//       for (int i; i < buttons.size(); i++) {
//           buttons.get(i).click();
//       }

        // lấy id tên nút Button1
       WebElement btn1 = driver.findElement(By.id("btnExample1"));
        // thực hiện click trên btn
       btn1.click();
        // lấy id tên textbox
       WebElement texteBtn = driver.findElement(By.id("lbStatusButton"));
        // lấy dữ liệu text trên textbox -> string
       String valueBtn = texteBtn.getText();
        // so sánh kết quả actual, expected
        Assert.assertEquals(valueBtn, "Click on Button 1");

        System.out.println("url hiện tại là: " + driver.getCurrentUrl());
        System.out.println("valueBtn là: " + valueBtn);
    }

    @Test
    public void TestRun_textbox() {
       // setup driver của chrome
        WebDriverManager.chromedriver().setup();
       // truy cập trang web theo string truyền vào
        driver.get("https://auto.fresher.dev/lessons/lession7/index.html");

        // tìm element theo id
        WebElement textBoxInput = driver.findElement(By.id("txtInput1"));

        // khai báo biến Class String = giá trị atttribute name value
        String textBoxInputValue = textBoxInput.getAttribute("value");

        // so sánh dữ liệu biến và string có sẵn
        Assert.assertEquals(textBoxInputValue,"Default value of input");

        // Click vào ô textbox
        textBoxInput.click();
        // xóa trắng giá trị trong textbox
        textBoxInput.clear();
        // khái báo biến newValue method String
        String newValue = "Đây là dữ liệu nhập vào";
        // truyền dữ liệu vào element textbox
        textBoxInput.sendKeys(newValue);
        // khai báo biến newInputValue dạng String lấy lại giá trị ô textbox
        String newInputValue = textBoxInput.getAttribute("value");
        // so sánh dữ lệu lấy về với dữ liệu nhập vào
        Assert.assertEquals(newInputValue, newValue);

        System.out.println("Dữ liệu Expedted: " + newValue);
        System.out.println("Dữ liệu Actual: " + newInputValue);
    }

    @Test
    public void TestRun4_textbox () {
        driver.get("https://auto.fresher.dev/lessons/lession7/index.html");

        WebElement element = driver.findElement(By.id("defaultCheck1"));
        element.click();
        boolean isChecked = element.isSelected();
       // System.out.println(isChecked);
        element.click();
        element.click();
        element.click();
        element.click();
        element.click();
        element.click();

        setCheckboxState(element, true);

        if (isChecked == true){
            System.out.println("Trạng thái của btn là được tick. " + isChecked);
        } else {
            System.out.println("Trạng thái của btn là không được tick. " + isChecked) ;
        }
    }
    public void setCheckboxState (WebElement element, boolean isChecked) {
        boolean isActualChecked = element.isSelected();
        if (isChecked != isActualChecked) {
            element.click();
        }

    }

    @Test(priority = 2)
    public void TestRun2() {
        driver.get("https://mylocal.vn");
        driver.navigate().refresh();
        driver.navigate().to("https://thanhnien.vn");
     //   sleep(5000);

        System.out.println("Run test 2.");
    }


}
