package test;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author miguelarcadioarangoluna
 */
public class enviocorreo {

    public void correosaliente(String mensaje) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "mail.tpdindustrial.co");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Datos de autenticación
        final String username = "miguel.arango@tpdindustrial.co";
        final String password = "miguel12402047";
//        final String usuariocorreo = usuario;
//        final String clave = pass;

        // Crear una sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
//            return new PasswordAuthentication(usuariocorreo,clave);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miguel.arango@tpdindustrial.co"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arcadio37@gmail.com,miguelarango3777@hotmail.com"));
            message.setSubject("Prueba para el envio de correos desde java");
            message.setText("El mensaje desde la clase prueba es: \n" + mensaje);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
