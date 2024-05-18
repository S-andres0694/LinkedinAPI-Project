package PersistenceUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "responsibilities")
public class ResponsibilitiesEntity {
  public ResponsibilitiesEntity() {}
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "responsibilities", columnDefinition = "longtext")
  private String responsibilities;

  public String getResponsibilities() {
    return responsibilities;
  }

  public void setResponsibilities(String responsibilities) {
    this.responsibilities = responsibilities;
  }

  public ResponsibilitiesEntity(String responsibilities) {
    this.responsibilities = responsibilities;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
