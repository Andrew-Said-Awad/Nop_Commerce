package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Register {
    public static void main(String[] args) throws InterruptedException {

        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions to configure browser settings
        ChromeOptions options = new ChromeOptions();

        // Disable notifications and other settings
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("test-type");

        // Set preferences to disable notifications and password saving
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("autofill.profile_enabled", false);         //*** imp line to disable notification ***
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // Enable headless mode (optional)
         //options.addArguments("--headless");


        // Initialize WebDriver with configured options
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");





//
        driver.get("https://demo.nopcommerce.com/");

        // Go to Registration
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("gender-male")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("FirstName")).sendKeys("Andrew");
        Thread.sleep(1000);

        driver.findElement(By.name("LastName")).sendKeys("Said");
        Thread.sleep(1000);

        // *** Setting birthday at 9 then changing it to 3 then 7 ***
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByVisibleText("9");
        Thread.sleep(1000);
        day.selectByIndex(3);
        Thread.sleep(1000);
        day.selectByValue("7");
        Thread.sleep(1000);

        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByValue("11");
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1993");
        Thread.sleep(1000);

        driver.findElement(By.name("Email")).sendKeys("Andrew.Tester.2023@gmail.com");         ///////////////////////
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[id=\"Company\"]")).sendKeys("Andrew's World Domination Company");

        driver.findElement(By.id("Password")).sendKeys("123456789");
        Thread.sleep(1000);

        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456789");
        Thread.sleep(1000);

        driver.findElement(By.id("register-button")).click();
        Thread.sleep(1000);

        driver.findElement(By.className("buttons")).click();



         //*** choose to buy from Electronics***

        WebElement imageElement = driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000005_electronics_450.jpeg\"]"));

        imageElement.click();

        //*** Choose Camera & Photo ***

        WebElement imageElement1 = driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000006_camera-photo_450.jpeg\"]"));

        imageElement1.click();




        // *** inside Camera & Photo Page ***

        // Using By.cssSelector for a class with spaces

        WebElement dCam = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.products-container > div.products-wrapper > div > div > div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button"));
        dCam.click();



        Thread.sleep(1000);


        WebElement imageElement2 = driver.findElement(By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000035_nikon-d5500-dslr_415.jpeg\"]"));

        imageElement2.click();

        driver.findElement(By.id("product_enteredQuantity_15")).clear();

        driver.findElement(By.id("product_enteredQuantity_15")).sendKeys("2");

        driver.findElement(By.id("add-to-cart-button-15")).click();

        driver.findElement(By.className("ico-cart")).click();



        // ***  Shopping Cart Page ***

        // Changing the cart quantity --- By xpath
        WebElement qty = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[2]/td[5]/input"));

        qty.clear();

        qty.sendKeys("1");



        //Clear First Item from Shopping Cart
        driver.findElement(By.className("remove-btn")).click();

        //Estimating Shipping
        driver.findElement(By.id("open-estimate-shipping-popup")).click();

        // Select Country
        Select country = new Select(driver.findElement(By.name("CountryId")));
        country.selectByVisibleText("Egypt");

        // Enter ZipCode
       driver.findElement(By.id("ZipPostalCode")).sendKeys("22524");

        Thread.sleep(2000);


       // Press Apply

        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[5]/button")).click();
        Thread.sleep(1000);





        // Gift Wrapping Selection

        driver.findElement(By.id("checkout_attribute_1")).click();

        Select Wrapping = new Select(driver.findElement(By.id("checkout_attribute_1")));
        Wrapping.selectByVisibleText("Yes [+$10.00]");

        // Agree on Terms & Services
        driver.findElement(By.id("termsofservice")).click();

        //Checkout
        driver.findElement(By.id("checkout")).click();
//


      //  driver.get("https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart");

        //*** Log in Again ***
        driver.findElement(By.name("Email")).sendKeys("Andrew.Tester.2023@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.id("Password")).sendKeys("123456789");

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();

        // *** Checkout ***
        // Agree on Terms & Services
        driver.findElement(By.id("termsofservice")).click();

        //Checkout
        driver.findElement(By.id("checkout")).click();


        // *** Shipping information ***

        Select country2 = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country2.selectByVisibleText("Egypt");

        // State Address
         driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Alexandria");

         // Address 1
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("5 El mosheer St,Sidi Gaber.");

        // Address 2
        driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("N/A");

        //  ZipCode
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("22524");

        // Phone Number
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("+20 01280570099");

        // Fax No.
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("N/A");

        // *** Shipping address ***
         driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
          Thread.sleep(1000);


        // *** Shipping method ***
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        Thread.sleep(1000);


        // *** Payment method ***
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        Thread.sleep(1000);


        // *** Payment Information ***
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
        Thread.sleep(1000);

         // *** Confirm Order ***
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();

        Thread.sleep(1000);

//


        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button")).click();


        Thread.sleep(1000);

        driver.quit();



    }
}
