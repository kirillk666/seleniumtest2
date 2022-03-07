package lesson6;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Task12 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Check(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();

        List<WebElement> catalog = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Catalog)').click()");
        driver.findElement(By.cssSelector("h1"));

        String random_combined = RandomStringUtils.randomAlphanumeric(6);
        String random_letters = RandomStringUtils.randomAlphabetic(6);
        String random_numbers = RandomStringUtils.randomNumeric(5);

        WebElement add_new_product = driver.findElement(By.cssSelector("div[style] .button:nth-child(2)"));
        add_new_product.click();

        List<WebElement> status = driver.findElements(By.cssSelector("label"));
        for(WebElement single_status : status){
            if(single_status.getAttribute("value").equals("1")){
                single_status.click();
            }
        }

        List<WebElement> name = driver.findElements(By.cssSelector(".input-wrapper input"));
        for(WebElement single_name : name){
            if(single_name.getAttribute("name").equals("name[en]")){
                single_name.sendKeys(random_letters);
            }
            if(single_name.getAttribute("value").equals("1-2")){
                single_name.click();
            }
        }

        WebElement code = driver.findElement(By.cssSelector("[name=code]"));
        code.sendKeys(random_numbers);

        //todo quantity doesn't work????
        WebElement quantity = driver.findElement(By.cssSelector("[name=quantity]"));
        quantity.click();
        quantity.sendKeys(random_numbers);


}
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
//        Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять.
//
//        Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях).
//
//        Картинку с изображением товара нужно уложить в репозиторий вместе с кодом. При этом указывать в коде полный абсолютный путь к файлу плохо, на другой машине работать не будет. Надо средствами языка программирования преобразовать относительный путь в абсолютный.
//
//        После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.