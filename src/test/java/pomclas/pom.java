package pomclas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pom {

    public WebDriver driver;
    public pom(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);



    }

    @FindBy(xpath="//iframe[@class='demo-frame']")
    public WebElement frame;

    @FindBy(xpath = "//input[@id='datepicker']")
    public WebElement datepicker;

    @FindBy(css = ".ui-datepicker-title>span[class='ui-datepicker-month']")
    public WebElement month;

    @FindBy(css = ".ui-icon.ui-icon-circle-triangle-e")
    public WebElement next;





}
