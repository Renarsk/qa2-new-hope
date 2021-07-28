Feature: Tickets reservation service check

  Scenario: Checking reservation data via API
    Given flight from "RIX" to "SVO"
    And passenger info:
      | name            | Renars     |
      | surname         | K          |
      | discount        | CCCCCC     |
      | passenger count | 4          |
      | child count     | 2          |
      | luggage         | 2          |
      | date            | 16-05-2018 |

    And seat number is: 21

    When we are opening home page
    And selecting airports

    Then airports are displayed on step 2

    When we are submitting passenger info

    Then name appears in summary

    Then price calculated is: 3600

    When we are pressing Book button

    When selecting seat number

    Then seat number appears in page

    When we are booking flight

    Then success message appears

#    When we are requesting reservations via API
#
#    Then our reservation with correct data appears
