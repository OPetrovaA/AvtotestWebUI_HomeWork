package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExampleMain {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.cian.ru/");

        WebElement webElement1 = driver.findElement(By.xpath(".//a[@href='/authenticate/?returnUrl=https://www.cian.ru/']"));

        try {
            WebElement webElementError = driver.findElement(By.linkText("Войти"));
        } catch (NoSuchElementException e) {
            System.out.println();
        }

        webElement1.click();



        // driver.quit();
    }
}
