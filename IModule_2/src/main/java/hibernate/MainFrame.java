package hibernate;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tinylog.Logger;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.SpringLayout;

public class MainFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DBConnection dbc;
	private List<TheUser> dbList;
	private JPanel selectedPanel;
	private JLabel selectedName;
	private JLabel selectedEmail;
	private JLabel selectedAge;
	

	

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createNewFrame() {
		Logger.info("Приложение запущено");
		dbc = new DBConnection();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane dbPanel = new JScrollPane();
		contentPane.add(dbPanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		dbPanel.setViewportView(contentPanel);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel);
		
		JButton addButton = new JButton("Добавить");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFrame cFrame = new AddFrame();
				cFrame.createNewFrame();
				frame.dispose();
			}
		});
		SpringLayout sl_buttonPanel = new SpringLayout();
		sl_buttonPanel.putConstraint(SpringLayout.NORTH, addButton, 10, SpringLayout.NORTH, buttonPanel);
		sl_buttonPanel.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.WEST, buttonPanel);
		buttonPanel.setLayout(sl_buttonPanel);
		buttonPanel.add(addButton);
		
		JButton changeButton = new JButton("Изменить");
		sl_buttonPanel.putConstraint(SpringLayout.NORTH, changeButton, 15, SpringLayout.SOUTH, addButton);
		sl_buttonPanel.putConstraint(SpringLayout.EAST, changeButton, 0, SpringLayout.EAST, addButton);
		changeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedPanel!=null) {
					
					ChangeFrame cframe = new ChangeFrame(Integer.parseInt(selectedPanel.getName()), selectedName.getText(), selectedEmail.getText(), selectedAge.getText());
					cframe.createNewFrame();
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Запись не выбрана", "Ошибка при изменении записи", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		buttonPanel.add(changeButton);
		
		JButton removeButton = new JButton("Удалить");
		sl_buttonPanel.putConstraint(SpringLayout.NORTH, removeButton, 16, SpringLayout.SOUTH, changeButton);
		sl_buttonPanel.putConstraint(SpringLayout.WEST, removeButton, 0, SpringLayout.WEST, addButton);
		sl_buttonPanel.putConstraint(SpringLayout.EAST, removeButton, 0, SpringLayout.EAST, addButton);
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedPanel!=null)
				{
					dbc.delete(Integer.parseInt(selectedPanel.getName()));
					contentPanel.remove(selectedPanel);
					selectedPanel=null;
					contentPanel.revalidate();
					contentPanel.repaint();
			
				}
				
				else
					JOptionPane.showMessageDialog(null, "Запись не выбрана", "Ошибка при удалении записи", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		buttonPanel.add(removeButton);
		
		JButton logButton = new JButton("Лог-файл");
		sl_buttonPanel.putConstraint(SpringLayout.SOUTH, logButton, -10, SpringLayout.SOUTH, buttonPanel);
		sl_buttonPanel.putConstraint(SpringLayout.EAST, logButton, -10, SpringLayout.EAST, buttonPanel);
		logButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openFile("logs/hiblog.log");
				
			}
		});
		buttonPanel.add(logButton);
		
		dbList = dbc.read();
		
		if (dbList!=null) {
			JPanel headPanel = new JPanel();
			JLabel headNumber = new JLabel("№");
			headNumber.setPreferredSize(new Dimension(30, 30));
			JLabel headName = new JLabel("Имя");
			headName.setPreferredSize(new Dimension(100, 30));
			JLabel headEmail = new JLabel("Email");
			headEmail.setPreferredSize(new Dimension(200, 30));
			JLabel headAge = new JLabel("Возраст");
			headAge.setPreferredSize(new Dimension(80, 30));
			JLabel headCreatedDate = new JLabel("Дата создания");
			headCreatedDate.setPreferredSize(new Dimension(200, 30));
			headPanel.add(headNumber);
			headPanel.add(headName);
			headPanel.add(headEmail);
			headPanel.add(headAge);
			headPanel.add(headCreatedDate);
			contentPanel.add(headPanel);
			for (int i = 0; i < dbList.size(); i++)
			{
				JPanel panel = new JPanel();
				panel.setName(String.valueOf(dbList.get(i).getid()));
				JLabel number = new JLabel();
				number.setText(String.valueOf(i + 1));
				number.setPreferredSize(new Dimension(30, 30));
				JLabel name = new JLabel();
				name.setText(dbList.get(i).getName());
				name.setPreferredSize(new Dimension(100, 30));
				JLabel email = new JLabel();
				email.setText(dbList.get(i).getEmail());
				email.setPreferredSize(new Dimension(200, 30));
				JLabel age = new JLabel();
				age.setText(String.valueOf(dbList.get(i).getAge()));
				age.setPreferredSize(new Dimension(80, 30));
				JLabel createdDate = new JLabel();
				createdDate.setText(dbList.get(i).getCreatedDate());
				createdDate.setPreferredSize(new Dimension(200, 30));
			
				panel.add(number);
				panel.add(name);
				panel.add(email);
				panel.add(age);
				panel.add(createdDate);
				
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if (selectedPanel!=null)
							selectedPanel.setBackground(null);
						selectedPanel = panel;
						selectedName = name;
						selectedEmail = email;
						selectedAge = age;
						
						panel.setBackground(Color.GRAY);
						int panelID = Integer.parseInt(panel.getName());
						
					}
				});
				
				
				contentPanel.add(panel);
				
				contentPanel.revalidate();
				contentPanel.repaint();
				Logger.info("Данные загружены");
			}
			

		}
		else
		{
			JLabel label = new JLabel("База данных пуста");
			contentPanel.add(label);
			contentPanel.revalidate();
			contentPanel.repaint();
			Logger.info("База данных пуста");
			
					
		}

		frame.setVisible(true);
	}
	
	void openFile(String url)
	{
        File file = new File(url); 
        if (file.exists()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при открытии файла", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Файл не существует", "Ошибка при открытии файла", JOptionPane.ERROR_MESSAGE);
        }
	}
}
