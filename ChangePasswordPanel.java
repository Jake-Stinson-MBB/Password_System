import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordPanel extends JPanel {
	private JTextField usernameField;
	private JTextField currentPasswordField;
	private JTextField newPasswordField;
	private JTextField confirmNewPasswordField;

	/**
	 * Create the panel.
	 */
	public ChangePasswordPanel(Database db, JFrame frame) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_4 = new JLabel("Enter info:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 5;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel usernameLabel= new JLabel("Username:");
		GridBagConstraints gbc_usernameLabel= new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 3;
		gbc_usernameLabel.gridy = 3;
		add(usernameLabel, gbc_usernameLabel);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 4;
		gbc_usernameField.gridy = 3;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Current Password:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		currentPasswordField = new JTextField();
		GridBagConstraints gbc_currentPasswordField = new GridBagConstraints();
		gbc_currentPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_currentPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_currentPasswordField.gridx = 4;
		gbc_currentPasswordField.gridy = 4;
		add(currentPasswordField, gbc_currentPasswordField);
		currentPasswordField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		newPasswordField = new JTextField();
		GridBagConstraints gbc_newPasswordField = new GridBagConstraints();
		gbc_newPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_newPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newPasswordField.gridx = 4;
		gbc_newPasswordField.gridy = 5;
		add(newPasswordField, gbc_newPasswordField);
		newPasswordField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm New Password:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 6;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		confirmNewPasswordField = new JTextField();
		GridBagConstraints gbc_confirmNewPasswordField = new GridBagConstraints();
		gbc_confirmNewPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_confirmNewPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmNewPasswordField.gridx = 4;
		gbc_confirmNewPasswordField.gridy = 6;
		add(confirmNewPasswordField, gbc_confirmNewPasswordField);
		confirmNewPasswordField.setColumns(10);
		
		JLabel inputError = new JLabel("");
		GridBagConstraints gbc_inputError = new GridBagConstraints();
		gbc_inputError.insets = new Insets(0, 0, 5, 0);
		gbc_inputError.gridx = 4;
		gbc_inputError.gridy = 7;
		add(inputError, gbc_inputError);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().equals("")) {
					inputError.setText("Username is blank or taken");
					return;
				}
				if (!db.userValidation(usernameField.getText(), currentPasswordField.getText())) {
					inputError.setText("Current password invalid");
					return;
				}
				if (!db.passwordStrengthCheck(newPasswordField.getText())) {
					inputError.setText("Password is not strong enough");
					return;
				}
				if (!confirmNewPasswordField.getText().equals(newPasswordField.getText())) {
					inputError.setText("Passwords are not the same");
					return;
				}
				if (db.updateValueUsertable(usernameField.getText(), "password", newPasswordField.getText())) {
					inputError.setText("Unable to update password");
					return;
				} else {
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				}
			}

		});
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SigninPanel signinPanel = new SigninPanel(db, frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
				frame.validate();
			}
		});

		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 4;
		gbc_cancelButton.gridy = 9;
		add(cancelButton, gbc_cancelButton);
		

	}

}
