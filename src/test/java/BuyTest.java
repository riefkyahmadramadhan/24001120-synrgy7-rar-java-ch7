import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class BuyTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage                 = new LoginPage(driver);
        HomePage homePage                   = new HomePage(driver);
        CartPage cartPage                   = new CartPage(driver);
        CheckInfoPage checkInfoPage         = new CheckInfoPage(driver);
        CheckOverviewPage checkOverviewPage = new CheckOverviewPage(driver);
        CompletePage completePage           = new CompletePage(driver);

        // login action
        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // assertion after login
        // assert on homepage
        Assert.assertEquals(homePage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homePage.getTextProduct(),"Products");
        homePage.shoppingIconIsDisplayed();

        // add to cart action
        // action on homepage
        homePage.clickAddCartButton();
        homePage.clickCartButton();

        // assertion after add to cart
        // assert on cart page
        Assert.assertEquals(cartPage.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getPageHeader(), "Your Cart");
        cartPage.productPriceIsDisplayed();
        cartPage.nextButtonIsDisplayed();

        // cart is ok
        // action on cart page
        cartPage.clickNextButton();

        // assertion after cart page
        // assert on check info page
        Assert.assertEquals(checkInfoPage.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(checkInfoPage.getPageHeader(), "Checkout: Your Information");
        checkInfoPage.formIsDisplayed();
        checkInfoPage.continueButtonIsDisplayed();

        // input data action
        // action on check info page
        checkInfoPage.inputFirstName("Red");
        checkInfoPage.inputLastName("Velvet");
        checkInfoPage.inputPostalCode("0801");
        checkInfoPage.clickContinueButton();

        // assertion after input data
        // assert on check overview page
        Assert.assertEquals(checkOverviewPage.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkOverviewPage.getPageHeader(), "Checkout: Overview");
        Assert.assertEquals(checkOverviewPage.getPriceTotal(), "Price Total");
        checkOverviewPage.finishButtonIsDisplayed();

        // overview is ok
        // action on overview page
        checkOverviewPage.clickFinishButton();

        // assert complete page
        Assert.assertEquals(checkOverviewPage.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        completePage.backButtonIsDisplayed();
        completePage.successImageIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
