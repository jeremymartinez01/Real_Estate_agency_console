/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.EstadoPropiedad;
import Propiedades.Propiedad;
import java.time.LocalDate;
import java.time.LocalDateTime;
import proyectopoo.*;

import java.util.ArrayList;

/**
 *
 * @author jjmg0
 */
public class Agente extends Usuario {
    private int numeroVentas;
    private int codigo;
    private ArrayList<Propiedad> propiedadesCargo;
    private int numeroRespuestas;
    
    /**
     * Constructor de Agente
     * @param cedula
     * @param nombre
     * @param usuario
     * @param email
     * @param contrasenia
     * @param numeroVentas
     * @param user 
     */

    public Agente(String cedula, String nombre, String usuario, String email, String contrasenia,int numeroVentas,ArrayList<Usuario>user) {
        super(cedula, nombre, usuario, email, contrasenia);
        this.numeroVentas = numeroVentas;
        this.codigo=user.size()+1;
        this.propiedadesCargo = new ArrayList<>();
        this.numeroRespuestas=0;
    }
    
    public CompraVenta registrarVenta(Usuario u,Propiedad p){
        if (p.getEstado().equals(EstadoPropiedad.DISPONIBLE)){
            CompraVenta cv = new CompraVenta(u, p);
            p.setEstado(EstadoPropiedad.NODISPONIBLE);
            this.numeroVentas += 1;
            System.out.println("La venta se ha registrado con exito");
            return cv;
            
        }
        else{
            System.out.println("La propiedad no se encuentra Disponible para la venta");
        }
        return null;
    }
    
    /**
     * Metodo que muestra las interacciones que ha realizado el agente
     * @param agencia 
     */
    public void mostrarInteracciones(Agencia agencia){
        ArrayList<Interaccion> interacciones = agencia.getInteracciones();
        for (Interaccion i: interacciones){
            if (propiedadesCargo.contains(i.getPropiedad())){
                i.toString();
            }
        }
    }
    
    /**
     * Metodo que responde una interaccion realizada por el cliente
     * @param agencia
     * @param respuesta
     * @param id 
     */
    public void responderInteraccion(Agencia agencia, String respuesta, int id){
        ArrayList<Interaccion> interacciones = agencia.getInteracciones();
        for (Interaccion i: interacciones){
            if (propiedadesCargo.contains(i.getPropiedad()) && i.getId()==id && i.getEstado().equals("No Respondida")){
                i.setRespuestaAgente(respuesta);
                i.setFechares(LocalDateTime.now());
                i.setEstado("Respondida");
                numeroRespuestas+=1;
            }
            else{
                System.out.println("El ID de la consulta no es el correcto");
            }
        }
    }
    
    
    
   
    public int getNumeroVentas() {
        return numeroVentas;
    }

    public ArrayList<Propiedad> getPropiedadesCargo() {
        return propiedadesCargo;
    }

    public int getNumeroRespuestas() {
        return numeroRespuestas;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
    
    
    
    
    
}
