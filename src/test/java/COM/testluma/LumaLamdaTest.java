package COM.testluma;

import COM.lumapages.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LumaLamdaTest {
    WebDriver driver;
    public LumaLoginPage lumaLoginPage;
    public HomePage homePage;
    public AddtoWishlist addtoWishlist;
    public ShippingAddressPage shippingAddressPage;
    public ReviewAndPaymentsPage reviewAndPaymentsPage;
    public ThankyouPage thankyouPage;
    @BeforeTest
    public void setUpLamdatest() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("platform", "win10");
        desiredCapabilities.setCapability("browserVersion", "108");
        desiredCapabilities.setCapability("build", "LUMA");
        desiredCapabilities.setCapability("project", "luma");

        desiredCapabilities.setCapability("test", "luma");

        try {
            driver = new RemoteWebDriver(new URL("https://shankar12933:BrbTsEMYFbuIj7wltU0Wz2uEwG8abDIy0plWznNRyiG4lpd5LI@hub.lambdatest.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }
    @BeforeClass
    public void lumainitalizepages(){
        lumaLoginPage=new LumaLoginPage(driver);
        homePage=new HomePage(driver);
        addtoWishlist=new AddtoWishlist(driver);
        shippingAddressPage=new ShippingAddressPage(driver);
    }
    @Test
    public void login() throws InterruptedException, IOException, ParseException {
        lumaLoginPage.loginWebelements("shankar12933@gmail.com","Shankar@2169");
        homePage.homepageWebelements();
        homePage.gethighestPrice();
        addtoWishlist.VerifyMywishlist();
        Thread.sleep(2000);
        shippingAddressPage.address();
        reviewAndPaymentsPage.clickOnPlacorder();
        thankyouPage.thankyou();
    }

}
