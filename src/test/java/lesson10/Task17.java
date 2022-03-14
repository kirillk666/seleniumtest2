package lesson10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.logging.Level;


public class Task17 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        LoggingPreferences prefs = new LoggingPreferences();
        prefs.enable("browser", Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, prefs);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Check() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector(".footer button")).click();

        System.out.println(driver.manage().logs().getAvailableLogTypes());

        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }

       ((JavascriptExecutor) driver)
                .executeScript("return $('.name:contains(Catalog)').click()");
        WebElement main_header = driver.findElement(By.cssSelector("h1"));
        String main_header_str = main_header.getText();

        List<WebElement> rubber_ducks = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) a"));
        for(WebElement rubber_duck : rubber_ducks){
            if(rubber_duck.getText().equals("Rubber Ducks")){
                rubber_duck.click();
                break;
            }
        }

        List<WebElement> subcategory = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) a"));
        for(WebElement sub_element : subcategory){
            if(sub_element.getText().equals("Subcategory")){
                sub_element.click();
                break;
            }
        }

        List<WebElement> elements = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) a"));
        int size = elements.size();
        System.out.println(size);
        for(int i=0; i<size; i++){
            List<WebElement> elements2 = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) a"));
            String dd = elements2.get(i).getText();
            System.out.println(dd);
            elements2.get(i).click();
            WebElement header =  driver.findElement(By.cssSelector("h1"));
            if(!(header.getText().equals(main_header_str))){
                driver.findElement(By.cssSelector(".button-set [name=cancel]")).click();
            }
        }

    }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}