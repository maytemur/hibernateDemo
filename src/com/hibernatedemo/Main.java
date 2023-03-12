package com.hibernatedemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.*;
import org.hibernate.service.ServiceRegistry;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();
		//Unit of Work- Bu session işlemi Unit of Work tasarım deseninin uygulanış halidir!!!
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			// HQL ---> Hibernate Query Language
			@SuppressWarnings("unchecked")
			//ASC- Ascending - default böyle normal sıralama
			//DESC- Descending
//			List<City> cities = session.createQuery("from City").getResultList();
//			List<City> cities = session.createQuery("from City sehir ORDER BY sehir.name DESC").getResultList();
//			List<City> cities = session.createQuery("from City a where a.countryCode='TUR'").getResultList();
// burdaki a - alias yani kısaltma c veya başka birşeyde olabilir
//			List<City> cities = session.createQuery("from City a where a.countryCode='TUR' OR a.countryCode='USA'").getResultList();			
//			List<City> cities = session.createQuery("from City a where a.countryCode='TUR' AND a.district='Ankara'").getResultList();
//			List<City> cities = session.createQuery("from City a where a.name LIKE '%kar%'").getResultList();
// isminin içinde kar geçen şehirler - %kar - sonu kar ile biten şehirler kar% ise kar ile başlayanlar
//			List<City> dunya = session.createQuery("select a.countryCode from City a ORDER BY a.countryCode").getResultList();			
//			for (City kodlar : dunya) {
//  				System.out.println(kodlar.getName());
//			}
/*			List<String> cities = session.createQuery("select a.countryCode from City a GROUP BY a.countryCode").getResultList();			
			//burada en sonunda getResultList() yerine sql sorgusu içinde update delete vs işlerini
			//yaparak executeUpdate() komutu ilede bu işlemleri (CRUD) yapabiliriz
			for (String kodlar : cities) {
				System.out.println(kodlar);
			}
*/
			//INSERT işlemi
//			City city= new City();
//			city.setName("Duzce Efsane10");
//			city.setCountryCode("TUR");
//			city.setDistrict("Karadeniz");
//			city.setPopulation(23456789);
//			session.save(city);
			
			//UPDATE işlemi
//			City city=session.get(City.class, 4085);
//			System.out.println(city.getName());
//			city.setPopulation(900000);
//			session.save(city);

			//DELETE
			City city= session.get(City.class, 4085);
			session.delete(city);
			
			session.getTransaction().commit();
			System.out.println("Sehir Guncellendi");
		} finally {
			factory.close();
		}

	}

}
