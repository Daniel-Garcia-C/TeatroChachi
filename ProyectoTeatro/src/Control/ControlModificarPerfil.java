/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.DAOUsuario;
import Dominio.Usuario;
import Vista.PantallaInicio;
import Vista.PantallaMenu;
import Vista.PantallaModificarPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeanb
 */
public class ControlModificarPerfil implements ActionListener{
    private PantallaModificarPerfil vistaModificarPerfil;
    private Usuario modeloUsuario;

    public ControlModificarPerfil(PantallaModificarPerfil vistaModificarPerfil, Usuario modeloUsuario) {
        this.vistaModificarPerfil = vistaModificarPerfil;
        this.modeloUsuario = modeloUsuario;
        
        this.vistaModificarPerfil.getjButton1().addActionListener(this);
        this.vistaModificarPerfil.getjButton2().addActionListener(this);
        this.vistaModificarPerfil.getjButton3().addActionListener(this);
        
        this.vistaModificarPerfil.getjTextField1().setText(this.modeloUsuario.getCurp());
         this.vistaModificarPerfil.getjTextField2().setText(this.modeloUsuario.getNombre());
         this.vistaModificarPerfil.getjTextField3().setText(this.modeloUsuario.getApellido());
         this.vistaModificarPerfil.getjTextField4().setText(this.modeloUsuario.getNombreUsuario());
          this.vistaModificarPerfil.getjTextField5().setText(this.modeloUsuario.getContrasenia());
    }
    
    public void actionPerformed(ActionEvent evento){
        if(vistaModificarPerfil.getjButton1() == evento.getSource()){
            modeloUsuario.setNombre(vistaModificarPerfil.getjTextField2().getText());
            modeloUsuario.setApellido(vistaModificarPerfil.getjTextField3().getText());
            modeloUsuario.setNombreUsuario(vistaModificarPerfil.getjTextField4().getText());
            modeloUsuario.setContrasenia(vistaModificarPerfil.getjTextField5().getText());
                if((modeloUsuario.getNombre().equals("") == false) && (modeloUsuario.getApellido().equals("") == false) && (modeloUsuario.getCurp().equals("") == false) && (modeloUsuario.getNombreUsuario().equals("") == false) && (modeloUsuario.getContrasenia().equals("") == false)){
                        DAOUsuario daoUsuario;
                       
                        try {
                            daoUsuario = new DAOUsuario();
                            daoUsuario.modificar(modeloUsuario);
                            PantallaMenu vistaMenu = new PantallaMenu();
                           ControlMenu controlMenu = new ControlMenu(vistaMenu, modeloUsuario);
                            vistaMenu.setVisible(true);
                            this.vistaModificarPerfil.dispose();
                        } catch (IOException ex) {
                            java.util.logging.Logger.getLogger(ControlInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                         }else{
                             System.out.print("Rellene todos los campos");
                         }
            }
        if(vistaModificarPerfil.getjButton2() ==  evento.getSource()){
            
            PantallaMenu vistaMenu = new PantallaMenu();
            ControlMenu controlMenu = new ControlMenu(vistaMenu, modeloUsuario);
            vistaMenu.setVisible(true);
            this.vistaModificarPerfil.dispose();
        }
        
        if(vistaModificarPerfil.getjButton3() == evento.getSource()){
            DAOUsuario daoUsuario;
            try {
                daoUsuario = new DAOUsuario();
                daoUsuario.eliminar(modeloUsuario);
                PantallaInicio vistaInicio = new PantallaInicio();
                ControlInicio controlInicio = new ControlInicio(vistaInicio, modeloUsuario);
                vistaInicio.setVisible(true);
                this.vistaModificarPerfil.dispose();
            } catch (IOException ex) {
                Logger.getLogger(ControlModificarPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            
        }
        }
    }
    
    
    

