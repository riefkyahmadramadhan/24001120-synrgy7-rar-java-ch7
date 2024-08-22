import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Collections;
import java.util.List;

public class SortingHiLoTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sortingTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion
        Assert.assertEquals(homePage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homePage.getTextProduct(),"Products");
        homePage.shoppingIconIsDisplayed();

        List<Double> originalPrices = homePage.getProductPrices();
        homePage.sortProductsByPriceHighToLow();
        List<Double> filteredPrices = homePage.getProductPrices();
        Collections.sort(originalPrices);
        Collections.reverse(originalPrices);

        //Assertion
        Assert.assertEquals(originalPrices, filteredPrices);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
