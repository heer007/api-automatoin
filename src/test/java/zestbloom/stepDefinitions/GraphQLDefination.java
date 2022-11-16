package zestbloom.stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import zestbloom.steps.serenity.GraphQLSteps;

public class GraphQLDefination {
    @Steps
    public GraphQLSteps graphQLSteps;

    @Given("Query and verify all the asset for network {string}")
    public void query_and_verify_all_the_asset_for_network(String string) throws JsonProcessingException {
        graphQLSteps.query_and_verify_all_the_asset_for_network(string);
    }


    @Given("Query and validate pagination for all assets list as per following data")
    public void query_and_validate_pagination_for_all_assets_list_as_per_following_data(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        graphQLSteps.query_and_validate_pagination_for_all_assets_list_as_per_following_data(dataTable);
    }


    @Given("Query and verify all the asset with criteria firstAssetId and hasMedia and hasMedia and isDestroyed and limit and network and offset and orderBy and resultCount")
    public void query_and_verify_all_the_asset_with_criteria_first_asset_id_and_has_media_and_has_media_and_is_destroyed_and_limit_and_network_and_offset_and_order_by_and_result_count(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        graphQLSteps.query_and_verify_all_the_asset_with_criteria_first_asset_id_and_has_media_and_has_media_and_is_destroyed_and_limit_and_network_and_offset_and_order_by_and_result_count(dataTable);
    }

    @Given("Query and verify all the asset with following data with criteria createdAt and description and id and isDestroyed and isNfsfw and name and network and updatedAt")
    public void query_and_verify_all_the_asset_with_following_data_with_criteria_created_at_and_description_and_id_and_is_destroyed_and_is_nfsfw_and_name_and_network_and_updated_at(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        graphQLSteps.query_and_verify_all_the_asset_with_following_data_with_criteria_created_at_and_description_and_id_and_is_destroyed_and_is_nfsfw_and_name_and_network_and_updated_at(dataTable);
    }

    @Given("Query and verify all the asset with following data for StringTraitSummary with search criteria name and values")
    public void query_and_verify_all_the_asset_with_following_data_for_string_trait_summary_with_search_criteria_name_and_values(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        graphQLSteps.query_and_verify_all_the_asset_with_following_data_for_string_trait_summary_with_search_criteria_name_and_values(dataTable);
    }


    @Given("Query asset by invalid id for network {string} and verify the error message")
    public void query_asset_by_invalid_id_for_network_and_verify_the_error_message(String network) throws JsonProcessingException {
      graphQLSteps.query_asset_by_invalid_id_for_network_and_verify_the_error_message(network);
    }

    @Given("Query asset by id for network {string} and verify assetInfoData")
    public void query_asset_by_id_for_network_and_verify_asset_info_data(String network) throws JsonProcessingException {
        graphQLSteps.query_asset_by_id_for_network_and_verify_asset_info_data(network);
    }

    @Given("Query asset by id for network {string} and verify assetInfoData and assetMetaData and name and network")
    public void query_asset_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network(String network) throws JsonProcessingException {
        graphQLSteps.query_asset_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network(network);
    }

    @Given("Query assets by id for network {string} and verify assetInfoData and assetMetaData and name and network")
    public void query_assets_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network(String network) throws JsonProcessingException {
        graphQLSteps.query_assets_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network( network);
    }

    @Given("Query tags with id")
    public void query_tags_with_id() throws JsonProcessingException {
        graphQLSteps.query_tags_with_id();
    }

    @Given("Query tags with name")
    public void query_tags_with_name() throws JsonProcessingException {
        graphQLSteps.query_tags_with_name();
    }

    @Given("Query tags with limit")
    public void query_tags_with_limit() throws JsonProcessingException {
        graphQLSteps.query_tags_with_limit();
    }

    @Given("Query tag with id")
    public void query_tag_with_id() throws JsonProcessingException {
        graphQLSteps.query_tag_with_id();
    }

    @Given("Query tag with name")
    public void query_tag_with_name() throws JsonProcessingException {
        graphQLSteps.query_tag_with_name();
    }
}


