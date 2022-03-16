package lesson11;

import org.testng.annotations.Test;

public class MainTest extends TestBase {

    @Test
    public void Check() {
        driver.get("http://localhost/litecart/en/");

        AddProducts.addProducts(5, driver, wait);
        CartTest.cartCheck(driver,wait);
    }
}
