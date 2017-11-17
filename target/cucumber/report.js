$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RemoteControl_test.feature");
formatter.feature({
  "line": 1,
  "name": "As a driver, I can control the vehicle via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-control-the-vehicle-via-mobile-app",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#  Background: I have to login the mobile app first."
    },
    {
      "line": 4,
      "value": "#    Given I login the mobile app"
    },
    {
      "line": 6,
      "value": "#  Scenario: I can remote door lock via mobile app."
    },
    {
      "line": 7,
      "value": "#    When \"remote status\" is triggered by vehicle"
    },
    {
      "line": 8,
      "value": "#    When I tap \"door lock\" button"
    },
    {
      "line": 9,
      "value": "#    When Vehicle do \"door lock\" operation"
    },
    {
      "line": 10,
      "value": "#    Then I can get latest \"door lock\" status"
    },
    {
      "line": 12,
      "value": "#  Scenario: I can remote door unlock via mobile app."
    },
    {
      "line": 13,
      "value": "#    When \"remote status\" is triggered by vehicle"
    },
    {
      "line": 14,
      "value": "#    When I tap \"door unlock\" button"
    },
    {
      "line": 15,
      "value": "#    When Vehicle do \"door unlock\" operation"
    },
    {
      "line": 16,
      "value": "#    Then I can get latest \"door unlock\" status"
    }
  ],
  "line": 18,
  "name": "I can query journey logs while Vehile upload a trip",
  "description": "",
  "id": "as-a-driver,-i-can-control-the-vehicle-via-mobile-app;i-can-query-journey-logs-while-vehile-upload-a-trip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "\"journey log\" is triggered by vehicle",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "journey log",
      "offset": 1
    }
  ],
  "location": "TEMStep.TemUploadMessage(String)"
});
formatter.result({
  "duration": 2298572363,
  "status": "passed"
});
});