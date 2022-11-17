/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import Control.*;
import Dominio.*;
import Vista.*;
/**
 *
 * @author jeanb
 */
public class MainTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario = new Usuario();
        PantallaInicio pantallaInicio = new PantallaInicio();
        ControlInicio controlInicio = new ControlInicio(pantallaInicio, usuario);
        pantallaInicio.setVisible(true);
    }
    
}
