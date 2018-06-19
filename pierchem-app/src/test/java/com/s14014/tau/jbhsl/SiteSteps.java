package com.s14014.tau.jbhsl;
/*
import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;


public class SiteSteps {



    private static WebDriver driver;

    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on github page of Sinnlos")
    public void userOnGitRepo() {

        pages.pierwiastekRepo().open();
    }

    @Given("user is on repository page")
    public void userOnRepoP() throws InterruptedException {

        assertTrue(pages.pierwiastekRepo().ifExist("pom.xml"));

    }

    @Given("user is in src folder")
    public void userOnSrc() throws InterruptedException {


     assertTrue(pages.pierwiastekRepo().ifExist("x.html"));

    }


    @Given("user is in main folder")
    public void userOnMain() throws InterruptedException {

        assertTrue(pages.pierwiastekRepo().ifExist("y.html"));

    }


    @Given("user is in java folder")
    public void userOnJava() throws InterruptedException {

        assertTrue(pages.pierwiastekRepo().ifExist("Pierwiastek.java"));

    }

    @When("user clicks the $linkById id")
    public void userClickId (String linkById){
        pages.pierwiastekRepo().clickId(linkById);
    }
    @When("user clicks the $linkText link")
    public void userClicksLink(String linkText) {

        //pages.pierwiastekRepo().findElement(By.linkText(linkText)).click();
        pages.pierwiastekRepo().click(linkText);
    }

   @Then("the link with text $linkText should be displayed")
    public void linksOpen(String linkText) throws InterruptedException {

        assertTrue(pages.pierwiastekRepo().ifExist(linkText));
    }

    @Then("the article $articleName is displayed")
    public void thenTheArticleInstrukcjeIsDisplayed(String articleName) throws IOException {

        assertTrue(pages.pierwiastekRepo().isArticlePresent(articleName));


    }

    @Then("the article $articleName is not displayed")
    public void thenTheArticleInstrukcjeIsNotDisplayed(String articleName) {
        assertFalse(pages.pierwiastekRepo().isArticlePresent(articleName));
    }





}
*/