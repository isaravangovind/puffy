package com.puffy.pages;

import com.puffy.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class JungleHome extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'subscribe')]")
    WebElementFacade email;

    @FindBy(xpath = "//footer//button[contains(text(),'Sign up')]")
    public WebElement signupBtn;

    @FindBy(xpath = "//div[contains(@class,'state')]")
    public WebElement signUpstate;


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
}
