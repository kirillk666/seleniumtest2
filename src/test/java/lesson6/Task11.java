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
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Check() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("[name=login_form] td a")).click();

        String random_combined = RandomStringUtils.randomAlphanumeric(6);
        String random_letters = RandomStringUtils.randomAlphabetic(6);
        String low_letters = random_letters.toLowerCase();
        String random_numbers = RandomStringUtils.randomNumeric(5);
        System.out.println(low_letters);

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
        String email_data = low_letters + "@" + low_letters + ".ru";
        email.sendKeys(email_data);
        System.out.println(email_data);

        WebElement phone = driver.findElement(By.cssSelector("[name=phone]"));
        phone.sendKeys("+1" + random_numbers);

        WebElement password = driver.findElement(By.cssSelector("[name=password]"));
        password.sendKeys(low_letters);

        WebElement confirmed_password = driver.findElement(By.cssSelector("[name=confirmed_password]"));
        confirmed_password.sendKeys(low_letters);

        Select country = new Select(driver.findElement(By.cssSelector("[name=country_code]")));
        country.selectByVisibleText("United States");

        Select zone_code = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        zone_code.selectByIndex(1);

        WebElement create_account = driver.findElement(By.cssSelector("[name=create_account]"));
        create_account.click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-account li:nth-child(4) a")));
        WebElement logout = driver.findElement(By.cssSelector("#box-account li:nth-child(4) a"));
        logout.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=email]")));
        WebElement email_in_login = driver.findElement(By.cssSelector("[name=email]"));
        email_in_login.clear();
        email_in_login.sendKeys(email_data);

        WebElement password_in_login = driver.findElement(By.cssSelector("[name=password]"));
        password_in_login.clear();
        password_in_login.sendKeys(low_letters);

        WebElement login = driver.findElement(By.cssSelector(".button-set [name=login]"));
        login.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-account li:nth-child(4) a")));
        WebElement logout2 = driver.findElement(By.cssSelector("#box-account li:nth-child(4) a"));
        logout2.click();
    }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
