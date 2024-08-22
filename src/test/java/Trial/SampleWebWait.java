package Trial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleWebWait {

    @Test
    public void homepageImplicitWait(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("window-size=450,750");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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

    @Test
    public void homepageExplicitWait(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("window-size=450,750");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // driver.findElement(By.id("user-name")).sendKeys("standard_user");
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        inputUsername.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // ASSERTION
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement textProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Products')]")));
        Assert.assertEquals(textProduct.getText(), "Products");

        WebElement shoppingIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'shopping_cart_link')]")));
        shoppingIcon.isDisplayed();

        driver.quit();
    }
}
