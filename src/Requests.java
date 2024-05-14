import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.net.URIBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Requests {

    protected JobDetails parsedJSONProvider(){
        HttpGet httpGetObj = new HttpGet("https://jsearch.p.rapidapi.com/search");
        URI uri = null;
        try {
            uri = new URIBuilder(httpGetObj.getUri())
                    .addParameter("query","Software Developer in California")
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("There has been a problem parsing through the given URI and it cannot be recognized");
        }
        httpGetObj.setUri(uri);

        //Creation of the necessary headers to get authentication from the API

        Header apiKey = new BasicHeader("X-RapidAPI-Key","14c022e6c8msh6f5cee1caad4bacp16bc3cjsn350654d077a9");
        Header hostKey = new BasicHeader("X-RapidAPI-Host","jsearch.p.rapidapi.com");
        List<Header> headers = new ArrayList<>();
        headers.add(apiKey);
        headers.add(hostKey);

        //Creation of the Client who retrieves the response from the API.

        try(CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(headers).build()) {
            String response = httpClient.execute(httpGetObj, new BasicHttpClientResponseHandler());
            Gson gsonObj = new Gson();
            return (gsonObj.fromJson(response, JobDetails.class));
        } catch (IOException e) {
            System.out.println("There has been a problem with the connection to the API. Please try again");
        }
        return null;
    }

    public static void main(String[] args) {

        /*
           HTTP Request which takes a single parameter at the moment, which is a query.
           To do this, it takes the URI and then after adding the parameters, it is placed
           inside the HTTP Request
         */



    }

}
