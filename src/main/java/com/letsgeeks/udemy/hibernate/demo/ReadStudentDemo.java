package com.letsgeeks.udemy.hibernate.demo;

import com.letsgeeks.udemy.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
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
            Student tempStudent = new Student("John", "Pappa", "pappa@gmail.com");
            System.out.println("Creating student object  :"+tempStudent.toString());
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println("Saving the  new student object..");
            session.save(tempStudent);
            System.out.println("Retriving the  new student object with ID :"+tempStudent.getId());
            Student retriveStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("The retrived Student is : " + retriveStudent.toString());
            // commit the transaction
            session.getTransaction().commit();
        }catch (Exception exc) {
            exc.printStackTrace();
        }finally {
            factory.close();
        }

    }
}
