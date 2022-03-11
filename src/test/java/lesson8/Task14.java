package lesson8;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;

public class Task14 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Check() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();

        List<WebElement> countries = (List<WebElement>) ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Countries)').click()");
        driver.findElement(By.cssSelector("h1"));

        WebElement new_country = driver.findElement(By.cssSelector("#content a.button"));
        new_country.click();

        List<WebElement> href = driver.findElements(By.cssSelector("#content tr [target=_blank"));
        for(WebElement single_href : href){
           String mainWindow = driver.getWindowHandle();
           Set<String> oldWindows = driver.getWindowHandles();
           single_href.click();
           String newWindow = wait.until(anyWindowOtherThan(oldWindows));
//           wait.until(ExpectedConditions.numberOfWindowsToBe(2));
           driver.switchTo().window(newWindow);
           WebElement header = driver.findElement(By.cssSelector("h1"));
           System.out.println(header.getText());
           driver.close();
           driver.switchTo().window(mainWindow);
        }

    }
    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next():null;
                }
            };
        }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
