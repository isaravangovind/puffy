package com.puffy.pages;

import com.puffy.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResourcesPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Sales')]")
    WebElementFacade sales;

    @FindBy(xpath = "//a[contains(text(), 'report')][contains(text(), 'collection')]")
    WebElementFacade report;

    @FindBy(xpath = "//a[contains(text(), 'create')]")
    WebElementFacade create;

    @FindBy(xpath = "//a[contains(text(), 'use Jungle')]")
    WebElementFacade use;

    @FindBy(xpath = " //a[contains(text(), 'sell')]")
    WebElementFacade sell;

    @FindBy(xpath = "//a[contains(text(), 'freezing')]")
    WebElementFacade freezing;

    @FindBy(xpath = " //a[text()= 'Resources']")
    WebElementFacade resourcesFAQ;


    public void navigateToFAQPage() {
        waitFor(ExpectedConditions.elementToBeClickable(resourcesFAQ));
        clickOn(resourcesFAQ);
    }

    public void clickFAQ(String faq) {

        if (faq.contains("sales")) {
            clickOn(sales);
        }

        if (faq.contains("report")) {
            clickOn(report);
        }

        if (faq.contains("create")) {
            clickOn(create);
        }

        if (faq.contains("use")) {
            clickOn(use);
        }

        if (faq.contains("sell")) {
            clickOn(sell);
        }

        if (faq.contains("freezing")) {
            clickOn(freezing);
        }
    }
}
