package COM.lumapages;

import COM.Readfromfile.Readfromjson;
import COM.actions.SeleniumActions;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static org.openqa.selenium.Keys.*;

public class ShippingAddressPage {

   private WebDriver driver;
    SeleniumActions seleniumActions;
    Readfromjson readfromjson;
    public ShippingAddressPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);
        readfromjson = new Readfromjson();
    }
@FindBy(xpath = "//input[@name='firstname']")
    WebElement firstname;
@FindBy(xpath = "//input[@name='lastname']")
        WebElement lastname;
@FindBy(xpath = "//input[@name='company']")
    WebElement  company;
@FindBy(xpath = "//input[@name='street[0]']")
    WebElement streetaddress;
@FindBy(xpath = "//input[@name='city']")
    WebElement city;
@FindBy(xpath = "//select[@name='region_id']")
WebElement statprovince;

@FindBy(xpath = "//input[@name='postcode']")
    WebElement postalcode;
@FindBy(xpath = "//select[@name='country_id']")
WebElement country;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumber;

    @FindBy(xpath = "//input[@class='radio']")
    WebElement radio;
    @FindBy (xpath = "//span[text()='Next']")
    WebElement nextbutton;

    @FindBy (xpath = "//span[text()='Place Order']")
    WebElement placeorder;
    @FindBy(xpath = "//button[@class='action action-show-popup']")
    WebElement newaddress;


    @FindBy(xpath = "//span[text()='Ship here']")
        WebElement shiphere;


    @FindBy(xpath = "//span[@class='label']//following::span")
    WebElement orderdate;


    public void address() throws IOException, ParseException, InterruptedException {
       // Thread.sleep(3000);
       // seleniumActions.clickOnElement(newaddress);
        seleniumActions.EnterValueOnTextfield(streetaddress,readfromjson.readFile("StreetAddress"));
        seleniumActions.EnterValueOnTextfield(city,readfromjson.readFile("City"));
        Thread.sleep(2000);
        seleniumActions.selectValueFromDropDown(country,readfromjson.readFile("Country"),"value");
        seleniumActions.selectValueFromDropDown(statprovince,readfromjson.readFile("StateProvince"),"value");//StateProvince
        //System.out.println(statprovince.getText());//StateProvince);
        seleniumActions.EnterValueOnTextfield(postalcode,readfromjson.readFile("PostalCode"));
        seleniumActions.EnterValueOnTextfield(phonenumber,readfromjson.readFile("PhoneNumber"));

       Thread.sleep(1000);
        seleniumActions.clickOnElement(shiphere);
       // Thread.sleep(5000);
        seleniumActions.clickOnElement(radio);
        //Thread.sleep(5000);
        seleniumActions.clickOnElement(nextbutton);

    }

}
