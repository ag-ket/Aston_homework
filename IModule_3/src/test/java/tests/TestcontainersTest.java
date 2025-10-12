package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import test.TheCat;

import org.testcontainers.containers.PostgreSQLContainer;

@Testcontainers
class TestcontainersTest {
	private SessionFactory factory;
	Transaction transaction;
	
	
	@Container
	private static PostgreSQLContainer<?> dbcontainer = new PostgreSQLContainer<>("postgres")
	.withDatabaseName("testdb")
	.withUsername("user")
	.withPassword("password");
	
	 public static SessionFactory getSessionFactory() {
		 Configuration configuration = new Configuration();
		 configuration.setProperty("hibernate.connection.url", dbcontainer.getJdbcUrl());
	     configuration.setProperty("hibernate.connection.username", dbcontainer.getUsername());
	     configuration.setProperty("hibernate.connection.password", dbcontainer.getPassword());
	     configuration.setProperty("hibernate.hbm2ddl.auto", "update");
	     configuration.addAnnotatedClass(TheCat.class); 
	     
	     return configuration.buildSessionFactory();
	       
	    }
	
	 @BeforeEach
	    void setup() {
	        factory = getSessionFactory();
	    }

	    @Test
	    void saveAndRead() {
	    	
	        Session session = factory.openSession();
	        transaction = session.beginTransaction();

	        TheCat cat = new TheCat ("Злюка", 3);
	        session.persist(cat);

	        transaction.commit();
	        session.close();
	       
	        session = factory.openSession();
	        transaction = session.beginTransaction();
	        List <TheCat> catlist = session.createNativeQuery("Select * from thecat", TheCat.class).getResultList();
	        transaction.commit();
	        assertEquals("Злюка", catlist.get(0).getName());
	        session.close();
	    }

	    

	

}
