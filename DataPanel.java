import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataPanel extends JPanel {
	private JTextField dateField;
	private JTextField testAMField;
	private JTextField levelAMField;
	private JTextField breakfastField;
	private JTextField lunchField;
	private JTextField testPMField;
	private JTextField dinnerField;
	private JTextField levelPMField;

	/**
	 * Create the panel.
	 */
	public DataPanel(Database db, String username, JFrame frame) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel welcomeLabel = new JLabel("Diabetes Data");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.gridwidth = 7;
		gbc_welcomeLabel.insets = new Insets(50, 0, 50, 0);
		gbc_welcomeLabel.gridx = 0;
		gbc_welcomeLabel.gridy = 0;
		add(welcomeLabel, gbc_welcomeLabel);
		
		ArrayList<String[]> returnList = db.getDataRows(username);
		DefaultTableModel model = new DefaultTableModel() {
			String[] columnHeaders = { "Date", "Time of Test AM", "Blood Sugar AM", "Breakfast menu", "Lunch menu",
					"Dinner menu", "Time of Test PM", "Blood Sugar PM" };

			@Override
			public int getColumnCount() {
				return columnHeaders.length;
			}

			@Override
			public String getColumnName(int index) {
				return columnHeaders[index];
			}
		};
		for (int i = 0; i < returnList.size(); i++) {
			model.addRow(new Object[] { (returnList.get(i)[1]),
					(returnList.get(i)[2]),
					(returnList.get(i)[3]),
					(returnList.get(i)[4]),
					(returnList.get(i)[5]),
					(returnList.get(i)[6]),
					(returnList.get(i)[7]),
					(returnList.get(i)[8]) });
		}
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(920, 200));
		table.setFillsViewportHeight(true);

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 9;
		gbc_table.gridwidth = 15;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;

		

		JScrollPane tableContainer = new JScrollPane(table);

		add(tableContainer, gbc_table);
		
		JLabel dateLabel = new JLabel("Date:");
		dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.gridwidth = 2;
		gbc_dateLabel.insets = new Insets(0, 100, 5, 5);
		gbc_dateLabel.gridx = 3;
		gbc_dateLabel.gridy = 12;
		add(dateLabel, gbc_dateLabel);
		
		dateField = new JTextField();
		dateField.setText("");
		GridBagConstraints gbc_dateField = new GridBagConstraints();
		gbc_dateField.insets = new Insets(0, 0, 5, 5);
		gbc_dateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateField.gridx = 5;
		gbc_dateField.gridy = 12;
		add(dateField, gbc_dateField);
		dateField.setColumns(10);
		
		JLabel testAMLabel = new JLabel("Time of Test AM:");
		testAMLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_testAMLabel = new GridBagConstraints();
		gbc_testAMLabel.gridwidth = 2;
		gbc_testAMLabel.insets = new Insets(0, 100, 5, 5);
		gbc_testAMLabel.gridx = 3;
		gbc_testAMLabel.gridy = 13;
		add(testAMLabel, gbc_testAMLabel);
		
		testAMField = new JTextField();
		GridBagConstraints gbc_testAMField = new GridBagConstraints();
		gbc_testAMField.insets = new Insets(0, 0, 5, 5);
		gbc_testAMField.fill = GridBagConstraints.HORIZONTAL;
		gbc_testAMField.gridx = 5;
		gbc_testAMField.gridy = 13;
		add(testAMField, gbc_testAMField);
		testAMField.setColumns(10);
		
		JLabel levelAMLabel = new JLabel("Blood Sugar Level AM:");
		levelAMLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_levelAMLabel = new GridBagConstraints();
		gbc_levelAMLabel.gridwidth = 2;
		gbc_levelAMLabel.insets = new Insets(0, 100, 5, 5);
		gbc_levelAMLabel.gridx = 3;
		gbc_levelAMLabel.gridy = 14;
		add(levelAMLabel, gbc_levelAMLabel);
		
		levelAMField = new JTextField();
		GridBagConstraints gbc_levelAMField = new GridBagConstraints();
		gbc_levelAMField.insets = new Insets(0, 0, 5, 5);
		gbc_levelAMField.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelAMField.gridx = 5;
		gbc_levelAMField.gridy = 14;
		add(levelAMField, gbc_levelAMField);
		levelAMField.setColumns(10);
		
		JLabel breakfastLabel = new JLabel("Breakfast Menu:");
		breakfastLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_breakfastLabel = new GridBagConstraints();
		gbc_breakfastLabel.gridwidth = 2;
		gbc_breakfastLabel.insets = new Insets(0, 100, 5, 5);
		gbc_breakfastLabel.gridx = 3;
		gbc_breakfastLabel.gridy = 15;
		add(breakfastLabel, gbc_breakfastLabel);
		
		breakfastField = new JTextField();
		GridBagConstraints gbc_breakfastField = new GridBagConstraints();
		gbc_breakfastField.insets = new Insets(0, 0, 5, 5);
		gbc_breakfastField.fill = GridBagConstraints.HORIZONTAL;
		gbc_breakfastField.gridx = 5;
		gbc_breakfastField.gridy = 15;
		add(breakfastField, gbc_breakfastField);
		breakfastField.setColumns(10);
		
		JLabel lunchLabel = new JLabel("Lunch Menu:");
		lunchLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lunchLabel = new GridBagConstraints();
		gbc_lunchLabel.gridwidth = 2;
		gbc_lunchLabel.insets = new Insets(0, 100, 5, 5);
		gbc_lunchLabel.gridx = 3;
		gbc_lunchLabel.gridy = 16;
		add(lunchLabel, gbc_lunchLabel);
		
		lunchField = new JTextField();
		GridBagConstraints gbc_lunchField = new GridBagConstraints();
		gbc_lunchField.insets = new Insets(0, 0, 5, 5);
		gbc_lunchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lunchField.gridx = 5;
		gbc_lunchField.gridy = 16;
		add(lunchField, gbc_lunchField);
		lunchField.setColumns(10);
		
		JLabel dinnerLabel = new JLabel("Dinner Menu:");
		dinnerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_dinnerLabel = new GridBagConstraints();
		gbc_dinnerLabel.gridwidth = 2;
		gbc_dinnerLabel.insets = new Insets(0, 100, 5, 5);
		gbc_dinnerLabel.gridx = 3;
		gbc_dinnerLabel.gridy = 17;
		add(dinnerLabel, gbc_dinnerLabel);
		
		dinnerField = new JTextField();
		GridBagConstraints gbc_dinnerField = new GridBagConstraints();
		gbc_dinnerField.insets = new Insets(0, 0, 5, 5);
		gbc_dinnerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dinnerField.gridx = 5;
		gbc_dinnerField.gridy = 17;
		add(dinnerField, gbc_dinnerField);
		dinnerField.setColumns(10);
		
		JLabel testPMLabel = new JLabel("Time of Test PM:");
		testPMLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_testPMLabel = new GridBagConstraints();
		gbc_testPMLabel.gridwidth = 2;
		gbc_testPMLabel.insets = new Insets(0, 100, 5, 5);
		gbc_testPMLabel.gridx = 3;
		gbc_testPMLabel.gridy = 18;
		add(testPMLabel, gbc_testPMLabel);
		
		testPMField = new JTextField();
		GridBagConstraints gbc_testPMField = new GridBagConstraints();
		gbc_testPMField.insets = new Insets(0, 0, 5, 5);
		gbc_testPMField.fill = GridBagConstraints.HORIZONTAL;
		gbc_testPMField.gridx = 5;
		gbc_testPMField.gridy = 18;
		add(testPMField, gbc_testPMField);
		testPMField.setColumns(10);
		
		JLabel levelPMLabel = new JLabel("Blood Sugar Level PM:");
		levelPMLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_levelPMLabel = new GridBagConstraints();
		gbc_levelPMLabel.gridwidth = 2;
		gbc_levelPMLabel.insets = new Insets(0, 100, 5, 5);
		gbc_levelPMLabel.gridx = 3;
		gbc_levelPMLabel.gridy = 19;
		add(levelPMLabel, gbc_levelPMLabel);
		
		levelPMField = new JTextField();
		GridBagConstraints gbc_levelPMField = new GridBagConstraints();
		gbc_levelPMField.insets = new Insets(0, 0, 5, 5);
		gbc_levelPMField.fill = GridBagConstraints.HORIZONTAL;
		gbc_levelPMField.gridx = 5;
		gbc_levelPMField.gridy = 19;
		add(levelPMField, gbc_levelPMField);
		levelPMField.setColumns(10);
		
		JButton addRowButton = new JButton("Add Daily Entry");
		addRowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.createDataRow(username, dateField.getText(), testAMField.getText(), levelAMField.getText(),
						breakfastField.getText(), lunchField.getText(), dinnerField.getText(), testPMField.getText(),
						levelPMField.getText());
				model.addRow(new Object[] { dateField.getText(), testAMField.getText(), levelAMField.getText(),
						breakfastField.getText(), lunchField.getText(), dinnerField.getText(), testPMField.getText(),
						levelPMField.getText() });
			}
		});

		GridBagConstraints gbc_addRowButton = new GridBagConstraints();
		gbc_addRowButton.insets = new Insets(0, 10, 5, 5);
		gbc_addRowButton.gridx = 5;
		gbc_addRowButton.gridy = 20;
		add(addRowButton, gbc_addRowButton);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SigninPanel signinPanel = new SigninPanel(db, frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
				frame.validate();
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 21;
		add(btnNewButton, gbc_btnNewButton);
		

		JButton changePasswordButton = new JButton("Change Passwords / Info");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					RegisterPanel registerPanel = new RegisterPanel(db, frame, username);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(registerPanel, BorderLayout.CENTER);
					frame.validate();

			}
		});
		GridBagConstraints gbc_changePasswordButton = new GridBagConstraints();
		gbc_changePasswordButton.insets = new Insets(0, 0, 0, 5);
		gbc_changePasswordButton.gridx = 6;
		gbc_changePasswordButton.gridy = 21;
		add(changePasswordButton, gbc_changePasswordButton);

		
	}
	

}
