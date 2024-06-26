package com.tut;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project is started" );
       
      Configuration cfg = new Configuration();
      cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
       
        
        Student st = new Student();
        st.setId(104);
        st.setName("uttam");
        st.setCity("pura");
        System.out.println(st);
        
        Address ad = new Address();
        ad.setAddressId(104);
        ad.setStreet(" colony");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setX(123.12);
        ad.setAddedDate(new Date());
        ad.setImage(null);
        System.out.println(ad);
        
        
        Session session = factory.getCurrentSession();
        
      Transaction tx =  session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
       // session.getTransaction().commit();
        
        session.close();
        System.out.println("work is Done");
    }
}
