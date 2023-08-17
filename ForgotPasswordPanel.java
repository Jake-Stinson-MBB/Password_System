import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPasswordPanel extends JPanel {
	private JTextField emailField;
	private JTextField usernameField;

	/**
	 * Create the panel.
	 */
	public ForgotPasswordPanel(Database db, JFrame frame) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titleLabel = new JLabel("Reset Password");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 5;
		gbc_titleLabel.insets = new Insets(50, 0, 50, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 1;
		add(titleLabel, gbc_titleLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 200, 5, 5);
		gbc_usernameLabel.gridx = 3;
		gbc_usernameLabel.gridy = 3;
		add(usernameLabel, gbc_usernameLabel);

		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 200);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 4;
		gbc_usernameField.gridy = 3;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 200, 5, 5);
		gbc_emailLabel.gridx = 3;
		gbc_emailLabel.gridy = 4;
		add(emailLabel, gbc_emailLabel);

		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 200);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 4;
		gbc_emailField.gridy = 4;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel inputError = new JLabel("Fill out username/email and a temp password will emailed");
		GridBagConstraints gbc_inputError = new GridBagConstraints();
		gbc_inputError.insets = new Insets(0, 0, 5, 150);
		gbc_inputError.gridx = 4;
		gbc_inputError.gridy = 6;
		add(inputError, gbc_inputError);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbEmail = db.getValueUsertable(usernameField.getText(), "email");
				System.out.println(dbEmail);
				if(dbEmail.equals("")) {
					inputError.setText("Invalid username");
					return;
				}
				if(dbEmail.equals(emailField.getText())) {
					SendEmail emailSender = new SendEmail();
					emailSender.sendEmail(dbEmail, db, usernameField.getText());
					inputError.setText("Temporary Password sent to Email");
					
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				}
				else {
					inputError.setText("Invalid email address");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 200);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SigninPanel signinPanel = new SigninPanel(db, frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
				frame.validate();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 200);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 8;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
