Feature: Describe some common step in this feature
  APP
  1.Given I login the mobile app
    Login mobie app to get token
  2.When I tap "some" button
    Call remote control api to tc-backend
  3.Then I can get latest "some" status
    Call remote status api to tc-backened

  PORTAL
  1.When I select "some" page
    Call tmp-backend api
  2.Then I can get "something" of the evnet
    assert the tmp-backend api response

  TEM:
  1.When Vehicle do "some" operation
  TEM trigger event to CSP