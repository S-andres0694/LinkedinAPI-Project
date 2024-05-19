import PersistenceUnit.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.net.URIBuilder;

public class Requests{

     /*
           HTTP Request which takes a single parameter at the moment, which is a query.
           To do this, it takes the URI and then after adding the parameters, it is placed
           inside the HTTP Request
         */

    protected static ArrayList<JobDataEntity> parsedJSONProvider(int page){
        HttpGet httpGetObj = new HttpGet("https://jsearch.p.rapidapi.com/search");
        URI uri = null;
        try {
            uri = new URIBuilder(httpGetObj.getUri())
                    .addParameter("query","Software Developer in California")
                    .addParameter("page", String.valueOf(page))
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("There has been a problem parsing through the given URI and it cannot be recognized");
        }
        httpGetObj.setUri(uri);

        //Creation of the necessary headers to get authentication from the API

        Header apiKey = new BasicHeader("X-RapidAPI-Key","66305618d7msh4a97ed0a0c53863p127236jsn61e95b0679a0");
        Header hostKey = new BasicHeader("X-RapidAPI-Host","jsearch.p.rapidapi.com");
        List<Header> headers = new ArrayList<>();
        headers.add(apiKey);
        headers.add(hostKey);

        //Creation of the Client who retrieves the response from the API.

        try(CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(headers).build()) {
            String response = httpClient.execute(httpGetObj, new BasicHttpClientResponseHandler());
            Gson gsonObj = new Gson();
            JobDetails details = (gsonObj.fromJson(response, JobDetails.class));
            ArrayList<JobDataEntity> jobDataEntities = new ArrayList<>();
            for(JobData jobs : details.getData()){
        jobDataEntities.add(
            new JobDataEntity(
                jobs.getEmployer_name(),
                jobs.getEmployer_website(),
                jobs.getEmployer_company_type(),
                jobs.getJob_publisher(),
                jobs.getJob_employment_type(),
                jobs.getJob_title(),
                jobs.getJob_apply_link(),
                jobs.getJob_apply_is_direct(),
                jobs.getJob_description(),
                jobs.getJob_is_remote(),
                jobs.getJob_posted_at_timestamp(),
                jobs.getJob_city(),
                jobs.getJob_state(),
                jobs.getJob_country(),
                jobs.getJob_offer_expiration_timestamp(),
                jobs.getJob_min_salary(),
                jobs.getJob_max_salary(),
                jobs.getJob_salary_currency(), jobs.getJob_salary_period(),
                new HighlightsEntity(new QualificationsEntity(String.join(". ", jobs.getJob_highlights().getQualifications())), new ResponsibilitiesEntity(String.join(". ", jobs.getJob_highlights().getResponsibilities())), new BenefitsEntity(String.join(". ", jobs.getJob_highlights().getBenefits()))), new PreviousExperienceEntity(jobs.getJob_required_experience().getExperience_preferred(), jobs.getJob_required_experience().getRequired_experience_in_months(), jobs.getJob_required_experience().getNo_experience_required()),
                    new PrevEducationEntity(jobs.getJob_required_education().getBachelorsDegree(), jobs.getJob_required_education().getAssociatesDegree(), jobs.getJob_required_education().getHighSchool(), jobs.getJob_required_education().getProfessionalCertification(), jobs.getJob_required_education().getPostgraduateDegree())));
            }
            return jobDataEntities;
        } catch (IOException e) {
            System.out.println("There has been a problem with the connection to the API. Please try again");
        }
        return null;
    }
}
