package lesson11;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

public class CartTest extends TestBase {

    @Test
    public static void cartCheck(WebDriver driver, WebDriverWait wait) {

        WebElement go_inside_cart = driver.findElement(By.cssSelector("#cart-wrapper .link"));
        go_inside_cart.click();

        List<WebElement> products_view = driver.findElements(By.cssSelector(".viewport li.item"));
        for(int i=0;i<products_view.size();i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".viewport li.item")));
            WebElement single_product = driver.findElement(By.cssSelector(".viewport li.item"));
            WebElement product_name = single_product.findElement(By.cssSelector("p a"));
            String product_name_string = product_name.getText();
            WebElement remove_product = driver.findElement(By.cssSelector("[name=remove_cart_item]"));
            remove_product.click();
            wait.until(ExpectedConditions.invisibilityOf(single_product));
            wait.until(invisibilityOfElementWithText(By.cssSelector("#box-checkout-summary tr td.item"), product_name_string));
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("viewport")));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("em"), "There are no items in your cart."));
    }

}
