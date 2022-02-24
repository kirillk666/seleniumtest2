package Lesson4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.Locator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.swing.UIManager.get;


public class Task6Menu {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        //todo неявное ожидание
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }

    @Test
//    boolean sub_menu(WebDriver driver, By locator){
//        return driver.findElements(By.cssSelector("[id^=doc]")).size() > 0;}

    public void LoginTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa-sign-out")));



        List<WebElement> menu = driver.findElements(By.cssSelector("[id^=app]"));
        int count = menu.size();
        for (int i=0;i<count;i++){
            List<WebElement> menu2 = driver.findElements(By.cssSelector("[id^=app]"));
            menu2.get(i).click();
            WebElement header = driver.findElement(By.cssSelector("h1"));
            System.out.println(header.getText());

            List<WebElement> sub_menu = driver.findElements(By.cssSelector("[id^=doc]"));
            int count2 = sub_menu.size();
            System.out.println(count2);
            if (count2 > 0) {
                for (int i2=0;i2<count2;i2++){
                    List<WebElement> sub_menu2 = driver.findElements(By.cssSelector("[id^=doc]"));
                    sub_menu2.get(i2).click();
                    driver.findElement(By.cssSelector("h1"));
                }
            }
        }
    }

    @AfterTest
    public void stop(){
        driver.quit();
        driver=null;
    }
}