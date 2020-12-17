package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author ALEJO
 */
public class RegistrarEquipos extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;
    //Aqui traemos la fecha del sistema
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
    String fechaSistema = formatoFecha.format(fecha);
    
    /**
     * Creates new form RegistrarEquipos
     */
    public RegistrarEquipos() {
        initComponents();
        user = Login.user;
        user_update = GestionarClientes.user_update;
       
        setTitle("Registrar nuevo equipo - Sesión de " + user);
        setSize(630, 375);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(),
                lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);
        this.repaint();
        txt_nombreCliente.setText(user_update);
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

        txt_nombreCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_noSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmb_marca = new javax.swing.JComboBox<>();
        jLabel_footer = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_tipoEquipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observaciones = new javax.swing.JTextArea();
        jButton_registrarEquipo = new javax.swing.JButton();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombreCliente.setEnabled(false);
        txt_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de equipo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de Equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_noSerie.setBackground(new java.awt.Color(153, 153, 255));
        txt_noSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_noSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_noSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_noSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_noSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apple", "Acer", "HP", "Lenovo", "Sony" }));
        cmb_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_marcaActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel_footer.setText("Creado por La Geekipedia de Ernesto ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N° de serie:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        cmb_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 290, 170));

        jButton_registrarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_registrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_registrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrarEquipo.setText("Registrar Equipo");
        jButton_registrarEquipo.setBorder(null);
        jButton_registrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloActionPerformed

    private void jButton_registrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarEquipoActionPerformed

        int tipoEq_cmb, marca_cmb, validacion = 0;
        String  modelo, noSerie, observaciones, tipoEquipo_string = "", Marca_string = "";

        noSerie = txt_noSerie.getText().trim();
        modelo = txt_modelo.getText().trim();
        marca_cmb = cmb_marca.getSelectedIndex() + 1;
        tipoEq_cmb = cmb_tipoEquipo.getSelectedIndex() + 1;
        observaciones = txt_observaciones.getText().trim();

        if(noSerie.equals("")){
            txt_noSerie.setBackground(Color.red);
            validacion++;
        }
        if(modelo.equals("")){
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if(observaciones.equals("")){
            txt_observaciones.setBackground(Color.red);
            validacion++;
        }

        if(marca_cmb == 1){
            Marca_string = "Apple";
        } else if(marca_cmb == 2){
            Marca_string = "Acer";
        } else if(marca_cmb == 3){
            Marca_string = "HP";
        } else if(marca_cmb == 4){
            Marca_string = "Lenovo";
        } else if(marca_cmb == 5){
            Marca_string = "Sony";
        }

        if(tipoEq_cmb == 1){
            tipoEquipo_string = "Laptop";
        } else if(tipoEq_cmb == 2){
            tipoEquipo_string = "Desktop";
        } else if(tipoEq_cmb == 3){
            tipoEquipo_string = "Impresora";
        } else if(tipoEq_cmb == 4){
            tipoEquipo_string = "Multifuncional";
        }

        try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst = cn2.prepareStatement(
                    "select id_cliente from clientes where nombre_cliente= '" + user_update + "'");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    ID = rs.getInt("id_cliente");
                }
                cn2.close();
                    
        } catch (SQLException e) {
            System.err.println("Error al buscar id del cliente." + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion de refuerzo, ¡Contacte al administrador!");
        }
        
        if (validacion == 0) {         
            
            try{
                Connection cn = Conexion.conectar();
                PreparedStatement pst2 = cn.prepareStatement(
                            "insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?)");
                        
                        pst2.setInt(1, 0);
                        pst2.setInt(2, ID);
                        pst2.setString(3, tipoEquipo_string);
                        pst2.setString(4, Marca_string);
                        pst2.setString(5, modelo);
                        pst2.setString(6, noSerie);
                        pst2.setString(7, fechaSistema);
                        pst2.setString(8, observaciones);
                        pst2.setString(9, "Nuevo Ingreso");
                        pst2.setString(10, user);
                        pst2.setString(11, "");
                        pst2.setString(12, "");
                        
                        pst2.executeUpdate();
                        cn.close();
                        
                        Limpiar();
                        
                        txt_noSerie.setBackground(Color.green);
                        txt_nombreCliente.setBackground(Color.green);
                        txt_modelo.setBackground(Color.green);
                        txt_observaciones.setBackground(Color.green);
                        
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        this.dispose();

            }catch(SQLException e){
                System.err.println("Error al Registrar el usuario." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador.");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_registrarEquipoActionPerformed

    private void txt_nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreClienteActionPerformed
        
    }//GEN-LAST:event_txt_nombreClienteActionPerformed

    private void cmb_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_marcaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipoEquipo;
    private javax.swing.JButton jButton_registrarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_noSerie;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextArea txt_observaciones;
    // End of variables declaration//GEN-END:variables

    //Metodo que limpia los campos del formulario
    public void Limpiar(){
        txt_noSerie.setText("");
        txt_nombreCliente.setText("");
        txt_modelo.setText("");
        txt_observaciones.setText("");
        cmb_marca.setSelectedIndex(0);
        cmb_tipoEquipo.setSelectedIndex(0);
    }
    
    
}