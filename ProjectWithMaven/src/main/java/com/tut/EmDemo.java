package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure(); 
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student1 = new Student();
        student1.setId(10);
        student1.setCity("Noida");
        student1.setName("pdsingh");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("6 months");
        
        student1.setCerti(certificate);
        
        Student student2 = new Student();
        student2.setId(11);
        student2.setCity("Gwalior");
        student2.setName("pd kushwah");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("python");
        certificate1.setDuration("2 months");
        
        student2.setCerti(certificate1);
        
        Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(student1);
            session.save(student2);
            transaction.commit();
            System.out.println("Students saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
