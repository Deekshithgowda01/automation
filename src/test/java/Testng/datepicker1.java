package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class datepicker1 {
    public WebDriver driver;

    @Test
    public void daeu()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/datepicker/#localization");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement sel = driver.findElement(By.xpath("//select[@id='locale']"));
        Select sele=new Select(sel);
        sele.selectByIndex(2);
        driver.findElement(By.cssSelector(".hasDatepicker")).click();
        while(!driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("ui-icon ui-icon-circle-triangle-e")).click();
        }
        int ele = driver.findElements(By.cssSelector(".ui-state-default")).size();
        for(int i=0;i<ele;i++)
        {
            String datu = driver.findElements(By.cssSelector(".ui-state-default")).get(i).getText();
            if(datu.equals("1"))
            {
                driver.findElements(By.cssSelector(".ui-state-default")).get(i).click();
                break;
            }
        }

    }
}
