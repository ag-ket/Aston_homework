package hibernate;

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
import org.tinylog.Logger;


public class DBConnection {
	
	SessionFactory factory;
	Session session;
	Transaction transaction;
	TheUser entity;
	
	void dbCreate() throws SQLException  {
		
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgresqlisevil");;
		Statement statement = connection.createStatement();
		
		try  {
			
            ResultSet resultSet = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname = 'hiberbase");

        } catch (Exception ex) {
        	try {
				statement.executeUpdate("CREATE DATABASE hiberbase");
				statement.close();
	            connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
            Logger.error("Ошибка при создании базы данных: " + ex.getMessage());
        }
		
		
	}
	
	void create(TheUser theUser) {

		try {
			
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(theUser);
			transaction.commit();
			Logger.info("Данные добавлены");
			
		}
		
		catch(HibernateException ex) {
			Logger.error("Ошибка при создании записи: " + ex.getMessage());
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
			List <TheUser> userlist = session.createNativeQuery("Select * from theuser", TheUser.class).getResultList();
			transaction.commit();
			return userlist;
		}
		
		catch(HibernateException ex){
			try {
				dbCreate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Logger.error("Ошибка при чтении данных: " + ex.getMessage());
			
		}
		
		finally{
			if (factory!=null)
				factory.close();	
		}
		return null;
	}
	
	void update (int id, String newName, String newEmail, int newAge) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			entity = session.find(TheUser.class, id);
			entity.setName(newName);
			entity.setEmail(newEmail);
			entity.setAge(newAge);

			transaction.commit();
			Logger.info("Данные изменены");
		}
		
		catch(Exception ex) {
			Logger.error("Ошибка при изменении записи: " + ex.getMessage());
			
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
			entity = session.find(TheUser.class, id);
			session.remove(entity);
			transaction.commit();
			Logger.info("Данные удалены");
		}
		
		catch(Exception ex) {
			Logger.error("Ошибка при удалении записи: " + ex.getMessage());
			
		}
		
		finally {
			if (factory!=null)
				factory.close();	
		}
		
	}

}
