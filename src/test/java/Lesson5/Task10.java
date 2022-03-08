package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Check() throws Exception {
        driver.get("http://localhost/litecart/en/");

        WebElement name_main = driver.findElement(By.cssSelector("#box-campaigns .name"));

        String name1 = name_main.getText();

        WebElement manufacturer_main = driver.findElement(By.cssSelector("#box-campaigns .manufacturer"));
        String manufacturer1 = manufacturer_main.getText();


        WebElement regular_price_main = driver.findElement(By.cssSelector("#box-campaigns .regular-price"));
        String regular_price1 = regular_price_main.getText();
        String regular_price1_color = regular_price_main.getCssValue("color");
        String regular_price1_crossed = regular_price_main.getCssValue("text-decoration");
        String regular_price1_font_size = regular_price_main.getCssValue("font-size");

       //todo гораздо более простая реализация поиска цвета, о которой я узнал слишком поздно =)
        Color priceRegularColor1 = Color.fromString(regular_price1_color);
        System.out.println(priceRegularColor1.getColor().getRed());


        Pattern pattern00 = Pattern.compile("[0-9][0-9]");
        Matcher matcher00 = pattern00.matcher(regular_price1_font_size);
        int start00 = 0;
        int result00 = 0;
        while (matcher00.find(start00)) {
            String value = regular_price1_font_size.substring(matcher00.start(), matcher00.end());
            result00 = Integer.parseInt(value);
//            System.out.println(result00);
            start00 = matcher00.end();
        }


        WebElement campaign_price_main = driver.findElement(By.cssSelector("#box-campaigns .campaign-price"));
        String campaign_price1 = campaign_price_main.getText();
        String campaign_price1_color = campaign_price_main.getCssValue("color");
        String campaign_price1_bold = campaign_price_main.getCssValue("font-weight");
        String campaign_price1_font_size = campaign_price_main.getCssValue("font-size");

        Matcher matcher01 = pattern00.matcher(campaign_price1_font_size);
        int start01 = 0;
        int result01 = 0;
        while (matcher01.find(start01)) {
            String value = campaign_price1_font_size.substring(matcher01.start(), matcher01.end());
            result01 = Integer.parseInt(value);
//            System.out.println(result01);
            start01 = matcher01.end();
        }

        driver.findElement(By.cssSelector("#box-campaigns .product")).click();

        WebElement name_sub = driver.findElement(By.cssSelector("h1"));
        String name2 = name_sub.getText();

        WebElement manufacturer_sub = driver.findElement(By.cssSelector("#box-product .manufacturer img"));
        String manufacturer2 = manufacturer_sub.getAttribute("title");

        WebElement regular_price_sub = driver.findElement(By.cssSelector("#box-product .regular-price"));
        String regular_price2 = regular_price_sub.getText();
        String regular_price2_color = regular_price_sub.getCssValue("color");
        String regular_price2_crossed = regular_price_sub.getCssValue("text-decoration");
        String regular_price2_font_size = regular_price_sub.getCssValue("font-size");

        Matcher matcher02 = pattern00.matcher(regular_price2_font_size);
        int start02 = 0;
        int result02 = 0;
        while (matcher02.find(start02)) {
            String value = regular_price2_font_size.substring(matcher02.start(), matcher02.end());
            result02 = Integer.parseInt(value);
//            System.out.println(result02);
            start02 = matcher02.end();
        }


        WebElement campaign_price_sub = driver.findElement(By.cssSelector("#box-product .campaign-price"));
        String campaign_price2 = campaign_price_sub.getText();
        String campaign_price2_color = campaign_price_sub.getCssValue("color");
        String campaign_price2_bold = campaign_price_sub.getCssValue("font-weight");
        String campaign_price2_font_size = campaign_price_sub.getCssValue("font-size");

        Matcher matcher03 = pattern00.matcher(campaign_price2_font_size);
        int start03 = 0;
        int result03 = 0;
        while (matcher03.find(start03)) {
            String value = campaign_price2_font_size.substring(matcher03.start(), matcher03.end());
            result03 = Integer.parseInt(value);
//            System.out.println(result03);
            start03 = matcher03.end();
        }


        if (!name1.equals(name2)) {
            throw new Exception("Names on main and in product are different");
        } else {
            System.out.println("Names are the same: " + name1);
        }
        if (!manufacturer1.equals(manufacturer2)) {
            throw new Exception("Manufactures on main and in product are different");
        } else {
            System.out.println("Manufactures are the same: " + manufacturer1);
        }
        if (!regular_price1.equals(regular_price2)) {
            throw new Exception("Regular prices on main and in product are different");
        } else {
            System.out.println("Regular prices are the same: " + regular_price1);
        }
        if ((!regular_price1_crossed.contains("line-through")) || (!regular_price2_crossed.contains("line-through"))) {
            throw new Exception("Regular price has wrong style");
        } else {
            System.out.println("Regular prices have correct style: " + regular_price1_crossed);
        }
        if (!campaign_price1.equals(campaign_price2)) {
            throw new Exception("Campaign prices on main and in product are different");
        } else {
            System.out.println("Campaign prices are the same: " + campaign_price1);
        }
        if (((Integer.parseInt(campaign_price1_bold)) < 600) || ((Integer.parseInt(campaign_price1_bold)) > 1000)) {
            throw new Exception("Campaign price has wrong style");
        } if (((Integer.parseInt(campaign_price2_bold)) < 600) || ((Integer.parseInt(campaign_price2_bold)) > 1000))  {
            throw new Exception("Campaign price has wrong style");
        } else {
            System.out.println("Campaign prices have correct style \"bold\"");
        }
        if (result01 < result00) {
            throw new Exception("Fold of campaign price (" + result01 + ") should be bigger then fold of regular price: (" + result00 + ")");
        } else {
            System.out.println("Fold of campaign price (" + result01 + ") is bigger then fold of regular price: (" + result00 + ")");
        }
        if (result03 < result02) {
            throw new Exception("Fold of campaign price (" + result03 + ") should be bigger then fold of regular price: (" + result02 + ")");
        } else {
            System.out.println("Fold of campaign price (" + result03 + ") is bigger then fold of regular price: (" + result02 + ")");
        }


        ArrayList<String> dd = new ArrayList<>();
        ArrayList<String> dd2 = new ArrayList<>();
        ArrayList<String> dd3 = new ArrayList<>();
        ArrayList<String> dd4 = new ArrayList<>();

        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(regular_price1_color);
        while (matcher.find()) {
//            System.out.println(matcher.group());
            dd.add(matcher.group());
        }
//        System.out.println(dd.toString());
        if(((dd.get(0).equals(dd.get(1)))) && (dd.get(0).equals(dd.get(2)))){
            System.out.println("Regular price from main page has correct color: " + regular_price1_color);
        } else {
            throw new Exception("Regular price from main page has wrong color");
        }

        Matcher matcher2 = pat.matcher(regular_price2_color);
        while (matcher2.find()) {
            dd2.add(matcher2.group());
        }
//        System.out.println(dd2.toString());
        if(((dd2.get(0).equals(dd2.get(1)))) && (dd2.get(0).equals(dd2.get(2)))){
            System.out.println("Regular price from product page has correct color: " + regular_price2_color);
        } else {
            throw new Exception("Regular price from product page has wrong color");
        }

        Matcher matcher3 = pat.matcher(campaign_price1_color);
        while (matcher3.find()) {
            dd3.add(matcher3.group());
        }
//        System.out.println(dd3.toString());
        if(((dd3.get(1).equals(dd3.get(2)))) && (dd3.get(1).equals("0"))){
            System.out.println("Campaign price from main page has correct color: " + campaign_price1_color);
        } else {
            throw new Exception("Campaign price from main page has wrong color");
        }

        Matcher matcher4 = pat.matcher(campaign_price2_color);
        while (matcher4.find()) {
            dd4.add(matcher4.group());
        }
//        System.out.println(dd4.toString());
        if(((dd4.get(1).equals(dd4.get(2)))) && (dd4.get(1).equals("0"))){
            System.out.println("Campaign price from product page has correct color: " + campaign_price2_color);
        } else {
            throw new Exception("Campaign price from product page has wrong color");
        }

    }

    @AfterTest
    public void stop () {
        driver.quit();
        driver = null;
    }
}
