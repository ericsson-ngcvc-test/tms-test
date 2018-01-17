$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RemoteControl.feature");
formatter.feature({
  "line": 1,
  "name": "As a driver, I can do remote control via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-do-remote-control-via-mobile-app",
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
      "line": 5,
      "value": "#"
    },
    {
      "line": 6,
      "value": "#  Scenario: I can remote door unlock via mobile app"
    },
    {
      "line": 7,
      "value": "#    When I press \"door unlock\" button in mobile app"
    },
    {
      "line": 8,
      "value": "#    Then I can get latest \"door unlock\" status"
    },
    {
      "line": 9,
      "value": "#"
    },
    {
      "line": 10,
      "value": "#  Scenario: I can remote door lock via mobile app"
    },
    {
      "line": 11,
      "value": "#    When I press \"door lock\" button in mobile app"
    },
    {
      "line": 12,
      "value": "#    Then I can get latest \"door lock\" status"
    }
  ],
  "line": 14,
  "name": "I can remote start engine via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-do-remote-control-via-mobile-app;i-can-remote-start-engine-via-mobile-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I press \"start engine\" button in mobile app",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I can get latest \"engine started\" status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "start engine",
      "offset": 9
    }
  ],
  "location": "TCStep.AppSendMessage(String)"
});
formatter.result({
  "duration": 2953459206,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "engine started",
      "offset": 18
    }
  ],
  "location": "TCStep.GetRVS(String)"
});
formatter.result({
  "duration": 5770445119,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "I can remote stop engine via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-do-remote-control-via-mobile-app;i-can-remote-stop-engine-via-mobile-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I press \"stop engine\" button in mobile app",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I can get latest \"engine stopped\" status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "stop engine",
      "offset": 9
    }
  ],
  "location": "TCStep.AppSendMessage(String)"
});
formatter.result({
  "duration": 709477234,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "engine stopped",
      "offset": 18
    }
  ],
  "location": "TCStep.GetRVS(String)"
});
formatter.result({
  "duration": 5762531943,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "I can remote close all windows via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-do-remote-control-via-mobile-app;i-can-remote-close-all-windows-via-mobile-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "I press \"close windows\" button in mobile app",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I can get latest \"windows closed\" status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "close windows",
      "offset": 9
    }
  ],
  "location": "TCStep.AppSendMessage(String)"
});
formatter.result({
  "duration": 687929271,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "windows closed",
      "offset": 18
    }
  ],
  "location": "TCStep.GetRVS(String)"
});
formatter.result({
  "duration": 5783939509,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "I can remote start air condition via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-do-remote-control-via-mobile-app;i-can-remote-start-air-condition-via-mobile-app",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "I press \"start air condition\" button in mobile app",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "I can get latest \"engine started\" status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "start air condition",
      "offset": 9
    }
  ],
  "location": "TCStep.AppSendMessage(String)"
});
formatter.result({
  "duration": 682106214,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "engine started",
      "offset": 18
    }
  ],
  "location": "TCStep.GetRVS(String)"
});
formatter.result({
  "duration": 5731206260,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cENGINE_[RUNNING]\u003e but was:\u003cENGINE_[OFF]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat tmstest.stepDefinitions.TCStep.GetRVS(TCStep.java:115)\r\n\tat ✽.Then I can get latest \"engine started\" status(RemoteControl.feature:28)\r\n",
  "status": "failed"
});
});