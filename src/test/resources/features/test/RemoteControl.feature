Feature: As a driver, I can do remote control via mobile app

#  Background: I have to login the mobile app first.
#    Given I login the mobile app

  Scenario: I can remote door unlock via mobile app
    When I press "door unlock" button in mobile app
    Then I can get latest "door unlock" status

  Scenario: I can remote door lock via mobile app
    When I press "door lock" button in mobile app
    Then I can get latest "door lock" status