package hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChangeFrame {

	private JFrame frame;
	private JPanel contentPane;
	private TheUser theUser;
	private DBConnection dbc;
	private JButton endButton;
	private JLabel label_1;
	private JPanel panel;
	private JLabel label_2;
	private JTextField nameText;
	private JTextField emailText;
	private JTextField ageText;
	private JLabel label;
	private String name;
	private String email;
	private String age;
	private int id;
	
	ChangeFrame(int id, String name, String email, String age)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
				
	}

	
	public void createNewFrame() {
		
		dbc = new DBConnection();
		theUser = new TheUser();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Имя");
		contentPane.add(lblNewLabel);
		
		nameText = new JTextField();
		nameText.setText(name);
		nameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!nameText.getText().matches("^[a-zA-Zа-яА-Я]+$"))
				{
					JOptionPane.showMessageDialog(null, "Ввод цифр и символов недопустим", "Ошибка в имени", JOptionPane.ERROR_MESSAGE);
					nameText.setText("");
				}
			}
		});
		contentPane.add(nameText);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		contentPane.add(lblNewLabel_2);
		
		emailText = new JTextField();
		emailText.setText(email);
		emailText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!emailText.getText().matches("^[a-zA-Z0-9-_]+@[a-zA-Z]+.[a-zA-Z]+$"))
				{
					JOptionPane.showMessageDialog(null, "Неверно указан адрес электронной почты", "Ошибка в адресе электронной почты", JOptionPane.ERROR_MESSAGE);
					emailText.setText("");
				}
			}
		});
		contentPane.add(emailText);
		
		JLabel lblNewLabel_1 = new JLabel("Возраст");
		
		contentPane.add(lblNewLabel_1);
		
		ageText = new JTextField();
		ageText.setText(age);
		ageText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!ageText.getText().matches("\\d+"))
				{
					JOptionPane.showMessageDialog(null, "Не является числом", "Ошибка в возрасте", JOptionPane.ERROR_MESSAGE);
					ageText.setText("");
				}
			}
		});
		contentPane.add(ageText);
		
		label_1 = new JLabel("");
		contentPane.add(label_1);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 5, 5));
		
		label_2 = new JLabel("");
		panel.add(label_2);
		
		endButton = new JButton("Изменить");
		endButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!nameText.getText().equals("")||!emailText.getText().equals("")||!ageText.getText().equals(""))
				{
					theUser.setName(nameText.getText());
					theUser.setEmail(emailText.getText());
					theUser.setAge(Integer.parseInt(ageText.getText()));
					
					dbc.update(id, nameText.getText(), emailText.getText(), Integer.parseInt(ageText.getText()));	
				}
				
				MainFrame mFrame = new MainFrame();
				mFrame.createNewFrame();
				frame.dispose();
				
			}
		});
		
		label = new JLabel("");
		panel.add(label);
		panel.add(endButton);
		
		frame.setVisible(true);
	}

}
