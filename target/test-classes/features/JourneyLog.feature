Feature: As a driver, I can check journey log via mobile app
  1.journey log switch
  2.show journey log list
  3.show a journey log details

  Background: I have to login the mobile app first.
    Given I login the mobile app
    
  Scenario Outline: I can switch journey log function on and off.
    Given When the switch of journey log is <before>
    When I switch to <after>
    Then The switch of journey log is <after>

    Examples:
    | before  | after |
    | on      | off   |
    | off     | on    |

  Scenario: I can get journey log history list
    When I go to Trips page of mobile app
    Then App will show all journey logs

  Scenario: I can see details of the trip
    When I select one of the trips
    Then App will show trip's details

