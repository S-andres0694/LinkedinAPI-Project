import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Requests {

    public static void main(String[] args) throws Exception{

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsearch.p.rapidapi.com/search?query=PythondeveloperinTexas%2C%20USA&page=1&num_pages=1"))
                .header("X-RapidAPI-Key", "14c022e6c8msh6f5cee1caad4bacp16bc3cjsn350654d077a9")
                .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JobDetails jobs = gson.fromJson(response.body(), JobDetails.class);
        System.out.println(jobs);
        System.out.println("hE");
    }

}
