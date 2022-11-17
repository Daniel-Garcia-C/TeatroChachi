/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;


import DAO.DAOUsuario;
import Vista.PantallaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dominio.*;
import Vista.PantallaIniciarSesion;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import Vista.PantallaMenu;

/**
 *
 * @author jeanb
 */
public class ControlInicio implements ActionListener{
    private PantallaInicio vistaInicio;
    private Usuario modeloUsuario;

    public ControlInicio(PantallaInicio vistaInicio, Usuario modeloUsuario) {
        this.vistaInicio = vistaInicio;
        this.modeloUsuario = modeloUsuario;
        
        this.vistaInicio.getjButton1().addActionListener(this);
        this.vistaInicio.getjButton2().addActionListener(this);
        this.vistaInicio.getjButton3().addActionListener(this);
        
    }
    

    public void actionPerformed(ActionEvent evento){
         if (vistaInicio.getjButton1() == evento.getSource()){
                  modeloUsuario.setNombre(vistaInicio.getjTextField1().getText());
                  modeloUsuario.setApellido(vistaInicio.getjTextField2().getText());
                  modeloUsuario.setCurp(vistaInicio.getjTextField3().getText());
                  modeloUsuario.setNombreUsuario(vistaInicio.getjTextField4().getText());
                  modeloUsuario.setContrasenia(vistaInicio.getjTextField5().getText());
                  if((modeloUsuario.getNombre().equals("") == false) && (modeloUsuario.getApellido().equals("") == false) && (modeloUsuario.getCurp().equals("") == false) && (modeloUsuario.getNombreUsuario().equals("") == false) && (modeloUsuario.getContrasenia().equals("") == false)){
                        DAOUsuario daoUsuario;
                       
                        try {
                            daoUsuario = new DAOUsuario();
                             if (daoUsuario.insertar(modeloUsuario) == 0){
                                 PantallaMenu vistaMenu = new PantallaMenu();
                                ControlMenu controlMenu = new ControlMenu(vistaMenu, modeloUsuario);
                                vistaMenu.setVisible(true);
                                this.vistaInicio.dispose();
                             }
                             
                        } catch (IOException ex) {
                            java.util.logging.Logger.getLogger(ControlInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                         }else{
                             System.out.print("Rellene todos los campos");
                         }
         }
       
        
           
        if (vistaInicio.getjButton2() == evento.getSource()){
            PantallaIniciarSesion vistaLogIn = new PantallaIniciarSesion();
            ControlIniciarSesion controlIniciarSesion = new ControlIniciarSesion(vistaLogIn, modeloUsuario);
            vistaLogIn.setVisible(true);
            vistaInicio.dispose();
        }
        if(vistaInicio.getjButton3() == evento.getSource()){
            vistaInicio.dispose();
        }
    }
    
}
