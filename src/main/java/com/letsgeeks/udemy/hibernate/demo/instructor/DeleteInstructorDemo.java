package com.letsgeeks.udemy.hibernate.demo.instructor;

import com.letsgeeks.udemy.hibernate.entity.Instructor;
import com.letsgeeks.udemy.hibernate.entity.InstructorDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDemo {
    private static final Logger logger = LogManager.getLogger(DeleteInstructorDemo.class);
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
            logger.info("Delete Instructor object !!");
            // Delete the instructor
            int instId = 4;
            // start a transaction
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, instId);
            logger.info("Instructor found");
            // Delete the instructory object
            logger.info("Delete Successfully !!!..");
            session.delete(instructor);
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
