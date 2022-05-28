Feature: SignUp Validation

  Background:
    Given Launch the app

  Scenario Outline: Footer SignUp Validation

    Then Sign up Text box should display "Enter your email"
    When Enter "<Email>" and Click on Sign up
    Then "Sending..." is displayed
    And Sign up is success with "Thank you, You are in!"
    Examples:
      | Email          |
      | valid@test.com |