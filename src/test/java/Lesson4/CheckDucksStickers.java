package Lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class CheckDucksStickers {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        //todo неявное ожидание
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void DucksTest() throws Exception {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> ducks = driver.findElements(By.cssSelector(".product"));
        System.out.println(ducks.size());
        for (WebElement single_duck : ducks) {
            List<WebElement> sticker_check = single_duck.findElements(By.cssSelector(".sticker"));
            int count = sticker_check.size();
            System.out.println(count);
            if (count > 1) {
                System.out.println(count);
                System.out.println(single_duck.getText());
                throw new Exception("Duck has more than 1 sticker");
            } else {
                System.out.println("sticker is ok for " + single_duck.getText());
            }
        }
    }
    @AfterTest
    public void stop(){
        driver.quit();
        driver=null;
    }
}