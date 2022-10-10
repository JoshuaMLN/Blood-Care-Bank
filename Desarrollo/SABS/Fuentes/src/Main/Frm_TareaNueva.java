/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Metodos_SQL.Metodos_sql;
import static java.lang.Integer.getInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON
 */
public class Frm_TareaNueva extends javax.swing.JFrame {

    /**
     * Creates new form Frm_TareaNueva
     */
    public Frm_TareaNueva() {
        initComponents();
        setLocationRelativeTo(null);

        //id ineditable
        jTextField_idNuevaTarea.setEditable(false);

    }

    Metodos_sql metodos = new Metodos_sql();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_descrip = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_idNuevaTarea = new javax.swing.JTextField();
        jdc_Fecha = new com.toedter.calendar.JDateChooser();
        jFormattedTextField_hora = new javax.swing.JFormattedTextField();
        estadoComboBox = new javax.swing.JComboBox<>();
        priorComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir tarea");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Titulo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descripcion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jTextField_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_tituloActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 229, -1));

        jTextArea_descrip.setColumns(20);
        jTextArea_descrip.setRows(5);
        jScrollPane1.setViewportView(jTextArea_descrip);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 300, 100));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Añadir tarea");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Prioridad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Estado:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Hora:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        jTextField_idNuevaTarea.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_idNuevaTarea.setBorder(null);
        jTextField_idNuevaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idNuevaTareaActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_idNuevaTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 51, -1));

        jdc_Fecha.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(jdc_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 272, 130, -1));

        try {
            jFormattedTextField_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_horaActionPerformed(evt);
            }
        });
        jPanel1.add(jFormattedTextField_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 80, -1));

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En Proceso", "Terminado" }));
        jPanel1.add(estadoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 100, 20));

        priorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jPanel1.add(priorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 100, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LibretaAñadirTarea.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -40, 530, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //arreglar hora para mysql(NO FUNCIONA XD)
        //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  sdf.parse("00:00:00") hora
        /*
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date hora = sdf.parse(jFormattedTextField_hora.getText()+":00");//sdf.parse(jFormattedTextField_hora.getText()+":00");
        } catch (ParseException ex) {
            Logger.getLogger(Frm_TareaNueva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long h = date.getTime();
        java.sql.Time hora = new java.sql.Time(h); 
         */
        //añadir nueva tarea
        if (jTextField_titulo.getText().equals("") || jTextArea_descrip.getText().equals("") || jdc_Fecha.getDate() == null || jFormattedTextField_hora.getText().equals("  :  :  ")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");

        } else {

            if (metodos.validarHora(jFormattedTextField_hora.getText()) == true) {
                //arreglar la fecha para mysql
                Date date = jdc_Fecha.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);//fecha esta en el formato de Mysql

                //Utilizar el metodo guardar TAREA
                if (metodos.existeTarea(jTextField_titulo.getText()) == 0) {
                    int i = metodos.guardarTarea(jTextField_titulo.getText(), jTextArea_descrip.getText(), fecha, jFormattedTextField_hora.getText(), Integer.parseInt(priorComboBox.getSelectedItem().toString()), estadoComboBox.getSelectedItem().toString(), Integer.parseInt(jTextField_idNuevaTarea.getText()));
                    if (i > 0) {
                        JOptionPane.showMessageDialog(this, "Nueva tarea añadida");
                        dispose();//cerrar el form cuando creas una tarea
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo añadir tarea");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Este tarea ya existe, digite otro nombre de tarea.");
                }

                

            } else {
                JOptionPane.showMessageDialog(null, "Hora invalida");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_tituloActionPerformed

    private void jTextField_idNuevaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idNuevaTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idNuevaTareaActionPerformed

    private void jFormattedTextField_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_horaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_TareaNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_TareaNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_TareaNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_TareaNueva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_TareaNueva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField_hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_descrip;
    public javax.swing.JTextField jTextField_idNuevaTarea;
    private javax.swing.JTextField jTextField_titulo;
    private com.toedter.calendar.JDateChooser jdc_Fecha;
    private javax.swing.JComboBox<String> priorComboBox;
    // End of variables declaration//GEN-END:variables
}
