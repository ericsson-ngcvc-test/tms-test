Feature: As a driver, I can get latest remote status via mobile app
  1.Remote Status & Dashboard
  2.Triggered Remote Status

  Background: I have to login the mobile app first.
    Given I login the mobile app

  Scenario: When vehicle trigger remote status to CSP, I can get latest remote status via mobile app
    When Vehicle do "remote status" operation
    And I tap "remote status" button
    Then I can get latest "remote status" status

