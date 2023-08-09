package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class scroll {
    public WebDriver driver;
    @Test
    public void scrollu()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/datepicker/");
        WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Restrict date range']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click()",ele);
        js.executeScript("window.scrollBy(0,500)","");
        driver.findElement(By.xpath("//a[normalize-space()='Restrict date range']")).click();
    }
}
