/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.AcercaDe.sesion_usuario;

/**
 *
 * @author ALEJO
 */
public class GraficoMarcas extends javax.swing.JFrame {

    String user = "", user_update = "", equipo_update="";
    
    int totalApple;
    int totalAcer;
    int totalHP;
    int totalLenovo;
    int totalSony;
    
    boolean bandera = false;
    /**
     * Creates new form graficoMarcas
     */
    public GraficoMarcas() {
        initComponents();
        user = Login.user;
        sesion_usuario = 1;
        user_update = GestionarUsuarios.user_update;
        
        setSize(547, 400);
        setResizable(false);
        setTitle("Grafico de marcas de equipos " + " - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(),
                lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);
        bandera = true;
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

        jLabel_footer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_footer.setText("Creado por La Geekipedia de Ernesto ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de Marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 547, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraficoMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficoMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficoMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficoMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficoMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel lbl_wallpaper;
    // End of variables declaration//GEN-END:variables

    public void paint(Graphics g){
        super.paint(g);
        if(bandera == true){
            
            //Aqui consultamos la bse de datos y contamos los registros que tengan un atributo en especifico,
            //para este caso queremos contar cuantos registros tiene como marcas el valor de HP
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(marca) from equipos where marca = 'Apple'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalApple = rs.getInt("count(marca)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al contar." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(marca) from equipos where marca = 'Acer'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalAcer = rs.getInt("count(marca)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al contar." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(marca) from equipos where marca = 'HP'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalHP = rs.getInt("count(marca)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al contar." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(marca) from equipos where marca = 'Lenovo'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalLenovo = rs.getInt("count(marca)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al contar." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(marca) from equipos where marca = 'Sony'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalSony = rs.getInt("count(marca)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al contar." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            int total_marcas = totalApple + totalAcer + totalHP + totalLenovo + totalSony;
            
            //Definimos los grados de cada item en el circulo
            int grados_apple = totalApple * 360 / total_marcas;
            int grados_acer = totalAcer * 360 / total_marcas;
            int grados_HP = totalHP * 360 / total_marcas;
            int grados_lenovo = totalLenovo * 360 / total_marcas;
            int grados_sony = totalSony * 360 / total_marcas;
            
            //Empezamos a graficar cada uno de los colores
            g.setColor(new Color(255, 0, 0));
            g.fillArc(25, 80, 200, 200, 0, grados_apple);
            g.fillRect(250, 120, 20, 20);
            g.drawString("Apple: " + totalApple, 275, 135);
            
            g.setColor(new Color(0, 130, 0));
            g.fillArc(25, 80, 200, 200, grados_apple, grados_acer);
            g.fillRect(250, 150, 20, 20);
            g.drawString("Acer: " + totalAcer, 275, 165);
            
            g.setColor(new Color(0, 0, 255));
            g.fillArc(25, 80, 200, 200, grados_apple + grados_acer, grados_HP);
            g.fillRect(250, 180, 20, 20);
            g.drawString("HP: " + totalHP, 275, 195);
            
            g.setColor(new Color(227,253,3));
            g.fillArc(25, 80, 200, 200, grados_apple + grados_acer + grados_HP, grados_lenovo);
            g.fillRect(250, 210, 20, 20);
            g.drawString("Lenovo: " + totalLenovo, 275, 225);
            
            g.setColor(new Color(253,3,196));
            g.fillArc(25, 80, 200, 200, grados_apple + grados_acer + grados_HP + grados_lenovo, grados_sony);
            g.fillRect(250, 240, 20, 20);
            g.drawString("Sony: " + totalSony, 275, 255);
        }
    }        
}

