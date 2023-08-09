package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataprovideru {
    public WebDriver driver;
    public WebDriverWait wait;
    @Test(dataProvider = "data")
    public void dataprovider(String data1)

    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait =new WebDriverWait(driver, Duration.ofMinutes(5));
        driver.get("https://outlook.office.com/mail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116"))).sendKeys(data1);
    }
    @DataProvider()
    public Object[][] data()
    {
        return new Object[][]{{"notebook"},{"wordpad","manoj"}};
    }
}
