import jakarta.persistence.*;

@Entity
@Table(name = "previous_experience_entity")
public class PreviousExperienceEntity {

  public PreviousExperienceEntity(String experience_preferred, String required_experience_in_months, String no_experience_required) {
    this.experience_preferred = experience_preferred;
    this.required_experience_in_months = required_experience_in_months;
    this.no_experience_required = no_experience_required;
  }

  public PreviousExperienceEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "no_experience_required")
  private String no_experience_required;

  @Column(name = "required_experience_in_months")
  private String required_experience_in_months;

  @Column(name = "experience_preferred")
  private String experience_preferred;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNo_experience_required() {
    return no_experience_required;
  }

  public void setNo_experience_required(String no_experience_required) {
    this.no_experience_required = no_experience_required;
  }

  public String getRequired_experience_in_months() {
    return required_experience_in_months;
  }

  public void setRequired_experience_in_months(String required_experience_in_months) {
    this.required_experience_in_months = required_experience_in_months;
  }

  public String getExperience_preferred() {
    return experience_preferred;
  }

  public void setExperience_preferred(String experience_preferred) {
    this.experience_preferred = experience_preferred;
  }
}
