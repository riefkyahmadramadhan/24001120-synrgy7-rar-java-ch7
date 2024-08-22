package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    By pageHeader   = By.xpath("//span[contains(text(), 'Overview')]");
    By priceTotal   = By.xpath("//div[contains(text(), 'Price Total')]");
    By finishButton   = By.id("finish");

    public CheckOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageHeader(){
        return driver.findElement(pageHeader).getText();
    }

    public String getPriceTotal(){
        return driver.findElement(priceTotal).getText();
    }

    public void finishButtonIsDisplayed(){
        driver.findElement(finishButton).isDisplayed();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
