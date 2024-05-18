import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        Configuration config = new Configuration();
        config.configure(new File("src/main/resources/hibernate.cfg.xml"));
        config.addAnnotatedClass(JobDataEntity.class);
        config.addAnnotatedClass(HighlightsEntity.class);
        config.addAnnotatedClass(PrevEducationEntity.class);
        config.addAnnotatedClass(QualificationsEntity.class);
        config.addAnnotatedClass(BenefitsEntity.class);
        config.addAnnotatedClass(ResponsibilitiesEntity.class);
        config.addAnnotatedClass(PreviousExperienceEntity.class);
        try (SessionFactory sessionFactory = config.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ArrayList<JobDataEntity> jobs = Requests.parsedJSONProvider();
            for (JobDataEntity job : jobs) {
                session.persist(job);
            }
            transaction.commit();
            session.flush();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    try (SessionFactory sessionFactory = config.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Query<JobDataEntity> query = session.createQuery("FROM JobDataEntity", JobDataEntity.class);
            for(JobDataEntity job : query.getResultList()){
                System.out.println(job.getEmployer_name());
            }
            session.flush();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }

}
