- Project using technologies such as Hibernate, Maven, MySQL, RapidAPIs/RestAPIs and Standard Java to create an interface that allows to organise job postings and to place them under a database using Hibernate. Then, this database is queried to turn those job postings into an Excel Sheet, which is then sent to my email address. 

- The project is built using Maven and makes use of libraries such as Apache POI, Apache HTTPComponents, GSON and Angus-Mail to carry out the aforementioned tasks. 

- Essentially, the project makes an HTTP Request to an API Supplied by RapidAPI to receive a JSON File with the Job Postings, which is then turned into a Java POJO using the GSON Library. Then using Hibernate, it introduces those Job Postings into a MySQL Database through a simple Scanner interface. Then, it queries the database to obtain the job postings, places them into a newly-created Excel file, using the Apache POI Library, and then sends it to my email address. 

- This is still a work in progress, as aspects such as testing and improvements to the interface are yet (and currently) to be made.
