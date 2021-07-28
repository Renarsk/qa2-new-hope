Feature: Testing weather end point

  Scenario: Checking weather for city by ID
    Given city ID: 524901

    When we are requesting weather data

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

#    Then lon is 145.77
#    And lat is -16.92


   And sys is:

      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | AU         |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |

    And weathers are:

      | id  | main   | description      | icon |
      | 802 | Clouds | scattered clouds | 03n  |
