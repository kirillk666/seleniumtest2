package Lesson4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CheckDuck {
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
    public void DucksTest() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> ducks = driver.findElements(By.cssSelector(".hover-light"));
        for (WebElement ducks_sticker : ducks) {
            WebElement sticker_check = driver.findElement(By.cssSelector(".sticker"));
            if (sticker_check == null) {
                System.out.println(ducks_sticker.getText());
                throw new NullPointerException("Duck has no sticker");
            }
            WebElement sticker_check_amount = driver.findElement(By.cssSelector("div.image-wrapper div:nth-child(2)"));
            try {
                WebElement sticker_check_amount2 = driver.findElement(By.cssSelector("div.image-wrapper div:nth-child(3)"));
                if (sticker_check_amount2 != null) {
                    System.out.println("Duplicate sticker");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Only one sticker");
            }
        }
    }

            @AfterTest
            public void stop(){
                driver.quit();
                driver=null;
            }
        }

            //todo не получилось сделать локатор с i
//            for (int i = 2; i > 0; i++) {
//                try {
//                    WebElement sticker_check_amount = driver.findElement(By.cssSelector("div.image-wrapper div:nth-child(+ i +)"));
//
//                    if (sticker_check_amount == null & i > 2) {
//                        break;
//                    }
//                    if (sticker_check_amount != null & i > 2) {
//                        System.out.println("Duplicate sticker");
//                        break;
//                    }
//                } catch (NoSuchElementException e) {
//                    System.out.println("caught");
//                }
//            }
//        }
//    }
            //todo list не подходит, т.к. считывает элементы со всей страницы сразу
//            List<WebElement> sticker_check = driver.findElements(By.cssSelector(".sticker"));
//            int count = sticker_check.size();
//            System.out.println(count);
//            if (count > 1) {
//                System.out.println(count);
//                System.out.println(ducks_sticker.getText());
//                throw new Exception("Duck has more than 1 sticker");
//            } if (count == 0) {
//                System.out.println(ducks_sticker.getText());
//                throw new NullPointerException("Duck has no sticker");
//            } else {
//                System.out.println("sticker is ok for " + ducks_sticker.getText());
//            }
//        }
//    }