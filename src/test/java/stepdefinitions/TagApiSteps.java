package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class TagApiSteps {
    private static final String BASE_URL = "https://dummyapi.io/data/v1/tag";
    private static Response response;

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.given().header("app-id", "your-app-id").get(BASE_URL);
    }

    @Then("the response should contain a list of tags")
    public void the_response_should_contain_a_list_of_tags() {
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }
}

