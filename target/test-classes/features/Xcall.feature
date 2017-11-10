Feature: As a call center admin, I can excute xcall operation
  1.Ecall
  2.Oncall
  3.Icall


  Scenario: I can excute ecall operation
    Given "Ecall event" is triggered by vehicle
    When I select "ecall" page
    Then I can get "ecall vehicle info and location" of the event

    When I send ETA to vehicle
    Then Vehicle receive the ETA message

    When I send CLOSE to vehicle
    Then The ecall event closed

  Scenario: I can excute oncall operation
    Given "Oncall event" is triggerd by vehicle
    When I select "oncall info" page
    Then I can get "oncall vehicle info" of the event

    When I select "oncall road" page
    Then I can get "oncall vehivle location" of the evnet

    ...
    ...

  Scenario: I can excute icall operation
    Given "Icall event" is triggerd by vehicle
    When I select "POI" page
    Then I can get "icall vehicle location" of the event

    When I select "send to car" page
    Then Vehicle receive the POI

    ...
    ...

