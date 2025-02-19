Feature: User API Testing

  Scenario: Get user by ID
    Given I have a valid user ID
    When I send a GET request to "/user/{id}"
    Then the response status should be 200
    And the response should contain user details

  Scenario: Create a new user
    Given I have user details
    When I send a POST request to "/user"
    Then the response status should be 201
    And the response should contain the new user ID

  Scenario: Update user information
    Given I have an existing user ID
    And I have updated user details
    When I send a PUT request to "/user/{id}"
    Then the response status should be 200
    And the response should reflect the updated user details

  Scenario: Delete a user
    Given I have a valid user ID
    When I send a DELETE request to "/user/{id}"
    Then the response status should be 204
    And the user should no longer exist when I fetch it
