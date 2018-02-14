package com.revature.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.revature.bankapp.Bank;
import com.revature.bankapp.BankUser;
import com.revature.dao.BankUserDAO;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class GUI {
	
	AtmScreen atm =new AtmScreen();
	BankUser bu = new BankUser();
	Bank b = Bank.getSingleton();
	BankUserDAO bd = new BankUserDAO();
	private JFrame frame;
	private JPanel mainMenu;
	private JPanel loginScreen;
	private JTextField userField;
	private JPasswordField passwordField;
	private int counter = 3;
	private JLabel lblNumberOfTries;
	private JTextField newUser;
	private JPasswordField newPw;
	private JTextField balance;
	private JPanel signUp;
	private JTextField dUser;
	private JPasswordField dPw;
	private JPanel delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setResizable(false);
		mainMenu = new JPanel();
		frame.getContentPane().add(mainMenu, "name_153628768460816");
		mainMenu.setLayout(null);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginScreen.setVisible(true);
				mainMenu.setVisible(false);
				counter=3;
			}
		});

		JLabel lblNewLabel = new JLabel("Welcome to SlickRick's Financial Institution");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 61, 319, 46);
		mainMenu.add(lblNewLabel);
		btnNewButton.setBounds(85, 155, 89, 23);
		mainMenu.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(184, 155, 89, 23);
		mainMenu.add(btnNewButton_1);

		JButton btnDeleteAccount = new JButton("Delete account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.setVisible(true);
				mainMenu.setVisible(false);
				counter=3;
			}
		});
		btnDeleteAccount.setBounds(283, 155, 121, 23);
		mainMenu.add(btnDeleteAccount);

		loginScreen = new JPanel();
		frame.getContentPane().add(loginScreen, "name_153660450087607");
		loginScreen.setLayout(null);

		userField = new JTextField();

		userField.setBounds(211, 86, 148, 20);
		loginScreen.add(userField);
		userField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(211, 129, 148, 20);
		loginScreen.add(passwordField);

		JLabel lblEnterUsername = new JLabel("Enter username:");
		lblEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsername.setBounds(106, 89, 95, 14);
		loginScreen.add(lblEnterUsername);

		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPassword.setBounds(106, 132, 95, 14);
		loginScreen.add(lblEnterPassword);

		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = userField.getText();
				String pw = String.valueOf(passwordField.getPassword());
				if (!b.checkUsername(input) || !b.checkPassword(pw)) {
					if (counter == 0) {
						JOptionPane.showMessageDialog(frame, "You are locked out. Returning to main menu.",
								"Out of attempts", JOptionPane.ERROR_MESSAGE);
						mainMenu.setVisible(true);
						lblNumberOfTries.setVisible(false);
						loginScreen.setVisible(false);
						counter = 3;
					} else if (counter != 0) {
						JOptionPane.showMessageDialog(frame,
								"Either your username or password did not match our records", "Invalid credentials",
								JOptionPane.WARNING_MESSAGE);
						lblNumberOfTries.setText("Number of tries left: " + counter);
						counter--;
						lblNumberOfTries.setVisible(true);
					}
				}
				if (b.checkUsername(input) && b.checkPassword(pw)) {
					JOptionPane.showMessageDialog(frame, "Logged in!\n Please look at the console to use the atm.", "Success", JOptionPane.INFORMATION_MESSAGE);
					userField.setText("");
					passwordField.setText("");
					loginScreen.setVisible(false);
					mainMenu.setVisible(true);
					lblNumberOfTries.setVisible(false);
					counter = 3;
					atm.prompt();
				}
			}
		});
		btnNewButton_2.setBounds(270, 181, 89, 23);
		loginScreen.add(btnNewButton_2);

		lblNumberOfTries = new JLabel();
		lblNumberOfTries.setForeground(Color.RED);
		lblNumberOfTries.setBounds(106, 185, 130, 14);
		lblNumberOfTries.setVisible(false);
		loginScreen.add(lblNumberOfTries);

		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userField.setText("");
				passwordField.setText("");
				mainMenu.setVisible(true);
				lblNumberOfTries.setVisible(false);
				loginScreen.setVisible(false);
			}
		});
		button_1.setBounds(10, 11, 46, 23);
		loginScreen.add(button_1);

		signUp = new JPanel();
		frame.getContentPane().add(signUp, "name_159512201518791");
		signUp.setLayout(null);

		newUser = new JTextField();
		newUser.setColumns(10);
		newUser.setBounds(262, 63, 148, 20);
		signUp.add(newUser);

		newPw = new JPasswordField();
		newPw.setBounds(262, 106, 148, 20);
		signUp.add(newPw);

		JLabel label = new JLabel("Enter your new username:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(35, 66, 217, 14);
		signUp.add(label);

		JLabel label_1 = new JLabel("Enter your new password:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(35, 109, 217, 14);
		signUp.add(label_1);

		JButton button = new JButton("Sign up");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (b.checkUsername(newUser.getText())) {
					JOptionPane.showMessageDialog(frame,
							"There seems to be an account connected to the information provided.\n"
									+ "If you already have an account please log in",
							"Existing account", JOptionPane.WARNING_MESSAGE);
					newPw.setText("");
					balance.setText("0.05");
				}else if(String.valueOf(newPw.getPassword()).equals("")|| newUser.getText().equals("")){
					JOptionPane.showMessageDialog(frame,
							"Username or password cannot be null.",
							"Empty credentials", JOptionPane.WARNING_MESSAGE);
					newUser.setText("");
					newPw.setText("");
					balance.setText("0.05");
				}
				else {
					try {
						if(Double.parseDouble(balance.getText())<=0) {
							JOptionPane.showMessageDialog(frame,
									"Please enter a number higher than 0. Try inputing a valid balance!",
									"Not a valid balance", JOptionPane.ERROR_MESSAGE);
							balance.setText("0.05");
							newUser.setText("");
							newPw.setText("");
						}
						else {
							bu = new BankUser(newUser.getText(), String.valueOf(newPw.getPassword()),
									Double.parseDouble(balance.getText()));
							JOptionPane.showMessageDialog(frame, "Your account has been created. Now returning to main menu.", "Success", JOptionPane.INFORMATION_MESSAGE);
							mainMenu.setVisible(true);
							balance.setText("0.05");
							newUser.setText("");
							newPw.setText("");
							signUp.setVisible(false);
							b.getList().add(bu);
							bd.save(bu);
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(frame,
								"Oops, it seems you do not know how to input numbers or just wanna crash my app!\n"
										+ "Try inputing a valid balance!",
								"Not a valid balance", JOptionPane.ERROR_MESSAGE);
						newUser.setText("");
						newPw.setText("");
						balance.setText("0.05");
					} 
					

				}

			}
		});
		button.setBounds(321, 207, 89, 23);
		signUp.add(button);

		JLabel label_2 = new JLabel("Enter your starting balance:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(35, 153, 217, 14);
		signUp.add(label_2);

		balance = new JTextField();
		balance.setHorizontalAlignment(SwingConstants.RIGHT);
		balance.setText("0.05");
		balance.setBounds(262, 150, 148, 20);
		signUp.add(balance);
		balance.setColumns(10);

		JButton btnback = new JButton("<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp.setVisible(false);
				balance.setText("0.05");
				newUser.setText("");
				newPw.setText("");
				mainMenu.setVisible(true);

			}
		});
		btnback.setBounds(10, 11, 46, 23);
		signUp.add(btnback);

		delete = new JPanel();
		frame.getContentPane().add(delete, "name_165345030974573");
		delete.setLayout(null);

		dUser = new JTextField();
		dUser.setColumns(10);
		dUser.setBounds(219, 87, 148, 20);
		delete.add(dUser);

		dPw = new JPasswordField();
		dPw.setBounds(219, 130, 148, 20);
		delete.add(dPw);

		JLabel label_3 = new JLabel("Enter username:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(114, 90, 95, 14);
		delete.add(label_3);

		JLabel label_4 = new JLabel("Enter password:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(114, 133, 95, 14);
		delete.add(label_4);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = dUser.getText();
				String pw = String.valueOf(dPw.getPassword());

				if (counter == 0) {
					JOptionPane.showMessageDialog(frame,
							"Sorry no account found with those credentials.\n Returning to main menu.",
							"Out of attempts", JOptionPane.ERROR_MESSAGE);
					mainMenu.setVisible(true);
					delete.setVisible(false);
					dUser.setText("");
					dPw.setText("");
					counter = 3;
				}else if(counter!=0 && (!b.checkUsername(input) || !b.checkPassword(pw))){
					JOptionPane.showMessageDialog(frame, "No account found. Please try again", "Invalid credentials",
							JOptionPane.WARNING_MESSAGE);
					counter--;
				}
				if (b.checkUsername(input) && b.checkPassword(pw)) {
					JOptionPane.showMessageDialog(frame, "You are no longer a member of this bank.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					bd.delete(b.getUser());
					b.getList().remove(b.getUser());
					dUser.setText("");
					dPw.setText("");
					mainMenu.setVisible(true);
					delete.setVisible(false);
					counter = 3;
				} 
			}
		});
		btnDelete.setBounds(278, 185, 89, 23);
		delete.add(btnDelete);

		JButton button_2 = new JButton("<");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				delete.setVisible(false);
				dUser.setText("");
				dPw.setText("");
			}
		});
		button_2.setBounds(10, 11, 46, 23);
		delete.add(button_2);
		
		
	}
}
