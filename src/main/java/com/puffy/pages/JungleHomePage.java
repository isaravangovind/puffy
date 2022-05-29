package com.puffy.pages;

import com.puffy.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class JungleHomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'subscribe')]")
    WebElementFacade email;

    @FindBy(xpath = "//footer//button[contains(text(),'Sign up')]")
    WebElementFacade signupBtn;

    @FindBy(xpath = "//div[contains(@class,'state')]")
    WebElementFacade signUpstate;

    @FindBy(xpath = "//span[contains(@class, 'login')]")
    WebElementFacade signUpHeader;

    @FindBy(linkText = "Explore")
    WebElementFacade explore;

    @FindBy(linkText = "Market")
    WebElementFacade market;

    @FindBy(linkText = "How It Works")
    WebElementFacade howItWorks;


    public List getAllBrokenLinks() {
        return validateBrokenLinks();
    }

    public void enterEmail(String emailAddress) {
        clickOn(email);
        email.type(emailAddress);
        clickOn(signupBtn);
    }


    public String getSignupState(String text) {
        waitFor(ExpectedConditions.textToBePresentInElement(signUpstate, text));
        return signUpstate.getText();
    }

    public String getdefaultText() {
        scrollToview(email);
        return email.getAttribute("placeholder");
    }

    public void clicksignUp(){
        clickOn(signUpHeader);
    }

    public void clickExplore(){
        clickOn(explore);
    }


    public void clickOnMarket() {
        clickOn(howItWorks);
    }

    public void clickOnHowitWorks() {
        clickOn(howItWorks);
    }
}
