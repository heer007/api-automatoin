package zestbloom.imagesearch;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import zestbloom.Utils;

public class ResourceImpl implements Resources{
    @Override
    public boolean uploadImage() {
        RestTemplate restTemplate = new RestTemplate();
        Resource filePath = new ClassPathResource(
                "image/mogli.jpeg");
        String url="https://zestbloom-image-search-api.p.rapidapi.com/v1/search-image-upload";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key","2db187e986msh875835bb365f226p1ef17ajsn593a61a2f032");
        headers.set("X-RapidAPI-Host","zestbloom-image-search-api.p.rapidapi.com");

        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("image", filePath, MediaType.IMAGE_JPEG);
        MultiValueMap<String, HttpEntity<?>> multipartBody = multipartBodyBuilder.build();
        HttpEntity httpEntity = new HttpEntity(multipartBody,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,String.class);
        if(response.getStatusCode().value()==200){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean searchImage() {
        String appendUrl="/v1/search-image?imageId=6de8c0abc056174d50e9de71305a2eee859091c0&limit=32&offset=0";
        ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
        if(response.getStatusCode()==HttpStatus.OK){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean searchImage(int id) {
        String appendUrl="/v1/search-image?imageId="+id+"&limit=32&offset=0";

        try {
            ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean searchAsset() {
        String appendUrl="/v1/get-asset?id=721562614&network=algo";

        ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
        if(response.getStatusCode()==HttpStatus.OK){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean searchAsset(int id) {
        String appendUrl="/v1/get-asset?id="+id+"&network=algo";

        try {
            ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean searchByText() {
        String appendUrl="/v1/search?limit=32&q=sauce&network=algo&showNsfw=false";
        try {
        ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
        if(response.getStatusCode()==HttpStatus.OK){
            return true;
        }else {
            return false;
        }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean searchByText(String appendUrl) {
        try {
            ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean searchImage(String appendUrl) {

        ResponseEntity<String> response = Utils.requestImageSearchURL(appendUrl);
        if(response.getStatusCode()==HttpStatus.OK){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        ResourceImpl resource = new ResourceImpl();
        resource.uploadImage();
    }
}

