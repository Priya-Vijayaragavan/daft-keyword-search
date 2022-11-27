# new feature
# Tags: optional

Feature: Keyword search filter testing

  Scenario: Keyword search filter
    Given user is to open Daft homepage "https://www.daft.ie/"
    When search for a Sale Ad in county Dublin
    Then check that there are results for the selected "Dublin"
    And apply "garage" keyword filter
    Then check that there are results for that filter by checking filter count "1"
    Then check that the filter was applied correctly by the "garage" is there on that advert

