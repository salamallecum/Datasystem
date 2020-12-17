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
public class GraficoEstatus extends javax.swing.JFrame {

    String user = "", user_update = "", equipo_update="";
    
    int totalnvoIngreso;
    int totalnoReparado;
    int totalenRevision;
    int totalReparado;
    int totalEntregado;
    
    boolean bandera = false;
    /**
     * Creates new form graficoEstatus
     */
    public GraficoEstatus() {
        initComponents();
        user = Login.user;
        sesion_usuario = 1;
        user_update = GestionarUsuarios.user_update;
        
        setSize(547, 400);
        setResizable(false);
        setTitle("Grafico de estatus de equipos " + " - Sesión de " + user);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de Estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel_footer.setText("Creado por La Geekipedia de Ernesto ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

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
            java.util.logging.Logger.getLogger(GraficoEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficoEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficoEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficoEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficoEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel lbl_wallpaper;
    // End of variables declaration//GEN-END:variables
 
    //Metodo que dibuja la grafica
    public void paint(Graphics g){
        super.paint(g);
        if(bandera == true){
            
            //Aqui consultamos la bse de datos y contamos los registros que tengan un atributo en especifico,
            //para este caso queremos contar cuantos registros tiene como estatus el valor de Nuevo Ingreso
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(estatus) from equipos where estatus = 'Nuevo Ingreso'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalnvoIngreso = rs.getInt("count(estatus)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(estatus) from equipos where estatus = 'No Reparado'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalnoReparado = rs.getInt("count(estatus)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(estatus) from equipos where estatus = 'En Revision'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalenRevision = rs.getInt("count(estatus)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(estatus) from equipos where estatus = 'Reparado'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalReparado = rs.getInt("count(estatus)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select count(estatus) from equipos where estatus = 'Entregado'");
            
                ResultSet rs = pst.executeQuery();        
                               
                if(rs.next()) {
                    totalEntregado = rs.getInt("count(estatus)");
                    
                }
                cn.close();   
               
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al analizar, ¡Contacte al administrador!");
            }
            
            int valor_mayor = mayorValor(totalnvoIngreso, totalnoReparado, totalenRevision, totalReparado, totalEntregado);
            
            //Definimos la longitud de las barras ( el 400 es opcional lo podemos ajustar a nuestra necesidad
            int largo_nvoIngreso = totalnvoIngreso * 400 / valor_mayor;
            int largo_noReparado = totalnoReparado * 400 / valor_mayor;
            int largo_enRevision = totalenRevision * 400 / valor_mayor;
            int largo_Reparado = totalReparado * 400 / valor_mayor;
            int largo_Entregado = totalEntregado * 400 / valor_mayor;
            
             
            
            //Dijujamos las graficas
            g.setColor(new Color (255,0,0));
            g.fillRect(100, 100, largo_nvoIngreso, 40);
            g.drawString("Nuevo Ingreso: " + totalnvoIngreso, 10, 125);
            
            g.setColor(new Color (0,130,0));
            g.fillRect(100, 150, largo_noReparado, 40);
            g.drawString("No Reparado: " + totalnoReparado, 10, 175);
            
            g.setColor(new Color (0,0,255));
            g.fillRect(100, 200, largo_enRevision, 40);
            g.drawString("En Revision: " + totalenRevision, 10, 225);
            
            g.setColor(new Color (135,54,0));
            g.fillRect(100, 250, largo_Reparado, 40);
            g.drawString("Reparado: " + totalReparado, 10, 275);
            
            g.setColor(new Color (214,137,16));
            g.fillRect(100, 300, largo_Entregado, 40);
            g.drawString("Entregado: " + totalEntregado, 10, 325);
        }
    }        
    public int mayorValor(int totalnvoIngreso, int totalnoReparado , int totalenRevision, int totalReparado , int totalEntregado){
        if(totalnvoIngreso > totalnoReparado && totalnvoIngreso > totalenRevision && totalnvoIngreso > totalnoReparado && totalnvoIngreso > totalEntregado ){
            return totalnvoIngreso;
        } else if(totalnoReparado > totalenRevision && totalnoReparado > totalReparado && totalnoReparado > totalEntregado){
            return totalnoReparado;
        } else if(totalenRevision > totalReparado && totalenRevision > totalEntregado){
            return totalenRevision;
        } else if(totalReparado > totalEntregado){
            return totalReparado;
        }else{
            return totalEntregado;
        }    
    }
}
    
        
        
    

