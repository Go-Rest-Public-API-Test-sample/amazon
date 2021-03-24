package am.mouse.interview.restfulapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ClientExample {
    private final static String BEARER_TOKEN_PREFIX = "Bearer ";
    private final static String AUTHORIZATION_KEY = "Authorization";
    private final static int TIMOUT = 10;
    private static final String DESTINATION_FQDN = "";
    private static final Gson gson = new Gson();
    private static final String ENDPOINT = "";

    private final String bearerToken;
    private final HttpClient httpClient;


    public ClientExample(String bearerToken) {
        this.bearerToken = BEARER_TOKEN_PREFIX + bearerToken;
        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(TIMOUT))
                .build();
    }


    public ApiResponse<Object, Object> postExample(Object user) throws IOException, InterruptedException {
        String json = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DESTINATION_FQDN + ENDPOINT))
                .header("Content-Type", "application/json")
                .header(AUTHORIZATION_KEY, this.bearerToken)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        return getApiResponse(request);
    }

    public ApiResponse<Object, Object> getExample() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DESTINATION_FQDN + ENDPOINT))
                .header("Content-Type", "application/json")
                .header(AUTHORIZATION_KEY, this.bearerToken)
                .GET()
                .build();
        return getApiResponse(request);
    }

    private ApiResponse<Object, Object> getApiResponse(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Type type = new TypeToken<ApiResponse<Object, Object>>() {
        }.getType();
        return gson.fromJson(response.body(), type);

    }

}
