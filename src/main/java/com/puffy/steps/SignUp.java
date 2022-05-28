package com.puffy.steps;

import com.puffy.pages.JungleHome;

import static org.junit.Assert.assertTrue;

public class SignUp {

    JungleHome junglehome;

    public void enterEmail(String email) {
        junglehome.enterEmail(email);
    }


    public void getSignupState(String inProgressMsg) {
        assertTrue("Sign up state is in correct - Expected Sign up state is " + inProgressMsg + " But displayed " + junglehome.getSignupState(inProgressMsg),
                junglehome.getSignupState(inProgressMsg).equals(inProgressMsg));
    }

    public void signUpSuccess(String successMsg) {
        assertTrue("Sign up state is in correct - Expected Sign up state is " + successMsg + " But displayed " + junglehome.getSignupState(successMsg),
                junglehome.getSignupState(successMsg).equals(successMsg));
    }

    public void validatedefaultText(String defaultText) {
        assertTrue("Email Sign up default value mismatch - Expected Sign up state is " + defaultText + " But displayed " + junglehome.getdefaultText(), junglehome.getdefaultText().equals(defaultText));
    }
}
