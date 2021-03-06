package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarUsuarios.user_update;
import static ventanas.InformacionCliente.equipo_update;

/**
 *
 * @author ALEJO
 */
public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    String user_update;
    public static int id_equipo_update;
    int filas;
    
    DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form GestionarEquipos
     */
    public GestionarEquipos() {
        initComponents();
        user = Login.user;
        user_update = GestionarClientes.user_update;
        
        
        setSize(630, 330);
        setTitle("Equipos registrados - Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(),
                lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);
        this.repaint();
        
        
        jTable_equipos = new JTable(model);
                    jScrollPane1.setViewportView(jTable_equipos);
                    
        model.addColumn("Id Equipo");
        model.addColumn("Tipo de Equipo");            
        model.addColumn("Marca");
        model.addColumn("Estatus");
        
        try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        
        //Agregamos la funcion de ver informacion del cliente al hacer click sobre el registro de la tabla
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if(fila_point > -1){
                    id_equipo_update = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico informacion_equipotec = new InformacionEquipoTecnico();
                    informacion_equipotec.setVisible(true);
                }
                
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        Cmb_estatus = new javax.swing.JComboBox<>();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 630, 180));

        jLabel_footer.setText("Creado por La Geekipedia de Ernesto ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        Cmb_estatus.setMaximumRowCount(6);
        Cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado", " ", " " }));
        Cmb_estatus.setToolTipText("");
        Cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_estatusActionPerformed(evt);
            }
        });
        getContentPane().add(Cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 100, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_estatusActionPerformed
       
        //Programamos la funcion de filtro a traves del combobox
        if(Cmb_estatus.getSelectedItem().equals("Todos")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
            
        } else if(Cmb_estatus.getSelectedItem().equals("Nuevo Ingreso")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + Cmb_estatus.getSelectedItem() + "'");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        } else if(Cmb_estatus.getSelectedItem().equals("No Reparado")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + Cmb_estatus.getSelectedItem() + "'");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        } else if(Cmb_estatus.getSelectedItem().equals("En Revision")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + Cmb_estatus.getSelectedItem() + "'");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        } else if(Cmb_estatus.getSelectedItem().equals("Reparado")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + Cmb_estatus.getSelectedItem() + "'");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        } else if(Cmb_estatus.getSelectedItem().equals("Entregado")){
            
            filas = jTable_equipos.getRowCount();
            for (int i = 0; i<filas; i++) {
                model.removeRow(0);
            }
            
            try{
            Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + Cmb_estatus.getSelectedItem() + "'");
            
                ResultSet rs = pst.executeQuery();        
                               
                while (rs.next()) {
                    Object[] fila = new Object[4];
                
                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                
                    model.addRow(fila);
                }
                cn.close();        
            
            } catch (SQLException e) {
                System.err.println("Error al llenar tabla." + e);
                JOptionPane.showMessageDialog(null, "Error al mostrar información, ¡Contacte al administrador!");
            }
        }
        
    }//GEN-LAST:event_Cmb_estatusActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JLabel lbl_wallpaper;
    // End of variables declaration//GEN-END:variables
}
