package com.puffy.steps;

import com.puffy.pages.JungleHomePage;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.SoftAssertions;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertTrue;

public class JungleHome {

    JungleHomePage junglehomepage;

    public void clickOnExplore() {
        junglehomepage.clickExplore();
    }


    public void verifyPageUrl(String page, String url, SoftAssertions soft) {

        Serenity.recordReportData().withTitle(page + " URL").andContents("Current URL for " + page + " is \n"
                + getDriver().getCurrentUrl());

        soft.assertThat(getDriver().getCurrentUrl()).as("Redirection to " + page + " Validation")
                .isEqualToIgnoringCase(url);
    }

    public void clickOnMarket() {
        junglehomepage.clickOnMarket();
    }

    public void clickOnHowitWorks() {
        junglehomepage.clickOnHowitWorks();
    }
}
