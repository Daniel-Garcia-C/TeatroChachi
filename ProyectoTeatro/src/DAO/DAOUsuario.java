/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author jeanb
 */
public class DAOUsuario {
     private ArrayList <Usuario> lista;
    
    public DAOUsuario() throws IOException{
        this.lista = new ArrayList <Usuario>();
        
        String separador = ",";
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader("Usuarios.txt"));
            String linea = bufferLectura.readLine();
            Usuario usuario;
            while (linea != null){
                String[] datos = linea.split(separador);
                usuario = new Usuario(datos[0], datos[1], datos [2], datos[3], datos[4]);
                lista.add(usuario);
                linea = bufferLectura.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (bufferLectura != null){
                bufferLectura.close();
            }
        }
    }
    
    
    public int insertar(Usuario usuario){
        for (int i = 0; i<lista.size(); i++){
            if (usuario.getCurp().equals(lista.get(i).getCurp())){
                System.out.println("Usuario ya registrado");
                return 1;
            }
        }
        lista.add(usuario);
        try {
            FileWriter writer = new FileWriter("Usuarios.txt", false);
            for (int i = 0; i<lista.size(); i++){
                writer.write(lista.get(i).getNombre() + "," + lista.get(i).getApellido() + "," + lista.get(i).getCurp() + "," + lista.get(i).getNombreUsuario() + "," + lista.get(i).getContrasenia() +  "\r\n");
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuario añadido exitosamente");
        return 0;
    }
    
    public int eliminar(Usuario usuario){
        for(int i=0; i<lista.size(); i++){
            if(usuario.getCurp().equals(lista.get(i).getCurp())){
                lista.remove(i);
                
                //Actualizando el archivo .TXT con la lista modificada
                try{
                    FileWriter writer = new FileWriter("Usuarios.txt", false);
                    for(int j=0; j < lista.size(); j++){
                        writer.write(lista.get(j).getNombre()+","+lista.get(j).getApellido()+ "," + lista.get(j).getCurp() + "," + lista.get(j).getNombreUsuario() + "," + lista.get(j).getContrasenia() +  "\r\n");
                    }
                    writer.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }            
                System.out.println("Usuario eliminado");
                return 0;  //Regsitro eliminado
            }
        }    
        System.out.println("Usuario no encontrado");
        return 1; //Registro no encontrado
    }
    
    public int modificar(Usuario usuario){
        for(int i=0; i<lista.size(); i++){
            if(usuario.getCurp().equals(lista.get(i).getCurp())){
                lista.set(i, usuario);
                
                //Actualizando el archivo .TXT con la lista modificada
                try{
                    FileWriter writer = new FileWriter("Usuarios.txt", false);
                    for(int j=0; j < lista.size(); j++){
                        writer.write(lista.get(j).getNombre()+","+lista.get(j).getApellido()+ "," + lista.get(j).getCurp() + "," + lista.get(j).getNombreUsuario() + "," + lista.get(j).getContrasenia() + "\r\n");
                    }
                    writer.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Usuario modificado");
                return 0;  //Regsitro modificado
            }
        } 
        System.out.println("Usuario inexistente");
        return 1; //Registro no encontrado
    }      

     public Usuario recuperar(String primerLabel, String contrasenia){
        for (int i=0; i<lista.size(); i++){
            if (((lista.get(i).getNombreUsuario().equals(primerLabel)) || (lista.get(i).getCurp().equals(primerLabel))) && lista.get(i).getContrasenia().equals(contrasenia)){
                return lista.get(i);
            }
        }
        System.out.println("Usuario no encontrado");
        return null;
    }
}


