import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void sendMail(String recepient) throws Exception {
		System.out.println("Preparing send email");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		String myAccountEmail = "technology220222@gmail.com";
		String password = "M123456!v";
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient);

		Transport.send(message);
		System.out.println("Message sent succesfully");

	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("My fist email in java");
			message.setText("Look my email please");
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
