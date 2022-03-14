package lesson7;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Task13 {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeTest
        public void start() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        @Test
        public void Check() {
            driver.get("http://localhost/litecart/en/");

//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=email]")));
//            WebElement email_in_login = driver.findElement(By.cssSelector("[name=email]"));
//            email_in_login.clear();
//            email_in_login.sendKeys("otzxei@otzxei.ru");
//
//            WebElement password_in_login = driver.findElement(By.cssSelector("[name=password]"));
//            password_in_login.clear();
//            password_in_login.sendKeys("otzxei");
//
//            WebElement login = driver.findElement(By.cssSelector(".button-set [name=login]"));
//            login.click();
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-account li:nth-child(4) a")));

            int count_clicks = 3;
            for (int i = 0; i < count_clicks; i++) {
                WebElement product = driver.findElement(By.cssSelector("#box-most-popular .products:nth-child(1)"));
                product.click();

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

                WebElement back_to_main = driver.findElement(By.cssSelector("#logotype-wrapper a"));
                back_to_main.click();
            }

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
    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}