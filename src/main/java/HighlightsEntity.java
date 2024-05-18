import jakarta.persistence.*;

@Entity
@Table(name = "highlights")
public class HighlightsEntity {

  public HighlightsEntity(QualificationsEntity qualificationsEntity, ResponsibilitiesEntity responsibilitiesEntity, BenefitsEntity benefits) {
    QualificationsEntity = qualificationsEntity;
    ResponsibilitiesEntity = responsibilitiesEntity;
    Benefits = benefits;
  }

  public HighlightsEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToOne(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
      orphanRemoval = true)
  @JoinColumn(name = "qualifications_id")
  private QualificationsEntity QualificationsEntity;

  @OneToOne(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
      orphanRemoval = true)
  @JoinColumn(name = "responsibilities_id")
  private ResponsibilitiesEntity ResponsibilitiesEntity;

  @OneToOne(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH},
      orphanRemoval = true)
  @JoinColumn(name = "benefits_id")
  private BenefitsEntity Benefits;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public QualificationsEntity getQualifications() {
    return QualificationsEntity;
  }

  public void setQualifications(QualificationsEntity QualificationsEntity) {
    this.QualificationsEntity = QualificationsEntity;
  }

  public ResponsibilitiesEntity getResponsibilities() {
    return ResponsibilitiesEntity;
  }

  public void setResponsibilities(ResponsibilitiesEntity ResponsibilitiesEntity) {
    this.ResponsibilitiesEntity = ResponsibilitiesEntity;
  }

  public BenefitsEntity getBenefits() {
    return Benefits;
  }

  public void setBenefits(BenefitsEntity Benefits) {
    this.Benefits = Benefits;
  }
}
