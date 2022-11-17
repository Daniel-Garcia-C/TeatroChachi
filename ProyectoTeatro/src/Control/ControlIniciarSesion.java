/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.DAOUsuario;
import Dominio.Usuario;
import Vista.PantallaIniciarSesion;
import Vista.PantallaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeanb
 */
public class ControlIniciarSesion implements ActionListener {
    private PantallaIniciarSesion vistaIniciarSesion;
    private Usuario modeloUsuario;

    public ControlIniciarSesion(PantallaIniciarSesion vistaIniciarSesion, Usuario modeloUsuario) {
        this.vistaIniciarSesion = vistaIniciarSesion;
        this.modeloUsuario = modeloUsuario;
        
        this.vistaIniciarSesion.getjButton1().addActionListener(this);
        this.vistaIniciarSesion.getjButton2().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evento){
        if (vistaIniciarSesion.getjButton1() == evento.getSource()){
            DAOUsuario daoUsuario;
            try {
                daoUsuario = new DAOUsuario();
                 PantallaMenu vistaMenu = new PantallaMenu();
                 modeloUsuario = daoUsuario.recuperar(vistaIniciarSesion.getjTextField1().getText(), vistaIniciarSesion.getjPasswordField1().getText());
                 if (modeloUsuario != null){
                    ControlMenu controlMenu = new ControlMenu(vistaMenu, modeloUsuario);
                    vistaMenu.setVisible(true);
                    vistaIniciarSesion.dispose();
                 }
                  
            } catch (IOException ex) {
                Logger.getLogger(ControlIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (vistaIniciarSesion.getjButton2() == evento.getSource()){
            DAOUsuario daoUsuario;
            try {
                daoUsuario = new DAOUsuario();
                //Coming soon
            } catch (IOException ex) {
                Logger.getLogger(ControlIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
