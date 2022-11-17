/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author jeanb
 */
public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String curp;
    protected String nombreUsuario;
    protected String contrasenia;

    public Usuario(String nombre, String apellido, String curp, String nombreUsuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curp = curp;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
    
    public Usuario(){
        
    }

    public String getCurp() {
        return curp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
    
    
}
