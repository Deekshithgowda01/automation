package Testng;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class lazda {
    public ExtentReports report;
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeClass
    public void extentreport()
    {
         report =new ExtentReports("reports/repo.html");
    }
    @AfterClass
    public void flushreport()
    {
        report.flush();
    }
    @BeforeMethod
    public void loginlazda()
    {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.beyoung.in/?utm_source=BR_AL_AF_Admitad&utm_medium=1667664_&utm_campaign=cps&admitad_uid=2966b9cecd6a19f784ce50486aea65d3");
        driver.manage().deleteAllCookies();
         wait =new WebDriverWait(driver, Duration.ofMinutes(2));

    }
    @Test
    public void menshooping() throws InterruptedException {
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//a[.='Men']"))).build().perform();
        a.moveToElement(driver.findElement(By.xpath("(//a[.='Gym '])[1]"))).click().build().perform();
       // driver.findElement(By.xpath("//a[.='S']")).click();
       driver.findElement(By.cssSelector("a[style='background:#0f261f']")).click();
       Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/balidaan-badge-half-sleeve-t-shirt-for-men']")).click();
        driver.findElement(By.xpath("//div[normalize-space()='S']")).click();
        driver.findElement(By.xpath("//a[.='ADD TO CART']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".add-cart-icon")).click();
        String imgsrc = driver.findElement(By.xpath("//img[@alt='product img']")).getAttribute("src");
        String productdetails = driver.findElement(By.cssSelector(".product-main-box")).getText();
        System.out.println(productdetails);
        System.out.println(imgsrc);
        if(!Objects.equals(imgsrc, "https://www.beyoung.in/api/cache/catalog/products/printed_t-shirts_for_men_15_8_2022/balidaan_badge_half_sleeve_t-shirt_for_men_base_280x280.jpg"))
        {
            driver.findElement(By.xpath("//a[normalize-space()='checkout securely']")).click();

        }
        else
        {
            driver.findElement(By.xpath("//a[@class='remove-btn']")).click();
        }
    }

}
