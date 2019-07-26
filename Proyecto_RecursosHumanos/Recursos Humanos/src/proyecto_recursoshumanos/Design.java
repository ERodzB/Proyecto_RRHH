/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_recursoshumanos;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author hondu
 */
public class Design {

    public Design() {
        
    }
    
    public void AbrirFormulario(JLayeredPane principal_panel, JPanel mostrar_panel){
        principal_panel.removeAll();
        principal_panel.setLayout(new BorderLayout());
        principal_panel.add(mostrar_panel);
        principal_panel.repaint();
        principal_panel.revalidate();
    }

    
    
}
