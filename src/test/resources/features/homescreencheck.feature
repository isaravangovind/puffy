Feature: Home Screen Basic Check

  Background:
    Given Launch the app

  Scenario: Check Presence of Broken Links
    Then Check for broken Links

  Scenario: Page Title and Url
    Then Page title should be "Jungle NFT | Buy, Sell & Create NFT Marketplace"

  Scenario: Header Links Redirection
    Then Header Link Should redirect to respective sections
      | Link         | Url                       | Section Title              |
      | Explore      | https://jungle.co/#faq    | Frequently asked questions |
      | Market       | https://jungle.co/#market | Browse by category         |
      | How It Works | https://jungle.co/#steps  | How it works               |


  Scenario: Footer Links Redirection
    Then Footer Link Should redirect to respective sections
      | Link         | Url                        | Section Title              |
      | Explore      | https://jungle.co/#faq     | Frequently asked questions |
      | Market       | https://jungle.co/#market  | Browse by category         |
      | How It Works | https://jungle.co/#steps   | How it works               |
      | Terms        | https://jungle.co/#terms   | Terms and Conditions       |
      | Privacy      | https://jungle.co/#privacy | Privacy                    |




