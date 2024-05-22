package PersistenceUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "prev_education")
public class PrevEducationEntity {

  public PrevEducationEntity() {}

  public PrevEducationEntity(String bachelors_degree, String associates_degree, String high_school, String professional_certification, String postgraduate_degree) {
    this.bachelors_degree = bachelors_degree;
    this.associates_degree = associates_degree;
    this.high_school = high_school;
    this.professional_certification = professional_certification;
    this.postgraduate_degree = postgraduate_degree;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "postgraduate_degree")
  private String postgraduate_degree;

  @Column(name = "professional_certification")
  private String professional_certification;

  @Column(name = "high_school")
  private String high_school;

  @Column(name = "associates_degree")
  private String associates_degree;

  @Column(name = "bachelors_degree")
  private String bachelors_degree;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPostgraduate_degree() {
    return postgraduate_degree;
  }

  public void setPostgraduate_degree(String postgraduate_degree) {
    this.postgraduate_degree = postgraduate_degree;
  }

  public String getProfessional_certification() {
    return professional_certification;
  }

  public void setProfessional_certification(String professional_certification) {
    this.professional_certification = professional_certification;
  }

  public String getHigh_school() {
    return high_school;
  }

  public void setHigh_school(String high_school) {
    this.high_school = high_school;
  }

  public String getAssociates_degree() {
    return associates_degree;
  }

  public void setAssociates_degree(String associates_degree) {
    this.associates_degree = associates_degree;
  }

  public String getBachelors_degree() {
    return bachelors_degree;
  }

  public void setBachelors_degree(String bachelors_degree) {
    this.bachelors_degree = bachelors_degree;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("     Postgraduate Degree: ");
    sb.append(getPostgraduate_degree());
    sb.append("\n");

    sb.append("     Professional Certification: ");
    sb.append(getProfessional_certification());
    sb.append("\n");

    sb.append("     High School: ");
    sb.append(getHigh_school());
    sb.append("\n");

    sb.append("     Associate's Degree: ");
    sb.append(getAssociates_degree());
    sb.append("\n");

    sb.append("     Bachelor's Degree: ");
    sb.append(getBachelors_degree());
    sb.append("\n");

    return sb.toString();
  }

}
