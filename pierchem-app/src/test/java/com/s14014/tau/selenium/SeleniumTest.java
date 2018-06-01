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

public class SeleniumTest {


    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    private WebElement unexpectedPineapple;


    private StringBuffer verificationErrors = new StringBuffer();


    private String firstName1 = "Adam";
    private String lastName1 = "Nowak";
    private String email1 = "s14014@pjwstk.edu.pl";
    private String passwd1 = "superhaslo";
    private String address1 = "Oak 34";
    private String city1 = "Las Vegas";
    private String state1 = "21";
    private String zip1 = "11111";
    private String country1 = "21";
    private String phone1 = "987654321";
    private String alias1 = "address";

    private String firstName2 = "Adam#$";
    private String lastName2 = "Nowak";
    private String email2;
    private String passwd2 = "supe";
    private String address2 = "Oak 34";
    private String city2 = "Las Vegas";
    private String state2 = "21";
    private String zip2 = "11111";
    private String country2 = "21";
    private String phone2 = "";
    private String alias2 = "address";



    public String mailRandom(String email2){


        int c;
        Random rand = new Random();
        c = rand.nextInt(30000);

        email2 = (firstName1 + lastName1 + c);

        return email2;
    }


    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://automationpractice.com/index.php";

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


    private void register() {
        driver.findElement(By.id("submitAccount")).click();
    }


    public void signInCreateAccount() throws Exception {


        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(email1);
        driver.findElement(By.id("SubmitCreate")).click();

        if(checkIfErrorExist("#create_account_error") == true){

            int c;
            Random rand = new Random();
            c = rand.nextInt(30000);

            email2 = (firstName1 + lastName1 + c);



            driver.findElement(By.id("email_create")).clear();
            driver.findElement(By.id("email_create")).sendKeys(email2 + "@wp.pl");
            driver.findElement(By.id("SubmitCreate")).click();
        }

    }




    public void fillingInfo() throws Exception {

        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName2);

        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName2);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(passwd2);

        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(address2);

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city2);

        WebElement element1 = driver.findElement(By.id("id_state"));
        Select s1 = new Select(element1);
        s1.selectByValue(state2);

        WebElement element2 = driver.findElement(By.id("id_country"));
        Select s2 = new Select(element2);
        s2.selectByValue(country2);

        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys(zip2);

        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys(phone2);

        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(alias2);


        register();

        if (checkIfErrorExist("#center_column > div > ol > li") == true) {

            String alertText = driver.findElement(By.cssSelector("#center_column > div")).getText();

            assertTrue(alertText.contains("firstname"));

            if (alertText.contains("firstname")) {

                driver.findElement(By.id("customer_firstname")).clear();
                driver.findElement(By.id("customer_firstname")).sendKeys(firstName1);






            }

            if (alertText.contains("passwd")) {

                driver.findElement(By.id("passwd")).clear();
                driver.findElement(By.id("passwd")).sendKeys(passwd1);



            }

            if (alertText.contains("You must register at least one phone number.")) {

                driver.findElement(By.id("phone_mobile")).clear();
                driver.findElement(By.id("phone_mobile")).sendKeys(phone1);




            }


            register();
        }

    }


    @Test
    public void test() throws Exception {


        signInCreateAccount();

        fillingInfo();


        ifSignedIn();

        signOut();





    }

    private boolean checkIfErrorExist(String cssSelector) throws Exception {
        Thread.sleep(3000);
        return driver.findElement(By.cssSelector(cssSelector)).isDisplayed();
    }



    public void ifSignedIn(){

        WebElement text = driver.findElement(By.linkText(firstName1 + " " + lastName1));

        assertNotNull(text);



    }

    public void signOut(){

        driver.findElement(By.linkText("Sign out")).click();


    }






}


*/
















