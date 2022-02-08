package com.xyzcorp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CGITest {

    public static ChromeDriver driver;

    static Options options;

    @BeforeAll
    static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rayan.bouamrane\\Desktop\\chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    void setupCookies() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500, 800));
        driver.get("https://www.cgi.com/en");
        driver.findElement(By.cssSelector("#popup-buttons > button.agree-button.eu-cookie-compliance-default-button")).click();
    }


    @AfterEach
    void teardown() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }

    @Test
    void testReadCookies() {
        options = driver.manage();
        Set<Cookie> cookies = options.getCookies();

        Cookie username = options.getCookieNamed("cookie-agreed");

        assertThat(username.getValue()).isEqualTo("2");
        assertThat(username.getPath()).isEqualTo("/");
    }

    @Test
    void testSearchBar() {
        assertThat(driver.findElement(By.className("search-icon")).getAttribute("style")).isEqualTo("");

        driver.findElement(By.className("search-icon-btn")).click();
        WebElement w = driver.findElement(By.className("search-icon"));
        assertThat(w.getAttribute("style")).isEqualTo("display: none;");

        driver.findElement(By.cssSelector("#main-nav > div > div.hidden.search-bar > div > div > span")).click();

        assertThat(driver.findElement(By.className("search-icon")).getAttribute("style")).isEqualTo("");

    }

    @Test
    void testContactPageWithInvalidInfo() throws InterruptedException {
        driver.findElement(By.cssSelector("#block-cgicontactusblockcontact > a")).click();

        {
            WebElement element = driver.findElement(By.linkText("Contact"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }

        Thread.sleep(Duration.ofSeconds(1).toMillis());

        driver.findElement(By.className("ui-dialog-buttonset")).click();

        Thread.sleep(Duration.ofSeconds(5).toMillis());

        driver.findElement(By.className("messages--error"));

    }

}