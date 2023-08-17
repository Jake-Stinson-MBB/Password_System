import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class DiabetesDataApp {

	private JFrame frame;
	private Database db; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiabetesDataApp window = new DiabetesDataApp();
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
	public DiabetesDataApp() {
		db = new Database();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SigninPanel signinPanel = new SigninPanel(db, frame);
		frame.getContentPane().add(signinPanel, BorderLayout.CENTER);	
	}

}
