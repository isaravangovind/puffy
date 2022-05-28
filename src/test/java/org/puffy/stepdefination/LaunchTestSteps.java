package org.puffy.stepdefination;

import com.puffy.steps.BrokenLinks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class LaunchTestSteps {

    @Steps
    BrokenLinks brokenlinks;

    @Given("Launch the app")
    public void launchApp() throws InterruptedException {
        brokenlinks.launchApp();
    }

    @Then("Check for broken Links")
    public void checkForBrokenLinks() throws InterruptedException {
        brokenlinks.getBrokenLinks();
        Thread.sleep(5000);
    }
}
