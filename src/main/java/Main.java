import PersistenceUnit.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
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
      @SuppressWarnings("unused")
      org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
      java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
      Session session = factory.openSession();
      Transaction tx = session.beginTransaction();
      session.persist(jobDataEntity);
      session.flush();
      tx.commit();
  }

  protected static void dropEverything() {

      @SuppressWarnings("unused")
      org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
      java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

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

  protected static void Interface(Iterator<JobDataEntity> commander, ArrayList<JobDataEntity> jobs) {
      Scanner scanner = new Scanner(System.in);
      int x = 1;
      while (commander.hasNext()) {
          System.out.println(commander.next());
          System.out.println("Would you like this to be added to the final Database? Press [Y] for Yes, [N] for No, [X] to stop the process or [J] to go to the next page.");
          String userInput = scanner.next();
          if (userInput.equalsIgnoreCase("y")) {
              jobs.add(commander.next());
          }else if(userInput.equalsIgnoreCase("x")){
              break;
          }else if(userInput.equalsIgnoreCase("j")){
              x++;
              Interface(Requests.parsedJSONProvider(x).iterator(), jobs);
          }else if(userInput.equalsIgnoreCase("n")){
              continue;
          } else {
              System.out.println("Unrecognized option. Try again.");
          }
      }
  }

  public static void main(String[] args) {

            dropEverything();
            ArrayList<JobDataEntity> jobs = new ArrayList<>();
            Interface(Requests.parsedJSONProvider(1).iterator(), jobs);

//        try (SessionFactory sf = config().buildSessionFactory()) {
//
//          ArrayList<JobDataEntity> jobs = Requests.parsedJSONProvider();
//          for (JobDataEntity job : jobs) {
//            Persist(job);
//          }
//
//          try (Session session = sf.openSession()) {
//            Query<JobDataEntity> query = session.createQuery("FROM PersistenceUnit.JobDataEntity", JobDataEntity.class);
//            for (JobDataEntity job : query.getResultList()) {
//              System.out.println(job.getEmployer_name());
//            }
//          }
//        } catch (HibernateException e){
//          System.out.println(e.getMessage());
//        }
  }
}
