import Iphone.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IphoneTests {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();

    }

   // @AfterMethod
    public void teardown() {
        driver.quit();
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
        Assert.assertTrue(cartPage.getProductPrice(expectedPrice), "Le prix n'est pas conforme");
        Assert.assertTrue(cartPage.getSubTotal(expectedPrice), "Le sous-total n'est pas conforme");
       // Assert.assertEquals(cartPage.getTotal(), expectedPrice);
       // Assert.assertEquals(cartPage.getCartTitle(), expectedPrice);
      // Assert.assertEquals(cartPage.getProductName(), expectedTitle);
    }
}
