Feature:As a driver, I can receive app message once vehicle was broken into or breaken into.
  As a call center admin, I can start SVT service via CallCenter Protal.

  Scenario: SVT service
    When I start SVT service on cc protal
    Then I can receive SVT message at regular interval

  Scenario Outline: I can receive message once my vehicle is broke into or towed away
    When <threft event> is triggered by vehicle
    Then I can receive <threft event> message

    Examples:
    |threft event|
    |break in    |
    |tow away    |
