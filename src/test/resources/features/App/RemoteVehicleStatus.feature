Feature: As a driver, I can query latest remote vehicle status via mobile app

#  Background: I have to login the mobile app first.
#    Given I login the mobile app

  Scenario: I can query latest remote vehicle status via mobile app
    When I press "remote status" button in mobile app
    Then I can get latest "remote vehicle" status