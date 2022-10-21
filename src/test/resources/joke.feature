Feature: the joke can be retrieved
  Scenario: client makes call to GET /jokes
    When the client call the app
    Then the client receives status code of 200
    And the client receives server joke "Moving to Paris would be In-Seine."