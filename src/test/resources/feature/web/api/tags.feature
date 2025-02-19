Feature: Tag API Testing

  Scenario: Get list of tags
    When I send a GET request to "/tag"
    Then the response status should be 200
    And the response should contain a list of tags
