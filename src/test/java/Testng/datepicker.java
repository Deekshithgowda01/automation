package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class datepicker {

    public WebDriver driver;
    @Test
    public void date()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/datepicker/#default");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        driver.findElement(By.cssSelector(".hasDatepicker")).click();
        //driver.findElement(By.cssSelector(".ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all"));
        while(!driver.findElement(By.cssSelector(".ui-datepicker-title>span[class='ui-datepicker-month']")).getText().equals("September"))
        {

            driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
        }

        int ele = driver.findElements(By.cssSelector(".ui-state-default")).size();
        for(int i=0;i<ele;i++)
        {
            String date = driver.findElements(By.cssSelector(".ui-state-default")).get(i).getText();
            if(date.equals("26"))
            {
                driver.findElements(By.cssSelector(".ui-state-default")).get(i).click();
                break;
            }
        }




    }
}
