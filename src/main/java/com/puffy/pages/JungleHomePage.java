package com.puffy.pages;

import com.puffy.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JungleHomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'subscribe')]")
    public WebElementFacade email;

    @FindBy(xpath = "//footer//button[contains(text(),'Sign up')]")
    public WebElementFacade signupBtn;

    @FindBy(xpath = "//div[contains(@class,'state')]")
    public WebElementFacade signUpstate;

    @FindBy(xpath = "//span[contains(@class, 'login')]")
    public WebElementFacade signUpHeader;

    @FindBy(linkText = "Explore")
    public WebElementFacade explore;

    @FindBy(linkText = "Market")
    public WebElementFacade market;

    @FindBy(linkText = "How It Works")
    public WebElementFacade howItWorks;

    @FindBy(xpath = "//span[text()='©2022']")
    public WebElementFacade copyRightYear;

    @FindBy(xpath = "//div[contains(@class,'right header')]//input[@type='search']")
    public WebElementFacade search;

    @FindBy(xpath = "//h2[@class='section__title'][text()='Frequently asked questions']")
    public WebElementFacade exploreSectionTitle;

    @FindBy(xpath = "//h2[@class='section__title']")
    public WebElementFacade sectionTitle;


    @FindBy(xpath = "//h2[@class='section__title'][text()='How it works']")
    public WebElementFacade howItWorksSectionTitle;

    @FindBy(xpath = "//h2[@class='section__title'][text()='Browse by category']")
    public WebElementFacade marketTitleSectionTitle;

    @FindBy(xpath = "//div[@class='footer-menu']/a[text()='Explore']")
    public WebElementFacade footerExplore;

    @FindBy(xpath = "//div[@class='footer-menu']/a[text()='Market']")
    public WebElementFacade footerMarket;

    @FindBy(xpath = "//div[@class='footer-menu']/a[text()='How It Works']")
    public WebElementFacade footerHowItWorks;

    @FindBy(xpath = "//div[@class='footer-menu']/a[text()='Terms Of services']")
    public WebElementFacade terms;

    @FindBy(xpath = "//div[@class='footer-menu']/a[text()='Privacy']")
    public WebElementFacade privacy;


    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Telegram']")
    public WebElementFacade telegram;

    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Twitter']")
    public WebElementFacade twitter;

    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Instagram']")
    public WebElementFacade insta;

    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Facebook']")
    public WebElementFacade fb;

    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Discord']")
    public WebElementFacade discord;

    @FindBy(xpath = "//a[@class='social-list__item'][@aria-label='Linkedin']")
    public WebElementFacade linkedin;



    public List getAllBrokenLinks() {
        return validateBrokenLinks();
    }

    public void enterEmail(String emailAddress) {
//        clickOn(email);
        email.type(emailAddress);
    }


    public String getSignupState(String text) {
        waitFor(ExpectedConditions.textToBePresentInElement(signUpstate, text));
        return signUpstate.getText();
    }

    public String getdefaultText() {
        return email.getAttribute("placeholder");
    }

    public void clicksignUp() {
        clickOn(signUpHeader);
    }

    public void clickExplore() {
        clickOn(explore);
    }


    public void clickOnMarket() {
        clickOn(market);
    }

    public void clickOnHowitWorks() {
        clickOn(howItWorks);
    }

    public void clicksignUpBtnFooter() {
        clickOn(signupBtn);
    }

    public boolean notPresentOfSuccessMsg(String text) {
        System.out.println(waitFor(ExpectedConditions.textToBePresentInElement(signUpstate, text)));
        return waitFor(ExpectedConditions.textToBePresentInElement(signUpstate, text));
    }

    public void scrollToBottomText() {

    }
}
