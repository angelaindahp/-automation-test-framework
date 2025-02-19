package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class UserApiSteps {
    private static final String BASE_URL = "https://dummyapi.io/data/v1/user";
    private static Response response;
    private static String userId;

    @Given("I have a valid user ID")
    public void i_have_a_valid_user_ID() {
        userId = "60d0fe4f5311236168a109ca"; // Contoh user ID dari API Dummy
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.given().header("app-id", "your-app-id").get(BASE_URL + "/" + userId);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("the response should contain user details")
    public void the_response_should_contain_user_details() {
        Assert.assertNotNull(response.jsonPath().getString("id"));
    }

    @Given("I have user details")
    public void i_have_user_details() {
        response = RestAssured.given()
                .header("app-id", "your-app-id")
                .contentType("application/json")
                .body("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\"}")
                .post(BASE_URL);
        userId = response.jsonPath().getString("id");
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = RestAssured.given().header("app-id", "your-app-id").delete(BASE_URL + "/" + userId);
    }
}
