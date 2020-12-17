package ventanas;

import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author ALEJO
 */
public class CorreoCreatividad extends javax.swing.JFrame {

    String user = "", user_update = "";
    /**
     * Creates new form CorreoCreatividad
     */
    public CorreoCreatividad() {
        initComponents();
        
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setSize(441, 360);
        setResizable(false); 
        setTitle("Envio de correo electronico" + user_update + " - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(),
                lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);
        this.repaint();
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_destinatario = new javax.swing.JTextField();
        txt_asunto = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mensaje = new javax.swing.JTextArea();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Para:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Asunto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escriba su mensaje aqui...");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_destinatario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txt_destinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 250, -1));

        txt_asunto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txt_asunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));

        btn_enviar.setBackground(new java.awt.Color(153, 153, 255));
        btn_enviar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_enviar.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        btn_cancelar.setBackground(new java.awt.Color(153, 153, 255));
        btn_cancelar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        txt_mensaje.setColumns(20);
        txt_mensaje.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_mensaje.setRows(5);
        txt_mensaje.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(txt_mensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 400, 130));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo del boton cancelar
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        
        this.hide();
             
    }//GEN-LAST:event_btn_cancelarActionPerformed

    //Metodo del boton enviar
    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        
        //Crea la conexion
        Properties propiedad = new Properties();
        propiedad.put("mail.smtp.host","smtp.gmail.com");
        propiedad.put("mail.smtp.starttls.enable","true");
        propiedad.put("mail.smtp.port", "587");
        propiedad.put("mail.smtp.auth", "true");
		         
        Session sesion = Session.getDefaultInstance(propiedad);
		         
        //Establecemos el correo con el cual se enviaran los correos
        String correoEnvia = "paranguaralejo@gmail.com";
        String contraseña = "97041806706";
		         
        //Aqui recibimos los datos del destinatario para el envio del correo
        String destinatario = txt_destinatario.getText();
        String asunto = txt_asunto.getText();
        String mensaje = txt_mensaje.getText();
		         
		         
        MimeMessage mail = new MimeMessage(sesion);
		         
        //Definimos la transaccion con la cual se enviara el correo
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
		            
		            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contraseña);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
		            
            JOptionPane.showMessageDialog(null, "El mensaje ha sido enviado");
            this.hide();
		        
        }catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btn_enviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CorreoCreatividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorreoCreatividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorreoCreatividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorreoCreatividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CorreoCreatividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JTextField txt_asunto;
    private javax.swing.JTextField txt_destinatario;
    private javax.swing.JTextArea txt_mensaje;
    // End of variables declaration//GEN-END:variables
}