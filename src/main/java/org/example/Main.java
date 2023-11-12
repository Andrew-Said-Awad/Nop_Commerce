package org.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Import the WebDriverManager package

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Chrome driver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Maximum Dimentions of the web page
        driver.manage().window().maximize();
        // Navigate to a website
        driver.get("https://www.example.com");
        Thread.sleep(1000);

        Dimension Iphone_12_Pro = new Dimension(390,844);
        driver.manage().window().setSize(Iphone_12_Pro);

        Thread.sleep(1000);
        // Close the browser when done
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);



        // Get Current Url
        System.out.println(driver.getCurrentUrl());
        // Get Title
        System.out.println(driver.getTitle());

        driver.quit();


    }
}
