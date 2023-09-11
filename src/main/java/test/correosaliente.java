package test;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class correosaliente {

    public static void main(String[] args) {
        // Configuración de las propiedades del servidor de correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "mail.tpdindustrial.co");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Datos de autenticación
        final String username = "miguel.arango@tpdindustrial.co";
        final String password = "miguel12402047";

        // Crear una sesión con autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear el mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miguel.arango@tpdindustrial.co"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arcadio37@gmail.com,miguelarango3777@hotmail.com"));
            message.setSubject("Prueba para el envio de correos desde java");
            message.setText("Envio de informacion a traves del correo saliente de desde aplicacion ");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

