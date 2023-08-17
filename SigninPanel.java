import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SigninPanel extends JPanel {

	private JTextField passwordField;
	private JTextField usernameField;

	public SigninPanel(Database db, JFrame frame) {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gbl_panel);

		JLabel welcomeLabel = new JLabel("Welcome to Diabetes Data");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 7;
		gbc_welcomeLabel.insets = new Insets(50, 0, 50, 0);
		gbc_welcomeLabel.gridx = 0;
		gbc_welcomeLabel.gridy = 1;
		add(welcomeLabel, gbc_welcomeLabel);

		JLabel errorLabel = new JLabel("          ");
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.insets = new Insets(10, 0, 10, 200);
		gbc_errorLabel.gridx = 5;
		gbc_errorLabel.gridy = 11;
		add(errorLabel, gbc_errorLabel);

		JLabel usernameLabel = new JLabel("Username:");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 200, 5, 5);
		gbc_usernameLabel.gridx = 4;
		gbc_usernameLabel.gridy = 5;
		add(usernameLabel, gbc_usernameLabel);

		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 200);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridwidth = 2;
		gbc_usernameField.gridx = 5;
		gbc_usernameField.gridy = 5;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);

		JButton forgotPasswordButton = new JButton("Forgot Password");
		GridBagConstraints gbc_forgotPasswordButton = new GridBagConstraints();
		gbc_forgotPasswordButton.insets = new Insets(0, 200, 0, 5);
		gbc_forgotPasswordButton.gridx = 4;
		gbc_forgotPasswordButton.gridy = 12;

		forgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPasswordPanel forgotPasswordPanel = new ForgotPasswordPanel(db, frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(forgotPasswordPanel, BorderLayout.CENTER);
				frame.validate();
			}
		});

		add(forgotPasswordButton, gbc_forgotPasswordButton);

		JLabel passwordLabel = new JLabel("Password:");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 200, 5, 5);
		gbc_passwordLabel.gridx = 4;
		gbc_passwordLabel.gridy = 9;
		add(passwordLabel, gbc_passwordLabel);

		passwordField = new JTextField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 200);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 9;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);

		JButton signinButton = new JButton("Sign in");
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (db.userValidation(usernameField.getText(), passwordField.getText())) {
					QuestionsPanel questionsPanel = new QuestionsPanel(db, usernameField.getText(), frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(questionsPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					errorLabel.setText("Invalid Username / Password");
				}
			}
		});
		GridBagConstraints gbc_signinButton = new GridBagConstraints();
		gbc_signinButton.insets = new Insets(0, 0, 0, 200);
		gbc_signinButton.gridx = 6;
		gbc_signinButton.gridy = 12;
		add(signinButton, gbc_signinButton);

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPanel registerPanel = new RegisterPanel(db, frame, "");
				frame.getContentPane().removeAll();
				frame.getContentPane().add(registerPanel, BorderLayout.CENTER);
				frame.validate();

			}
		});

		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(0, 0, 0, 5);
		gbc_registerButton.gridx = 5;
		gbc_registerButton.gridy = 12;
		add(registerButton, gbc_registerButton);

	}
}
