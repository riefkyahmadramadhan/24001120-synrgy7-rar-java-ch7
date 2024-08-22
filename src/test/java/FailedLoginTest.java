import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class FailedLoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void failedLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUser("red velvet");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion
        Assert.assertEquals(loginPage.getCurrentUrl(),"https://www.saucedemo.com/");
        loginPage.loginIsDisplayed();
        loginPage.erorIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
