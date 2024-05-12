import java.util.ArrayList;

public class JobDetails {

  private String status;
  private Parameters parameters;
  private ArrayList<JobData> data;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public void setParameters(String query, int page, int num_pages) {
    this.parameters.setQuery(query);
    this.parameters.setPage(page);
    this.parameters.setNum_pages(num_pages);
  }

  public void setData(
      String employer_name,
      String employer_website,
      String employer_company_type,
      String job_publisher,
      String job_employment_type,
      String job_title,
      String job_apply_link,
      String job_apply_is_direct,
      String job_description,
      String job_is_remote,
      String job_posted_at_timestamp,
      String job_city,
      String job_state,
      String job_country,
      String job_offer_expiration_timestamp) {

    JobData data1 = new JobData();
    data1.setEmployer_name(employer_name);
    data1.setEmployer_website(employer_website);
    data1.setEmployer_company_type(employer_company_type);
    data1.setJob_publisher(job_publisher);
    data1.setJob_employment_type(job_employment_type);
    data1.setJob_title(job_title);
    data1.setJob_apply_link(job_apply_link);
    data1.setJob_apply_is_direct(job_apply_is_direct);
    data1.setJob_description(job_description);
    data1.setJob_is_remote(job_is_remote);
    data1.setJob_posted_at_timestamp(job_posted_at_timestamp);
    data1.setJob_city(job_city);
    data1.setJob_state(job_state);
    data1.setJob_country(job_country);
    data1.setJob_offer_expiration_timestamp(job_offer_expiration_timestamp);
    data.add(data1);
  }

  public ArrayList<JobData> getData() {
    return data;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Request Status: " + status + "\n");
    stringBuilder.append("Request Internal Parameters:" + "\n" + getParameters() + "\n");
    stringBuilder.append("Job Data:" + "\n" + data.get(0));
    return stringBuilder.toString();
  }
}
