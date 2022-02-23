package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LitecartLogIn {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        //todo неявное ожидание
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void LoginTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa-sign-out")));

        List<WebElement> appearence = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Appearence)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement template = driver.findElement(By.cssSelector("#doc-template"));
        driver.findElement(By.cssSelector("h1"));
        WebElement logotype = driver.findElement(By.cssSelector("#doc-logotype"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> catalog = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Catalog)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement sub_catalog = driver.findElement(By.cssSelector("#doc-catalog"));
        driver.findElement(By.cssSelector("h1"));
        WebElement product_groups = driver.findElement(By.cssSelector("#doc-product_groups"));
        driver.findElement(By.cssSelector("h1"));
        WebElement option_groups = driver.findElement(By.cssSelector("#doc-option_groups"));
        driver.findElement(By.cssSelector("h1"));
        WebElement manufacturers = driver.findElement(By.cssSelector("#doc-manufacturers"));
        driver.findElement(By.cssSelector("h1"));
        WebElement suppliers = driver.findElement(By.cssSelector("#doc-suppliers"));
        driver.findElement(By.cssSelector("h1"));
        WebElement delivery_statuses = driver.findElement(By.cssSelector("#doc-delivery_statuses"));
        driver.findElement(By.cssSelector("h1"));
        WebElement sold_out_statuses = driver.findElement(By.cssSelector("#doc-sold_out_statuses"));
        driver.findElement(By.cssSelector("h1"));
        WebElement quantity_units = driver.findElement(By.cssSelector("#doc-quantity_units"));
        driver.findElement(By.cssSelector("h1"));
        WebElement catalog_csv = driver.findElement(By.cssSelector("#doc-csv"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> countries = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Countries)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> currencies = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Currencies)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> customers = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Customers)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement sub_customers = driver.findElement(By.cssSelector("#doc-customers"));
        driver.findElement(By.cssSelector("h1"));
        WebElement customers_csv = driver.findElement(By.cssSelector("#doc-csv"));
        driver.findElement(By.cssSelector("h1"));
        WebElement newsletter = driver.findElement(By.cssSelector("#doc-newsletter"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> geo_zones = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Geo Zones)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> languages = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Languages)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement sub_languages = driver.findElement(By.cssSelector("#doc-languages"));
        driver.findElement(By.cssSelector("h1"));
        WebElement storage_encoding = driver.findElement(By.cssSelector("#doc-storage_encoding"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> modules = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Modules)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement jobs = driver.findElement(By.cssSelector("#doc-jobs"));
        driver.findElement(By.cssSelector("h1"));
        WebElement customer = driver.findElement(By.cssSelector("#doc-customer"));
        driver.findElement(By.cssSelector("h1"));
        WebElement shipping = driver.findElement(By.cssSelector("#doc-shipping"));
        driver.findElement(By.cssSelector("h1"));
        WebElement payment = driver.findElement(By.cssSelector("#doc-payment"));
        driver.findElement(By.cssSelector("h1"));
        WebElement order_total = driver.findElement(By.cssSelector("#doc-order_total"));
        driver.findElement(By.cssSelector("h1"));
        WebElement order_success = driver.findElement(By.cssSelector("#doc-order_success"));
        driver.findElement(By.cssSelector("h1"));
        WebElement order_action = driver.findElement(By.cssSelector("#doc-order_action"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> orders = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Orders)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement sub_orders = driver.findElement(By.cssSelector("#doc-orders"));
        driver.findElement(By.cssSelector("h1"));
        WebElement order_statuses = driver.findElement(By.cssSelector("#doc-order_statuses"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> pages = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Pages)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> reports = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Reports)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement monthly_sales = driver.findElement(By.cssSelector("#doc-monthly_sales"));
        driver.findElement(By.cssSelector("h1"));
        WebElement most_sold_products = driver.findElement(By.cssSelector("#doc-most_sold_products"));
        driver.findElement(By.cssSelector("h1"));
        WebElement most_shopping_customers = driver.findElement(By.cssSelector("#doc-most_shopping_customers"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> settings = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Settings)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement store_info = driver.findElement(By.cssSelector("#doc-store_info"));
        driver.findElement(By.cssSelector("h1"));
        WebElement defaults = driver.findElement(By.cssSelector("#doc-defaults"));
        driver.findElement(By.cssSelector("h1"));
        WebElement general = driver.findElement(By.cssSelector("#doc-general"));
        driver.findElement(By.cssSelector("h1"));
        WebElement listings = driver.findElement(By.cssSelector("#doc-listings"));
        driver.findElement(By.cssSelector("h1"));
        WebElement images = driver.findElement(By.cssSelector("#doc-images"));
        driver.findElement(By.cssSelector("h1"));
        WebElement checkout = driver.findElement(By.cssSelector("#doc-checkout"));
        driver.findElement(By.cssSelector("h1"));
        WebElement advanced = driver.findElement(By.cssSelector("#doc-advanced"));
        driver.findElement(By.cssSelector("h1"));
        WebElement security = driver.findElement(By.cssSelector("#doc-security"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> slides = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Slides)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> tax = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Tax)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement tax_classes = driver.findElement(By.cssSelector("#doc-tax_classes"));
        driver.findElement(By.cssSelector("h1"));
        WebElement tax_rates = driver.findElement(By.cssSelector("#doc-tax_rates"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> translations = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Translations)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement search = driver.findElement(By.cssSelector("#doc-search"));
        driver.findElement(By.cssSelector("h1"));
        WebElement scan = driver.findElement(By.cssSelector("#doc-scan"));
        driver.findElement(By.cssSelector("h1"));
        WebElement translations_csv = driver.findElement(By.cssSelector("#doc-csv"));
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> users = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Users)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> vqmods = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(vQmods)').click()");
        driver.findElement(By.cssSelector("h1"));
        WebElement sub_vqmods = driver.findElement(By.cssSelector("#doc-vqmods"));
        driver.findElement(By.cssSelector("h1"));
    }

    @AfterTest
        public void stop(){
            driver.quit();
            driver=null;
    }
}
