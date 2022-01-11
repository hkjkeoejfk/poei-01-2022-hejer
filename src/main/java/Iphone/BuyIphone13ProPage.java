package Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphone13ProPage {
    WebDriver driver;
    int timeout = 10;
    By iphoneMaxButton = new By.ByCssSelector("[data-autom='dimensionScreensize6_7inch']+label");
    By iphoneColor = new By.ByCssSelector("[data-autom='dimensionColorsierrablue']+label");
    By capacityButton = new By.ByCssSelector("[data-autom='dimensionCapacity128gb']+label");
    By tradeButton = new By.ByCssSelector("[data-autom='choose-noTradeIn']+label");
    By addToCartButton = new By.ByCssSelector(".button.button-block");
    By bande = new By.ByCssSelector(".as-standardnav-background");

    public BuyIphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }

    public BuyIphone13ProPage selectIphone13ProMax()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bande));
        driver.findElement(iphoneMaxButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphoneColor));
        return this;
    }

    public BuyIphone13ProPage selectBlueAlpin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColor));
        driver.findElement(iphoneColor).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(capacityButton));
        Thread.sleep(1000);
        return this;

    }

    public BuyIphone13ProPage select256Go() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(capacityButton));
        driver.findElement(capacityButton).click();
        Thread.sleep(1000);
        return this;
    }

    public BuyIphone13ProPage noAppleTradeIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(tradeButton));
        driver.findElement(tradeButton).click();
        return this;
    }

    public ConfirmationAddToCartPage addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        ConfirmationAddToCartPage confirmationAddToCartPage= new ConfirmationAddToCartPage(driver);
        return confirmationAddToCartPage;
    }
}
