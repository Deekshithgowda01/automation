package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class qaclick {
    public WebDriver driver;
public WebDriverWait wait;

    @Test
    public void flight() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
         wait = new WebDriverWait(driver, Duration.ofMinutes(5));
         //Autosuggestivedropdown
//        WebElement eleofcountry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inputs.ui-autocomplete-input")));
//        //eleofcountry.sendKeys("Ind",Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
//        Actions a=new Actions(driver);
//        a.sendKeys(eleofcountry,"Ind").build().perform();
//        a.moveToElement(driver.findElement(By.cssSelector("#ui-id-121"))).click().build().perform();
//        eleofcountry.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
////        eleofcountry.sendKeys(Keys.ARROW_DOWN);
//        eleofcountry.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul>li>a[text='Bangkok (BKK)']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[.=' Dubai, All Airports(DWC) (DXB)'])[2]"))).click();
        int month = driver.findElements(By.cssSelector(".ui-datepicker-title")).size();
        for(int i=0;i<month;i++)
        {
            String nameofmonth = driver.findElements(By.cssSelector(".ui-datepicker-title")).get(i).getText();

            if(nameofmonth.equals("June 2023"))
            {
                int datesize = driver.findElements(By.xpath("//td[@data-month='5']")).size();
                for(int j=0;j<datesize;j++)
                {
                    String exactdate = driver.findElements(By.xpath("//td[@data-month='5']")).get(j).getText();
                    if(exactdate.equals("26"))
                    {
                        driver.findElements(By.xpath("//td[@data-month='5']")).get(j).click();
                        break;
                    }
                }
            }
        }
        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ad-row-right>#hrefIncAdt")).click();
        driver.findElement(By.cssSelector("#hrefIncChd")).click();
        driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select sel=new Select(dropdown);
        sel.selectByIndex(1);
        driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        String alemssg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(alemssg);
        TakesScreenshot tg= (TakesScreenshot) driver;
        File src = tg.getScreenshotAs(OutputType.FILE);
        File trg = new File("screeshot/ff" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(src,trg);


    }


}
