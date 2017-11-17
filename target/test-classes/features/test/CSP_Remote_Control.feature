Feature: As a driver, I can control the vehicle via mobile app
1.Remote Climate Start/stop
2.Remote operate window
3.Remote engine start/stop
4.Remote honk flash
5.Remote lock unlock door
6.Remote lock unlock  trunk
7.Remote seat heat t start/stop
8.Remote pull PM2.5
9.Remote PM2.5 clean
10.Remote EV schedule charging
11.Remote Control activation
12.Telematics Service Activation

Background: I have to login the mobile app first.
Given I login the mobile app

#remote control
Scenario: I can start the climate system via mobile app.
When I tap "Cliamte start" button
Then I can get latest "Cliamte start" status

Scenario: I can stop the climate system via mobile app.
When I tap "Cliamte stop" button
And I can get latest "Cliamte stop" status

Scenario: I can open the door system via mobile app.
  When I tap "door open" button
  Then I can get latest "door open" status

Scenario: I can close the door system via mobile app.
  When I tap "door close" button
  And I can get latest "door close" status

#Remote Control activation
Scenario: I can active if vehicle's remote control activation status is off.
Given Vehicle's remote control activation status is off
When I tap "remote active" button
Then Vehicle's remote control activation status turn to on

#Telematics Service Activation
Scenario: I can add vehicles on mobile app
When Input last 8 charactoer of the vin
And Input vehicle onwer's phone number
Then new car will be showed on app