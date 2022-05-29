Feature: Resources Link

  Background:
    Given Launch the app
    When Navigate to Resources Page

#  Scenario: Check for Broken Links in Resource Page
#    And Check for broken Links
#
#  Scenario Outline: Navigate to All Resources FAQ Links and Check for Broken Links
#    Then Click to see "<FAQ>" page has any broken links
#    Examples:
#      | FAQ        |
#      | NFT Sales  |
#      | Report NFT |
#      | Create NFT |
#      | Use NFT    |
#      | Sell NFT   |
#      | Freezing   |
#
#
#  Scenario: Verify each Resources FAQ links redirects to respective URLs
#    Then Click to see FAQ links that Navigates to correct URLs
#      | FAQ        | URL                                                              |
#      | NFT Sales  | https://jungle.co/faq/where-can-i-find-nft-sales/                |
#      | Report NFT | https://jungle.co/faq/how-do-i-report-an-nft-user-or-collection/ |
#      | Create NFT | https://jungle.co/faq/how-do-i-create-an-nft/                    |
#      | Use NFT    | https://jungle.co/faq/why-should-i-use-jungle-nft/               |
#      | Sell NFT   | https://jungle.co/faq/how-do-i-sell-an-nft/                      |
#      | Freezing   | https://jungle.co/faq/what-is-freezing-metadata/                 |


  Scenario: User can able to redirect to Other Pages from Resources Page
    Then Redirect to Other Pages
      | Page         | URL                       |
      | Explore      | https://jungle.co/#faq    |
      | Market       | https://jungle.co/#market |
      | How It Works | https://jungle.co/#steps  |