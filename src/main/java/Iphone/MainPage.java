package Iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;
    int timeout=3;
    By categorie = By.cssSelector(".ac-gn-link.ac-gn-link-iphone");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public IphonePage openIphonePage(){

        driver.findElement(categorie).click();
        IphonePage iphonePage= new IphonePage(driver);
        return iphonePage;
    }

}
