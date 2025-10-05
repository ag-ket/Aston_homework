package hibernate;

import java.awt.EventQueue;
import java.sql.SQLException;

import org.postgresql.Driver;
import org.tinylog.Logger;

public class Main {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.createNewFrame();
				} catch (Exception e) {
					Logger.error("Произошла ошибка при запуске приложения " + e.getMessage());
				}
			}
		});

	}

}
