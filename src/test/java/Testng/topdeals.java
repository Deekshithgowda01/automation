package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class topdeals {
    public WebDriver driver;
    @Test
    public void top()
    {
        WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.cssSelector(".cart>a[class='cart-header-navlink']:nth-child(2)")).click();
        String parent = driver.getWindowHandle();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        while (it.hasNext())
        {
            String child = it.next();
            if(child!=parent)
            {
                driver.switchTo().window(child);

            }
        }
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-field:nth-child(2)"))).sendKeys("M");
        int ele = driver.findElements(By.cssSelector("tbody>tr")).size();
        int sizeofheader = driver.findElements(By.cssSelector("thead>tr>th")).size();
        System.out.println(sizeofheader);
        System.out.println(ele);
        for(int j=1;j<=ele;j++)
        {
            for (int i = 1; i <= ele; i++) {


                //String heder = driver.findElement(By.cssSelector("thead>tr>th:nth-child(" + i + ")")).getText();
                String body = driver.findElement(By.xpath("//tbody//tr["+i+"]//td["+j+"]")).getText();
                System.out.println(body);
                 //System.out.println(heder+"   :   "+body);
            }

        }

    }
}
