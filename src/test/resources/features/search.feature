Feature: Search

  Background:
    Given Launch the app

  Scenario: Search Any Collection

    When Search for "Collection"
    Then Should display search result contains "Collection"
