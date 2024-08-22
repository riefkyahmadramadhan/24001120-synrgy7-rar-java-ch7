package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {

    WebDriver driver;
    WebDriverWait wait;

    By successImage = By.xpath("//*[contains(@alt, 'Pony Express')]");
    By backButton   = By.id("back-to-products");

    public CompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void successImageIsDisplayed(){
        driver.findElement(successImage).isDisplayed();
    }

    public void backButtonIsDisplayed(){
        driver.findElement(backButton).isDisplayed();
    }

}
