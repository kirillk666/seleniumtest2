package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class Task8 {

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
    public void Sort() throws Exception {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();

        List<WebElement> countries = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Countries)').click()");
        driver.findElement(By.cssSelector("h1"));

        List <WebElement> countries_list = driver.findElements(By.cssSelector("[name=countries_form] .row td:nth-child(5)"));

        int size0 = countries_list.size();
        String[] actual = new String[size0];
        String[] sorted = new String[size0];

        for(WebElement single_country:countries_list){
            int i = countries_list.indexOf(single_country);
               actual[i] = sorted[i] = single_country.getText();
        }

        Arrays.sort(sorted);
        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(sorted));
        for(int i = 0;i<size0;i++){
            if (actual[i] != sorted[i]){
                throw new Exception("Элемент " + i + " не отсортирован");
            }
        }

        System.out.println("sorting is good");

        List<WebElement> zones_list = driver.findElements(By.cssSelector("[name=countries_form] .row td:nth-child(6)"));
        int count_zones_on_main = zones_list.size();
        for (int i = 0; i < count_zones_on_main; i++) {
            List<WebElement> zones_list2 = driver.findElements(By.cssSelector("[name=countries_form] .row td:nth-child(6)"));
            List<WebElement> countries_click = driver.findElements(By.cssSelector("[name=countries_form] .row td:nth-child(5) a"));
            if (Integer.parseInt(zones_list2.get(i).getText()) > 0) {
                countries_click.get(i).click();
                List<WebElement> names = driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3)"));
                List<WebElement> names2 = driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3) [type=hidden]"));

                int size = names2.size();
                String[] actual_names = new String[size];
                String[] sorted_names = new String[size];

                for (WebElement single_name : names) {
                    if (single_name.getText().isEmpty()) {
                    } else {
                        int q = names.indexOf(single_name);
                        actual_names[q] = sorted_names[q] = single_name.getText();
                    }
                }
                Arrays.sort(sorted_names);
                System.out.println(Arrays.toString(actual_names));
                System.out.println(Arrays.toString(sorted_names));
                for (int k = 0; k < size; k++) {
                    if (actual_names[k] != sorted_names[k]) {
                        throw new Exception("Элемент таблицы Zones " + k + " не отсортирован");
                    }
                }

                System.out.println("sorting is good");

                List<WebElement> countries2 = (List<WebElement>) ((JavascriptExecutor) driver)
                        .executeScript("return $('.name:contains(Countries)').click()");
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }

        @AfterTest
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
