package COM.lumapages;

import COM.actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaLoginPage {

    private WebDriver driver;
    SeleniumActions seleniumActions;
    public LumaLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);
    }
    @FindBy(css = "#email")
    WebElement remail;

    @FindBy(xpath = "//div[@class='field password required']//following::input")
    WebElement rpassword;

    @FindBy(xpath = "//button[@id=\"send2\"]")
    WebElement singinbutton;
    public void loginWebelements(String email,String password){
        seleniumActions.EnterValueOnTextfield(remail,email );
        seleniumActions.EnterValueOnTextfield(rpassword,password);
        seleniumActions.clickOnElement(singinbutton);
    }
}

