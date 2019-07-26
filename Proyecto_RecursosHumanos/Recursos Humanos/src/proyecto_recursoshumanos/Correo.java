/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_recursoshumanos;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author hondu
 */
public class Correo
{
    public void mandarCorreo(String nuevaContra,String Mail){
        final String username = "transporte.escolar.bonilla13@gmail.com";
        final String password = "transporte93";

                Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS
                
                Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients( Message.RecipientType.TO,InternetAddress.parse(Mail));
            message.setSubject("Cambio de Contraseña");
            message.setText("Su nueva contraseña es: "+nuevaContra);

            Transport.send(message);

            JOptionPane.showMessageDialog(null,"Su Nueva Contraseña ha sido enviado a su correo");

            } catch (MessagingException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Su Nueva Contraseña  no ha sido enviado a su correo"+ e);
                }
            }

    }
