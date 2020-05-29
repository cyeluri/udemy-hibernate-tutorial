package com.letsgeeks.udemy.hibernate.demo;

import com.letsgeeks.udemy.hibernate.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    private static final Logger logger = LogManager.getLogger(QueryStudentDemo.class);
    public static void main(String args[]){
        //create sessionfactory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            // Query the students
            List<Student> theStudents = session.createQuery("from Student").list();
            // Display the students
            displayStudents(theStudents);
            //Query students : LastName = "Yeluri"
            theStudents = session.createQuery("from Student s where s.lastName='yeluri'").list();
            // Display the students
            displayStudents(theStudents);

            //Query students : LastName = "Yeluri or FirstName=chaitu"
            theStudents = session.createQuery("from Student s where s.lastName='yeluri' or s.firstName='chaitu'").list();
            // Display the students
            displayStudents(theStudents);


            //Query students : email like gmail.com"
            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            // Display the students
            displayStudents(theStudents);

            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            logger.debug("This is a debug message");
            logger.info("This is an info message");
            logger.warn("This is a warn message");
            logger.error("This is an error message");
            logger.fatal("This is a fatal message");
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student student: theStudents) {
            System.out.println(student.toString());
        }
    }
}
