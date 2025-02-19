Feature: Login Functionality

  Scenario: User berhasil login dengan kredensial yang valid
    Given User membuka halaman login
    When User memasukkan username "testuser" dan password "test123"
    And User menekan tombol login
    Then User berhasil masuk

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter an invalid username or password
    And I click the login button
    Then I should see an error message "Invalid username or password"

  Scenario: Unsuccessful login with empty fields
    Given I am on the login page
    When I leave the username and password fields empty
    And I click the login button
    Then I should see an error message "Username and password are required"
