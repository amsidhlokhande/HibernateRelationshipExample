package com.amsidh.mvc.domain.many.to.many;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {

	public static void main(String[] args) {
		Person p1=new Person(1,"PersonName1","Description1",new Date());
		Person p2=new Person(2,"PersonName2","Description2",new Date());
		Person p3=new Person(3,"PersonName3","Description3",new Date());

		Address address1=new Address(1,"Maharashtra");
		Address address2=new Address(2,"Karnataka");
		Address address3=new Address(3,"Keral");
		
		p1.getAddresses().add(address1);
		p1.getAddresses().add(address2);
		
		p2.getAddresses().add(address2);
		p2.getAddresses().add(address3);
		
		p3.getAddresses().add(address3);
		
		
		address1.getPersons().add(p1);
		
		address2.getPersons().add(p1);
		address2.getPersons().add(p2);
		
		address3.getPersons().add(p2);
		address3.getPersons().add(p3);
		
		
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		
		SessionFactory sessionFactory=configure.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
		
	}

}
