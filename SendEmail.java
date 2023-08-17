import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

	final String username = "SemoTester2024@gmail.com";
	final String password = "enoizackqpwhborm";
	final String from = "SemoTester2024@gmail.com";
	final String host = "smtp.gmail.com";
	private Properties properties;
	private Session session;
	
	public SendEmail() {
		properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		session = Session.getInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}
	public void sendEmail(String emailAddress, Database db, String username) {
		try {
			String tempPassword = "T3mpP@55";
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
			message.setSubject("Temp Password for Diabetes Data");
			message.setText("The temp password is: " + tempPassword);
			db.updateValueUsertable(username, "password", tempPassword);

			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
}
