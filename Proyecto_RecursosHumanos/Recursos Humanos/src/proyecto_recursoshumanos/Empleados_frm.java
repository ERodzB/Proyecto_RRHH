/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_recursoshumanos;

/**
 *
 * @author hondu
 */
public class Empleados_frm extends javax.swing.JPanel {

    /**
     * Creates new form Empleados_frm
     */
    public Empleados_frm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bonos_btn = new javax.swing.JButton();
        nuevoEmpleado_btn = new javax.swing.JButton();
        modificarEmpleado_btn = new javax.swing.JButton();
        despidoRenuncias_btn = new javax.swing.JButton();
        empleados_panel = new javax.swing.JLayeredPane();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 7));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bonos_btn.setBackground(new java.awt.Color(215, 0, 5));
        bonos_btn.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        bonos_btn.setForeground(new java.awt.Color(255, 255, 255));
        bonos_btn.setText("Bonos");
        bonos_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bonos_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonos_btnActionPerformed(evt);
            }
        });
        jPanel1.add(bonos_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 110, 60));

        nuevoEmpleado_btn.setBackground(new java.awt.Color(215, 0, 5));
        nuevoEmpleado_btn.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        nuevoEmpleado_btn.setForeground(new java.awt.Color(255, 255, 255));
        nuevoEmpleado_btn.setText("Nuevo Empleado");
        nuevoEmpleado_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevoEmpleado_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        nuevoEmpleado_btn.setName(""); // NOI18N
        jPanel1.add(nuevoEmpleado_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        modificarEmpleado_btn.setBackground(new java.awt.Color(215, 0, 5));
        modificarEmpleado_btn.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        modificarEmpleado_btn.setForeground(new java.awt.Color(255, 255, 255));
        modificarEmpleado_btn.setText("Modificar Empleado");
        modificarEmpleado_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        modificarEmpleado_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpleado_btnActionPerformed(evt);
            }
        });
        jPanel1.add(modificarEmpleado_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 210, 60));

        despidoRenuncias_btn.setBackground(new java.awt.Color(215, 0, 5));
        despidoRenuncias_btn.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        despidoRenuncias_btn.setForeground(new java.awt.Color(255, 255, 255));
        despidoRenuncias_btn.setText("Despidos/Renuncias");
        despidoRenuncias_btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        despidoRenuncias_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despidoRenuncias_btnActionPerformed(evt);
            }
        });
        jPanel1.add(despidoRenuncias_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 210, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        javax.swing.GroupLayout empleados_panelLayout = new javax.swing.GroupLayout(empleados_panel);
        empleados_panel.setLayout(empleados_panelLayout);
        empleados_panelLayout.setHorizontalGroup(
            empleados_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        empleados_panelLayout.setVerticalGroup(
            empleados_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        add(empleados_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 1030, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void bonos_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonos_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bonos_btnActionPerformed

    private void despidoRenuncias_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despidoRenuncias_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_despidoRenuncias_btnActionPerformed

    private void modificarEmpleado_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEmpleado_btnActionPerformed
        // TODO add your handling code here:
        modificarEmpleado_frm mod = new modificarEmpleado_frm();
        Design estetica = new Design();
        estetica.AbrirFormulario(empleados_panel, mod);
    }//GEN-LAST:event_modificarEmpleado_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bonos_btn;
    private javax.swing.JButton despidoRenuncias_btn;
    private javax.swing.JLayeredPane empleados_panel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificarEmpleado_btn;
    private javax.swing.JButton nuevoEmpleado_btn;
    // End of variables declaration//GEN-END:variables
}
