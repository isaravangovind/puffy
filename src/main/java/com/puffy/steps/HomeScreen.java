package com.puffy.steps;

import com.puffy.pages.JungleHomePage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertTrue;


public class HomeScreen {

    JungleHomePage junglehomepage;

    @Step("Launch JUNGLE app")
    public void launchApp() {
        junglehomepage.open();
        //   return this;
    }

    @Step("Check of Broken Links")
    public void getBrokenLinks() {
        String links = null;
        List<String> brokenLinks = junglehomepage.getAllBrokenLinks();
        System.out.println(StringUtils.join(brokenLinks, ", "));
        Serenity.recordReportData().withTitle("Broken Links @ " + getDriver().getCurrentUrl()).andContents(StringUtils.join(brokenLinks, ", \n"));
        if (brokenLinks.size() > 0) {
            assertTrue("There is broken links ", false);
        }
    }

    public void pageTitle(String pageTitle) {
        assertTrue("Page title Mismatch \n Expected = pageTitle \n Actual = " + getDriver().getTitle(), pageTitle.equals(getDriver().getTitle()));
    }

    public void
    checkPresenceOfWallet(String wallet, SoftAssertions soft) {

        boolean check = ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + wallet + "']")).equals(true);

        if (check == false) {
            Serenity.recordReportData().withTitle("Presence of " + wallet)
                    .andContents("No Presence of such Wallet");
        } else {
            Serenity.recordReportData().withTitle("Presence of " + wallet)
                    .andContents("Wallet is Present");
        }

        soft.assertThat(check).isEqualTo(true);

    }

    public void searchFor(String searchText) {
        junglehomepage.search.type(searchText);
    }

    public void verifySearchResult(String searchText) {
        boolean check = ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + searchText + "']")).equals(true);
        if (check == false) {
            Serenity.recordReportData().withTitle("Presence of Search Text " + searchText)
                    .andContents("No Presence of such item / No Presence of Search List");
        } else {
            Serenity.recordReportData().withTitle("Presence of Search Text " + searchText)
                    .andContents("Search Result displayed the results for " + searchText);
        }
        assertTrue(check);
    }

    public void validateTheHeaderLinkRedirection(String link, String url, String sectionTitle, SoftAssertions soft) {
        if (link.equalsIgnoreCase("explore")) {
            junglehomepage.clickExplore();
//            System.out.println();
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }
        if (link.equalsIgnoreCase("how it works")) {
            junglehomepage.clickOnHowitWorks();
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }
        if (link.equalsIgnoreCase("market")) {
            junglehomepage.clickOnMarket();
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }

    }

    public void scrollToBottom() {
        junglehomepage.scrollToBottom();
    }

    public void validateFooterLinkRedirection(String link, String url, String sectionTitle, SoftAssertions soft) {
        if (link.equalsIgnoreCase("explore")) {
            junglehomepage.scrollToview(junglehomepage.footerExplore);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.footerExplore);
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }
        if (link.equalsIgnoreCase("how it works")) {
            junglehomepage.scrollToview(junglehomepage.footerHowItWorks);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.footerHowItWorks);
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }
        if (link.equalsIgnoreCase("market")) {
            junglehomepage.scrollToview(junglehomepage.footerMarket);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.footerMarket);
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }

        if (link.equalsIgnoreCase("Terms")) {
            junglehomepage.scrollToview(junglehomepage.terms);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.terms);
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }

        if (link.equalsIgnoreCase("Privacy")) {
            junglehomepage.scrollToview(junglehomepage.privacy);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.privacy);
            soft.assertThat(getDriver().getCurrentUrl()).isEqualTo(url);
        }
    }

    public void switchWindow() {

        Set<String> windowsHandles = getDriver().getWindowHandles();
        System.out.println(windowsHandles.size());
        for (String window : windowsHandles) {
            System.out.println(window);
            getDriver().switchTo().window(window);
        }

    }

    public void checkSocialMediaInfo(String link, String url, String title, SoftAssertions soft) {
        String mainWindow = getDriver().getWindowHandle();
        if (link.equalsIgnoreCase("twitter")) {
            junglehomepage.scrollToview(junglehomepage.twitter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.twitter);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

        if (link.equalsIgnoreCase("facebook")) {
            junglehomepage.scrollToview(junglehomepage.fb);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.fb);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

        if (link.equalsIgnoreCase("instagram")) {
            junglehomepage.scrollToview(junglehomepage.insta);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.insta);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

        if (link.equalsIgnoreCase("discord")) {
            junglehomepage.scrollToview(junglehomepage.discord);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.discord);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

        if (link.equalsIgnoreCase("telegram")) {
            junglehomepage.scrollToview(junglehomepage.telegram);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.telegram);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

        if (link.equalsIgnoreCase("Linkedin")) {
            junglehomepage.scrollToview(junglehomepage.linkedin);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            junglehomepage.clickOn(junglehomepage.linkedin);
            socialmediaHandles(link, url, title, mainWindow, soft);
        }

    }

    private void socialmediaHandles(String link, String url, String title, String mainWindow, SoftAssertions soft) {
        System.out.println(getDriver().getWindowHandle());
        switchWindow();
        System.out.println(getDriver().getWindowHandle());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getDriver().getTitle());
        soft.assertThat(getDriver().getTitle().replaceAll("\\s", "")).contains(title);
        soft.assertThat(getDriver().getCurrentUrl()).contains(url);
        Serenity.recordReportData().withTitle(link + " details")
                .andContents("URL : " + getDriver().getCurrentUrl() + "\n"
                        + "Page Title Contains expected : " + getDriver().getTitle());
        getDriver().close();
        getDriver().switchTo().window(mainWindow);
        System.out.println(getDriver().getCurrentUrl());
    }
}
