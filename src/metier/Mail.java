package metier;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {

	public static void sendEmail(String recipient, String nom,int code) throws MessagingException, Exception {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mai.smtp.port", "587");

        String MyAccountEmail = "charity.contactus@gmail.com";
        String password = "Charity123";

        Session session;
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(MyAccountEmail, password);
            }
        }
        );

        Message msg = prepareMsg(session, MyAccountEmail, recipient,nom, code);
        Transport.send(msg);
    }

    private static Message prepareMsg(Session session, String MyAccountEmail, String recipient,String nom,int code) throws Exception {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(MyAccountEmail));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        msg.setSubject("MyClub Support");
        String html ="<div style=\"border: 5px outset green;text-align: center;\">"
                + "<h1 font-color=red>Notice</h1>\n" +
                "  <h2 style=\"color:red;\">Bienvenue chez nous "+nom+"</h3>\n" +        		
                "  <h2 style=\"color:red;\">Merci de bien confirmer votre compte en connectant avec les doonnees suivantes :<h2>\n"+
                "  <h4>Login : "+recipient+"</h4>\n" +
                "  <h4>Code : "+code+"</h4>"+
                "</div>";
        msg.setContent(html, "text/html");
        
        return msg;

    }
}
