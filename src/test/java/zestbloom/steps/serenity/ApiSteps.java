package zestbloom.steps.serenity;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import zestbloom.Utils;
import zestbloom.imagesearch.ResourceImpl;
import zestbloom.imagesearch.Resources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static org.junit.Assert.*;


import static net.serenitybdd.rest.SerenityRest.given;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;


public class ApiSteps{
    private static final String API_URL;
    private static String AUTH_TOKEN;
    private static String SUPER_USER_AUTH_TOKEN;
    static{
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        API_URL = variables.getProperty("api.base.url");
        AUTH_TOKEN=null;
        try {
            AUTH_TOKEN=Utils.getAuthHeaderForAPi();
            SUPER_USER_AUTH_TOKEN = Utils.getAuthHeaderForSuperUserForAPi();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Step public void i_send_a_request_to_endpoint(String network) {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/assets/?network=algo&offset=1&limit=10")
                .when().get();
    }

    @Step
    public void the_api_should_return_status(int status) {
        int statusCode = SerenityRest.lastResponse().statusCode();
        assertEquals(status,statusCode);
        }

    @Step
    public void response_should_contains() {
        String asset = SerenityRest.lastResponse().toString();
        assertNotNull(asset);
    }

    public void get_the_asset_for_id_network(Integer id, String network) throws JsonProcessingException {

        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/assets/"+network+"/"+ Utils.getExistingAssetId(network)+"/")
                .when()
                .get();
    }

    public void     post_a_request_to_add_new_tag() {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/tags/")
                .body("{\"name\": \"string"+ LocalDateTime.now() +"\"}")
                .when().log().all()
                .post() ;
    }

    public void validate_that_new_tag_is_created() {
        String asset = SerenityRest.lastResponse().toString();
        assertNotNull(asset);
    }

    public void delete_all_the_asset_for_network(String network) throws JsonProcessingException {
        String body ="{\n" +
                "  \"network\": \"algo\",\n" +
                "  \"asset_ids\": [ "+Utils.getExistingAssetId(network) +
                "  ],\n" +
                "  \"force\": false\n" +
                "}";
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/assets/import/")
                .body(body  )
                .when().log().all()
                .post() ;
    }

    public void validate_the_response_body_for_deleted_assets() {
        String asset = SerenityRest.lastResponse().toString();
        assertNotNull(asset);
    }


    public void udpate_the_assetby_id_with_tag_for_network(String string) {
        String body ="{\n" +
                "  \"tags\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}  ";
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/assets/algo/564819214/tags/")
                .body(body  )
                .when().log().all()
                .patch() ;
    }


    public void validate_the_response_body_after_updating_tag_for_asset() {
        String asset = SerenityRest.lastResponse().toString();
        assertNotNull(asset);
    }


    public void put_a_request_to_update_tag_with_id(Integer int1) {
        String body ="{\n" +
                "  \"name\": \"updated "+ LocalDate.now()+"\"\n" +
                "}";
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/ion/tags/2/")
                .body(body  )
                .when().log().all()
                .put() ;
    }

    @Step
    public void delete_the_asset_by_id_for_network(String network) throws JsonProcessingException {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .baseUri(API_URL)
                .basePath("/ion/assets/"+network+"/"+ Utils.getExistingAssetId(network)+"/")
                .when()
                .get();
    }
    @Step
    public void validate_the_response_body_for_deleted_asset() {
        int statusCode = SerenityRest.lastResponse().statusCode();
        assertEquals(200,statusCode);
    }


    @Step
    public void get_a_request_to_list_all_the_tags_within_offset_to_limit(Integer offset, Integer limit) {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .baseUri(API_URL)
                .basePath("/ion/tags/?offset="+offset+"&limit="+limit)
                .when()
                .get();
    }

    @Step
    public void get_a_request_for_a_tag_with_id_associated_with(Integer offset, String limit) {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .baseUri(API_URL)
                .basePath("/ion/tags/1/assets/?offset="+offset+"&limit="+limit)
                .when()
                .get();
    }

    @Step
    public void   get_request_per_second_for_single_user_for_all_the_asset_for_network_for(Integer reqs, String network) {

        ExecutorService executor  = Executors.newFixedThreadPool(reqs);
        AssetRequest assetRequest = new AssetRequest();
        List<Integer> statuses = new ArrayList<>();    
        for(int i=1; i<=reqs;i++) {
            Future<Integer> result = executor.submit(new AssetRequest());
            try {
                statuses.add(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("List all status of requests: " +statuses);
        Assert.assertTrue(!statuses.contains(403));
        Assert.assertTrue(!statuses.contains(500));
        Assert.assertTrue(!statuses.contains(503));
        try {
            Thread.sleep(2000);
            Resources resources = new ResourceImpl();
            String appendUrl="/v1/search?limit=32&q=sauce&network=algo";
            Assert.assertTrue(resources.searchByText(appendUrl));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


    class AssetRequest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Random rand = new Random();
            int limit = rand.nextInt((10 - 1) + 1) + 1;
            return given().contentType("application/json")
                    .header("Accept", ContentType.JSON.getAcceptHeader())
                    .accept("application/json")
                    .baseUri(API_URL)
                    .basePath("/ion/assets/?network=algo&offset=1&limit="+limit+"&is_destroyed=false")
                    .when().log().all()
                    .get()
                    .statusCode();

        }
    }

    @Step
    public void super_user_get_all_the_blacklist() {
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(SUPER_USER_AUTH_TOKEN)
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .baseUri(API_URL)
                .basePath("/gateway/settings/blacklist/")
                .when()
                .log()
                .all()
                .get();

    }
    @Step
    public void validate_the_response() {
        int respone = SerenityRest.lastResponse().statusCode();
        assertEquals(200, respone);
    }

    @Step
    public void super_user_add_to_the_blacklist() {
        String body ="{\n" +
                "  \"ip\": \"12.1.1.1\",\n" +
                "  \"user\": 1,\n" +
                "  \"api_key\": \"api1234\",\n" +
                "  \"expiration_date\": \"122002202\"\n" +
                "}";
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(SUPER_USER_AUTH_TOKEN   )
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/gateway/settings/blacklist/")
                .body(body  )
                .when().log().all()
                .post() ;
    }

    @Step
    public void super_user_delete_from_the_blacklist() {
        String body ="{\n" +
                "  \"ip\": \"12.1.1.1\",\n" +
                "  \"user\": 1,\n" +
                "  \"api_key\": \"api1234\",\n" +
                "  \"expiration_date\": \"122002202\"\n" +
                "}";
        given().contentType("application/json")
                .auth()
                .preemptive()
                .oauth2(SUPER_USER_AUTH_TOKEN   )
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .accept("application/json")
                .baseUri(API_URL)
                .basePath("/gateway/settings/blacklist/")
                .body(body  )
                .when().log().all()
                .delete() ;
    }

    @Step
    public void validate_the_response_after_adding_to_the_blacklist() {
        JsonPath jsonPath = SerenityRest.lastResponse().getBody().jsonPath();
        String ip = jsonPath.get("ip").toString();
        String user = jsonPath.get("user").toString();
        String api_key = jsonPath.get("api_key").toString();
        String expiration_date = jsonPath.get("expiration_date").toString();
        assertEquals("12.1.1.1",ip);
        assertEquals("1",user);
        assertEquals("api1234",api_key);
       // assertEquals("122002202",expiration_date);

    }

    @Step
    public void user_is_able_to_search_asset_by_id() {
        Resources resources = new ResourceImpl();
        Assert.assertTrue(resources.searchAsset());
    }

    @Step
    public void user_is_able_to_search_asset_by_invalid_id() {
        Resources resources = new ResourceImpl();
        Assert.assertFalse(resources.searchAsset(-1));
    }

    @Step
    public void user_is_able_to_search_image_by_text() {
        Resources resources = new ResourceImpl();
        Assert.assertTrue(resources.searchByText());
    }

    @Step
    public void user_is_able_to_search_image_by_invalid_text() {
        Resources resources = new ResourceImpl();
        String text="$#$%#%#";
        String appendUrl="/v1/search?limit=32&q="+text+"&network=algo&showNsfw=false";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }

    @Step
    public void user_is_able_to_search_image_with_negative_offset_value() {
        Resources resources = new ResourceImpl();
        String text="-1";
        String appendUrl="/v1/search?limit="+text+"&q=sauce&network=algo&showNsfw=false";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }

    @Step
    public void user_is_able_to_search_image_with_special_characters_offset_value() {
        Resources resources = new ResourceImpl();
        String text="@@@@&&";
        String appendUrl="/v1/search?limit="+text+"&q=sauce&network=algo&showNsfw=false";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }
    @Step
    public void user_is_able_to_search_image_with_special_chars_in_show_nsfw() {
        Resources resources = new ResourceImpl();
        String text="@@@@&&";
        String appendUrl="/v1/search?limit=32&q=sauce&network=algo&showNsfw="+text;
        Assert.assertTrue(resources.searchByText(appendUrl));
    }

    @Step
    public void user_is_able_to_search_with_invalid_text() {
        Resources resources = new ResourceImpl();
        String text="<$%^&>";
        String appendUrl="/v1/search?limit=32&q="+text+"&network=algo&showNsfw=false";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }
    @Step
    public void user_is_able_to_search_with_javascript_code_in_text() {
        Resources resources = new ResourceImpl();
        String text=" <script> alert (1) </script> ";
        String appendUrl="/v1/search?limit=32&q="+text+"&network=algo&showNsfw=false";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }


    @Step
    public void user_is_able_to_search_image_without_show_nsfw_value() {
        Resources resources = new ResourceImpl();
        String appendUrl="/v1/search?limit=32&q=sauce&network=algo";
        Assert.assertTrue(resources.searchByText(appendUrl));
    }

    @Step
    public void user_is_able_to_search_with_invalid_network() {
        Resources resources = new ResourceImpl();
        String text="invalid";
        String appendUrl="/v1/search?limit=32&q=sauce&network="+text+"&showNsfw=false";
        Assert.assertFalse(resources.searchByText(appendUrl));
    }

    @Step
    public void upload_image_and_verify_its_uploaded_successfully() {
        Resources resources = new ResourceImpl();
        Assert.assertTrue(resources.uploadImage());
    }

    @Step
    public void search_image_by_valid_id() {
        Resources resources = new ResourceImpl();
        Assert.assertTrue(resources.searchImage());
    }

    @Step
    public void search_image_by_invalid_id() {
        Resources resources = new ResourceImpl();
        Assert.assertFalse(resources.searchImage(-1));
    }
    @Step
    public void user_is_able_to_search_by_image_with_negative_offset_value() {
        Resources resources = new ResourceImpl();
        String text="-1";
        String appendUrl="/v1/search-image?imageId=6de8c0abc056174d50e9de71305a2eee859091c0&limit=32&offset="+text;
        Assert.assertFalse(resources.searchImage(appendUrl));
    }

    @Step
    public void user_is_able_to_search_by_image_with_special_characters_offset_value() {
        Resources resources = new ResourceImpl();
        String text="$$@#$";
        String appendUrl="/v1/search-image?imageId=6de8c0abc056174d50e9de71305a2eee859091c0&limit=32&offset="+text;
        Assert.assertFalse(resources.searchImage(appendUrl));
    }

}
