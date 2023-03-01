package COM.lumapages;

import COM.Readfromfile.Readfromjson;
import COM.actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ThankyouPage {

    private WebDriver driver;
    SeleniumActions seleniumActions;
    Readfromjson readfromjson;
    public ThankyouPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);}
        @FindBy(xpath = "//div[@class='checkout-success']//following::strong")
        WebElement ordernumber;
    public void thankyou(){

       // Assert.assertTrue(ordernumber.isDisplayed());
       // System.out.println(ordernumber.getText());
        seleniumActions.clickOnElement(ordernumber);
        System.out.println("1");



    }
    }


