package com.xyzcorp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {

    private ChromeDriver chromeDriver;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rayan.bouamrane\\Desktop\\chromedriver_win32");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void testPage() {

    }
    @AfterAll
    public void cleanup(){
        chromeDriver.close();
    }


}
