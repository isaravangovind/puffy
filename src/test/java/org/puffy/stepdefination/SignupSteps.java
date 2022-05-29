package org.puffy.stepdefination;

import com.puffy.steps.SignUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.thucydides.core.annotations.Steps;

public class SignupSteps {

    @Steps
    SignUp signup;

    @Then("Sign up Text box should display {string}")
    public void checkDefaultText(String defaultString) {
        signup.validatedefaultText(defaultString);
    }

    @When("Enter {string} and Click on Sign up")
    public void enterEmail(String email) {
        signup.enterEmail(email);
    }

    @Then("{string} is displayed")
    public void signUpInprogress(String inProgressMsg) {
        signup.getSignupState(inProgressMsg);
    }

    @Then("Sign up is success with {string}")
    public void signUpSuccess(String successMsg) {
        signup.signUpSuccess(successMsg);
    }


    @When("Click on sign up")
    public void clickOnSignUp() {
        signup.clickSignUp();
    }

    @Then("Navigates to Sign up page")
    public void navigatesToSignUpPage() {
        signup.checkSignUpNavigation();
    }
}
