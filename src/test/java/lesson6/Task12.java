package lesson6;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Task12 {
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
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();

        List<WebElement> catalog = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Catalog)').click()");
        driver.findElement(By.cssSelector("h1"));

        WebElement add_new_product = driver.findElement(By.cssSelector("div[style] .button:nth-child(2)"));
        add_new_product.click();

        String random_combined = RandomStringUtils.randomAlphanumeric(6);
        String random_letters = RandomStringUtils.randomAlphabetic(6);
        String random_numbers = RandomStringUtils.randomNumeric(5);

        List<WebElement> tabs = driver.findElements(By.cssSelector(".tabs li"));
        for (WebElement single_tab : tabs) {
            if (single_tab.getText().equals("General")) {
                System.out.println(single_tab.getText());
                single_tab.click();
                List<WebElement> status = driver.findElements(By.cssSelector("label input"));
//                Assert.assertEquals(driver,By.cssSelector("label"));
                wait.until(ExpectedConditions.visibilityOfAllElements(status));
                for (WebElement single_status : status) {
                    if (single_status.getAttribute("value").equals("1")) {
                        single_status.click();
                    }
                }

                List<WebElement> name = driver.findElements(By.cssSelector(".input-wrapper input"));
                for (WebElement single_name : name) {
                    if (single_name.getAttribute("name").equals("name[en]")) {
                        single_name.sendKeys(random_letters);
                    }
                    if (single_name.getAttribute("value").equals("1-2")) {
                        single_name.click();
                    }
                }

                WebElement code = driver.findElement(By.cssSelector("[name=code]"));
                code.sendKeys(random_numbers);

                WebElement quantity = driver.findElement(By.cssSelector("[name=quantity]"));
                quantity.click();
                quantity.sendKeys(random_numbers);

                String path = "C:\\Tools\\Test12.png";
                Path path_absolute = Path.of(path).toAbsolutePath();
                
                attachFile(driver, By.cssSelector("[type=file]"), path_absolute.toString());

//                //        setDatepicker(driver, "[name=date_valid_from]", "02/20/2002");

                WebElement calendar1 = driver.findElement(By.cssSelector("[name=date_valid_from]"));
                calendar1.sendKeys("02202002");

                WebElement calendar2 = driver.findElement(By.cssSelector("[name=date_valid_to]"));
                calendar2.sendKeys("02202022");
            }

            if (single_tab.getText().equals("Information")) {
                single_tab.click();
                System.out.println(single_tab.getText());
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[name=manufacturer_id]"))));
                Select manufacturer = new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]")));
                manufacturer.selectByIndex(1);

                WebElement keywords = driver.findElement(By.cssSelector("[name=keywords]"));
                keywords.sendKeys(random_combined);

                List<WebElement> short_description = driver.findElements(By.cssSelector(".input-wrapper input"));
                for (WebElement single_short_description : short_description) {
                    if (single_short_description.getAttribute("name").equals("short_description[en]")) {
                        single_short_description.sendKeys(random_combined);
                    }
                    if (single_short_description.getAttribute("name").equals("head_title[en]")) {
                        single_short_description.sendKeys(random_combined);
                    }
                    if (single_short_description.getAttribute("name").equals("meta_description[en]")) {
                        single_short_description.sendKeys(random_combined);
                    }
                }

                WebElement description = driver.findElement(By.cssSelector(".trumbowyg-editor"));
                description.sendKeys(random_combined);
            }

            if (single_tab.getText().equals("Prices")) {
                single_tab.click();
                System.out.println(single_tab.getText());
                wait.until(visibilityOf(driver.findElement(By.cssSelector("[name=purchase_price]"))));

                WebElement purchase_price = driver.findElement(By.cssSelector("[name=purchase_price]"));
                purchase_price.clear();
                purchase_price.sendKeys(random_numbers);

                Select currency = new Select(driver.findElement(By.cssSelector("[name=purchase_price_currency_code]")));
                currency.selectByIndex(1);

                List<WebElement> prices = driver.findElements(By.cssSelector(".input-wrapper input"));
                for (WebElement single_prices : prices) {
                    if (single_prices.getAttribute("name").equals("prices[USD]")) {
                        single_prices.sendKeys(random_numbers);
                    }
                    if (single_prices.getAttribute("name").equals("prices[EUR]")) {
                        single_prices.sendKeys(random_numbers);
                    }
                    if (single_prices.getAttribute("name").equals("gross_prices[USD]")) {
                        single_prices.sendKeys(random_numbers);
                    }
                    if (single_prices.getAttribute("name").equals("gross_prices[EUR]")) {
                        single_prices.sendKeys(random_numbers);
                    }
                }
            }
        }
        WebElement save = driver.findElement(By.cssSelector(".button-set [name=save]"));
        save.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dataTable")));
        wait.until(visibilityOf(driver.findElement(By.cssSelector(".dataTable"))));

    }


    //todo methods for uploading files
    public void unhide(WebDriver driver, WebElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
                + "return true;";
        ((JavascriptExecutor) driver).executeScript(script, element);

    }

    public void attachFile(WebDriver driver, By locator, String file) {
        WebElement input = driver.findElement(locator);
        unhide(driver, input);
        input.sendKeys(file);
    }

//    //todo method for calendar
//    public void setDatepicker(WebDriver driver, String cssSelector, String date) {
//       new WebDriverWait(driver, 30000).until((WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());
//       JavascriptExecutor.class.cast(driver).executeScript(String.format("$('{0}').datepicker('setDate', '{1}')", cssSelector, date));
//    }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
//    Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке).
//
//        Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить.
//
//        Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campaigns) на вкладке Prices можно не добавлять.
//
//        Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях).
//
//        Картинку с изображением товара нужно уложить в репозиторий вместе с кодом. При этом указывать в коде полный абсолютный путь к файлу плохо, на другой машине работать не будет. Надо средствами языка программирования преобразовать относительный путь в абсолютный.
//
//        После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.