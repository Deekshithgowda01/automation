package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class fruits {
public WebDriver driver;

    @Test
    public void addfruits()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)","");
        int ele = driver.findElements(By.cssSelector("div.product-action>button")).size();
        for(int i=0;i<ele;i++)
        {
            String vegname = driver.findElements(By.cssSelector(".product>h4")).get(i).getText();
            driver.findElements(By.cssSelector("div.product-action>button")).get(i).click();
            System.out.println(vegname);

        }

    }
}
