Feature: As CallCenter admin, I can sed POI to the vehicle
  Or as a driver, I can send POI via mobile app

  Scenario: On the CallCenter portal, I can send POI to vehicle
    Given "Icall event" is triggerd by vehicle\
    When I select "send POI" page
    Then IHU should receive the POI message

  Scenario: I can send POI via mobile app
    Given I login the mobile app
    When I tap "send POI" button
    Then IHU should receive the POI message

