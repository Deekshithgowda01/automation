package Testng;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class swagger {
    public ExtentReports report;
    public ExtentTest test;
    public  WebDriver driver;
    @BeforeClass
    public void repotrs()
    {
         report =new ExtentReports("reports/swagerereprot.html");
    }
    @Test(dataProvider = "dataprovideru")
    public void swagu(String username,String password) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        String url = "https://www.saucedemo.com/inventory.html";
         test = report.startTest("swagger");
        if(url.equals(driver.getCurrentUrl()))
        {
            test.log(LogStatus.PASS,"Tcpass");
        }
        else {
            test.log(LogStatus.FAIL,screenshot(),"Tcfaill");
        }
    }
    @DataProvider
    public Object[][] dataprovideru()
    {
        return new Object[][]{{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"}};
    }
    @AfterClass
    public void flushreport()
    {
        report.flush();

    }
    @AfterTest
    public void closebrowser()
    {
        driver.close();
    }

    public String screenshot() throws IOException {
        TakesScreenshot tg = (TakesScreenshot) driver;
        File src = tg.getScreenshotAs(OutputType.FILE);
        File trg = new File("screeshot/ss"+System.currentTimeMillis()+".png");
        String path = trg.getAbsolutePath();
        FileUtils.copyFile(src,trg);
        return path;
    }


}
