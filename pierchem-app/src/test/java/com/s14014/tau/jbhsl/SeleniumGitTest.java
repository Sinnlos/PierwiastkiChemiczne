package com.s14014.tau.jbhsl;

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



    public void openPage() throws Exception {


        driver.get(baseUrl + "/");



    }


    @Test
    public void walkThroughTest() throws Exception {


        openPage();

        findRepo();

        findClass();






    }

    private boolean checkIfExist(String cssSelector) throws Exception {
        Thread.sleep(3000);
        return driver.findElement(By.cssSelector(cssSelector)).isDisplayed();
    }




   public void findRepo(){

        driver.findElement(By.linkText("PierwiastkiChemiczne")).click();

    }


    public void findClass() throws Exception {

        //driver.click("pierchem-app");

        
        
        
        driver.findElement(By.linkText("pierchem-app")).click();
        driver.findElement(By.linkText("src")).click();
        driver.findElement(By.linkText("main")).click();
        driver.findElement(By.linkText("java")).click();
        driver.findElement(By.linkText("com/s14014/tau")).click();
        driver.findElement(By.linkText("domain")).click();
        driver.findElement(By.linkText("Pierwiastek.java")).click();



        checkIfExist("#LC14");

        String text = driver.findElement(By.cssSelector("#LC14")).getText();

        assertTrue(text.contains("public class Pierwiastek"));

    }





}
