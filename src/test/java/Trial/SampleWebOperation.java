package Trial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleWebOperation {

    @Test

    public void homepageOperation(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("window-size=450,750");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement textProduct = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        Assert.assertEquals(textProduct.getText(), "Products");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement userProfile = driver.findElement(By.xpath("//*[contains(@class,'shopping_cart_link')]"));
        userProfile.isDisplayed();

        driver.quit();
    }
}
