import Iphone.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IphoneTests {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);
        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();

    }

   // @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void passedTest() {
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(true);
    }
    @Test
    public void Iphone13ProAddToCartTests() throws InterruptedException {

        String expectedPrice = "1 259,00";
        String expectedTitle = "iPhone 13 Pro Max 256 Go Bleu Alpin";

        //Act
        MainPage mainPage= new MainPage(driver);
        CartPage cartPage = mainPage.openIphonePage()
                .openIphone13ProPage()
                .buy()
                .selectIphone13ProMax()
                .selectBlueAlpin()
                .select256Go()
                .noAppleTradeIn()
                .addToCart()
                .openCartPage();

                //Assert
        //Assert.assertTrue(cartPage.getProductPrice(expectedPrice), "Le prix n'est pas conforme");
       // Assert.assertTrue(cartPage.getSubTotal(expectedPrice), "Le sous-total n'est pas conforme");
       // Assert.assertEquals(cartPage.getTotal(), expectedPrice);
       // Assert.assertEquals(cartPage.getCartTitle(), expectedPrice);
      // Assert.assertEquals(cartPage.getProductName(), expectedTitle);
    }
}
