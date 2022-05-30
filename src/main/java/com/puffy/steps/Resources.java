package com.puffy.steps;

import com.puffy.pages.ResourcesPage;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.StringUtils;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertTrue;

public class Resources {

    ResourcesPage resourcespage;

    public void navigateFAQpage() {
        resourcespage.navigateToFAQPage();
    }

    public void lookUpforFAQ(String faq, String url) {
        resourcespage.clickFAQ(faq);
        if (faq.contains("sales")) {
            System.out.println("================="+ getDriver().getCurrentUrl().equals(url) + "================");
            Serenity.recordReportData().withTitle("NFT Sales FAQ URL").andContents(getDriver().getCurrentUrl());
           assertTrue("Sales URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }

        if (faq.contains("report")) {
            System.out.println("================="+ getDriver().getCurrentUrl().equals(url) + "================");
            Serenity.recordReportData().withTitle("Report FAQ URL").andContents(getDriver().getCurrentUrl());
            assertTrue("Report User / NFT / Collection URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }

        if (faq.contains("create")) {
            System.out.println("================="+ getDriver().getCurrentUrl().equals(url) + "================");
            Serenity.recordReportData().withTitle("Create NFT FAQ URL").andContents(getDriver().getCurrentUrl());
            assertTrue("Create FAQ URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }

        if (faq.contains("use")) {
            System.out.println("================="+ getDriver().getCurrentUrl()+ "================");
            Serenity.recordReportData().withTitle("Use NFT FAQ URL").andContents(getDriver().getCurrentUrl());
            assertTrue("Use NFT FAQ URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }

        if (faq.contains("sell")) {
            System.out.println("================="+ getDriver().getCurrentUrl() + "================");
            Serenity.recordReportData().withTitle("NFT Sell FAQ URL").andContents(getDriver().getCurrentUrl());
            assertTrue("NFT Sell FAQ URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }

        if (faq.contains("freezing")) {
            System.out.println("================="+ getDriver().getCurrentUrl().equals(url) + "================");
            Serenity.recordReportData().withTitle("Freezing FAQ URL").andContents(getDriver().getCurrentUrl());
            assertTrue("Freeze FAQ URL is incorrect", getDriver().getCurrentUrl().equals(url));
        }
    }

    public void clickOnResource(String faq) {
        resourcespage.clickFAQ(faq);
    }
}
