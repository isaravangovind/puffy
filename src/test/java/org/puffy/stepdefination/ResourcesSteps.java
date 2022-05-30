package org.puffy.stepdefination;

import com.puffy.steps.HomeScreen;
import com.puffy.steps.JungleHome;
import com.puffy.steps.Resources;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

public class ResourcesSteps {

    @Steps
    Resources resourcesFAQs;

    @Steps
    HomeScreen brokenlinks;

    @Steps
    JungleHome junglehome;

    SoftAssertions soft = new SoftAssertions();

    @When("Navigate to Resources Page")
    public void navigate_to_resources_page() {
        resourcesFAQs.navigateFAQpage();
    }

    @Then("Click to see {string} and Navigates to {string}")
    public void clickToSeeAndNavigatesTo(String faq, String url) {
        resourcesFAQs.lookUpforFAQ(faq.toLowerCase(), url);
    }

    @Then("Click to see FAQ links that Navigates to correct URLs")
    public void clickToSeeFAQLinksThatNavigatesToCorrectURLs(DataTable faqs) {
        for (Map<String, String> data : faqs.asMaps(String.class, String.class)) {
            resourcesFAQs.lookUpforFAQ(data.get("FAQ").toLowerCase(), data.get("URL"));
        }

    }

    @Then("Click to see FAQ links and check for broken links")
    public void clickToSeeFAQLinksAndCheckForBrokenLinks(DataTable faqs) {
        for (Map<String, String> data : faqs.asMaps(String.class, String.class)) {
            resourcesFAQs.lookUpforFAQ(data.get("FAQ").toLowerCase(), data.get("URL"));
            brokenlinks.getBrokenLinks();
        }

    }

    @Then("Click to see {string} page has any broken links")
    public void clickToSeePageHasAnyBrokenLinks(String faq) {
        resourcesFAQs.clickOnResource(faq.toLowerCase());
        brokenlinks.getBrokenLinks();
    }

    @Then("Redirect to Other Pages")
    public void redirectToOtherPages(DataTable newPage) {

        for (Map<String, String> data : newPage.asMaps(String.class, String.class)) {
            if(data.get("Page").equalsIgnoreCase("Explore")) {
                junglehome.clickOnExplore();
            }

            if(data.get("Page").equalsIgnoreCase("Market")) {
                junglehome.clickOnMarket();
            }

            if(data.get("Page").equalsIgnoreCase("How It Works")) {
                junglehome.clickOnHowitWorks();
            }
            junglehome.verifyPageUrl(data.get("Page"), data.get("URL"), soft);
        }
        soft.assertAll();
    }
}
