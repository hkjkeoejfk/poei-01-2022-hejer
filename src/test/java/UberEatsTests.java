import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class UberEatsTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.ubereats.com/fr");
        driver.manage().window().maximize();
        WebElement buttonCookies = driver.findElement(By.cssSelector(".bc.gh.gi.gl.bj.bk.bl.bm.bn.bo.bt.bu.ba.bb"));
        buttonCookies.click();
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }



    @Test
    public void addBurgerToCarttest () throws InterruptedException {
        // Arrange
    int timeoutSearchLoad= 10;
    String positionName= "la defense";
    By positionSelector = By.id("location-typeahead-home-input");
    By boutonBurgerSelector = By.cssSelector("[alt='Burgers']");
    By restorantSelector = By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
    By restaurantSelector = By.cssSelector("[alt=\'Le Marcel Jackson\']");
    By addBoutonSelector= By.cssSelector(".b8.b9.ba.bb.bc.bd.dh.ah.bf.bg.b0.bh.bi.bj.bk.bl.bm.bn.bo");
    By cartSelector= By.cssSelector("button[aria-label='checkout'] > div");
    By promoSelector =  By.cssSelector(".ba.c0.e2.b9.bj.ch");
    String expectedCartItems= "1";

        // Act

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad));


    WebElement position = driver.findElement(positionSelector);
    position.sendKeys(positionName);
    Thread.sleep(2000);
    position.sendKeys(Keys.ENTER);

    wait.until(ExpectedConditions.visibilityOfElementLocated(boutonBurgerSelector));
    WebElement burger= driver.findElement(boutonBurgerSelector);
    burger.click();


    wait.until(ExpectedConditions.visibilityOfElementLocated(restorantSelector));
    WebElement marcel = driver.findElement(restorantSelector);
    marcel.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantSelector));
    WebElement restaurant = driver.findElement(restaurantSelector);
    restaurant.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(addBoutonSelector));
    WebElement addBouton = driver.findElement(addBoutonSelector);
    addBouton.click();

    wait.until(ExpectedConditions.invisibilityOfElementLocated(promoSelector));

        // Assert
    WebElement cart = driver.findElement(cartSelector);
    Assert.assertTrue(cart.getText().contains(expectedCartItems), "The cart does not contain 1 item");

}
}
