 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.ObraTeatro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DANIEL GARCIA
 */
public class DaoObraTeatro {
    
    private ArrayList<ObraTeatro> lista;
    private String documento = "ObrasTeatro.txt";

    public DaoObraTeatro() {
        this.lista = new ArrayList<ObraTeatro>();
        this.lectura();
    }
    
    public void insertar(ObraTeatro obra){
        
        //lectura() = Obtener el array this.lista
        this.lectura();
        int id = this.consultarOrganizarUltimoID();
        
        obra.setId(id);
        this.lista.add(obra);
        
        try{
            FileOutputStream fos = new FileOutputStream(this.documento);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(this.lista);
            
            System.out.println("Exito en la carga");
            
            oos.close();
            fos.close();
            
        }catch(IOException ex){
           ex.printStackTrace();
           System.out.println("Falla en la carga");
        }
    
    }
    
    public void modificar(ObraTeatro obra){
        
        this.lectura();
        
        //Seguro para comprobar todos los indices
        for(int i = 0; i < this.lista.size(); i++){
            if(this.lista.get(i).getId() == obra.getId()){
                obra.setId((obra.getId()-1));
                this.lista.set(i, obra);
            }
        }
        
        this.consultarOrganizarUltimoID();
        
        //Reescribir la informacion
        try{
            FileOutputStream fos = new FileOutputStream(this.documento);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(this.lista);
            
            System.out.println("Exito en la carga");
            
            oos.close();
            fos.close();
            
        }catch(IOException ex){
           ex.printStackTrace();
           System.out.println("Falla en la carga");
        }
        
    }
    
    public void eliminar(int id){
        
        this.lectura();
        
        for(int i = 0; i < this.lista.size(); i++ ){
         
            if(this.lista.get(i).getId() == id){
                try{
                    this.lista.remove(i);
                }catch(IndexOutOfBoundsException ioobe){
                    System.out.println("Elemento No eliminado");
                }
            }
        }
        
        this.consultarOrganizarUltimoID();
        
        try{
            FileOutputStream fos = new FileOutputStream(this.documento);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(this.lista);
            
            System.out.println("Exito en la carga");
            
            oos.close();
            fos.close();
            
        }catch(IOException ex){
           ex.printStackTrace();
           System.out.println("Falla en la carga");
        }
        
    }
    
    public ObraTeatro consultar(int id){
        
        this.lectura();
  
            for(int i = 0; i < this.lista.size(); i++ ){
                if(this.lista.get(i).getId() == id){    
                    return this.lista.get(i);
                }
            }
        return null;
    }
    
    public void lectura(){
        
        try{
            File file = new File(this.documento);

            if(file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis); 
                this.lista = (ArrayList<ObraTeatro>)ois.readObject();
                ois.close();
                fis.close();
                
                System.out.println("Exito en la lectura");
            }

        }catch(Exception ex){
           ex.printStackTrace();
           System.out.println("Falla en la lectura");
        }

    }
    
    public int consultarOrganizarUltimoID(){
        int id = -1;
        
        if(this.lista.isEmpty()){
            id = 1;
        }
        else{
            for(int i = 0; i < this.lista.size(); i++ ){
                this.lista.get(i).setId((i+1));
                id = i+1;
            }
        }
        return (id+1);
    }

    public ArrayList<ObraTeatro> getLista() {
        this.lectura();
        return this.lista;
    }
    
    
}
