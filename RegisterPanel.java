import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegisterPanel extends JPanel {

	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField confirmPasswordField;
	private JTextField fullNameField;
	private JTextField emailField;
	private JTextField phoneNumberField;
	private JTextField DoBField;
	private JTextField q1Custom;
	private JTextField answer1Field;
	private JTextField q2Custom;
	private JTextField answer2Field;
	private JTextField q3Custom;
	private JTextField answer3Field;

	/**
	 * Create the panel.
	 */

	public RegisterPanel(Database db, JFrame frame, String username) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel registerUserLabel = new JLabel("");
		if (username.isBlank()) {
			registerUserLabel.setText("Register User");
		} else {
			registerUserLabel.setText("Update User");
		}
		registerUserLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_registerUserLabel = new GridBagConstraints();
		gbc_registerUserLabel.gridwidth = 4;
		gbc_registerUserLabel.insets = new Insets(50, 0, 50, 0);
		gbc_registerUserLabel.gridx = 5;
		gbc_registerUserLabel.gridy = 1;
		add(registerUserLabel, gbc_registerUserLabel);

		JLabel usernameLabel = new JLabel("Username:");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.gridwidth = 5;
		gbc_usernameLabel.anchor = GridBagConstraints.EAST;
		gbc_usernameLabel.insets = new Insets(0, 100, 5, 5);
		gbc_usernameLabel.gridx = 2;
		gbc_usernameLabel.gridy = 3;
		add(usernameLabel, gbc_usernameLabel);

		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 7;
		gbc_usernameField.gridy = 3;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);

		if (!username.isBlank()) {
			usernameField.setText(username);
			usernameField.setEditable(false);
		}

		JLabel passwordLabel = new JLabel("Password");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.gridwidth = 5;
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 100, 5, 5);
		gbc_passwordLabel.gridx = 2;
		gbc_passwordLabel.gridy = 4;
		add(passwordLabel, gbc_passwordLabel);

		passwordField = new JTextField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 7;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);

		if (!username.isBlank()) {
			passwordField.setText(db.getValueUsertable(username, "password"));
		}

		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		GridBagConstraints gbc_confirmPasswordLabel = new GridBagConstraints();
		gbc_confirmPasswordLabel.gridwidth = 5;
		gbc_confirmPasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_confirmPasswordLabel.insets = new Insets(0, 100, 5, 5);
		gbc_confirmPasswordLabel.gridx = 2;
		gbc_confirmPasswordLabel.gridy = 5;
		add(confirmPasswordLabel, gbc_confirmPasswordLabel);

		confirmPasswordField = new JTextField();
		GridBagConstraints gbc_confirmPasswordField = new GridBagConstraints();
		gbc_confirmPasswordField.insets = new Insets(0, 0, 5, 5);
		gbc_confirmPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmPasswordField.gridx = 7;
		gbc_confirmPasswordField.gridy = 5;
		add(confirmPasswordField, gbc_confirmPasswordField);
		confirmPasswordField.setColumns(10);

		if (!username.isBlank()) {
			confirmPasswordField.setText(db.getValueUsertable(username, "password"));
		}

		JLabel fullNameLabel = new JLabel("Full Name:");
		GridBagConstraints gbc_fullNameLabel = new GridBagConstraints();
		gbc_fullNameLabel.gridwidth = 5;
		gbc_fullNameLabel.anchor = GridBagConstraints.EAST;
		gbc_fullNameLabel.insets = new Insets(0, 100, 5, 5);
		gbc_fullNameLabel.gridx = 2;
		gbc_fullNameLabel.gridy = 6;
		add(fullNameLabel, gbc_fullNameLabel);

		fullNameField = new JTextField();
		GridBagConstraints gbc_fullNameField = new GridBagConstraints();
		gbc_fullNameField.insets = new Insets(0, 0, 5, 5);
		gbc_fullNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullNameField.gridx = 7;
		gbc_fullNameField.gridy = 6;
		add(fullNameField, gbc_fullNameField);
		fullNameField.setColumns(10);

		if (!username.isBlank()) {
			fullNameField.setText(db.getValueUsertable(username, "fullname"));
		}

		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.gridwidth = 5;
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 100, 5, 5);
		gbc_emailLabel.gridx = 2;
		gbc_emailLabel.gridy = 7;
		add(emailLabel, gbc_emailLabel);

		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 7;
		gbc_emailField.gridy = 7;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);

		if (!username.isBlank()) {
			emailField.setText(db.getValueUsertable(username, "email"));
		}

		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
		gbc_phoneNumberLabel.gridwidth = 5;
		gbc_phoneNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneNumberLabel.insets = new Insets(0, 100, 5, 5);
		gbc_phoneNumberLabel.gridx = 2;
		gbc_phoneNumberLabel.gridy = 8;
		add(phoneNumberLabel, gbc_phoneNumberLabel);

		phoneNumberField = new JTextField();
		GridBagConstraints gbc_phoneNumberField = new GridBagConstraints();
		gbc_phoneNumberField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNumberField.gridx = 7;
		gbc_phoneNumberField.gridy = 8;
		add(phoneNumberField, gbc_phoneNumberField);
		phoneNumberField.setColumns(10);

		if (!username.isBlank()) {
			phoneNumberField.setText(db.getValueUsertable(username, "phonenumber"));
		}

		JLabel DoBLabel = new JLabel("Date of Birth:");
		GridBagConstraints gbc_DoBLabel = new GridBagConstraints();
		gbc_DoBLabel.gridwidth = 5;
		gbc_DoBLabel.anchor = GridBagConstraints.EAST;
		gbc_DoBLabel.insets = new Insets(0, 100, 5, 5);
		gbc_DoBLabel.gridx = 2;
		gbc_DoBLabel.gridy = 9;
		add(DoBLabel, gbc_DoBLabel);

		DoBField = new JTextField();
		GridBagConstraints gbc_DoBField = new GridBagConstraints();
		gbc_DoBField.insets = new Insets(0, 0, 5, 5);
		gbc_DoBField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DoBField.gridx = 7;
		gbc_DoBField.gridy = 9;
		add(DoBField, gbc_DoBField);
		DoBField.setColumns(10);

		if (!username.isBlank()) {
			DoBField.setText(db.getValueUsertable(username, "dateofbirth"));
		}
		ArrayList<String> potentialQuestions = new ArrayList<String>();

		potentialQuestions.add("What is the name of a college you applied to but didnt attend?");
		potentialQuestions.add("What was the name of the first school you remember attending?");
		potentialQuestions.add("Where was the destination of your most memorable school field trip?");
		potentialQuestions.add("What was your maths teachers surname in your 8th year of school?");
		potentialQuestions.add("What was the name of your first stuffed toy?");
		potentialQuestions.add("What was your driving instructors first name?");

		if (!username.isBlank()) {
			potentialQuestions.add(db.getValueUsertable(username, "question1"));
			potentialQuestions.add(db.getValueUsertable(username, "question2"));
			potentialQuestions.add(db.getValueUsertable(username, "question3"));
		}

		JLabel q1Label = new JLabel("Question 1:");
		q1Label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_q1Label = new GridBagConstraints();
		gbc_q1Label.gridwidth = 2;
		gbc_q1Label.anchor = GridBagConstraints.EAST;
		gbc_q1Label.insets = new Insets(0, 100, 5, 5);
		gbc_q1Label.gridx = 5;
		gbc_q1Label.gridy = 11;
		add(q1Label, gbc_q1Label);

		JComboBox q1ComboBox = new JComboBox(potentialQuestions.toArray());
		if (!username.isBlank()) {
			q1ComboBox.setSelectedIndex(6);
		}
		GridBagConstraints gbc_q1ComboBox = new GridBagConstraints();
		gbc_q1ComboBox.insets = new Insets(0, 0, 5, 100);
		gbc_q1ComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_q1ComboBox.gridx = 7;
		gbc_q1ComboBox.gridy = 11;
		add(q1ComboBox, gbc_q1ComboBox);

		q1Custom = new JTextField();
		GridBagConstraints gbc_q1Custom = new GridBagConstraints();
		gbc_q1Custom.insets = new Insets(0, 0, 5, 100);
		gbc_q1Custom.fill = GridBagConstraints.HORIZONTAL;
		gbc_q1Custom.gridx = 7;
		gbc_q1Custom.gridy = 11;
		add(q1Custom, gbc_q1Custom);
		q1Custom.setColumns(10);
		q1Custom.setVisible(false);

		JLabel answer1Label = new JLabel("Answer 1:");
		answer1Label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_answer1Label = new GridBagConstraints();
		gbc_answer1Label.gridwidth = 5;
		gbc_answer1Label.anchor = GridBagConstraints.EAST;
		gbc_answer1Label.insets = new Insets(0, 100, 5, 5);
		gbc_answer1Label.gridx = 2;
		gbc_answer1Label.gridy = 12;
		add(answer1Label, gbc_answer1Label);

		answer1Field = new JTextField();
		GridBagConstraints gbc_answer1Field = new GridBagConstraints();
		gbc_answer1Field.insets = new Insets(0, 0, 5, 5);
		gbc_answer1Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer1Field.gridx = 7;
		gbc_answer1Field.gridy = 12;
		add(answer1Field, gbc_answer1Field);
		answer1Field.setColumns(10);
		if (!username.isBlank()) {
			answer1Field.setText(db.getValueUsertable(username, "answer1"));
		}

		JLabel q2Label = new JLabel("Question 2:");
		GridBagConstraints gbc_q2Label = new GridBagConstraints();
		gbc_q2Label.gridwidth = 5;
		gbc_q2Label.anchor = GridBagConstraints.EAST;
		gbc_q2Label.insets = new Insets(0, 100, 5, 5);
		gbc_q2Label.gridx = 2;
		gbc_q2Label.gridy = 13;
		add(q2Label, gbc_q2Label);

		JComboBox q2ComboBox = new JComboBox(potentialQuestions.toArray());
		if (!username.isBlank()) {
			q2ComboBox.setSelectedIndex(7);
		}
		GridBagConstraints gbc_q2ComboBox = new GridBagConstraints();
		gbc_q2ComboBox.insets = new Insets(0, 0, 5, 100);
		gbc_q2ComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_q2ComboBox.gridx = 7;
		gbc_q2ComboBox.gridy = 13;
		add(q2ComboBox, gbc_q2ComboBox);

		q2Custom = new JTextField();
		GridBagConstraints gbc_q2Custom = new GridBagConstraints();
		gbc_q2Custom.insets = new Insets(0, 0, 5, 100);
		gbc_q2Custom.fill = GridBagConstraints.HORIZONTAL;
		gbc_q2Custom.gridx = 7;
		gbc_q2Custom.gridy = 13;
		add(q2Custom, gbc_q2Custom);
		q2Custom.setColumns(10);
		q2Custom.setVisible(false);

		JLabel answer2Label = new JLabel("Answer 2:");
		answer2Label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_answer2Label = new GridBagConstraints();
		gbc_answer2Label.gridwidth = 5;
		gbc_answer2Label.anchor = GridBagConstraints.EAST;
		gbc_answer2Label.insets = new Insets(0, 100, 5, 5);
		gbc_answer2Label.gridx = 2;
		gbc_answer2Label.gridy = 14;
		add(answer2Label, gbc_answer2Label);

		answer2Field = new JTextField();
		GridBagConstraints gbc_answer2Field = new GridBagConstraints();
		gbc_answer2Field.insets = new Insets(0, 0, 5, 5);
		gbc_answer2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer2Field.gridx = 7;
		gbc_answer2Field.gridy = 14;
		add(answer2Field, gbc_answer2Field);
		answer2Field.setColumns(10);
		if (!username.isBlank()) {
			answer2Field.setText(db.getValueUsertable(username, "answer2"));
		}

		JLabel q3Label = new JLabel("Question 3:");
		GridBagConstraints gbc_q3Label = new GridBagConstraints();
		gbc_q3Label.gridwidth = 5;
		gbc_q3Label.anchor = GridBagConstraints.EAST;
		gbc_q3Label.insets = new Insets(0, 100, 5, 5);
		gbc_q3Label.gridx = 2;
		gbc_q3Label.gridy = 15;
		add(q3Label, gbc_q3Label);

		JComboBox q3ComboBox = new JComboBox(potentialQuestions.toArray());
		if (!username.isBlank()) {
			q3ComboBox.setSelectedIndex(8);
		}
		GridBagConstraints gbc_q3ComboBox = new GridBagConstraints();
		gbc_q3ComboBox.insets = new Insets(0, 0, 5, 100);
		gbc_q3ComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_q3ComboBox.gridx = 7;
		gbc_q3ComboBox.gridy = 15;
		add(q3ComboBox, gbc_q3ComboBox);

		q3Custom = new JTextField();
		GridBagConstraints gbc_q3Custom = new GridBagConstraints();
		gbc_q3Custom.insets = new Insets(0, 0, 5, 100);
		gbc_q3Custom.fill = GridBagConstraints.HORIZONTAL;
		gbc_q3Custom.gridx = 7;
		gbc_q3Custom.gridy = 15;
		add(q3Custom, gbc_q3Custom);
		q3Custom.setColumns(10);
		q3Custom.setVisible(false);

		JLabel answer3Label = new JLabel("Answer 3:");
		GridBagConstraints gbc_answer3Label = new GridBagConstraints();
		gbc_answer3Label.gridwidth = 5;
		gbc_answer3Label.anchor = GridBagConstraints.EAST;
		gbc_answer3Label.insets = new Insets(0, 100, 5, 5);
		gbc_answer3Label.gridx = 2;
		gbc_answer3Label.gridy = 16;
		add(answer3Label, gbc_answer3Label);

		answer3Field = new JTextField();
		GridBagConstraints gbc_answer3Field = new GridBagConstraints();
		gbc_answer3Field.insets = new Insets(0, 0, 5, 5);
		gbc_answer3Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer3Field.gridx = 7;
		gbc_answer3Field.gridy = 16;
		add(answer3Field, gbc_answer3Field);
		answer3Field.setColumns(10);
		if (!username.isBlank()) {
			answer3Field.setText(db.getValueUsertable(username, "answer3"));
		}

		JLabel InputError = new JLabel();
		InputError.setText("");
		GridBagConstraints gbc_InputError = new GridBagConstraints();
		gbc_InputError.insets = new Insets(0, 0, 5, 5);
		gbc_InputError.gridx = 7;
		gbc_InputError.gridy = 17;
		add(InputError, gbc_InputError);

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check password strength
				// check confirmed password matches password
				if (usernameField.getText().isBlank()) {
					InputError.setText("Username is blank");
					return;
				}
				if (username.isBlank() && usernameField.getText().equals(db.getValueUsertable(usernameField.getText(), "username"))) {
					InputError.setText(("Username: " + usernameField.getText() + " is taken"));
					return;
				}
				if (!db.passwordStrengthCheck(passwordField.getText())) {
					InputError.setText("Password is not strong enough");
					return;
				}
				if (emailField.getText().isBlank()) {
					InputError.setText("Email is blank");
					return;
				}
				if (!confirmPasswordField.getText().equals(passwordField.getText())) {
					InputError.setText("Passwords are not the same");
					return;
				}
				if (answer1Field.getText().isBlank()) {
					InputError.setText("Answer 1 is blank");
					return;
				}
				if (answer2Field.getText().isBlank()) {
					InputError.setText("Answer 2 is blank");
					return;
				}
				if (answer3Field.getText().isBlank()) {
					InputError.setText("Answer 3 is blank");
					return;
				}
				String q1String = (q1ComboBox.isVisible()) ? q1ComboBox.getSelectedItem().toString()
						: q1Custom.getText();
				String q2String = (q2ComboBox.isVisible()) ? q2ComboBox.getSelectedItem().toString()
						: q2Custom.getText();
				String q3String = (q3ComboBox.isVisible()) ? q3ComboBox.getSelectedItem().toString()
						: q3Custom.getText();
				if (username.isBlank()) {
					db.createUser(usernameField.getText(), passwordField.getText(), fullNameField.getText(),
							emailField.getText(), phoneNumberField.getText(), DoBField.getText(), q1String,
							answer1Field.getText(), q2String, answer2Field.getText(), q3String, answer3Field.getText(),
							"unknown");
				} else {
					db.updateUser(usernameField.getText(), passwordField.getText(), fullNameField.getText(),
							emailField.getText(), phoneNumberField.getText(), DoBField.getText(), q1String,
							answer1Field.getText(), q2String, answer2Field.getText(), q3String, answer3Field.getText(),
							"unknown");
				}

				PicturePanel picturePanel = new PicturePanel(db, usernameField.getText(), frame, true);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(picturePanel, BorderLayout.CENTER);
				frame.validate();
			}
		});

		JButton btnNewButton = new JButton("Custom Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (q1Custom.isVisible()) {
					q1ComboBox.setVisible(true);
					q1Custom.setVisible(false);
				} else {
					q1ComboBox.setVisible(false);
					q1Custom.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 100);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 11;
		add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Custom Question");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (q2Custom.isVisible()) {
					q2ComboBox.setVisible(true);
					q2Custom.setVisible(false);
				} else {
					q2ComboBox.setVisible(false);
					q2Custom.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 100);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 13;
		add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Custom Question");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (q3Custom.isVisible()) {
					q3ComboBox.setVisible(true);
					q3Custom.setVisible(false);
				} else {
					q3ComboBox.setVisible(false);
					q3Custom.setVisible(true);
				}
			}

		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 100);
		gbc_btnNewButton_2.gridx = 8;
		gbc_btnNewButton_2.gridy = 15;
		add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.insets = new Insets(0, 0, 5, 5);
		gbc_submitButton.gridx = 7;
		gbc_submitButton.gridy = 28;
		add(submitButton, gbc_submitButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().isBlank()) {
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				}
				else {
					DataPanel dataPanel = new DataPanel(db, username, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
					frame.validate();
				}
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 7;
		gbc_cancelButton.gridy = 29;
		add(cancelButton, gbc_cancelButton);
	}

}
