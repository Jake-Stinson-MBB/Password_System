import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionsPanel extends JPanel {
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	private int attempts = 0;
	


	public QuestionsPanel(Database db, String username, JFrame frame) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel securityQuestionsLabel = new JLabel("Security Questions:");
		securityQuestionsLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_securityQuestionsLabel = new GridBagConstraints();
		gbc_securityQuestionsLabel.gridwidth = 5;
		gbc_securityQuestionsLabel.insets = new Insets(50, 0, 50, 0);
		gbc_securityQuestionsLabel.gridx = 0;
		gbc_securityQuestionsLabel.gridy = 1;
		add(securityQuestionsLabel, gbc_securityQuestionsLabel);
		
		JLabel q1Label = new JLabel("Question 1:");
		GridBagConstraints gbc_q1Label = new GridBagConstraints();
		gbc_q1Label.anchor = GridBagConstraints.EAST;
		gbc_q1Label.insets = new Insets(0, 200, 5, 5);
		gbc_q1Label.gridx = 1;
		gbc_q1Label.gridy = 3;
		add(q1Label, gbc_q1Label);
		
		JLabel question1 = new JLabel(db.getValueUsertable(username, "question1"));
		GridBagConstraints gbc_question1 = new GridBagConstraints();
		gbc_question1.anchor = GridBagConstraints.WEST;
		gbc_question1.gridwidth = 3;
		gbc_question1.insets = new Insets(0, 0, 5, 0);
		gbc_question1.gridx = 2;
		gbc_question1.gridy = 3;
		add(question1, gbc_question1);
		
		JLabel answer1Label = new JLabel("Answer 1:");
		GridBagConstraints gbc_answer1Label = new GridBagConstraints();
		gbc_answer1Label.anchor = GridBagConstraints.EAST;
		gbc_answer1Label.insets = new Insets(0, 200, 5, 5);
		gbc_answer1Label.gridx = 1;
		gbc_answer1Label.gridy = 4;
		add(answer1Label, gbc_answer1Label);
		
		answer1 = new JTextField();
		GridBagConstraints gbc_answer1 = new GridBagConstraints();
		gbc_answer1.gridwidth = 2;
		gbc_answer1.insets = new Insets(0, 0, 5, 5);
		gbc_answer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer1.gridx = 2;
		gbc_answer1.gridy = 4;
		add(answer1, gbc_answer1);
		answer1.setColumns(10);
		
		JLabel q2Label = new JLabel("Question 2:");
		GridBagConstraints gbc_q2Label = new GridBagConstraints();
		gbc_q2Label.insets = new Insets(0, 200, 5, 5);
		gbc_q2Label.gridx = 1;
		gbc_q2Label.gridy = 5;
		add(q2Label, gbc_q2Label);
		
		JLabel question2 = new JLabel(db.getValueUsertable(username, "question2"));
		GridBagConstraints gbc_question2 = new GridBagConstraints();
		gbc_question2.anchor = GridBagConstraints.WEST;
		gbc_question2.gridwidth = 3;
		gbc_question2.insets = new Insets(0, 0, 5, 0);
		gbc_question2.gridx = 2;
		gbc_question2.gridy = 5;
		add(question2, gbc_question2);
		
		JLabel answer2Label = new JLabel("Answer 2:");
		GridBagConstraints gbc_answer2Label = new GridBagConstraints();
		gbc_answer2Label.anchor = GridBagConstraints.EAST;
		gbc_answer2Label.insets = new Insets(0, 200, 5, 5);
		gbc_answer2Label.gridx = 1;
		gbc_answer2Label.gridy = 6;
		add(answer2Label, gbc_answer2Label);
		
		answer2 = new JTextField();
		GridBagConstraints gbc_answer2 = new GridBagConstraints();
		gbc_answer2.gridwidth = 2;
		gbc_answer2.insets = new Insets(0, 0, 5, 5);
		gbc_answer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer2.gridx = 2;
		gbc_answer2.gridy = 6;
		add(answer2, gbc_answer2);
		answer2.setColumns(10);
		
		JLabel q3Label = new JLabel("Question 3:");
		GridBagConstraints gbc_q3Label = new GridBagConstraints();
		gbc_q3Label.insets = new Insets(0, 200, 5, 5);
		gbc_q3Label.gridx = 1;
		gbc_q3Label.gridy = 7;
		add(q3Label, gbc_q3Label);
		
		JLabel question3 = new JLabel(db.getValueUsertable(username, "question3"));
		GridBagConstraints gbc_question3 = new GridBagConstraints();
		gbc_question3.anchor = GridBagConstraints.WEST;
		gbc_question3.gridwidth = 3;
		gbc_question3.insets = new Insets(0, 0, 5, 5);
		gbc_question3.gridx = 2;
		gbc_question3.gridy = 7;
		add(question3, gbc_question3);
		
		JLabel answer3Label = new JLabel("Answer 3:");
		GridBagConstraints gbc_answer3Label = new GridBagConstraints();
		gbc_answer3Label.insets = new Insets(0, 200, 5, 5);
		gbc_answer3Label.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_answer3Label.gridx = 1;
		gbc_answer3Label.gridy = 8;
		add(answer3Label, gbc_answer3Label);
		
		answer3 = new JTextField();
		GridBagConstraints gbc_answer3 = new GridBagConstraints();
		gbc_answer3.gridwidth = 2;
		gbc_answer3.insets = new Insets(0, 0, 5, 5);
		gbc_answer3.fill = GridBagConstraints.HORIZONTAL;
		gbc_answer3.gridx = 2;
		gbc_answer3.gridy = 8;
		add(answer3, gbc_answer3);
		answer3.setColumns(10);
		
		JLabel questionError = new JLabel("");
		GridBagConstraints gbc_questionError = new GridBagConstraints();
		gbc_questionError.insets = new Insets(0, 0, 5, 0);
		gbc_questionError.gridx = 4;
		gbc_questionError.gridy = 10;
		add(questionError, gbc_questionError);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbAnswer1 = db.getValueUsertable(username, "answer1");
				String dbAnswer2 = db.getValueUsertable(username, "answer2");
				String dbAnswer3 = db.getValueUsertable(username, "answer3");
				String textAnswer1 = answer1.getText();
				String textAnswer2 = answer2.getText();
				String textAnswer3 = answer3.getText();
				if(textAnswer1.equals(dbAnswer1) &&
						textAnswer2.equals(dbAnswer2) &&
						textAnswer3.equals(dbAnswer3)) {
					PicturePanel picturePanel = new PicturePanel(db,username, frame, false);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(picturePanel, BorderLayout.CENTER);
					frame.validate();
				}else {
						questionError.setText("Invalid Answers. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 9;
		add(submitButton, gbc_btnNewButton);
		
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
		gbc_cancelButton.gridy = 11;
		add(cancelButton, gbc_cancelButton);
	

	}
	

}
