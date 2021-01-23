Feature: This feature is to test flipkart search

  Scenario Outline: Verify flipkart search result
   # Given User launch brower with flipkart search
    When user opens flipkart site
  #  And click search button
    Then Search result is displayed for "<val>"

    Examples:
    |  val    |
    | Samsung Galaxy S10   |