import jakarta.persistence.*;

@Entity
@Table(name = "job_data")
public class JobDataEntity {
  public JobDataEntity(String employer_name, String employer_website, String employer_company_type, String job_publisher, String job_employment_type, String job_title, String job_apply_link, String job_apply_is_direct, String job_description, String job_is_remote, String job_posted_at_timestamp, String job_city, String job_state, String job_country, String job_offer_expiration_timestamp, String job_min_salary, String job_max_salary, String job_salary_currency, String job_salary_period, HighlightsEntity job_highlights, PreviousExperienceEntity job_required_experience, PrevEducationEntity job_required_education) {
    this.employer_name = employer_name;
    this.employer_website = employer_website;
    this.employer_company_type = employer_company_type;
    this.job_publisher = job_publisher;
    this.job_employment_type = job_employment_type;
    this.job_title = job_title;
    this.job_apply_link = job_apply_link;
    this.job_apply_is_direct = job_apply_is_direct;
    this.job_description = job_description;
    this.job_is_remote = job_is_remote;
    this.job_posted_at_timestamp = job_posted_at_timestamp;
    this.job_city = job_city;
    this.job_state = job_state;
    this.job_country = job_country;
    this.job_offer_expiration_timestamp = job_offer_expiration_timestamp;
    this.job_min_salary = job_min_salary;
    this.job_max_salary = job_max_salary;
    this.job_salary_currency = job_salary_currency;
    this.job_salary_period = job_salary_period;
    this.job_highlights = job_highlights;
    this.job_required_experience = job_required_experience;
    this.job_required_education = job_required_education;
  }
  public JobDataEntity() {}
  @Id
  @GeneratedValue (strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private int ID;

  @Column(name = "employer_name")
  private String employer_name;

  @Column(name = "employer_website")
  private String employer_website;

  @Column(name = "employer_company_type")
  private String employer_company_type;

  @Column(name = "job_publisher")
  private String job_publisher;

  @Column(name = "job_employment_type")
  private String job_employment_type;

  @Column(name = "job_title")
  private String job_title;

  @Column(name = "job_apply_link")
  private String job_apply_link;

  @Column(name = "job_apply_is_direct")
  private String job_apply_is_direct;

  @Lob
  @Column(name = "job_description", columnDefinition = "MEDIUMTEXT")
  private String job_description;

  @Column(name = "job_is_remote")
  private String job_is_remote;

  @Column(name = "job_posted_at_timestamp")
  private String job_posted_at_timestamp;

  @Column(name = "job_city")
  private String job_city;

  @Column(name = "job_state")
  private String job_state;

  @Column(name = "job_country")
  private String job_country;

  @Column(name = "job_offer_expiration_timestamp")
  private String job_offer_expiration_timestamp;

  @Column(name = "job_min_salary")
  private String job_min_salary;

  @Column(name = "job_max_salary")
  private String job_max_salary;

  @Column(name = "job_salary_currency")
  private String job_salary_currency;

  @Column(name = "job_salary_period")
  private String job_salary_period;

  @OneToOne(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
      orphanRemoval = true)
  @JoinColumn(name = "previous_experience_entity_id")
  private PreviousExperienceEntity job_required_experience;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "highlights_id")
  private HighlightsEntity job_highlights;

  @OneToOne(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
      orphanRemoval = true)
  @JoinColumn(name = "prev_education_id")
  private PrevEducationEntity job_required_education;

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
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
    return job_apply_is_direct;
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
    return job_is_remote;
  }

  public void setJob_is_remote(String job_is_remote) {
    this.job_is_remote = job_is_remote;
  }

  public String getJob_posted_at_timestamp() {
    return job_posted_at_timestamp;
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
    return job_offer_expiration_timestamp;
  }

  public void setJob_offer_expiration_timestamp(String job_offer_expiration_timestamp) {
    this.job_offer_expiration_timestamp = job_offer_expiration_timestamp;
  }

  public String getJob_min_salary() {
    return job_min_salary;
  }

  public void setJob_min_salary(String job_min_salary) {
    this.job_min_salary = job_min_salary;
  }

  public String getJob_max_salary() {
    return job_max_salary;
  }

  public void setJob_max_salary(String job_max_salary) {
    this.job_max_salary = job_max_salary;
  }

  public String getJob_salary_currency() {
    return job_salary_currency;
  }

  public void setJob_salary_currency(String job_salary_currency) {
    this.job_salary_currency = job_salary_currency;
  }

  public String getJob_salary_period() {
    return job_salary_period;
  }

  public void setJob_salary_period(String job_salary_period) {
    this.job_salary_period = job_salary_period;
  }

  public HighlightsEntity getJob_highlights() {
    return job_highlights;
  }

  public void setJob_highlights(HighlightsEntity job_highlights) {
    this.job_highlights = job_highlights;
  }

  public PreviousExperienceEntity getJob_required_experience() {
    return job_required_experience;
  }

  public void setJob_required_experience(PreviousExperienceEntity job_required_experience) {
    this.job_required_experience = job_required_experience;
  }

  public PrevEducationEntity getJob_required_education() {
    return job_required_education;
  }

  public void setJob_required_education(PrevEducationEntity job_required_education) {
    this.job_required_education = job_required_education;
  }
}
