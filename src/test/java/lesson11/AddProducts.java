package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddProducts extends TestBase {

    @Test
    public static void addProducts(int count_clicks, WebDriver driver, WebDriverWait wait) {
        for (int i = 0; i < count_clicks; i++) {
            WebElement product = driver.findElement(By.cssSelector("#box-most-popular .products:nth-child(1)"));
            product.click();

            SingleProductPage.singleProductPage(driver,wait);

            WebElement back_to_main = driver.findElement(By.cssSelector("#logotype-wrapper a"));
            back_to_main.click();
        }
    }
}
