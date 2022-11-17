/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;


import Dominio.Usuario;
import Vista.PantallaInicio;
import Vista.PantallaMenu;
import Vista.PantallaModificarPerfil;
import Vista.VistaOpcionesGestionObras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeanb
 */
public class ControlMenu implements ActionListener {
    private PantallaMenu vistaMenu;
    private Usuario usuario;
    
    public ControlMenu(PantallaMenu vistaMenu, Usuario usuario){
        this.vistaMenu = vistaMenu;
        this.usuario = usuario;
        
        this.vistaMenu.getjButton1().addActionListener(this);
        this.vistaMenu.getjButton2().addActionListener(this);
        this.vistaMenu.getjButton3().addActionListener(this);
        this.vistaMenu.getjButton4().addActionListener(this);
        this.vistaMenu.getjButton5().addActionListener(this);
        
        this.vistaMenu.getjLabel2().setText("¡Bienvenido " + this.usuario.getNombreUsuario()+ "!");
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if (this.vistaMenu.getjButton1() == evento.getSource()){
            //Hacer código cuando se junte con lo de las funciones
        }
        
        if (this.vistaMenu.getjButton2() == evento.getSource()){
            //Hacer código cuando se junte con lo de las funciones
        }
        
        if (this.vistaMenu.getjButton3() == evento.getSource()){
            PantallaModificarPerfil vistaModificarPerfil = new PantallaModificarPerfil();
            ControlModificarPerfil controlModificarPerfil = new ControlModificarPerfil(vistaModificarPerfil, usuario);
            vistaModificarPerfil.setVisible(true);
            this.vistaMenu.dispose();
        }
        
        if (this.vistaMenu.getjButton4() == evento.getSource()){
            Usuario usuario = new Usuario();
            PantallaInicio pantallaInicio = new PantallaInicio();
            ControlInicio controlInicio = new ControlInicio(pantallaInicio, usuario);
            pantallaInicio.setVisible(true);
            this.vistaMenu.dispose();
        }
        
        if(this.vistaMenu.getjBtnModificarObras() == evento.getSource()){
            
            VistaOpcionesGestionObras vistaOpciones = new VistaOpcionesGestionObras();
            ControlOpcionObras controlOpciones = new ControlOpcionObras(vistaOpciones);
            
            vistaOpciones.setVisible(true);
            this.vistaMenu.dispose();
        }
        
    }
}
