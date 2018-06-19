package com.s14014.tau.jbhsl.pages;
/*
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PierwiastekRepo extends WebDriverPage{


    public PierwiastekRepo(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        get("https://github.com/Sinnlos");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public void click(String linkText){

        WebElement e = findElement(By.linkText(linkText));
        e.click();
    }

    public void clickId(String linkById){

        WebElement e = findElement(By.id(linkById));
        e.click();
    }

    public String getClassesForLink(String linkText) {
        WebElement e = findElement(By.partialLinkText(linkText));
        return e.getAttribute("class");
    }


/*    public boolean isTabSelected(String tabText) {
        WebElement e = findElement(By.partialLinkText(tabText));
        return e.getAttribute("class").contains("tabSelected");
    } */

/*
    public void setSearchText(String text) {
        WebElement searchInput = findElement(By.cssSelector(
                "#header > div.headerShadow > span.searchBar > input"));
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.RETURN);
    }




    public boolean isArticlePresent(String articleTitle) {
        try {
            List<WebElement> elements = findElements(By.cssSelector("#LC4 > span.pl-en"));
            for (WebElement e : elements) {
                if  (e.getText().toLowerCase().contains(articleTitle.toLowerCase())) return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isTabSelected(String tabText) {
        WebElement e = findElement(By.partialLinkText(tabText));
        return e.getAttribute("class").contains("tabSelected");
    }


    public boolean ifExist(String bts) throws InterruptedException {


        Thread.sleep(3000);
        WebElement e = findElement(By.linkText(bts));
        return e.isDisplayed();
    }





    @Test
    public void testRepo(){

        open();

        click("pierchem-app");

        click("src");
        click("main");
        click("java");
        click("com/s14014/tau");
        click("domain");
        click("Pierwiastek.java");
        getClassesForLink("Pierwiastek.java");

        isArticlePresent("public class Pierwiastek");





    }

}
*/