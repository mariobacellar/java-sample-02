package mailgun;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class MGSendSimpleSMTP {

	static String SMTPHostname = "smtp.mailgun.org";
	static String DefaultSMTPLogin = "postmaster@sandboxf7fc5fd99bdf4dcbbb7646f3bb89a19f.mailgun.org";
	static String DefaultPassword = "5245b4677da1a2e1a97049b80bf2fc76-3fb021d1-eba5a2be";
	
	static String API_KEY			= "543f5348004674aca94861e990b8898c-3fb021d1-81be7be2";
	static String YOUR_DOMAIN_NAME	= "sandboxf7fc5fd99bdf4dcbbb7646f3bb89a19f.mailgun.org";
	static String API_BASE_URL 	= "https://api.mailgun.net/v3/"+YOUR_DOMAIN_NAME;
	
    public static void main(String args[]) throws Exception {

        Properties 
        props = System.getProperties();
        props.put("mail.smtps.host", "smtp.mailgun.org");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);
        
        Message 
        msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("YOU@YOUR_DOMAIN_NAME"));

        InternetAddress[] addrs = InternetAddress.parse("mario.bacellar@gmail.com", false);
        
        msg.setRecipients(Message.RecipientType.TO, addrs);
        msg.setSubject("Hello");
        msg.setText("Testing some Mailgun awesomness");
        msg.setSentDate(new Date());

        SMTPTransport 
        transport = (SMTPTransport) session.getTransport("smtps");
        transport.connect("smtp.mailgun.org", "postmaster@" + YOUR_DOMAIN_NAME, DefaultPassword);
        transport.sendMessage(msg, msg.getAllRecipients());

        System.out.println("Response: " + transport.getLastServerResponse());

        transport.close();
    }
}
