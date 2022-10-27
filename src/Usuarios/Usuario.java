/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author jjmg0
 */
public class Usuario {
  private String cedula;
  private String nombre;
  private String email;
  private String usuario;
  private String contrasenia;
  
  /**
   * Constructor de Usuario
   * @param cedula
   * @param nombre
   * @param usuario
   * @param email
   * @param contrasenia 
   */
  private static ArrayList<Alerta> alertas; 

    public Usuario(String cedula, String nombre, String usuario, String email, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.contrasenia = contrasenia;
    }  
    
  @Override
    public boolean equals(Object obj){
//        Verifico que obj sea diferente de null
        if (obj != null){
//            verifico que obj sea una instancia de Usuario
            if (obj instanceof Usuario){
//                Hago un casting de Usuario para poder acceder a sus atributos.
                Usuario other = (Usuario) obj;
//                comparo las cedulas, si son iguales, los usuarios son los mismos.
                if (cedula.equals(other.cedula)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n"+"Cedula:" + cedula + "Nombre:" + nombre + ", Email:" + email + ", Usuario:" + usuario + ", Contraseña=" + contrasenia;
    }

    

    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }

    public String getCedula() {
        return cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }   
    public ArrayList<Alerta> getAlertas(){
        return alertas;
    }
}   