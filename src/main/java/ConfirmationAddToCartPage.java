import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAddToCartPage {
    WebDriver driver;
By cartButtonSelector= new By.ById("nav-cart-count");
    public ConfirmationAddToCartPage(WebDriver driver) {
        this.driver = driver;

    }
    public void openCart (){
        driver.findElement(cartButtonSelector).click();
    }
}
