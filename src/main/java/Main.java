import PersistenceUnit.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Main {

  private static SessionFactory factory = config().buildSessionFactory();

  protected static Configuration config() {
    Configuration config = new Configuration();
    config.configure(new File("src/main/resources/hibernate.cfg.xml"));
    config.addAnnotatedClass(JobDataEntity.class);
    config.addAnnotatedClass(HighlightsEntity.class);
    config.addAnnotatedClass(PrevEducationEntity.class);
    config.addAnnotatedClass(QualificationsEntity.class);
    config.addAnnotatedClass(BenefitsEntity.class);
    config.addAnnotatedClass(ResponsibilitiesEntity.class);
    config.addAnnotatedClass(PreviousExperienceEntity.class);
    return config;
  }

  protected static void Persist(JobDataEntity jobDataEntity) {
      Session session = factory.openSession();
      Transaction tx = session.beginTransaction();
      session.persist(jobDataEntity);
      session.flush();
      tx.commit();
  }

  protected static void dropEverything() {

    try (SessionFactory factory = config().buildSessionFactory()) {
      Session session = factory.openSession();
      Transaction tx = session.beginTransaction();
      try {
        ArrayList<String> ddl =
            new ArrayList<>(
                new BufferedReader(new FileReader("src/main/resources/Drop.sql"))
                    .lines()
                    .flatMap(x -> Arrays.stream(x.split(";")))
                    .collect(Collectors.toList()));
        for (String sql : ddl) {
          session.createNativeQuery(sql).executeUpdate();
        }
        tx.commit();
      } catch (FileNotFoundException e) {
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        dropEverything();

        try (SessionFactory sf = config().buildSessionFactory()) {

          ArrayList<JobDataEntity> jobs = Requests.parsedJSONProvider();
          for (JobDataEntity job : jobs) {
            Persist(job);
          }

          try (Session session = sf.openSession()) {
            Query<JobDataEntity> query = session.createQuery("FROM PersistenceUnit.JobDataEntity", JobDataEntity.class);
            for (JobDataEntity job : query.getResultList()) {
              System.out.println(job.getEmployer_name());
            }
          }
        } catch (HibernateException e){
          System.out.println(e.getMessage());
        }
  }
}
