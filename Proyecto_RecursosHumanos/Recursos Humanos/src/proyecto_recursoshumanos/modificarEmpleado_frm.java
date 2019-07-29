/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_recursoshumanos;

import javax.swing.JOptionPane;

/**
 *
 * @author ninte
 */
public class modificarEmpleado_frm extends javax.swing.JPanel {
    ConexionBD con = new ConexionBD();
    /**
     * Creates new form modificarEmpleado_frm
     */
    public modificarEmpleado_frm() {
        initComponents();
        LlenarCombo();
    }

    public void LlenarCombo()
    {
        cmbPuestos.setModel(con.cargarComboPuesto());
        cmbPuestos.setSelectedIndex(-1);
        cmbGenero.setModel(con.cargarComboGenero());
        cmbGenero.setSelectedIndex(-1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        cmbGenero = new javax.swing.JComboBox();
        cmbPuestos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 369, -1));

        jLabel1.setText("Identidad del empleado");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        Buscar.setText("Buscar");
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
        });
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGenero.setEnabled(false);
        add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 369, -1));

        cmbPuestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPuestos.setEnabled(false);
        add(cmbPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 369, -1));

        jLabel2.setText("Genero");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 134, -1));

        jLabel3.setText("Puesto");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        Guardar.setText("Guardar");
        Guardar.setEnabled(false);
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, -1, -1));

        txtNombre.setEnabled(false);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 369, -1));

        txtCorreo.setEnabled(false);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 369, -1));

        txtDireccion.setEnabled(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 369, -1));

        txtSueldo.setEnabled(false);
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });
        add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 369, -1));

        jLabel4.setText("Sueldo del Empleado");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        jLabel5.setText("Direccion Empleado");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        jLabel6.setText("Correo del Empleado");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        jLabel7.setText("Nombre del Empleado");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BuscarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        // TODO add your handling code here:
        txtNombre.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtSueldo.setEnabled(false);
        cmbPuestos.setEnabled(false);
        cmbGenero.setEnabled(false);
        Guardar.setEnabled(false);
    }//GEN-LAST:event_txtIDKeyPressed

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        // TODO add your handling code here:
        if (con.VerificarEmpleado(txtID.getText()))
        {
            JOptionPane.showMessageDialog(null, "Si existe ese empleado");
            txtNombre.setText(con.NombreEmpleado(txtID.getText()));
            txtNombre.setEnabled(true);
            txtCorreo.setText(con.CorreoEmpleado(txtID.getText()));
            txtCorreo.setEnabled(true);
            txtDireccion.setText(con.DireccionEmpleado(txtID.getText()));
            txtDireccion.setEnabled(true);
            txtSueldo.setText(con.SueldoEmpleado(txtID.getText()));
            txtSueldo.setEnabled(true);
            cmbPuestos.setSelectedIndex(Integer.parseInt(con.PuestoEmpleado(txtID.getText()))-1);
            cmbPuestos.setEnabled(true);
            cmbGenero.setSelectedIndex(Integer.parseInt(con.GeneroEmpleado(txtID.getText()))-1);
            cmbGenero.setEnabled(true);
            Guardar.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR, El empleado no existe");
        }

    }//GEN-LAST:event_BuscarMouseClicked

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
         String [] errores= new String [5];
        Integer cant=0;
        if(!txtID.getText().matches("^[0-9]{13}$")){
                txtID.setText("");
                errores[cant]="Identidad Incorrecta Digite bien los datos";
                cant++;
        }
        if(!txtNombre.getText().matches("^([a-zA-z]{4,})+([a-zA-Z ]{4,})$")){
            txtNombre.setText("");
            errores[cant]="Nombre Incorrecto";
            cant++;
        }
        if(!txtCorreo.getText().matches("^([a-z])+.+[@]+[a-zA-Z.]+(.com)$")){
                errores[cant]="Correo Electronico Incorrecto";
                cant++;
                txtCorreo.setText("");
        }
        
        if(!txtDireccion.getText().matches("^([a-zA-z]{1,})+.+[a-zA-Z .-_]$")){
                txtDireccion.setText("");
                errores[cant]="Direccion Incorrecta";
                cant++;
        }
        
        if(!txtSueldo.getText().matches("^([1-9]{1})+([0-9]{2,})+.??([0-9]{1,})$")){
                txtSueldo.setText("");
                errores[cant]="Sueldo Incorrecto";
                cant++;
        }        
        if(cmbGenero.getSelectedIndex()==-1){
            errores[cant]="Escoja un genero";
            cant++;
        }
        if(cmbPuestos.getSelectedIndex()==-1){
            errores[cant]="Escoja un puesto";
            cant++;
        }
        if(cant!=0){
            JOptionPane.showMessageDialog(null,errores);
        }
        else{
            con.UpdateEmpleado(txtID.getText(), txtNombre.getText(), txtCorreo.getText(), txtDireccion.getText(), txtSueldo.getText(), (cmbGenero.getSelectedIndex()+1),(cmbPuestos.getSelectedIndex()+1));

            JOptionPane.showMessageDialog(null, "La informacion ha sido guardada exitosamente");
            txtNombre.setText("");
            txtID.setText(" ");
            txtCorreo.setText("");
            txtDireccion.setText("");
            txtSueldo.setText("");
            cmbPuestos.setSelectedIndex(-1);
            cmbGenero.setSelectedIndex(-1);
            txtNombre.setEnabled(false);
            txtCorreo.setEnabled(false);
            txtDireccion.setEnabled(false);
            txtSueldo.setEnabled(false);
            cmbPuestos.setEnabled(false);
            cmbGenero.setEnabled(false);
            Guardar.setEnabled(false);
        }
        

    }//GEN-LAST:event_GuardarActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
        String valIde ="[0-9]";
        String a=Character.toString(evt.getKeyChar()) ;
            
          if(!a.matches(valIde) || txtID.getText().length()>=13 ){
            evt.consume();
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        String valNom ="[a-zA-Z ]";
        String a=Character.toString(evt.getKeyChar()) ;
            
          if(!a.matches(valNom)|| txtNombre.getText().length()>=80 ){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
        String valNom ="[a-zA-Z0-9@._-]";
        String a=Character.toString(evt.getKeyChar()) ;
            
          if(!a.matches(valNom)|| txtCorreo.getText().length()>=60 ){
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        String valNom ="[a-zA-Z .-]";
        String a=Character.toString(evt.getKeyChar()) ;
            
          if(!a.matches(valNom)|| txtDireccion.getText().length()>=80 ){
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        // TODO add your handling code here:
        String valNom ="[0-9.]";
        String a=Character.toString(evt.getKeyChar()) ;
            
          if(!a.matches(valNom)|| txtSueldo.getText().length()>=100 ){
            evt.consume();
            
        }
    }//GEN-LAST:event_txtSueldoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Guardar;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JComboBox cmbPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
