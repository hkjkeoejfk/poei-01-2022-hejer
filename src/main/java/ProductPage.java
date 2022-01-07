import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    int timeoutSidebar = 3;
    int timeoutConfirmation = 10;
    By addToCartButtonSelector = By.id("add-to-cart-button");
    By addWarrantyButtonSelector = By.cssSelector("#attachSiAddCoverage input");
    By noCoverageButtonSelector = By.cssSelector("#attachSiNoCoverage input");
    By confirmationImageSelector = new By.ById("add-to-cart-confirmation-image");
    public ProductPage(WebDriver driver) {
        this.driver = driver;

    }
    public void addToCart() {
        driver.findElement(addToCartButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSidebar));
        wait.until(ExpectedConditions.elementToBeClickable(addWarrantyButtonSelector));
    }
    public void noCoverage(){
        driver.findElement(noCoverageButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutConfirmation));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationImageSelector));
    }

}
