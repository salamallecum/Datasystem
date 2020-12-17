package ventanas;

import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ALEJO
 */
public class InformacionCliente extends javax.swing.JFrame {
    
    String user = "", user_update = "";
    int ID;
    DefaultTableModel model = new DefaultTableModel();
    public static String equipo_update = "";
    
    /**
     * Creates new form InformacionCliente
     */
    public InformacionCliente() {
        initComponents();
        user = Login.user;
        user_update = GestionarClientes.user_update;
        

        setSize(630, 462);
        setResizable(false); 
        setTitle("Información del cliente " + user_update + " - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(),
                lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);
        this.repaint();
        
        jLabel_Titulo.setText("Información del cliente " + user_update);
        
        //traemos la info de la bd de clientes
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select * from clientes where nombre_cliente = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ID = rs.getInt("id_cliente");
                
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_mail.setText(rs.getString("mail_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_UltModifPor.setText(rs.getString("ultima_modificacion"));
                
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar cliente. " + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!!, contacte al administrador.");
        }
        
        //Traemos la info de la BD de equipos
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente= '" + ID + "'");
            
            ResultSet rs = pst.executeQuery();
            
            jTable_equipos = new JTable(model);
            jScrollPane1.setViewportView(jTable_equipos);
            
            model.addColumn("Id Equipo");
            model.addColumn("Tipo de Equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");
            
            
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
                int columna_point = 1;
                
                if(fila_point > -1){
                    equipo_update = (String)model.getValueAt(fila_point, columna_point);
                    InformacionEquipo informacion_equipo = new InformacionEquipo();
                    informacion_equipo.setVisible(true);
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

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel_Nombre1 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        jLabel_Nombre2 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_UltModifPor = new javax.swing.JTextField();
        jButton_RegistrarEquipo = new javax.swing.JButton();
        jButton_ActualizarEquipo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jButton_generarReporte = new javax.swing.JButton();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del Cliente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("em@il:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Teléfono:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Direccion");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima modificacion por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_UltModifPor.setBackground(new java.awt.Color(153, 153, 255));
        txt_UltModifPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_UltModifPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltModifPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_UltModifPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltModifPor.setEnabled(false);
        getContentPane().add(txt_UltModifPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        jButton_RegistrarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RegistrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarEquipo.setText("Registrar Equipo");
        jButton_RegistrarEquipo.setBorder(null);
        jButton_RegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 210, 35));

        jButton_ActualizarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_ActualizarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_ActualizarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ActualizarEquipo.setText("Actualizar Cliente");
        jButton_ActualizarEquipo.setBorder(null);
        jButton_ActualizarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 210, 35));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 340, 180));

        jLabel_footer.setText("Creado por La Geekipedia de Ernesto ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        jButton_generarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_generarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 120, 100));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo boton registrar equipo
    private void jButton_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarEquipoActionPerformed

        RegistrarEquipos registrar_equipos = new RegistrarEquipos();
        registrar_equipos.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarEquipoActionPerformed

    //Metodo boton actualizar cliente
    private void jButton_ActualizarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarEquipoActionPerformed

        int validacion = 0;
        String nombre, mail, telefono, direccion;

        mail = txt_mail.getText().trim();
        direccion = txt_direccion.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        

        if(mail.equals("")){
            txt_mail.setBackground(Color.red);
            validacion++;
        }
        if(direccion.equals("")){
            txt_direccion.setBackground(Color.red);
            validacion++;
        }
        if(nombre.equals("")){
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if(telefono.equals("")){
            txt_telefono.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            try{

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update clientes set nombre_cliente ='"+txt_nombre.getText()+"',mail_cliente='"+txt_mail.getText()+"',tel_cliente='"+txt_telefono.getText()+"',dir_cliente='"+txt_direccion.getText()+"',ultima_modificacion='"
                   +user+"'where id_cliente='"+ID+"'");

                pst.executeUpdate();
                cn.close();

                System.out.println("Registro Exitoso");
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                this.dispose();

            }catch(SQLException e){
                System.err.println("Error al Actualizar el cliente." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar!!, contacte al administrador.");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }

    }//GEN-LAST:event_jButton_ActualizarEquipoActionPerformed

    //Metodo para botn de reportes
    private void jButton_generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generarReporteActionPerformed

        Document documento = new Document();

        try{
            //Aqui se coloca la ruta donde queremos que se guarden los reportes
            String ruta = "C:\\TRABAJOS UNIVERSIDAD\\mis proyectos\\proyectos netbeans\\DataSystem\\Reportes de clientes generados\\"; 
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + user_update+ ".pdf"));

            //Aqui insertamos la imagen en el documento
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Damos formato al texto del documento
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato creado por Alejo © \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Informacion del cliente \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            //Aqui creamos una tabla de tres columnas en el documento
            PdfPTable tabla = new PdfPTable(5);

            //Definimos los titulos de las columnas de la tabla
            tabla.addCell("ID del cliente");
            tabla.addCell("Nombre del cliente");
            tabla.addCell("Correo Electronico");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try{
                //Creamos la conexion con la BD para traer la info de la misma para el documento
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes where nombre_cliente = '" + user_update + "'");

                ResultSet rs = pst.executeQuery();

                //Traemos todos los valores para el reporte
                if(rs.next()){

                    do{
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while(rs.next());
                    documento.add(tabla);
                    parrafo.add("\n\n");
                }

            }catch(DocumentException | SQLException e){
            }
            
            }catch (DocumentException | HeadlessException | FileNotFoundException e){

            }
            catch (IOException e){
            System.out.println("Error en la imagen " + e );
            }
            
                
                Paragraph parrafo1 = new Paragraph();
                parrafo1.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo1.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo1.add("\n\n Equipos registrados del cliente \n\n");
        
            try {
                documento.add(parrafo1);
            } catch (DocumentException ex) {
                Logger.getLogger(InformacionCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
                //Aqui creamos otra tabla para el documento
                PdfPTable tabla1 = new PdfPTable(4);

                //Definimos los titulos de las columnas de la tabla
                tabla1.addCell("ID del Equipo");
                tabla1.addCell("Tipo");
                tabla1.addCell("Marca");
                tabla1.addCell("Estatus");
            
                //Consultamos los equipos que tiene el cliente con su id de cliente en la tabla equipos
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
            
                //Creamos la conexion con la BD para traer la info de la misma para el documento
                try{
                
                    Connection cn1 = Conexion.conectar();
                    PreparedStatement pst1 = cn1.prepareStatement("select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + ID + "'");

                    ResultSet rs1 = pst1.executeQuery();

                    //Traemos todos los valores para el reporte
                    if(rs1.next()){

                    do{
                        tabla1.addCell(rs1.getString(1));
                        tabla1.addCell(rs1.getString(2));
                        tabla1.addCell(rs1.getString(3));
                        tabla1.addCell(rs1.getString(4));
                    
                    } while(rs1.next());
                    documento.add(tabla1);
                    }

                }catch(DocumentException | SQLException e){
                }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado.");
        
        

    }//GEN-LAST:event_jButton_generarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarEquipo;
    private javax.swing.JButton jButton_RegistrarEquipo;
    private javax.swing.JButton jButton_generarReporte;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JTextField txt_UltModifPor;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
