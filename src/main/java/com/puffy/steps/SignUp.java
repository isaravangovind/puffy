package com.puffy.steps;

import com.puffy.pages.JungleHomePage;
import net.serenitybdd.core.Serenity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SignUp {

    JungleHomePage junglehomepage;

    public void enterEmail(String email) {
        junglehomepage.scrollToview(junglehomepage.copyRightYear);
        junglehomepage.email.clear();
        junglehomepage.enterEmail(email);
    }

    public void clickOnSignUpFooter() {
        junglehomepage.clicksignUpBtnFooter();
    }


    public void getSignupState(String inProgressMsg) {
        assertTrue("Sign up state is in correct - Expected Sign up state is " + inProgressMsg + " But displayed "
                        + junglehomepage.getSignupState(inProgressMsg),
                junglehomepage.getSignupState(inProgressMsg).equals(inProgressMsg));
    }

    public void signUpSuccess(String successMsg) {
        assertTrue("Sign up state is in correct - Expected Sign up state is " + successMsg + " But displayed "
                        + junglehomepage.getSignupState(successMsg),
                junglehomepage.getSignupState(successMsg).equals(successMsg));
    }

    public void validatedefaultText(String defaultText) {
        junglehomepage.scrollToview(junglehomepage.email);
        assertTrue("Email Sign up default value mismatch - Expected Sign up state is " + defaultText + " But displayed "
                + junglehomepage.getdefaultText(), junglehomepage.getdefaultText().equals(defaultText));

        // Check for Signup page
        // check for email confirmation
    }

    public void clickSignUp() {
        junglehomepage.clicksignUp();
    }

    public void checkSignUpNavigation() {
        try {
            if (junglehomepage.waitForAlert()) {
                // Enter Username and password
            } else {
                // check for email and password field
                // or any URL changes
            }
        } catch (Exception e) {
            Serenity.recordReportData().withTitle("Not able to Sign up").andContents("No Pop-ups / Field displayed for Signing");
            assertTrue(false);
        }

    }

    public void signUpFails(String successMsg) {
        assertFalse("Sign up should not be successful with invalid email address " + successMsg + " But displayed "
                        + junglehomepage.getSignupState(successMsg),
                junglehomepage.notPresentOfSuccessMsg(successMsg));
    }
}
