package Stepdefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pomclas.pom;

public class datepicker {
    public WebDriver driver;
    public  pom po;

    @Given("when user launch the browser using url {string}")
    public void when_user_launch_the_browser_using_url(String url) {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
         po = new pom(driver);
    }
    @When("when user click on datepicker")
    public void when_user_click_on_datepicker() {
        driver.switchTo().frame(po.frame);
        po.datepicker.click();
    }
    @When("^select month (.*) and date (.*)$")
    public void select_month_and_date(String month,String d) {
        while(!po.month.getText().equals(month))
        {

            po.next.click();
        }

        int ele = driver.findElements(By.cssSelector(".ui-state-default")).size();
        for(int i=0;i<ele;i++)
        {
            String date = driver.findElements(By.cssSelector(".ui-state-default")).get(i).getText();
            if(date.equals(d))
            {
                driver.findElements(By.cssSelector(".ui-state-default")).get(i).click();
                break;
            }
        }
    }
    @Then("validte the exact date is fetched")
    public void validte_the_exact_date_is_fetched() {
        System.out.println( po.datepicker.getText());

    }
}
