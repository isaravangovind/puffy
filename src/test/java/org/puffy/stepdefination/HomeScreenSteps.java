package org.puffy.stepdefination;

import com.puffy.steps.HomeScreen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class HomeScreenSteps {

    @Steps
    HomeScreen homescreen;

    SoftAssertions soft = new SoftAssertions();

    @Given("Launch the app")
    public void launchApp() {
        homescreen.launchApp();
    }

    @Then("Check for broken Links")
    public void checkForBrokenLinks() {
        homescreen.getBrokenLinks();
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String pageTitle) {
        homescreen.pageTitle(pageTitle);

    }

    @Then("Page should display any of below List of Wallet")
    public void pageShouldDisplayAnyOfBelowListOfWallet(DataTable walletList) {
        List<String> wallets = walletList.asList(String.class);
        for (String wallet : wallets) {
            homescreen.checkPresenceOfWallet(wallet, soft);
        }
        soft.assertAll();
    }

    @When("Search for {string}")
    public void searchFor(String searchText) {
        homescreen.searchFor(searchText);
    }

    @Then("Should display search result contains {string}")
    public void shouldDisplaySearchResultContains(String searchText) {
        homescreen.verifySearchResult(searchText);
    }

    @Then("Header Link Should redirect to respective sections")
    public void headerLinkShouldRedirectToRespectiveSections(DataTable headerLinks) {

        List<Map<String, String>> data = headerLinks.asMaps();
        // formValidationResults = new ArrayList<Boolean>();

        for (Map<String, String> headerLink : data) {
            String link = headerLink.get("Link");
            String url = headerLink.get("Url");
            String sectionTitle = headerLink.get("Section Title");
            homescreen.validateTheHeaderLinkRedirection(link, url, sectionTitle, soft);
        }
        soft.assertAll();
    }

    @Then("Footer Link Should redirect to respective sections")
    public void footerLinkShouldRedirectToRespectiveSections(DataTable footerLinks) {
        List<Map<String, String>> data = footerLinks.asMaps();
        // formValidationResults = new ArrayList<Boolean>();

        for (Map<String, String> headerLink : data) {
            String link = headerLink.get("Link");
            String url = headerLink.get("Url");
            String sectionTitle = headerLink.get("Section Title");
            homescreen.validateFooterLinkRedirection(link, url, sectionTitle, soft);
        }
        if(!soft.wasSuccess()){
            Serenity.recordReportData().withTitle("Redirection from Footer links").andContents("Some links are not navigating as expected");
        }
        soft.assertAll();
    }

    @Then("Check Social Media Links")
    public void checkSocialMediaLinks(DataTable mediaLinks) {
        List<Map<String, String>> data = mediaLinks.asMaps();
        // formValidationResults = new ArrayList<Boolean>();

        for (Map<String, String> mediaInfo : data) {
            String socialMedia = mediaInfo.get("Social Media");;
            String url = mediaInfo.get("Url");
            String title = mediaInfo.get("Title").replaceAll("\\s", "");
            homescreen.checkSocialMediaInfo(socialMedia, url, title, soft);
        }
        soft.assertAll();
    }
}

