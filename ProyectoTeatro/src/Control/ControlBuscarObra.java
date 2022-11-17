/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAO.DaoObraTeatro;
import Dominio.ObraTeatro;
import Vista.VistaGestionObras;
import Vista.VistaOpcionesGestionObras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL GARCIA
 */
public class ControlBuscarObra implements ActionListener {
    
    private ObraTeatro modeloObra;
    private VistaGestionObras vistaGestionObras;

    public ControlBuscarObra(ObraTeatro modeloObra, VistaGestionObras vistaGestionObras) {
        this.modeloObra = modeloObra;
        this.vistaGestionObras = vistaGestionObras;
        
        this.vistaGestionObras.getjBuscar().addActionListener(this);
        this.vistaGestionObras.getjRegresar().addActionListener(this);
        this.vistaGestionObras.getjBtnEliminar().addActionListener(this);
        this.vistaGestionObras.getjModificar().addActionListener(this);
        
        this.actualizarTabla();
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
         //Limpiar Mensaje de error
        this.vistaGestionObras.getjError().setText("");
        
        DaoObraTeatro daoObraTeatro = new DaoObraTeatro();
        
        this.actualizarTabla();
        
        if(this.vistaGestionObras.getjBuscar()== evento.getSource()){
            
            int id = -1;
            
            try{
                id = Integer.parseInt(this.vistaGestionObras.getjID().getText());

                this.modeloObra = daoObraTeatro.consultar(id);
                
                if(this.modeloObra != null){
                    //Mostrar la información del modelo obra
                    this.vistaGestionObras.getjNombreObra().setText(this.modeloObra.getNombre());
                    this.vistaGestionObras.getjGenero().setText(this.modeloObra.getGenero());
                    this.vistaGestionObras.getjPrecioBoleto().setText(String.valueOf(this.modeloObra.getPrecio()));
                    this.vistaGestionObras.getjActorPrincipal1().setText(this.modeloObra.getActorPrincipal()[0]);
                    this.vistaGestionObras.getjActorPrincipal2().setText(this.modeloObra.getActorPrincipal()[1]);
                    this.vistaGestionObras.getjResumen().setText(this.modeloObra.getResumen());
       
                    //Revisar las opciones de la caja de duracion
                    for(int i = 0; i < this.vistaGestionObras.getjDuracion().getItemCount(); i++){
                        if(this.vistaGestionObras.getjDuracion().getItemAt(i).equals(String.valueOf(this.modeloObra.getDuracion()))){
                           this.vistaGestionObras.getjDuracion().setSelectedIndex(i);
                        }
                    }
                }
                else{
                    this.vistaGestionObras.getjError().setText("Obra de Teatro No Encontrada");
                }

            }catch(NumberFormatException nfe){
                this.vistaGestionObras.getjError().setText("Llena el campo con la ID");
            }
            
            this.actualizarTabla();
        }
        
        if(this.vistaGestionObras.getjModificar() == evento.getSource()){
           
            int id = -1;
            boolean verificador = true;
            
            try{
                id = Integer.parseInt(this.vistaGestionObras.getjID().getText());
                String actores[] = {this.vistaGestionObras.getjActorPrincipal1().getText(), this.vistaGestionObras.getjActorPrincipal2().getText()};
                
                this.modeloObra.setNombre(this.vistaGestionObras.getjNombreObra().getText());
                this.modeloObra.setGenero(this.vistaGestionObras.getjGenero().getText());
                this.modeloObra.setActorPrincipal(actores);
                this.modeloObra.setNombre(this.vistaGestionObras.getjNombreObra().getText());
                this.modeloObra.setResumen(this.vistaGestionObras.getjResumen().getText());
                
                try{
                    this.modeloObra.setId(Integer.parseInt(this.vistaGestionObras.getjID().getText()));
                    this.modeloObra.setDuracion(Integer.parseInt(this.vistaGestionObras.getjDuracion().getSelectedItem().toString()));
                    this.modeloObra.setPrecio(Double.parseDouble(this.vistaGestionObras.getjPrecioBoleto().getText()));
                }catch(NumberFormatException nfe){
                    verificador = false;
                    System.out.println("Datos no válidos en ID,duracion o precio");
                }
                
                //Verificar cada uno de los strings no esten vacios
                if(this.modeloObra.getNombre().isBlank()){
                    verificador = false;
                }
                if(this.modeloObra.getGenero().isBlank()){
                    verificador = false;
                }
                if(this.modeloObra.getResumen().isBlank()){
                    verificador = false;
                }
                if(actores[0].isBlank() || actores[1].isBlank()){
                    verificador = false;
                }
                
                if(verificador == true){
                    //DaoObraTeatro daoObraTeatro = new DaoObraTeatro();
                    //MODIFICAR
                    daoObraTeatro.modificar(this.modeloObra);
                      
                    this.vistaGestionObras.getjError().setText("Obra de Teatro Modificada");
                }
                else{
                    this.vistaGestionObras.getjError().setText("Llena todos los campos"); 
                }

            }catch(NumberFormatException nfe){    
                this.vistaGestionObras.getjError().setText("Llena el campo con la ID");
            }
            
            this.actualizarTabla();
        }
        
        if(this.vistaGestionObras.getjBtnEliminar() == evento.getSource()){
            int id = -1;
            try{
                id = Integer.parseInt(this.vistaGestionObras.getjIDEliminar().getText());
                
               // DaoObraTeatro daoObraTeatro = new DaoObraTeatro();
                daoObraTeatro.eliminar(id);
                
                this.vistaGestionObras.getjError().setText("Obra de Teatro Eliminada");
                this.vistaGestionObras.getjIDEliminar().setText("");
                
            }catch(NumberFormatException nfe){    
                this.vistaGestionObras.getjError().setText("Llena el campo con la ID");
            }
            
            this.actualizarTabla();
        }
        
        if(this.vistaGestionObras.getjRegresar() == evento.getSource()){
            VistaOpcionesGestionObras vistaOpciones = new VistaOpcionesGestionObras();
            ControlOpcionObras controlOpciones = new ControlOpcionObras(vistaOpciones);
            
            vistaOpciones.setVisible(true);
            this.vistaGestionObras.dispose();
        }
        
    }
    
    public void actualizarTabla(){
        DaoObraTeatro daoObraTeatro = new DaoObraTeatro();
        DefaultTableModel model = (DefaultTableModel) this.vistaGestionObras.getjVistaPreviaObras().getModel();
        //Inicializar todas las obras registradas
        ArrayList<ObraTeatro> listaObras = daoObraTeatro.getLista();
        
        //Eliminar Datos para actualizar
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }   
        
        //Si no está vacio entonces llenamos la tabla
        for(int i = 0; i < listaObras.size(); i++){
            String[] obra = {String.valueOf(listaObras.get(i).getId()), listaObras.get(i).getNombre()};
            if(!listaObras.isEmpty()){
                model.addRow(obra);
            }
        }   
    }
    
}
