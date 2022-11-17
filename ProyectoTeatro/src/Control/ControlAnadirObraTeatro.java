/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.DaoObraTeatro;
import Dominio.ObraTeatro;
import Vista.VistaAnadirObras;
import Vista.VistaOpcionesGestionObras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DANIEL GARCIA
 */
public class ControlAnadirObraTeatro implements ActionListener {
    
    private ObraTeatro modeloObra;
    private VistaAnadirObras vistaObras;

    public ControlAnadirObraTeatro(ObraTeatro modeloObra, VistaAnadirObras vistaObras) {
        this.modeloObra = modeloObra;
        this.vistaObras = vistaObras;
        
        this.vistaObras.getjAgregarObra().addActionListener(this);
        this.vistaObras.getjRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
         //Limpiar Mensaje de error
            this.vistaObras.getjError().setText("");
            
        if(this.vistaObras.getjAgregarObra() == evento.getSource()){
 
            boolean verificador = true;
            
            String nombreObra = this.vistaObras.getjNombreObra().getText();
            String genero = this.vistaObras.getjGeneroObra().getText();
            String descripcion = this.vistaObras.getjDescripcion().getText();
            String actor[] = {this.vistaObras.getjActorPrincipal1().getText(), this.vistaObras.getjActorPrincipal2().getText()};
            int duracion = 0;
            double precioBoleto = -1;
            //Atrapar el error NumberFormatException en caso de espacio en blanco
            try{
                duracion = Integer.parseInt(this.vistaObras.getjDuracion().getSelectedItem().toString());
                precioBoleto = Double.parseDouble(this.vistaObras.getjPrecioBoleto().getText());
            }catch(NumberFormatException nfe){
                verificador = false;
                System.out.println("Error en datos numeros");
            }
            
            //Verificar cada uno de los strings no esten vacios
            if(nombreObra.isBlank()){
                verificador = false;
            }
            if(genero.isBlank()){
                verificador = false;
            }
            if(descripcion.isBlank()){
                verificador = false;
            }
            if(actor[0].isBlank() || actor[1].isBlank()){
                verificador = false;
            }
            
            //Si todos los campos están llenos agregar a base de datos
            if(verificador == true && duracion != 0 && precioBoleto != -1){
                this.modeloObra.setNombre(nombreObra);
                this.modeloObra.setGenero(genero);
                this.modeloObra.setDuracion(duracion);
                this.modeloObra.setActorPrincipal(actor);
                this.modeloObra.setPrecio(precioBoleto);
                this.modeloObra.setResumen(descripcion);

                DaoObraTeatro daoObraTeatro = new DaoObraTeatro();

                daoObraTeatro.insertar(modeloObra);
            }
            else{
                this.vistaObras.getjError().setText("Llena todos los campos");
            }
           
            
        }
        
        if(this.vistaObras.getjRegresar() == evento.getSource()){
            VistaOpcionesGestionObras vistaOpciones = new VistaOpcionesGestionObras();
            ControlOpcionObras controlOpciones = new ControlOpcionObras(vistaOpciones);
            
            vistaOpciones.setVisible(true);
            this.vistaObras.dispose();
        }
        
    }
    
    
    
}
