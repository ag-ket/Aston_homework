package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class DBConnection {
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private TheCat entity;
	
	void dbCreate() throws SQLException  {
		
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgresqlisevil");
		Statement statement = connection.createStatement();
		
		try  {
			
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname = 'testbase");

        } catch (Exception ex) {
        	try {
				statement.executeUpdate("CREATE DATABASE testbase");
				statement.close();
	            connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	ex.printStackTrace();

        }
		
		
	}
	
	void create(TheCat cat) {

		try {
			
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(cat);
			transaction.commit();
			
		}
		
		catch(HibernateException ex) {
			
			ex.printStackTrace();
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
	
	}
	
	List read() {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			List <TheCat> catlist = session.createNativeQuery("Select * from thecat", TheCat.class).getResultList();
			transaction.commit();
			return catlist;
		}
		
		catch(HibernateException ex){
			
			ex.printStackTrace();
			
		}
		
		finally{
			if (factory!=null)
				factory.close();	
		}
		return null;
	}
	
	void update (int id, String newName, int newAge) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			entity = session.find(TheCat.class, id);
			entity.setName(newName);
			entity.setAge(newAge);
			entity.setSly(newAge);
			entity.setImpudent(entity.getSly());
			transaction.commit();
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
		
	}
	
	void update (int id, String newName) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			entity = session.find(TheCat.class, id);
			entity.setName(newName);
			transaction.commit();
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
		
	}
	
	void update (int id, int newAge) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			entity = session.find(TheCat.class, id);
			entity.setAge(newAge);
			entity.setSly(newAge);
			entity.setImpudent(entity.getSly());
			

			transaction.commit();
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
		
	}
	
	void delete(int id) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			entity = session.find(TheCat.class, id);
			session.remove(entity);
			transaction.commit();
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
		
	}

}
