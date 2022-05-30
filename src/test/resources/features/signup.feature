Feature: SignUp Validation

  Background:
    Given Launch the app

  Scenario Outline: Footer SignUp check

    Then Sign up Text box should display "Enter your email"
    When Enter "<Email>" and Click on Sign up
    Then "Sending..." is displayed
    And Sign up is success with "Thank you, You are in!"
    Examples:
      | Email          |
      | valid@test.com |


  Scenario: Header SignUp check
    When Click on sign up
    Then Navigates to Sign up page

#  Scenario: Tool Tip check
#    When Enter "test" and Click on Sign up
#    When Enter "test" and Click on Sign up
#    And Enter "test@" and Click on Sign up
#    And Enter "test@1" and Click on Sign up
#    And Enter "test@1." and Click on Sign up