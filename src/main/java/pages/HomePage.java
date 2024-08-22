package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {

    WebDriver driver;

    // class attribute
    // By textProduct = By.xpath("//span[contains(text(), 'Products')]");
    // By shoppingIcon = By.xpath("//*[contains(@class,'shopping_cart_link')]");

    // class attribut page factory
    @FindBy(xpath = "//span[contains(text(), 'Products')]")
    WebElement textProduct;

    @FindBy(xpath = "//*[contains(@class,'shopping_cart_link')]")
    WebElement shoppingIcon;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    By addButton = By.id("add-to-cart-sauce-labs-backpack");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // method
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getTextProduct(){
        // return driver.findElement(textProduct).getText();
        return textProduct.getText();
    }

    public void shoppingIconIsDisplayed(){
        // driver.findElement(shoppingIcon).isDisplayed();
        shoppingIcon.isDisplayed();
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement price : productPrices) {
            prices.add(Double.valueOf(price.getText().replace("$", "")));
        }
        return prices;
    }

    public void sortProductsByPriceHighToLow() {
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText("Price (high to low)");
    }

    public void clickAddCartButton(){
        driver.findElement(addButton).click();
    }

    public void clickCartButton(){
        shoppingIcon.click();
    }
}
