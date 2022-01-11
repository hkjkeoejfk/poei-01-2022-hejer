package Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iphone13ProPage {
    WebDriver driver;
    By buyButton = new By.ByCssSelector(".ac-ln-button");

    public Iphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }
    public BuyIphone13ProPage buy(){
        driver.findElement(buyButton).click();
        BuyIphone13ProPage buyIphone13ProPage = new BuyIphone13ProPage(driver);
        return buyIphone13ProPage;
    }
}
