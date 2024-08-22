package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    By fnameForm        = By.id("first-name");
    By lnameForm        = By.id("last-name");
    By postCodeForm     = By.id("postal-code");
    By continueButton   = By.id("continue");
    By pageHeader       = By.xpath("//span[contains(text(), 'Checkout')]");

    public CheckInfoPage(WebDriver driver) {
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

    public void formIsDisplayed(){
        driver.findElement(fnameForm).isDisplayed();
    }

    public void continueButtonIsDisplayed(){
        driver.findElement(continueButton).isDisplayed();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void inputFirstName(String fname){
        driver.findElement(fnameForm).sendKeys(fname);
    }

    public void inputLastName(String lname){
        driver.findElement(lnameForm).sendKeys(lname);
    }

    public void inputPostalCode(String pcode){
        driver.findElement(postCodeForm).sendKeys(pcode);
    }

}
