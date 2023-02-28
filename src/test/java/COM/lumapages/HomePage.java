package COM.lumapages;

import COM.actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    WebDriver driver;
    SeleniumActions seleniumActions;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gearoption;
    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bagsoption;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement mycart;

    @FindBy(xpath = "//div[contains(@class,'block block-minicart ')]")
    WebElement mycarttextbox;
    @FindBy (xpath = "//span[text()='Add to Wish List']")
    WebElement  addtowishlist;

    public void homepageWebelements() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(10);
        actions.moveToElement(gearoption).perform();
        Thread.sleep(1000);
        actions.moveToElement(bagsoption).click().perform();
        seleniumActions.clickOnElement(mycart);
        Assert.assertTrue(mycarttextbox.isDisplayed());
        System.out.println(mycarttextbox.getText());

    }

    public void gethighestPrice() {
        List<WebElement> listofallprices = new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount = new ArrayList<>();
        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }
      //  System.out.println(Collections.max(allproductsamount));
        Double maxproductamount = Collections.max(allproductsamount);
        //System.out.println("max amount" + maxproductamount);
        WebElement maxproductamountpriceAddtocart = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'"+maxproductamount+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
      //  System.out.println(maxproductamountpriceAddtocart.getText());
        maxproductamountpriceAddtocart.click();
        seleniumActions.clickOnElement(addtowishlist);
    }
}





