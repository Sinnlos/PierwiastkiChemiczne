package com.s14014.tau.selenium;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumGitTest {


    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    private WebElement unexpectedPineapple;


    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "https://github.com/Sinnlos";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }



    public void findRepo(){

        driver.findElement(By.linkText("PierwiastkiChemiczne")).click();

    }

    public void findClass(){

        driver.findElement(By.id("6820effd90257835427fc9eac85252c3-f9cbd3f54d03760cd9a81c48886a8fa627f8e13b")).click();
        driver.findElement(By.id("25d902c24283ab8cfbac54dfa101ad31-716e5a9dff6164a21ec15fa8391264cd533d5898")).click();
        driver.findElement(By.id("fad58de7366495db4650cfefac2fcd61-bf17bf48051ce6a466132a901a7e860cb604477f")).click();
        driver.findElement(By.id("93f725a07423fe1c889f448b33d21f46-1fce3a641d6bc158900cacaf6aca0e5343259335")).click();
        driver.findElement(By.id("d4523ae5b2c6fbd8c3a05669be4dd10f-1119e3a2924a102fddc569955bf4deb0fbb58609")).click();
        driver.findElement(By.id("ad5f82e879a9c5d6b5b442eb37e50551-0a9c8021b2c7bf45ea1488d29ea7b755d3f4a7a8")).click();
        driver.findElement(By.id("b0c82fa8af3afad9e6f299145df2186e-5ef9744287c658ffd5081c0d0c81513f498cfa52")).click();








    }


    @Test
    public void walkThrough() throws Exception {

        setUp();
        findRepo();
        findClass();


    }





}
*/