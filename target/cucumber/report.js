$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RemoteControl_test.feature");
formatter.feature({
  "line": 1,
  "name": "As a driver, I can control the vehicle via mobile app",
  "description": "",
  "id": "as-a-driver,-i-can-control-the-vehicle-via-mobile-app",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "I have to login the mobile app first.",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I login the mobile app",
  "keyword": "Given "
});
formatter.match({
  "location": "TCStep.login()"
});
formatter.result({
  "duration": 2745527193,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 6,
      "value": "#  Scenario: I can remote door lock via mobile app."
    },
    {
      "line": 7,
      "value": "#    When Vehicle do \"remote status\" operation"
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
    }
  ],
  "line": 12,
  "name": "I can remote door open via mobile app.",
  "description": "",
  "id": "as-a-driver,-i-can-control-the-vehicle-via-mobile-app;i-can-remote-door-open-via-mobile-app.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 13,
      "value": "#    When Vehicle do \"remote status\" operation"
    }
  ],
  "line": 14,
  "name": "I tap \"door open\" button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Vehicle do \"door open\" operation",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I can get latest \"door open\" status",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "door open",
      "offset": 7
    }
  ],
  "location": "TCStep.AppSendMessage(String)"
});
formatter.result({
  "duration": 210297927,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "door open",
      "offset": 12
    }
  ],
  "location": "TEMStep.TemUploadMessage(String)"
});
formatter.result({
  "duration": 101362569,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "door open",
      "offset": 18
    }
  ],
  "location": "TCStep.GetRVS(String)"
});
formatter.result({
  "duration": 10478904284,
  "status": "passed"
});
});