package Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    int timeout=3;
    By titleSelector = new By.ByCssSelector("data-autom='bag-item-name'");
    By productPriceSelector= new By.ByCssSelector(".rs-iteminfo-price");
    By subTotalSelector = new By.ByCssSelector("data-autom='bagrs-summary-subtotalvalue'");
    By totalSelector = new By.ByCssSelector("data-autom='bagtotalvalue'");
    By cartTitleSelector = new By.ByCssSelector("data-autom='bag-header'");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName(){
        return driver.findElement(titleSelector).getText();

    }
    public String getCartTitle(){

        return driver.findElement(cartTitleSelector).getText();
    }
    public Boolean getProductPrice(String expectedResult){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceSelector));
        String price = driver.findElement(productPriceSelector).getText();
        return price.contains(expectedResult);

    }
    public Boolean getSubTotal(String expectedResult){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(subTotalSelector));
        String price= driver.findElement(subTotalSelector).getText();
        return price.contains(expectedResult);
    }
    public String getTotal(){
        return driver.findElement(totalSelector).getText();
    }
}
