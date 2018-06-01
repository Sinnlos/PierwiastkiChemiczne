package com.s14014.tau.jbhsl;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SiteSteps {

    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on github page of Sinnlos")
    public void userOnGitRepo() {

        pages.pierwiastekRepo().open();
    }

    @When("user clicks the $linkText tab")
    public void userClicksTabLink(String linkText) {

        pages.pierwiastekRepo().click(linkText);
    }

    @Then("the article $articleName is displayed")
    public void thenTheArticleInstrukcjeIsDisplayed(String articleName) {
        assertTrue(pages.pierwiastekRepo().isArticlePresent(articleName));
    }

    @Then("the article $articleName is not displayed")
    public void thenTheArticleInstrukcjeIsNotDisplayed(String articleName) {
        assertFalse(pages.pierwiastekRepo().isArticlePresent(articleName));
    }


}
