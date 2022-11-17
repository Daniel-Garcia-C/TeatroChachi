/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Dominio.ObraTeatro;
import Vista.VistaAnadirObras;
import Vista.VistaGestionObras;
import Vista.VistaOpcionesGestionObras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DANIEL GARCIA
 */
public class ControlOpcionObras implements ActionListener{
    
    private VistaOpcionesGestionObras vistaOpciones;

    public ControlOpcionObras(VistaOpcionesGestionObras vistaOpciones) {
        this.vistaOpciones = vistaOpciones;
        
        this.vistaOpciones.getjBtnAgregar().addActionListener(this);
        this.vistaOpciones.getjBtnModElim().addActionListener(this);
        this.vistaOpciones.getjBtnRegresar().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(this.vistaOpciones.getjBtnAgregar() == evento.getSource()){
            ObraTeatro modeloObra = new ObraTeatro();
            VistaAnadirObras vistaAnadirObras = new VistaAnadirObras();
            ControlAnadirObraTeatro controladorObra = new ControlAnadirObraTeatro(modeloObra , vistaAnadirObras);
            vistaAnadirObras.setVisible(true);
            
            this.vistaOpciones.dispose();
        }
        
        if(this.vistaOpciones.getjBtnModElim() == evento.getSource()){
            ObraTeatro modeloObra = new ObraTeatro();
            VistaGestionObras vistaGestionObras = new VistaGestionObras();
            ControlBuscarObra controlBuscarObra = new ControlBuscarObra(modeloObra, vistaGestionObras);
        
            vistaGestionObras.setVisible(true);
            this.vistaOpciones.dispose();
        }
        
        if(this.vistaOpciones.getjBtnRegresar() == evento.getSource()){
            
        }
        
    }

}
