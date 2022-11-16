package zestbloom.gql;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApacheHttpClient {
    public static HttpResponse callGraphQLService(String url, String query) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);

        HttpEntity stringEntity = new StringEntity(query, ContentType.APPLICATION_JSON);
        request.setEntity(stringEntity);
        return client.execute(request);
    }
}
