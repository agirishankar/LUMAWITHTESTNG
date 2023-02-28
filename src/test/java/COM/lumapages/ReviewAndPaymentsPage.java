package COM.lumapages;

import COM.Readfromfile.Readfromjson;
import COM.actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndPaymentsPage {
    private WebDriver driver;
    SeleniumActions seleniumActions;
    Readfromjson readfromjson;
    public ReviewAndPaymentsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);
        readfromjson = new Readfromjson();
    }

    @FindBy(xpath = "//button[@ class ='action primary checkout']")
    WebElement placeorder;

    @FindBy(xpath = "//div[@class='billing-address-details']")
    WebElement paymentaddress;
    @FindBy(xpath = "//input[@id='billing-address-same-as-shipping-checkmo']")
    WebElement addresscheckbox;

    public void clickOnPlacorder() throws InterruptedException {

        Thread.sleep(2000);
        seleniumActions.clickOnElement(addresscheckbox);
//        System.out.println(paymentaddress.getText());
        seleniumActions.clickOnElement(placeorder);

    }
}
