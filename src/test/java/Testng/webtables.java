package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webtables {
    public WebDriver driver;
    @Test
    public  void webtables()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int course1 = driver.findElements(By.xpath("(//tbody)[1]//tr//td")).size();
        for(int i=1;i<=course1;i++)
        {
            String ele = driver.findElement(By.xpath("((//tbody)[1]//tr//td)[" + i + "]")).getText();
            System.out.println(ele);
        }


    }
}
