package lesson11;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SingleProductPage extends TestBase{
    @Test
    public static void singleProductPage(WebDriver driver, WebDriverWait wait){
        WebElement title = driver.findElement(By.cssSelector("h1"));
        if (title.getText().equals("Yellow Duck")) {
            Select size = new Select(driver.findElement(By.cssSelector("select")));
            size.selectByIndex(1);
        }


        // count elements in cart
        WebElement cart = driver.findElement(By.cssSelector("#cart .content .quantity"));
        String string_in_cart = cart.getText();
        Integer amount_in_cart1 = Integer.parseInt(string_in_cart);
        System.out.println("products in cart = " + amount_in_cart1);

        // count new elements
        String random_numbers = RandomStringUtils.randomNumeric(1);
        WebElement quantity = driver.findElement(By.cssSelector(".quantity input"));
        quantity.clear();
        quantity.sendKeys(random_numbers);
        Integer new_amount = Integer.parseInt(random_numbers);
        System.out.println("Want to add products = " + new_amount);

        //Total sum
        Integer total_sum = amount_in_cart1 + new_amount;
        String string_total_sum = total_sum.toString();
        System.out.println("Total sum of products in cart = " + total_sum);

        WebElement add = driver.findElement(By.cssSelector("[name=add_cart_product]"));
        add.click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .content .quantity"), string_total_sum));
    }
}
