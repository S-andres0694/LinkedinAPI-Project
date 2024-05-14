import java.sql.Timestamp;
import java.util.Date;

public class JobData {

  private String employer_name,
      employer_website,
      employer_company_type,
      job_publisher,
      job_employment_type,
      job_title,
      job_apply_link,
      job_apply_is_direct,
      job_description,
      job_is_remote,
      job_posted_at_timestamp,
      job_city,
      job_state,
      job_country,
      job_offer_expiration_timestamp;

  private String job_min_salary;
  private String job_max_salary;
  private String job_salary_currency;
  private String job_salary_period;

  private PreviousExperience job_required_experience;
  private PrevEducation job_required_education;

  public PrevEducation getJob_required_education() {
    return job_required_education;
  }

  public void setEducationalQualifications(
      String postgraduate_degree,
      String professional_certification,
      String high_school,
      String associates_degree,
      String bachelors_degree) {
    job_required_education.setPostgraduate_degree(postgraduate_degree);
    job_required_education.setProfessional_certification(professional_certification);
    job_required_education.setHigh_school(high_school);
    job_required_education.setAssociates_degree(associates_degree);
    job_required_education.setBachelors_degree(bachelors_degree);
  }

  public PreviousExperience getJob_required_experience() {
    return job_required_experience;
  }

  public void setJob_required_experience(
      String no_experience_required,
      String required_experience_in_months,
      String experience_preferred) {
    job_required_experience.setRequired_experience_in_months(required_experience_in_months);
    job_required_experience.setExperience_preferred(experience_preferred);
    job_required_experience.setNo_experience_required(no_experience_required);
  }

  public String getEmployer_name() {
    return employer_name;
  }

  public void setEmployer_name(String employer_name) {
    this.employer_name = employer_name;
  }

  public String getEmployer_website() {
    return employer_website;
  }

  public void setEmployer_website(String employer_website) {
    this.employer_website = employer_website;
  }

  public String getEmployer_company_type() {
    return employer_company_type;
  }

  public void setEmployer_company_type(String employer_company_type) {
    this.employer_company_type = employer_company_type;
  }

  public String getJob_publisher() {
    return job_publisher;
  }

  public void setJob_publisher(String job_publisher) {
    this.job_publisher = job_publisher;
  }

  public String getJob_employment_type() {
    return job_employment_type;
  }

  public void setJob_employment_type(String job_employment_type) {
    this.job_employment_type = job_employment_type;
  }

  public String getJob_title() {
    return job_title;
  }

  public void setJob_title(String job_title) {
    this.job_title = job_title;
  }

  public String getJob_apply_link() {
    return job_apply_link;
  }

  public void setJob_apply_link(String job_apply_link) {
    this.job_apply_link = job_apply_link;
  }

  public String getJob_apply_is_direct() {
    if (job_apply_is_direct.equals("true")) {
      return "Yes!";
    } else return "No!";
  }

  public void setJob_apply_is_direct(String job_apply_is_direct) {
    this.job_apply_is_direct = job_apply_is_direct;
  }

  public String getJob_description() {
    return job_description;
  }

  public void setJob_description(String job_description) {
    this.job_description = job_description;
  }

  public String getJob_is_remote() {
    if (job_is_remote.equals("true")) {
      return "Yes!";
    }
    return "No!";
  }

  public void setJob_is_remote(String job_is_remote) {
    this.job_is_remote = job_is_remote;
  }

  public String getJob_posted_at_timestamp() {
    if (job_posted_at_timestamp != null) {
      Timestamp tms = new Timestamp(Long.parseLong(job_posted_at_timestamp));
      Date date = new Date(tms.getTime());
      return date.toString();
    } else return "Not given";
  }

  public void setJob_posted_at_timestamp(String job_posted_at_timestamp) {
    this.job_posted_at_timestamp = job_posted_at_timestamp;
  }

  public String getJob_city() {
    return job_city;
  }

  public void setJob_city(String job_city) {
    this.job_city = job_city;
  }

  public String getJob_state() {
    return job_state;
  }

  public void setJob_state(String job_state) {
    this.job_state = job_state;
  }

  public String getJob_country() {
    return job_country;
  }

  public void setJob_country(String job_country) {
    this.job_country = job_country;
  }

  public String getJob_offer_expiration_timestamp() {
    if (job_offer_expiration_timestamp != null) {
      Timestamp tms = new Timestamp(Long.parseLong(job_offer_expiration_timestamp));
      Date date = new Date(tms.getTime());
      return date.toString();
    } else return "Not Specified";
  }

  public void setJob_offer_expiration_timestamp(String job_offer_expiration_timestamp) {
    this.job_offer_expiration_timestamp = job_offer_expiration_timestamp;
  }

  public String getJob_max_salary() {
    if (job_max_salary == null) {
      return "Not Specified";
    } else {
      return job_max_salary;
    }
  }

  public String getJob_min_salary() {
    if (job_min_salary == null) {
      return "Not Specified";
    } else {
      return job_min_salary;
    }
  }

  public String getJob_salary_currency() {
    if (job_salary_currency == null) {
      return "Not Specified";
    } else {
      return job_salary_currency;
    }
  }

  public String getJob_salary_period() {
    if (job_salary_period == null) {
      return "Not Specified";
    } else {
      return job_salary_period;
    }
  }

  public void setJob_max_salary(String job_max_salary) {
    this.job_max_salary = job_max_salary;
  }

  public void setJob_min_salary(String job_min_salary) {
    this.job_min_salary = job_min_salary;
  }

  public void setJob_salary_currency(String job_salary_currency) {
    this.job_salary_currency = job_salary_currency;
  }

  public void setJob_salary_period(String job_salary_period) {
    this.job_salary_period = job_salary_period;
  }

  // region toString() -- generated by BoB the Builder of Beans

  @Override
  public String toString() {
    return new StringBuilder()
        .append("     Name of the Employer: " + getEmployer_name() + "\n")
        .append("     Employer Website: " + getEmployer_website() + "\n")
        .append("     Employer Company Type: " + getEmployer_company_type() + "\n")
        .append("     Job Publisher: " + getJob_publisher() + "\n")
        .append("     Employment Type: " + getJob_employment_type() + "\n")
        .append("     Official Title: " + getJob_title() + "\n")
        .append("     Job Application Link: " + getJob_apply_link() + "\n")
        .append("     Is the job application direct? " + getJob_apply_is_direct() + "\n")
        .append("     Description of the Role: " + getJob_description() + "\n")
        .append("     Is the job remote? " + getJob_is_remote() + "\n")
        .append("     When was the job posted? " + getJob_posted_at_timestamp() + "\n")
        .append("     City: " + getJob_city() + "\n")
        .append("     State: " + getJob_state() + "\n")
        .append("     Country: " + getJob_country() + "\n")
        .append(
            "     When does the job offer expire? " + getJob_offer_expiration_timestamp() + "\n")
        .append(job_required_experience.toString() + "\n")
        .append(job_required_education.toString() + "\n")
        .append(
            "Minimum salary disclosed: "
                + getJob_min_salary()
                + " Maximum salary disclosed: "
                + getJob_max_salary()
                + "\n")
        .append(
            "Currency in which the salary is going to be paid: " + getJob_salary_currency() + "\n")
        .append(
            "Period in which the salary is going to be paid in: " + getJob_salary_period() + "\n")
        .toString();
  }
}
