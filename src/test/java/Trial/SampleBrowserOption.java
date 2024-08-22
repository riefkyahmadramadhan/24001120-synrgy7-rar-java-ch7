package Trial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleBrowserOption {

    @Test

    public void homepageOption(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("window-size=450,750");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        driver.quit();
    }
}
