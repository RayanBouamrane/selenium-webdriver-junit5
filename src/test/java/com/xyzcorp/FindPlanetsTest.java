package com.xyzcorp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindPlanetsTest {

    private static ChromeDriver chromeDriver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rayan.bouamrane\\Desktop\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void findPlanet() {
        chromeDriver.get("https://en.wikipedia.org/wiki/Planet");
        String table = chromeDriver.findElement(By.className("jquery-tablesorter")).getText();

//        String table = "Name Equatorial\n" +
//                "diameter[g] Mass[g] Semi-major axis (AU) Orbital period\n" +
//                "(years) Inclination\n" +
//                "to Sun's equator (°) Orbital\n" +
//                "eccentricity Rotation period\n" +
//                "(days) Confirmed\n" +
//                "moons Axial tilt (°) Rings Atmosphere\n" +
//                "1. Mercury 0.383 0.06 0.39 0.24 3.38 0.206 58.65 0 0.10 no minimal\n" +
//                "2. Venus 0.949 0.81 0.72 0.62 3.86 0.007 −243.02 0 177.30 no CO2, N2\n" +1.00 1 23.44 no N2, O2, Ar\n" +
////                "4. Mars 0.532 0.11 1.52 1.88 5.65 0.093 1.03 2 25.19 no CO2, N2, Ar\n" +
////                "5. Jupiter 11.209 317.83 5.20 11.86 6.09 0.048 0.41 80 3.12 yes H2, He\n" +
////                "6. Saturn 9.449 95.16 9.54 29.45 5.51 0.054 0.44 83 26.73 yes H2, He\n" +
////                "7. Uranus 4.007 14.54 19.19 84.02 6.48 0.047 −0.72 27 97.86 yes H2, He, CH4\n" +
////                "8. Neptune 3.883 17.15 30.07 164.79 6.43 0.009 0.67 14 29.60 yes H2, He, CH4\n" +
////                "Color legend:   terrestrial planets   gas giants   ice giants (both are giant planets).\n" +
////                "(a) Find absolute values in article Earth";
//
//        chromeDriver.get("https://en.wikipedia.org/wiki/Planet");
//        chromeDriver.findElement(By.linkTe
//                "3. Earth(a) 1.000 1.00 1.00 1.00 7.25 0.017 xt("Earth")).click();

        double earthRadius = Double.parseDouble(chromeDriver.findElement(By.cssSelector("#mw-content-text > div.mw-parser-output > table.infobox > tbody > tr:nth-child(20) > td > span")).getText());

        double mercuryRadius = Double.parseDouble(table.substring(table.indexOf("Mercury")+8, table.indexOf("Mercury")+13)) * earthRadius;
        double venusRadius = Double.parseDouble(table.substring(table.indexOf("Venus")+6, table.indexOf("Venus")+11)) * earthRadius;
        double marsRadius = Double.parseDouble(table.substring(table.indexOf("Mars")+5, table.indexOf("Mars")+10)) * earthRadius;
        double jupiterRadius = Double.parseDouble(table.substring(table.indexOf("Jupiter")+8, table.indexOf("Jupiter")+13)) * earthRadius;
        double saturnRadius = Double.parseDouble(table.substring(table.indexOf("Saturn")+7, table.indexOf("Saturn")+12)) * earthRadius;
        double uranusRadius = Double.parseDouble(table.substring(table.indexOf("Uranus")+7, table.indexOf("Uranus")+12)) * earthRadius;
        double neptuneRadius = Double.parseDouble(table.substring(table.indexOf("Neptune")+8, table.indexOf("Neptune")+13)) * earthRadius;

        System.out.println("Mercury diameter = " + String.format("%,.2f", mercuryRadius*2));
        System.out.println("Venus diameter = " + String.format("%,.2f", venusRadius*2));
        System.out.println("Earth diameter = " + String.format("%,.2f", earthRadius*2));
        System.out.println("Mars diameter = " + String.format("%,.2f", marsRadius*2));
        System.out.println("Jupiter diameter = " + String.format("%,.2f", jupiterRadius*2));
        System.out.println("Saturn diameter = " + String.format("%,.2f", saturnRadius*2));
        System.out.println("Uranus diameter = " + String.format("%,.2f", uranusRadius*2));
        System.out.println("Neptune diameter = " + String.format("%,.2f", neptuneRadius*2));
        System.out.println("Pluto is not a planet");


    }

    @AfterAll
    public static void cleanup() {
        chromeDriver.close();
    }
}