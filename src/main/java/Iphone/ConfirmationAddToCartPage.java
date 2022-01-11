package Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAddToCartPage {
    WebDriver driver;
    int timeout =3;
    By openCartButton = new By.ByCssSelector("[data-autom='proceed']");
    public ConfirmationAddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public CartPage openCartPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(openCartButton));
        driver.findElement(openCartButton).click();
        CartPage cartPage= new CartPage(driver);
        return cartPage;
    }
}
