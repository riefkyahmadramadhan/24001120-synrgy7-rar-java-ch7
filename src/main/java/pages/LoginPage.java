package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

     //class attribute
     By usernameField = By.id("user-name");
     By passwordField = By.id("password");
     By loginButton = By.id("login-button");
    By failedLoginButton = By.xpath("//h3[@data-test='error']/button[@class='error-button']");

    // attribute page factory
    //@FindBy(id = "user-name")
    //WebElement usernameField;

    //@FindBy(id = "password")
    //WebElement passwordField;

    //@FindBy(id = "login-button")
    //WebElement loginButton;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // method
    public void inputUser(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
        // usernameField.sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        // passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
        // loginButton.click();
    }

    public void loginIsDisplayed(){
        driver.findElement(loginButton).isDisplayed();
    }

    public void erorIsDisplayed(){
        driver.findElement(failedLoginButton).isDisplayed();
    }
}
