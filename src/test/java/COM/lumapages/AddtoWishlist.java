package COM.lumapages;

import COM.actions.SeleniumActions;
import COM.constants.TimeWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddtoWishlist {

    private WebDriver driver;
    SeleniumActions seleniumActions;

    public AddtoWishlist(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver= driver;
        seleniumActions = new SeleniumActions(driver);

    }
    @FindBy(xpath = "//div[@class='product-item-info']//following::strong/a")
    WebElement MyWishListproducname;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement mycart;

   // @FindBy(xpath = "//span[text()='Add to Cart']")
   // WebElement ;

    @FindBy(xpath = "//div[@class='product-item-actions']//following-sibling::button")
    WebElement addtocart;

    @FindBy (xpath = "//div[@class='message info empty']")
    WebElement mywishlistmessage;

    @FindBy(xpath = "//div[@class='primary']")
    WebElement ProceedtoCheckout;

    @FindBy(xpath = "//button[@class='action action-show-popup']")
    WebElement newaddress;
    public void VerifyMywishlist() throws InterruptedException {

        Actions actions = new Actions(driver);
        Thread.sleep(10);
        actions.moveToElement(MyWishListproducname).perform();
        Thread.sleep(1000);
//        actions.moveToElement(bagsoption).click().perform();
//        seleniumActions.clickOnElement(mycart);
//
//        Assert.assertTrue(mycarttextbox.isDisplayed());
//        System.out.println(mycarttextbox.getText());
//

        Assert.assertTrue(MyWishListproducname.isDisplayed());
        System.out.println(MyWishListproducname.getText());
        seleniumActions.clickOnElement(addtocart);
        Assert.assertEquals(mywishlistmessage.getText(),"You have no items in your wish list.");
        System.out.println(mywishlistmessage.getText());
        Thread.sleep(1000);
        seleniumActions.clickOnElement(mycart);
        Thread.sleep(1000);
        seleniumActions.clickOnElement(ProceedtoCheckout);

        seleniumActions.clickOnElement(newaddress);
//        Thread.sleep(3000);
//        seleniumActions.clickOnElement(newaddress);


       // MyWishListproducname.click();
       // Thread.sleep(3000);
       // addtocart.click();

    }

}
