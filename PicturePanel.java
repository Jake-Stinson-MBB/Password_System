import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicturePanel extends JPanel {
	int attempts = 0;

	public PicturePanel(Database db, String username, JFrame frame, Boolean insertFlag) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel errorLabel = new JLabel("");
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 4;
		gbc_errorLabel.gridy = 6;
		add(errorLabel, gbc_errorLabel);

		JLabel selectPictureLabel = new JLabel("Select a Picture:");
		selectPictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectPictureLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_selectPictureLabel = new GridBagConstraints();
		gbc_selectPictureLabel.insets = new Insets(50, 0, 50, 0);
		gbc_selectPictureLabel.gridwidth = 7;
		gbc_selectPictureLabel.gridx = 0;
		gbc_selectPictureLabel.gridy = 1;
		add(selectPictureLabel, gbc_selectPictureLabel);

		JButton bearButton = new JButton("");
		bearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "bear");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("bear")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon bearImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\Bart-the-Bear.jpg"); // 178*100
		bearButton.setIcon(bearImg);
		GridBagConstraints gbc_bearButton = new GridBagConstraints();
		gbc_bearButton.insets = new Insets(0, 0, 5, 5);
		gbc_bearButton.gridx = 3;
		gbc_bearButton.gridy = 3;
		add(bearButton, gbc_bearButton);

		JButton monkeyButton = new JButton("");
		monkeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "monkey");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("monkey")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon monkeyImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\squirrel-monkey.jpg");
		monkeyButton.setIcon(monkeyImg);
		GridBagConstraints gbc_monkeyButton = new GridBagConstraints();
		gbc_monkeyButton.insets = new Insets(0, 0, 5, 5);
		gbc_monkeyButton.gridx = 4;
		gbc_monkeyButton.gridy = 3;
		add(monkeyButton, gbc_monkeyButton);

		JButton dogButton = new JButton("");
		dogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "dog");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("dog")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon dogImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\dogimg.jpg");
		dogButton.setIcon(dogImg);
		GridBagConstraints gbc_dogButton = new GridBagConstraints();
		gbc_dogButton.insets = new Insets(0, 0, 5, 5);
		gbc_dogButton.gridx = 5;
		gbc_dogButton.gridy = 3;
		add(dogButton, gbc_dogButton);

		JButton birdButton = new JButton("");
		birdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "bird");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("bird")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon birdImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\bird.jpg");
		birdButton.setIcon(birdImg);
		GridBagConstraints gbc_birdButton = new GridBagConstraints();
		gbc_birdButton.insets = new Insets(0, 0, 5, 5);
		gbc_birdButton.gridx = 3;
		gbc_birdButton.gridy = 4;
		add(birdButton, gbc_birdButton);

		JButton lionButton = new JButton("");
		lionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "lion");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("lion")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon lionImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\lion4.jpg");
		lionButton.setIcon(lionImg);
		GridBagConstraints gbc_lionButton = new GridBagConstraints();
		gbc_lionButton.insets = new Insets(0, 0, 5, 5);
		gbc_lionButton.gridx = 4;
		gbc_lionButton.gridy = 4;
		add(lionButton, gbc_lionButton);

		JButton bunnyButton = new JButton("");
		bunnyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "bunny");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("bunny")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon bunnyImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\bunny2.jpg");
		bunnyButton.setIcon(bunnyImg);
		GridBagConstraints gbc_bunnyButton = new GridBagConstraints();
		gbc_bunnyButton.insets = new Insets(0, 0, 5, 5);
		gbc_bunnyButton.gridx = 5;
		gbc_bunnyButton.gridy = 4;
		add(bunnyButton, gbc_bunnyButton);

		JButton sharkButton = new JButton("");
		sharkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "shark");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("shark")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon sharkImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\shark.jpg");
		sharkButton.setIcon(sharkImg);
		GridBagConstraints gbc_sharkButton = new GridBagConstraints();
		gbc_sharkButton.insets = new Insets(0, 0, 5, 5);
		gbc_sharkButton.gridx = 3;
		gbc_sharkButton.gridy = 5;
		add(sharkButton, gbc_sharkButton);

		JButton snakeButton = new JButton("");
		snakeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "snake");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("snake")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon snakeImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\snake.jpg");
		snakeButton.setIcon(snakeImg);
		GridBagConstraints gbc_snakeButton = new GridBagConstraints();
		gbc_snakeButton.insets = new Insets(0, 0, 5, 5);
		gbc_snakeButton.gridx = 4;
		gbc_snakeButton.gridy = 5;
		add(snakeButton, gbc_snakeButton);

		JButton horseButton = new JButton("");
		horseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (insertFlag) {
					db.updateValueUsertable(username, "pickedPicture", "horse");
					SigninPanel signinPanel = new SigninPanel(db, frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
					frame.validate();
				} else {
					String dbPickedPicture = db.getValueUsertable(username, "pickedpicture");
					if (dbPickedPicture.equals("horse")) {
						DataPanel dataPanel = new DataPanel(db, username, frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(dataPanel, BorderLayout.CENTER);
						frame.validate();
					} else {
						errorLabel.setText("Invalid Answer. Try Again " + (3-attempts) + " remaining");
						attempts++;
						if(attempts>3) {
							SigninPanel signinPanel = new SigninPanel(db, frame);
							frame.getContentPane().removeAll();
							frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
							frame.validate();
						}
					}
				}
			}
		});
		ImageIcon horseImg = new ImageIcon("C:\\Users\\jstin\\OneDrive\\Pictures\\horse.jpg");
		horseButton.setIcon(horseImg);
		GridBagConstraints gbc_horseButton = new GridBagConstraints();
		gbc_horseButton.insets = new Insets(0, 0, 5, 5);
		gbc_horseButton.gridx = 5;
		gbc_horseButton.gridy = 5;
		add(horseButton, gbc_horseButton);

		JButton btnNewButton_8 = new JButton("Cancel");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SigninPanel signinPanel = new SigninPanel(db, frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(signinPanel, BorderLayout.CENTER);
				frame.validate();
			}
		});

		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 4;
		gbc_btnNewButton_8.gridy = 7;
		add(btnNewButton_8, gbc_btnNewButton_8);

	}

}
