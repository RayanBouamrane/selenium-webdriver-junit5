package com.xyzcorp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {

    private static ChromeDriver chromeDriver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rayan.bouamrane\\Desktop\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void testWikipediaLinkClick() {
        chromeDriver.get("https://en.wikipedia.org/wiki/Rafael_Nadal");
        chromeDriver.manage().window().setSize(new Dimension(807, 824));
        chromeDriver.findElement(By.linkText("Roger Federer")).click();
    }

    @AfterAll
    public static void cleanup() {
        chromeDriver.close();
    }


}
