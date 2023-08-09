package Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class addofnum {
    public WebDriver driver;
    int sum=0;
    @Test
    public void addition()
    {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int ele = driver.findElements(By.cssSelector("tbody:nth-child(2)>tr>td:nth-child(4)")).size();
        for(int i=0;i<ele;i++)
        {
            String data = driver.findElements(By.cssSelector("tbody:nth-child(2)>tr>td:nth-child(4)")).get(i).getText();
            sum=sum+Integer.parseInt(data);

        }
        System.out.println(sum);

int sum1=0;
        int rah = driver.findElements(By.xpath("(//tbody)[1]//td[3]")).size();
        for(int j=1;j<=rah;j++)
        {
            String text = driver.findElement(By.xpath("((//tbody)[1]//td[3])[" + j + "]")).getText();
            System.out.println(text);
            int dg = Integer.parseInt(text);
            sum1=sum1+dg;
        }
        System.out.println(sum1);
    }



}
