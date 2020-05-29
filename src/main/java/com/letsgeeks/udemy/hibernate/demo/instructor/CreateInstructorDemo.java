package com.letsgeeks.udemy.hibernate.demo.instructor;

import com.letsgeeks.udemy.hibernate.entity.Instructor;
import com.letsgeeks.udemy.hibernate.entity.InstructorDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    private static final Logger logger = LogManager.getLogger(CreateInstructorDemo.class);
    public static void main(String args[]){
        //create sessionfactory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg2.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            // use the session object
            System.out.println("Creating new Instructor object !!");
            // create a student object
            Instructor instructor = new Instructor("Test-instructor", "Test-lastname", "test-instructor@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube/test-instructor", "Luv2 code !!!");
            instructor.setInstructor_detail_id(instructorDetail);
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the  new Instructor !!!..");
            session.save(instructor);
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
