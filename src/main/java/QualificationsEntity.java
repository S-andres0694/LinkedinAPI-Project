import jakarta.persistence.*;

@Entity
@Table(name = "qualifications")
public class QualificationsEntity {
  public QualificationsEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
