import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion
        Assert.assertEquals(homePage.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homePage.getTextProduct(),"Products");
        homePage.shoppingIconIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
