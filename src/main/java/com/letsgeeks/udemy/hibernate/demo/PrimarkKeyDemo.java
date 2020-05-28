package com.letsgeeks.udemy.hibernate.demo;

import com.letsgeeks.udemy.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimarkKeyDemo {
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
            System.out.println("Creating 3 new student object..");
            // create a student object
            Student tempStudent = new Student("Chaitu", "Yeluri", "cyeluri1@gmail.com");
            Student tempStudent2 = new Student("Shourya", "Yeluri", "adith1@gmail.com");

            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the  new student objects..");
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            factory.close();
        }
    }
}
