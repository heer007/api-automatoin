package zestbloom.stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import zestbloom.steps.serenity.ApiSteps;

import java.io.IOException;
import java.net.URISyntaxException;


public class ApiStepDefination {
    @Steps
    ApiSteps apiSteps;


    @Given("GET all the asset for network {string}")
    public void get_all_the_asset_for_network(String network) {
        apiSteps.i_send_a_request_to_endpoint(network);
    }

    @Then("the API should return status {int}")
    public void the_api_should_return_status(Integer status) {
        apiSteps.the_api_should_return_status(status);
    }

    @Then("validate the response body")
    public void validate_the_response_body() {
        apiSteps.response_should_contains();
    }

    @Given("GET  the asset for id {int} network {string}")
    public void get_the_asset_for_id_network(Integer id, String network) throws JsonProcessingException {
       apiSteps.get_the_asset_for_id_network(id,network);
    }

    @Given("POST a request to add new tag")
    public void post_a_request_to_add_new_tag() {
        apiSteps.post_a_request_to_add_new_tag();
    }
    @Then("validate that new tag is created")
    public void validate_that_new_tag_is_created() {
        apiSteps.validate_that_new_tag_is_created();
    }


    @Given("DELETE all the asset for network {string}")
    public void delete_all_the_asset_for_network(String string) throws JsonProcessingException {
        apiSteps.delete_all_the_asset_for_network(string);
    }
    @Then("validate the response body for deleted assets")
    public void validate_the_response_body_for_deleted_assets() {
        apiSteps.validate_the_response_body_for_deleted_assets();
    }

    @Given("UDPATE the assetby id with tag for network {string}")
    public void udpate_the_assetby_id_with_tag_for_network(String string) {
        apiSteps.udpate_the_assetby_id_with_tag_for_network(string);
    }

    @Then("validate the response body after updating tag for asset")
    public void validate_the_response_body_after_updating_tag_for_asset() {
        apiSteps.validate_the_response_body_after_updating_tag_for_asset();
    }

    @Given("PUT a request to update tag with id {int}")
    public void put_a_request_to_update_tag_with_id(Integer int1) {
        apiSteps.put_a_request_to_update_tag_with_id(int1);
    }

    @Given("DELETE the asset by id for network {string}")
    public void delete_the_asset_by_id_for_network(String network) throws JsonProcessingException {
        apiSteps.delete_the_asset_by_id_for_network(network);
    }
    @Then("validate the response body for deleted asset")
    public void validate_the_response_body_for_deleted_asset() {
        apiSteps.validate_the_response_body_for_deleted_asset();
    }


    @Given("GET a request to list all the tags within offset {int} to limit {int}")
    public void get_a_request_to_list_all_the_tags_within_offset_to_limit(Integer offset, Integer limit) {
        apiSteps.get_a_request_to_list_all_the_tags_within_offset_to_limit(offset,limit);
    }

    @Given("GET a request for a tag with id {int} associated with {string}")
    public void get_a_request_for_a_tag_with_id_associated_with(Integer offset, String limit) {
        apiSteps.get_a_request_for_a_tag_with_id_associated_with(offset,limit);
    }

    @Given("GET {int} request per second for single user for all the asset for network {string} for")
    public void get_request_per_second_for_single_user_for_all_the_asset_for_network_for(Integer reqs, String network) {
        apiSteps.get_request_per_second_for_single_user_for_all_the_asset_for_network_for(reqs,network);
    }


    @Given("Super user GET all the blacklist")
    public void super_user_get_all_the_blacklist() {
        apiSteps.super_user_get_all_the_blacklist();
    }
    @Then("Validate the response")
    public void validate_the_response() {
        apiSteps.validate_the_response();
    }

    @Given("Super user ADD to the blacklist")
    public void super_user_add_to_the_blacklist() {
        apiSteps.super_user_add_to_the_blacklist();
    }

    @Given("Super user DELETE from the blacklist")
    public void super_user_delete_from_the_blacklist() {
       apiSteps.super_user_delete_from_the_blacklist();
    }
    @Then("Validate the response after adding to the blacklist")
    public void validate_the_response_after_adding_to_the_blacklist() {
        apiSteps.validate_the_response_after_adding_to_the_blacklist();
    }

    @Given("user is able to search asset by id")
    public void user_is_able_to_search_asset_by_id() {
        apiSteps.user_is_able_to_search_asset_by_id();
    }
    @Given("user is able to search asset by  invalid id")
    public void user_is_able_to_search_asset_by_invalid_id() {
        apiSteps.user_is_able_to_search_asset_by_invalid_id();
    }

    @Given("user is able to search image by text")
    public void user_is_able_to_search_image_by_text() {
        apiSteps.user_is_able_to_search_image_by_text();
    }

    @Given("user is able to search image by invalid text")
    public void user_is_able_to_search_image_by_invalid_text() {
       apiSteps.user_is_able_to_search_image_by_invalid_text();
    }

    @When("upload image and verify its uploaded successfully")
    public void upload_image_and_verify_its_uploaded_successfully() {
        apiSteps.upload_image_and_verify_its_uploaded_successfully();
    }

    @Given("user is able to search image with negative offset value")
    public void user_is_able_to_search_image_with_negative_offset_value() {
        apiSteps.user_is_able_to_search_image_with_negative_offset_value();
    }

    @Given("user is able to search image with special characters offset value")
    public void user_is_able_to_search_image_with_special_characters_offset_value() {
        apiSteps.user_is_able_to_search_image_with_special_characters_offset_value();
    }

    @Given("user is able to search image without showNsfw value")
    public void user_is_able_to_search_image_without_show_nsfw_value() {
        apiSteps.user_is_able_to_search_image_without_show_nsfw_value();
    }

    @Given("user is able to search image with special chars in  showNsfw")
    public void user_is_able_to_search_image_with_special_chars_in_show_nsfw() {
        apiSteps.user_is_able_to_search_image_with_special_chars_in_show_nsfw();
    }
    @Given("user is able to search with invalid text")
    public void user_is_able_to_search_with_invalid_text() {
      apiSteps.user_is_able_to_search_with_invalid_text();
    }

    @Given("user is able to search with javascript code in text")
    public void user_is_able_to_search_with_javascript_code_in_text() {
        apiSteps.user_is_able_to_search_with_javascript_code_in_text();
    }

    @Given("user is able to search with invalid network")
    public void user_is_able_to_search_with_invalid_network() {
     apiSteps.user_is_able_to_search_with_invalid_network();
    }



    @When("search image by valid id")
    public void search_image_by_valid_id() {
        apiSteps.search_image_by_valid_id();
    }

    @When("search image by invalid id")
    public void search_image_by_invalid_id() {
        apiSteps.search_image_by_invalid_id();
    }

    @Given("user is able to search by image with negative offset value")
    public void user_is_able_to_search_by_image_with_negative_offset_value() {
       apiSteps.user_is_able_to_search_by_image_with_negative_offset_value();
    }

    @Given("user is able to search by image with special characters offset value")
    public void user_is_able_to_search_by_image_with_special_characters_offset_value() {
        apiSteps.user_is_able_to_search_by_image_with_special_characters_offset_value();
    }

}

