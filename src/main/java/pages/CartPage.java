package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;
    // WebDriverWait wait;

    By productPrices   = By.className("inventory_item_price");
    By checkOutButton  = By.id("checkout");
    By pageHeader      = By.xpath("//span[contains(text(), 'Your Cart')]");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // method
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public void productPriceIsDisplayed(){
        driver.findElement(productPrices).isDisplayed();
    }

    public void nextButtonIsDisplayed(){
        driver.findElement(checkOutButton).isDisplayed();
    }

    public void clickNextButton(){
        driver.findElement(checkOutButton).click();
    }
}
