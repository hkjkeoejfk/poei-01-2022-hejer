import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

By searchBarSelector = By.id("twotabsearchtextbox");
By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");
int timeOutSearch = 10;
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }
    public void searchProduct (String productName) {
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSearch));
        wait.until((ExpectedConditions.elementToBeClickable(searchResultSelector)));
    }
}
