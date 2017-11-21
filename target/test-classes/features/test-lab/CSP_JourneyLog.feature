Feature: As a driver, I can check journey log via mobile app
  1.journey log switch
  2.show journey log list
  3.show a journey log details

  Background: I have to login the mobile app first.
    Given I login the mobile app
    
  Scenario Outline: I can switch journey log function on and off.
    Given The switch of journey log is <before>
    When I switch to <after>
    Then The switch of journey log is <after>

    Examples:
    | before  | after |
    | on      | off   |
    | off     | on    |

  Scenario: I can get journey log history list
    When I tap "Trips page" button
    Then I can get latest "all journay logs" status

  Scenario: I can see details of the trip
    When I tap "one trip" button
    Then I can get latest "trip detail" status

