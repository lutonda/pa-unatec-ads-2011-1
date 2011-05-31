/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author dirceu
 */
public class SendEmail extends Thread{

    private String subject;
    private String message;
    private String sendTo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public SendEmail(String subject, String message, String sendTo) {
        this.subject = subject;
        this.message = message;
        this.sendTo = sendTo;
    }

    @Override
    public void run(){
        send();
    }

    private void send(){
        try {
            if (!sendTo.equals("")) {
                String host = "smtp.gmail.com";
                String username = "";
                String password = "";
                Properties props = new Properties();
                props.put("mail.smtps.auth", "true");
                props.put("mail.starttls.enable", "true");
                props.put("mail.smtp.port", "587");
                Session session = Session.getDefaultInstance(props, null);
                MimeMessage msg = new MimeMessage(session);
                String[] v = sendTo.split("\\;");
                for (String email : v) {
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                }
                msg.setSubject(subject);

                msg.setContent(message, "text/html; charset=ISO-8859-1");
                // set the message content here
                Transport t = session.getTransport("smtps");
                try {
                    t.connect(host, username, password);
                    t.sendMessage(msg, msg.getAllRecipients());
                } finally {
                    t.close();
                }
            } else {
                throw new Exception("Erro ao enviar e-mail");
            }
        } catch (Exception e) {

        }
    }

    public static void send(String subject, String message, String sendTo) throws Exception {
        SendEmail s = new SendEmail(subject, message, sendTo);
        s.start();
    }

}
