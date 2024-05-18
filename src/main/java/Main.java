import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main {

    protected static Configuration config(){
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

    protected static void Persist(JobDataEntity jobDataEntity){
        try(SessionFactory factory = config().buildSessionFactory()){
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(jobDataEntity);
            session.flush();
            tx.commit();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){

        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        try (SessionFactory sf = config().buildSessionFactory()) {

            ArrayList<JobDataEntity> jobs = Requests.parsedJSONProvider();
            for (JobDataEntity job : jobs) {
                Persist(job);
            }

            try (Session session = sf.openSession()) {
                    Query<JobDataEntity> query = session.createQuery("FROM JobDataEntity", JobDataEntity.class);
                    for(JobDataEntity job : query.getResultList()){
                        System.out.println(job.getEmployer_name());
                    }
                } catch (HibernateException e) {
                    System.out.println(e.getMessage());
                }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }


    }

}
