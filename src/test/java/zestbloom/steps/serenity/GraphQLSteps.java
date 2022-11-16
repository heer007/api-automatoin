package zestbloom.steps.serenity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.*;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import zestbloom.GraphQLQueries;
import zestbloom.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GraphQLSteps {
    private static final String GRAPHQL_BASE_URL;
    static{
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        GRAPHQL_BASE_URL = variables.getProperty("graphql.base.url");
    }
    private JsonNode getJsonNode(String query) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request =
                new HttpEntity<String>(query, headers);

        String personResultAsJsonStr =
                restTemplate.postForObject(GRAPHQL_BASE_URL, request, String.class);
        JsonNode root = null;
        try {
            root = objectMapper.readTree(personResultAsJsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Step
    public void query_and_verify_all_the_asset_for_network(String string) throws JsonProcessingException {
        String query  ="{\n" +
                "  \"query\": \"query MyQuery {getAssetByAssetId(assetId: 346010154 network: "+string+")\\n{assetId,isDestroyed}}\\n\\t\",\n" +
                "  \"variables\": null,\n" +
                "  \"operationName\": \"MyQuery\"\n" +
                "}";
        JsonNode root = getJsonNode(query);
        assertEquals("{\"data\":{\"getAssetByAssetId\":{\"assetId\":346010154,\"isDestroyed\":false}}}",root.toString());
    }




    @Step
    public void query_and_validate_pagination_for_all_assets_list_as_per_following_data(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String query ="{\"query\":\"query MyQuery {\\n  getAssets(offset: "+columns.get("offset")+", limit: "+columns.get("limit")+", orderBy: "+columns.get("orderBy")+")  {\\n    id\\n    assetId\\n    assetInfo\\n    assetMedia {\\n      imageThumbnailUrl\\n      imageOriginalUrl\\t\\t\\n    }\\n    name\\n  }\\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
            JsonNode root = getJsonNode(query);

            String[] count = root.toString().split("\"assetId\"");

            assertEquals(columns.get("pagination"),String.valueOf(count.length-1));
        }
    }



    @Step
    public void query_and_verify_all_the_asset_with_criteria_first_asset_id_and_has_media_and_has_media_and_is_destroyed_and_limit_and_network_and_offset_and_order_by_and_result_count(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String gpraphQLQuery = GraphQLQueries.getAssetsBy_firstAssetId_hasMedia_isDestroyed_limit_network_offset_orderBy(
                    columns.get("firstAssetId"),
                    columns.get("hasMedia"),
                    columns.get("isDestroyed"),
                    columns.get("limit"),
                    columns.get("network"),
                    columns.get("offset"),
                    columns.get("orderBy")
            );
            String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
            JsonNode root = getJsonNode(query);

            String[] count = root.toString().split("\"assetId\"");

            assertEquals(columns.get("resultCount"), String.valueOf(count.length - 1));
        }
    }

    @Step
    public void query_and_verify_all_the_asset_with_following_data_with_criteria_created_at_and_description_and_id_and_is_destroyed_and_is_nfsfw_and_name_and_network_and_updated_at(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String gpraphQLQuery = GraphQLQueries.getAssetsBy_createdAt_description_id_isDestroyed_isNsfw_name_network_updatedAt();
            String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
            JsonNode root = getJsonNode(query);

            String[] count = root.toString().split("\"id\"");

            assertEquals(columns.get("resultCount"), String.valueOf(count.length - 1));
        }
    }

    @Step
    public void query_and_verify_all_the_asset_with_following_data_for_string_trait_summary_with_search_criteria_name_and_values(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String gpraphQLQuery = GraphQLQueries.getAssetsBy_name_values();
            String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
            JsonNode root = getJsonNode(query);

            String[] count = root.toString().split("\"name\"");

            assertEquals(columns.get("resultCount"), String.valueOf(count.length - 1));
        }
    }

    @Step
    public void query_asset_by_id_for_network_and_verify_asset_info_data(String network) throws JsonProcessingException {
        String id = Utils.getExistingAssetId(network);
        String gpraphQLQuery = GraphQLQueries.getAssetsByassestIdandNetworkWithAssetInfo(id);
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] errorMessage = root.toString().split("\"url\"");

        assertNotNull( errorMessage[1]);
    }

    @Step
    public void query_asset_by_invalid_id_for_network_and_verify_the_error_message(String string) throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getAssetsByassestIdandNetwork("-1");
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] errorMessage = root.toString().split("\"message\"");

        assertTrue( errorMessage[1].contains("not found on  Network"));
    }

    @Step public void query_asset_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network(String network) throws JsonProcessingException {
        String id = Utils.getExistingAssetId(network);
        String gpraphQLQuery = GraphQLQueries.getAssetsByassestIdandNetworkWithAssetInfoAssetMetaDataNameNetwork(id);
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"name\"");
        String[] networkNode = root.toString().split("\"network\"");
        assertNotNull( name[1]);
        assertNotNull( networkNode[1]);
    }

    @Step
    public void query_assets_by_id_for_network_and_verify_asset_info_data_and_asset_meta_data_and_name_and_network(String network) throws JsonProcessingException {
        String id = Utils.getExistingAssetId(network);

        String gpraphQLQuery = GraphQLQueries.getAssetsByassestsIdandNetworkWithAssetInfoAssetMetaDataNameNetwork(id);
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"name\"");
        String[] networkNode = root.toString().split("\"network\"");
        assertNotNull( name[1]);
        assertNotNull( networkNode[1]);
    }


    @Step
    public void query_tags_with_id() throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getTagsWthID();
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] id = root.toString().split("\"id\"");

        assertNotNull( id[1]);
    }

    @Given("Query tags with name")
    public void query_tags_with_name() throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getTagsWthName();
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"id\"");

        assertNotNull( name[1]);
    }

    @Given("Query tags with limit")
    public void query_tags_with_limit() throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getTagsWthimit();
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"id\"");

        assertEquals( 1,name.length-1);
    }

    @Step
    public void query_tag_with_id() throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getTagWithId();
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"id\"");

        assertEquals( ":4}}}",name[1]);
    }

    @Step
    public void query_tag_with_name() throws JsonProcessingException {
        String gpraphQLQuery = GraphQLQueries.getTagWithName();
        String query = "{\"query\":\"query MyQuery {\\n " + gpraphQLQuery + " \\n}\\n\",\"variables\":null,\"operationName\":\"MyQuery\"}";
        JsonNode root = getJsonNode(query);

        String[] name = root.toString().split("\"name\"");

        assertEquals( ":\"string91\"}}}",name[1]);
    }
    public static int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
