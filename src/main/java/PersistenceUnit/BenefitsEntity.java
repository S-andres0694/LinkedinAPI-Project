package PersistenceUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "benefits")
public class BenefitsEntity {
  public BenefitsEntity(){}
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "job_benefits", columnDefinition = "longtext")
  private String benefits;

  public String getBenefits() {return benefits; }

  public void setBenefits(String benefits) { this.benefits = benefits;}

  public BenefitsEntity(String benefits) {
    this.benefits = benefits;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



}
