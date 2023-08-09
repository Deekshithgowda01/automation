package Testng;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class outlook {
    public ExtentReports report;
    public WebDriver driver;
    public WebDriverWait wait;

    public ExtentTest test;
    public   TakesScreenshot tg;
@BeforeClass
   public void beforeclass()
{
     report =new ExtentReports("reports/new reprorts.html");

}
@AfterClass
public void afterclass()
{
    report.flush();
}

@BeforeMethod
    public void loginofouutlook()
{
    WebDriverManager.chromedriver().setup();
     driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
     wait =new WebDriverWait(driver, Duration.ofMinutes(5));
    driver.get("https://outlook.office.com/mail");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116"))).sendKeys("deekshith.gowda@qualitestgroup.com", Keys.ENTER);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))).sendKeys("Iphone@1234",Keys.ENTER);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Text +XX XXXXXXXX76\u200E']"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#KmsiCheckboxField"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#idSIButton9"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#O365_MainLink_NavMenu")))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#O365_AppTile_Mail"))).click();
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
}

@AfterMethod
    public void close()
{
    driver.close();
}
@Test(priority = 1)
public void testcase() throws InterruptedException, IOException {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>span>button.splitPrimaryButton.root-185"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='To']"))).sendKeys("manoj.ms@qualitestgroup.com", Keys.DOWN);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='To']"))).sendKeys(Keys.ENTER);

//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Cc']"))).sendKeys("hemanth.kc@qualitestgroup.com", Keys.DOWN);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Cc']"))).sendKeys(Keys.ENTER);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Add a subject']"))).sendKeys("manoj");

    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#docking_DockingTriggerPart_0"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Message body, press Alt+F10 to exit']"))).sendKeys("hi");
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".elementToProof:nth-child(1)"))).sendKeys("hi  manoh");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Send']"))).click();
    //       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ok-1"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Sent Items']"))).click();
    Thread.sleep(3000);
    List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.IjzWp.XG5Jd.gy2aJ.Ejrkd")));
    int count = elements.size();
    for (int i = 0; i < count; i++) {
        String text = elements.get(i).getText();
        System.out.println(text);
         test = report.startTest("manoj");
        if (text.equals("manoj")) {
        test.log(LogStatus.PASS,"TCpass",screenshot());

            break;
        }

//            Assert.assertEquals(text,"manoj");
//            break;
    }
}
public String screenshot() throws IOException {
     tg= (TakesScreenshot) driver;
    File src = tg.getScreenshotAs(OutputType.FILE);
    File trg = new File("screeshot/ss"+System.currentTimeMillis()+".png");
    String path = trg.getAbsolutePath();
    FileUtils.copyFile(src,trg);
    return path;
}
@Test(priority = 2)
    public void delete() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Sent Items']"))).click();
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.IjzWp.XG5Jd.gy2aJ.Ejrkd")));
        int count = elements.size();
        for (int i=0;i<count;i++)
        {
            String ele = elements.get(i).getText();
            if (ele.equals("manoj"))
            {
                test.log(LogStatus.PASS,"Tcpass",screenshot());

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hcptT"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".QpoLy"))).click();

            }
        }



    }



}



