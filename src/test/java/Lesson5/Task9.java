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

public class Task9 {
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

        List<WebElement> geo_zones_page = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Geo Zones)').click()");
        driver.findElement(By.cssSelector("h1"));

        List<WebElement> countries_list = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
        int countries_count = countries_list.size();
        for (int i = 0; i < countries_count; i++) {
            List<WebElement> countries_list2 = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            countries_list2.get(i).click();

            List<WebElement> sub_countries_list = driver.findElements(By.cssSelector(".dataTable tr td:nth-child(2) .select2-selection__rendered"));

            int sub_countries_count = sub_countries_list.size();
            String[] actual_countries = new String[sub_countries_count];
            String[] sorted_countries = new String[sub_countries_count];

            for (WebElement single_sub_country : sub_countries_list) {
                int j = sub_countries_list.indexOf(single_sub_country);
                actual_countries[j] = sorted_countries[j] = single_sub_country.getText();
            }

            Arrays.sort(sorted_countries);
            System.out.println(Arrays.toString(sorted_countries));
            System.out.println(Arrays.toString(actual_countries));
            for (int l = 0; l < sub_countries_count; l++) {
                if (actual_countries[l] != sorted_countries[l]) {
                    throw new Exception("Элемент таблицы Zones столбца Country " + l + " не отсортирован");
                }
            }
            System.out.println("Sorting is good");

            List<WebElement> sub_zones_list = driver.findElements(By.cssSelector(".dataTable tr td:nth-child(3) option[selected]"));

            int sub_zones_count = sub_zones_list.size();
            String[] actual_zone = new String[sub_zones_count];
            String[] sorted_zone = new String[sub_zones_count];

            for (WebElement single_sub_zone : sub_zones_list) {
                if (single_sub_zone.isSelected()) {
                    int k = sub_zones_list.indexOf(single_sub_zone);
                    actual_zone[k] = sorted_zone[k] = single_sub_zone.getText();
                }
            }

                Arrays.sort(sorted_zone);
                System.out.println(Arrays.toString(sorted_zone));
                System.out.println(Arrays.toString(actual_zone));
                for (int l = 0; l < sub_countries_count; l++) {
                    if (actual_zone[l] != sorted_zone[l]) {
                        throw new Exception("Элемент таблицы Zones столбца Zone " + l + " не отсортирован");
                    }
                }
                System.out.println("Sorting is good");

                List<WebElement> geo_zones_page2 = (List<WebElement>) ((JavascriptExecutor) driver)
                        .executeScript("return $('.name:contains(Geo Zones)').click()");
                driver.findElement(By.cssSelector("h1"));
            }
        }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
