package com.amsidh.mvc.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.amsidh.mvc.domain.UserDetails;
import com.amsidh.mvc.domain.Vehicle;

public class MainApp {

	public static void main(String[] args) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties())
				.build();

		SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);

		UserDetails userDetails1 = new UserDetails(1, "Amsidh Lokhande");
		
		Vehicle v1 = new Vehicle(1, "CB-Shine");
		userDetails1.getVehicle().add(v1);
		
		Vehicle v2 = new Vehicle(2, "Wagon-R");
		userDetails1.getVehicle().add(v2);

		Vehicle v3 = new Vehicle(3, "TVS-Zesta");
		userDetails1.getVehicle().add(v3);
		

		v1.setUserDetail(userDetails1);
		v2.setUserDetail(userDetails1);
		//v3.setUserDetail(userDetails1);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(userDetails1);
        session.save(v3);		
		
        Vehicle v4 = (Vehicle) session.get(Vehicle.class, v3.getVehicleId());
        System.out.println(v4.getUserDetail());
		session.flush();
		session.getTransaction().commit();
		session.close();

		sessionFactory.close();
	}

}
