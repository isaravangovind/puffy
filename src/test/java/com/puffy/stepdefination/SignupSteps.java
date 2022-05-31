package com.puffy.stepdefination;

import com.puffy.steps.SignUp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.thucydides.core.annotations.Steps;

import java.util.List;

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
        signup.clickOnSignUpFooter();
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

//    @When("Enter invalid email and Click on Sign up")
//    public void enterInvalidEmailAndClickOnSignUp(DataTable emails) {
//        List<String> emailList = emails.asList(String.class);
//        for (String e : emailList) {
//            signup.enterEmail(e);
//        }
//    }

    @Then("Sign up is should not be successful with {string}")
    public void signUpIsShouldNotBeSuccessfullWith(String successMsg) {
        signup.signUpFails(successMsg);
    }
}
