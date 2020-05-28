package com.letsgeeks.udemy.hibernate.demo;

import com.letsgeeks.udemy.hibernate.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    private static final Logger logger = LogManager.getLogger(CreateStudentDemo.class);
    public static void main(String args[]){
        //create sessionfactory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            // use the session object
            System.out.println("Creating new student object..");
            // create a student object
            Student tempStudent = new Student("Chaitanya_8", "Yeluri", "cyeluri8@gmail.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the  new student object..");
            session.save(tempStudent);
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
