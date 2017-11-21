Feature: As a call center admin, I can excute xcall operation
  1.Ecall
  2.Oncall
  3.Icall

  Scenario: I can excute ecall operation
    Given "Ecall event" is triggered by vehicle
    When I select "ecall" page
    Then I can get "ecall vehicle info and location" of the event

    When I send "Ecall ETA" to vehicle
    Then Vehicle receive the "Ecall ETA" message

    When I send "Ecall CLOSE" to vehicle
    Then Vehicle receive the "Ecall CLOSE" message

  Scenario: I can excute oncall operation
    Given "Oncall event" is triggered by vehicle
    When I select "oncall info" page
    Then I can get "oncall vehicle info" of the event

    When I select "oncall road" page
    Then I can get "oncall vehivle location" of the event

  Scenario: I can excute icall operation
    Given "Icall event" is triggered by vehicle
    When I select "POI" page
    Then I can get "icall vehicle location" of the event

    When I select "send to car" page
    Then Vehicle receive the "POI" message

