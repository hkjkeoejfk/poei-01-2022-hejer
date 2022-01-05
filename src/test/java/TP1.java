
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TP1 {

    WebDriver driver;

    @BeforeMethod
        public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();

        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }
    @AfterMethod
    public void teardown(){

    driver.quit();
    }
   @Test
    public void test1 (){

    WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
    barreRecherche.sendKeys("machine à raclette");
    barreRecherche.sendKeys(Keys.ENTER);

    //Thread.sleep(1000);
    //*[@class="nav-fill"]
    //.nav-progressive-content
    //.nav-progressive-content.nav-logo-ext cssselector de plusieurs classes


    }
    @Test
    public void test2 (){


      WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
      barreRecherche.sendKeys("machine à raclette");
      barreRecherche.sendKeys(Keys.ENTER);
     try {
      Thread.sleep(2000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
     WebElement photo = driver.findElement(By.cssSelector("[data-component-id='1']"));


     photo.click();


    }
}
