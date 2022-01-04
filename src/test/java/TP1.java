
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class TP1 {

   @Test
    public void test1 (){
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.amazon.fr");
    driver.manage().window().maximize();

    WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
    buttonCookies.click();
    WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
    barreRecherche.sendKeys("machine à raclette");
    barreRecherche.sendKeys(Keys.ENTER);

    //Thread.sleep(1000);
    //*[@class="nav-fill"]
    //.nav-progressive-content
    //.nav-progressive-content.nav-logo-ext cssselector de plusieurs classes
    //driver.quit();

    }
    @Test
    public void test2 (){

      WebDriver driver = new ChromeDriver();
      driver.get("https://www.amazon.fr");
      driver.manage().window().maximize();

      WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
      buttonCookies.click();
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
     try {
      Thread.sleep(2000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
     driver.quit();
    }
}
