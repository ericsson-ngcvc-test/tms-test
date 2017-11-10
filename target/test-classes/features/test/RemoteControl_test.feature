Feature: As a driver, I can control the vehicle via mobile app

  Background: I have to login the mobile app first.
    Given I login the mobile app

#  Scenario: I can remote door lock via mobile app.
#    When Vehicle do "remote status" operation
#    When I tap "door lock" button
#    When Vehicle do "door lock" operation
#    Then I can get latest "door lock" status

  Scenario: I can remote door open via mobile app.
#    When Vehicle do "remote status" operation
    When I tap "door open" button
    When Vehicle do "door open" operation
    Then I can get latest "door open" status
