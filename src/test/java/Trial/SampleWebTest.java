package Trial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleWebTest {

    @Test

    public void homepage(){
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        driver.quit();
    }
}
