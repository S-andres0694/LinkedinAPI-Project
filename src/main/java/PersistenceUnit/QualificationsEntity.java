package PersistenceUnit;

import jakarta.persistence.*;

@Entity
@Table(name = "qualifications")
public class QualificationsEntity {
  public QualificationsEntity() {}
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "qualifications", columnDefinition = "longtext")
  private String qualification;

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public QualificationsEntity(String qualification) {
    this.qualification = qualification;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
