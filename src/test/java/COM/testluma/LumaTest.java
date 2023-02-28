package COM.testluma;

import COM.Readfromfile.Readfromjson;
import COM.baseluma.BaseClass;
import COM.lumapages.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LumaTest extends BaseClass {
    public LumaLoginPage lumaLoginPage;
    public HomePage homePage;
    public AddtoWishlist addtoWishlist;
    public ShippingAddressPage shippingAddressPage;
    public Readfromjson readfromjson;
    public ReviewAndPaymentsPage reviewAndPaymentsPage;
    public ThankyouPage thankyouPage;
@BeforeClass
public void lumainitalizepages(){
    lumaLoginPage=new LumaLoginPage(driver);
    homePage=new HomePage(driver);
    addtoWishlist=new AddtoWishlist(driver);
    shippingAddressPage=new ShippingAddressPage(driver);
    reviewAndPaymentsPage=new ReviewAndPaymentsPage(driver);
    thankyouPage =new ThankyouPage(driver);
    //readfromjson=new Readfromjson(driver);
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
