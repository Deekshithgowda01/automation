package adpautomate;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class demoadp1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofMinutes(5));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>span>button.splitPrimaryButton.root-185"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='To']"))).sendKeys("manoj.ms@qualitestgroup.com",Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='To']"))).sendKeys(Keys.ENTER);

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Cc']"))).sendKeys("hemanth.kc@qualitestgroup.com",Keys.DOWN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Cc']"))).sendKeys(Keys.ENTER);
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
        for (int i=0;i<count;i++)
        {
            String text = elements.get(i).getText();
            System.out.println(text);
            if (text.equals("manoj"))
            {
                break;
            }
//            Assert.assertEquals(text,"manoj");
//            break;
        }




//        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#O365_AppTile_077d59a8-0356-4893-bea6-65d163723f42")))).click();
//        String parent = driver.getWindowHandle();
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it = windows.iterator();
//        while (it.hasNext())
//        {
//            String child = it.next();
//            if (child!=parent)
//            {
//                driver.switchTo().window(child);
//            }
//        }
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shellNavComponent")));
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shellNavComponent"))).getShadowRoot().findElement(By.cssSelector("ul>li:nth-child(3)>button")).click();
//        driver.findElement(By.cssSelector("sdf-floating-pane[position-context='ELEMENT']")).getShadowRoot().findElement(By.cssSelector("wfn-shell-mega-menu[tabindex='-1']")).getShadowRoot().findElement(By.cssSelector(".grid-3>div:first-child>div:last-child>p>a")).click();

    }
}
