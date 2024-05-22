import PersistenceUnit.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.hibernate.query.NativeQuery;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
import javax.activation.*;



public class Main {

    private static SessionFactory factory = config().buildSessionFactory();

    protected static void sendEmail(String filePath){

        String receiver = "sebasandres0694@gmail.com";
        String sender = "sebasandres0694@gmail.com";
        String host = "127.0.0.1";
        int port = 8080;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", String.valueOf(port));
        javax.mail.Session session = Session.getDefaultInstance(properties);

        try{

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject( "Job Listings bro!");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Job Listings have been acquired. Check the attached Excel Table");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            String filename = "JobPostings.xlsx";
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Message has been sent successfully");

    } catch (javax.mail.MessagingException mex) {
            System.out.println("Exception was caught: " + mex.getMessage());
        }

    }

    protected static void writeHeaderLine(XSSFSheet sheet){

        XSSFRow headerRow = sheet.createRow(0);

        Cell cell = headerRow.createCell(0);
        cell.setCellValue("Employer Name");

        cell = headerRow.createCell(1);
        cell.setCellValue("Employer Website");

        cell = headerRow.createCell(2);
        cell.setCellValue("Employer Company Type");

        cell = headerRow.createCell(3);
        cell.setCellValue("Job Publisher");

        cell = headerRow.createCell(4);
        cell.setCellValue("Employment Type");

        cell = headerRow.createCell(5);
        cell.setCellValue("Job Title");

        cell = headerRow.createCell(6);
        cell.setCellValue("Job Apply Link");

        cell = headerRow.createCell(7);
        cell.setCellValue("Is the job direct?");

        cell = headerRow.createCell(8);
        cell.setCellValue("Job Description");

        cell = headerRow.createCell(9);
        cell.setCellValue("Job Posting Timestamp");

        cell = headerRow.createCell(10);
        cell.setCellValue("Job City");

        cell = headerRow.createCell(11);
        cell.setCellValue("Job State");

        cell = headerRow.createCell(12);
        cell.setCellValue("Job Country");

        cell = headerRow.createCell(13);
        cell.setCellValue("Job Offer Expiration Timestamp");

        cell = headerRow.createCell(14);
        cell.setCellValue("Min Salary");

        cell = headerRow.createCell(15);
        cell.setCellValue("Max Salary");

        cell = headerRow.createCell(16);
        cell.setCellValue("Currency");

        cell = headerRow.createCell(17);
        cell.setCellValue("Salary Period");

        cell = headerRow.createCell(18);
        cell.setCellValue("Qualifications");

        cell = headerRow.createCell(19);
        cell.setCellValue("Responsibilities");

        cell = headerRow.createCell(20);
        cell.setCellValue("Benefits");

        cell = headerRow.createCell(21);
        cell.setCellValue("Experience Preferred");

        cell = headerRow.createCell(22);
        cell.setCellValue("Required Experience");

        cell = headerRow.createCell(23);
        cell.setCellValue("No Experience Required");

        cell = headerRow.createCell(24);
        cell.setCellValue("Requirement for Bachelor's Degree");

        cell = headerRow.createCell(25);
        cell.setCellValue("Requirement for Associates Degree");

        cell = headerRow.createCell(26);
        cell.setCellValue("Requirement for High School Degree");

        cell = headerRow.createCell(27);
        cell.setCellValue("Requirement for Professional Cert");

        cell = headerRow.createCell(28);
        cell.setCellValue("Requirement for PhD");

    }

    protected static void writeData(List<JobDataEntity> finalJobs, XSSFWorkbook workbook, XSSFSheet sheet){
        int rowCount = 1;
        Iterator<JobDataEntity> commander = finalJobs.iterator();

        while(commander.hasNext()){

            JobDataEntity jobData = commander.next();

            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;

            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getEmployer_name());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getEmployer_website());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getEmployer_company_type());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_publisher());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_employment_type());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_title());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_apply_link());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_apply_is_direct());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_description());

            cell = row.createCell(columnCount++);
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy--MM--dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(jobData.getJob_posted_at_timestamp());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_city());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_state());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_country());

            cell = row.createCell(columnCount++);
            cellStyle = workbook.createCellStyle();
            creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy--MM--dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(jobData.getJob_offer_expiration_timestamp());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_min_salary());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_max_salary());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_salary_currency());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_salary_period());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_highlights().getQualifications().getQualification());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_highlights().getResponsibilities().getResponsibilities());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_highlights().getBenefits().getBenefits());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_experience().getExperience_preferred());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_experience().getRequired_experience_in_months());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_experience().getNo_experience_required());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_education().getBachelors_degree());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_education().getAssociates_degree());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_education().getHigh_school());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_education().getProfessional_certification());

            cell = row.createCell(columnCount++);
            cell.setCellValue(jobData.getJob_required_education().getPostgraduate_degree());

        }
    }

    protected static void export(List<JobDataEntity> results){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Job Postings");
        writeHeaderLine(sheet);
        writeData(results, workbook, sheet);
        try (FileOutputStream file = new FileOutputStream("JobPostings.xlsx")){
            workbook.write(file);
            System.out.println("Sheet has been created");
        } catch (IOException e) {
            System.out.println("There has been a problem while writing to the file");
        } finally{
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
        org.hibernate.Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(jobDataEntity);
        session.flush();
        tx.commit();
    }

    protected static void dropEverything() {

        try (SessionFactory factory = config().buildSessionFactory()) {
            org.hibernate.Session session = factory.openSession();
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
                System.out.println("The Deletion script has not been found");
            }
        }
    }

    protected static void Interface(Iterator<JobDataEntity> commander, ArrayList<JobDataEntity> jobs) {
        Scanner scanner = new Scanner(System.in);
        int pageCounter = 1;
        int postingCounter = 1;
        JobDataEntity job = commander.next();
        while (commander.hasNext()) {
            System.out.println(job);
            System.out.println("Would you like this to be added to the final Database? Press [Y] for Yes, [N] for No, [X] to stop the process or [J] to go to the next page.");
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("y")) {
                jobs.add(job);
                postingCounter++;
            }else if(userInput.equalsIgnoreCase("x")){
                break;
            }else if(userInput.equalsIgnoreCase("j")){
                pageCounter++;
                Interface(Requests.parsedJSONProvider(pageCounter).iterator(), jobs);
            }else if(userInput.equalsIgnoreCase("n")){
                continue;
            } else if (userInput.equalsIgnoreCase("n") && postingCounter == 10){
                Interface(Requests.parsedJSONProvider(pageCounter).iterator(), jobs);
            }
            job = commander.next();
        }
    }

    public static void main(String[] args) {

//        @SuppressWarnings("unused")
//        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
//        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//        dropEverything();
//        ArrayList<JobDataEntity> jobs = new ArrayList<>();
//        Interface(Requests.parsedJSONProvider(1).iterator(), jobs);
//
//        try (SessionFactory sf = config().buildSessionFactory()) {
//            for (JobDataEntity job : jobs) {
//                Persist(job);
//            }
//            try (org.hibernate.Session session = sf.openSession()) {
//                NativeQuery<JobDataEntity> query = session.createNativeQuery("SELECT * FROM job_data", JobDataEntity.class);
//                export(query.getResultList());
//            }
//        } catch (HibernateException e){
//            System.out.println(e.getMessage());
//        }
        File excelFile = new File("JobPostings.xlsx");
        sendEmail(excelFile.getPath());
    }
}

