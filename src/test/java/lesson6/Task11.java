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


public class Task11 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 100);
    }
    @Test
    public void Check() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("[name=login_form] td a")).click();

        String random_combined = RandomStringUtils.randomAlphanumeric(6);
        String random_letters = RandomStringUtils.randomAlphabetic(6);
        String random_numbers = RandomStringUtils.randomNumeric(5);
        System.out.println(random_combined);

        WebElement tax_id = driver.findElement(By.cssSelector("[name=tax_id]"));
        tax_id.sendKeys(random_numbers);

        WebElement company = driver.findElement(By.cssSelector("[name=company]"));
        company.sendKeys(random_letters);

        WebElement firstname = driver.findElement(By.cssSelector("[name=firstname]"));
        firstname.sendKeys(random_letters);

        WebElement lastname = driver.findElement(By.cssSelector("[name=lastname]"));
        lastname.sendKeys(random_letters);

        WebElement address1 = driver.findElement(By.cssSelector("[name=address1]"));
        address1.sendKeys(random_combined);

        WebElement address2 = driver.findElement(By.cssSelector("[name=address2]"));
        address2.sendKeys(random_combined);

        WebElement postcode = driver.findElement(By.cssSelector("[name=postcode]"));
        postcode.sendKeys(random_numbers);

        WebElement city = driver.findElement(By.cssSelector("[name=city]"));
        city.sendKeys(random_letters);

        WebElement email = driver.findElement(By.cssSelector("[name=email]"));
        String email_data = random_combined + "@" + random_letters + ".ru";
        email.sendKeys(email_data);
        System.out.println(email_data);

        WebElement phone = driver.findElement(By.cssSelector("[name=phone]"));
        phone.sendKeys("+1" + random_numbers);

        WebElement password = driver.findElement(By.cssSelector("[name=password]"));
        password.sendKeys(random_combined);

        WebElement confirmed_password = driver.findElement(By.cssSelector("[name=confirmed_password]"));
        confirmed_password.sendKeys(random_combined);

        Select country = new Select(driver.findElement(By.cssSelector("[name=country_code]")));
        country.selectByVisibleText("United States");

        Select zone_code = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        zone_code.selectByIndex(1);

        WebElement create_account = driver.findElement(By.cssSelector("[name=create_account]"));
        create_account.click();

        try {
            JavascriptExecutor j = (JavascriptExecutor) driver;
            if (j.executeScript("return document.readyState").toString().equals("complete")) {
                System.out.println("Page in ready state");
            }
        } catch (Exception exception) {
            System.out.println("Page not in ready state");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-account li:nth-child(4)")));
    }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
//    Сделайте сценарий для регистрации нового пользователя в учебном приложении litecart (не в админке, а в клиентской части магазина).
//Logout
//$$("#box-account li:nth-child(4)")

//        Сценарий должен состоять из следующих частей:
//
//        1) регистрация новой учётной записи с достаточно уникальным адресом электронной почты (чтобы не конфликтовало с ранее созданными пользователями, в том числе при предыдущих запусках того же самого сценария),
//        2) выход (logout), потому что после успешной регистрации автоматически происходит вход,
//        3) повторный вход в только что созданную учётную запись,
//        4) и ещё раз выход.
//
//        В качестве страны выбирайте United States, штат произвольный. При этом формат индекса -- пять цифр.
//
//
//        Проверки можно никакие не делать, только действия -- заполнение полей, нажатия на кнопки и ссылки. Если сценарий дошёл до конца, то есть созданный пользователь смог выполнить вход и выход -- значит создание прошло успешно.
//
//        В форме регистрации есть капча, её нужно отключить в админке учебного приложения на вкладке Settings -> Security.