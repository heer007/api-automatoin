package zestbloom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import zestbloom.steps.serenity.AuthResponse;
import java.io.IOException;

public class Utils {
    private static final String AUTH_URL;
    private static final String EMAIL;
    private static final String PASSWORD;
    private static final String API_URL;
    private static final String SUPER_USER_EMAIL;
    private static final String SUPER_USER_PASSWORD;
    private static final String IMAGE_SEARCH_URL;
    private static final String X_RAPIDAPI_KEY;
    private static final String X_RAPIDAPI_HOST;


    static{
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        API_URL = variables.getProperty("api.base.url");
        AUTH_URL = variables.getProperty("auth.url");
        EMAIL=variables.getProperty("email");
        PASSWORD =variables.getProperty("password");
        SUPER_USER_EMAIL = variables.getProperty("super.user.email");
        SUPER_USER_PASSWORD = variables.getProperty("super.user.password");
        IMAGE_SEARCH_URL=variables.getProperty("image.search.url");
        X_RAPIDAPI_KEY=variables.getProperty("X-RapidAPI-Key");
        X_RAPIDAPI_HOST=variables.getProperty("X-RapidAPI-Host");

    }

    public static String getExistingAssetId(String network) throws JsonProcessingException {
        String assetId = null;
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl =API_URL+"/ion//assets/"+network+"/?offset=0&limit=1&is_destroyed=false";

        String personResultAsJsonStr =
                restTemplate.getForObject(apiUrl, String.class);
        JsonNode root = null;
        try {
            root = objectMapper.readTree(personResultAsJsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode result = root.get("data");
        assetId= result.get(0).get("asset_id").toString();

        return assetId;
    }

    public static String getAuthHeaderForAPi() throws JsonProcessingException {
         String authToken= null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter() );

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", EMAIL);
        params.add("password", PASSWORD);
        HttpEntity httpEntity = new HttpEntity(params,headers);
        ResponseEntity<AuthResponse> authResponse = restTemplate.exchange(AUTH_URL, HttpMethod.POST, httpEntity,AuthResponse.class);
       authToken = authResponse.getBody().getAccess_token();


        return authToken;
    }

    public static String getAuthHeaderForSuperUserForAPi() throws JsonProcessingException {
        String authToken= null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter() );

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", SUPER_USER_EMAIL);
        params.add("password", SUPER_USER_PASSWORD);
        HttpEntity httpEntity = new HttpEntity(params,headers);
        ResponseEntity<AuthResponse> authResponse = restTemplate.exchange(AUTH_URL, HttpMethod.POST, httpEntity,AuthResponse.class);
        authToken = authResponse.getBody().getAccess_token();


        return authToken;
    }

    public static  ResponseEntity<String> requestImageSearchURL(String appendURLString){
        RestTemplate restTemplate = new RestTemplate();
        String url=IMAGE_SEARCH_URL+appendURLString;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("X-RapidAPI-Key",X_RAPIDAPI_KEY);
        headers.set("X-RapidAPI-Host",X_RAPIDAPI_HOST);

        HttpEntity httpEntity = new HttpEntity(headers);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }

}

