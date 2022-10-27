/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

import static Propiedades.EstadoPropiedad.*;
import java.util.ArrayList;


/**
 *
 * @author jjmg0
 */
public class Propiedad {
    private int codigo;
    private double precio;
    private double ancho;
    private double profundidad;
    private EstadoPropiedad estado;
    public Ubicacion ubicacion;
    private String descripcion;
    
    /**
     * Constructor de´Propiedad
     * @param precio
     * @param ancho
     * @param profundidad
     * @param ubicacion
     * @param descripcion
     * @param p 
     */

    public Propiedad(double precio, double ancho, double profundidad,Ubicacion ubicacion, String descripcion,ArrayList<Propiedad> p) {
        codigo = p.size()+1;
        this.precio = precio;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.estado = DISPONIBLE;
        this.ubicacion = ubicacion;
        this.descripcion=descripcion;
    }
    
    
    @Override
    public boolean equals(Object obj){
//        Verifico que obj sea diferente de null
        if (obj != null){
//            verifico que obj sea una instancia de Usuario
            if (obj instanceof Propiedad){
//                Hago un casting de Usuario para poder acceder a sus atributos.
                Propiedad other = (Propiedad) obj;
//                comparo las cedulas, si son iguales, los usuarios son los mismos.
                if (codigo == other.codigo){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que retorna el area de esa propiedad
     * @return 
     */
    public double calcularArea(){
        return ancho*profundidad;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nPrecio: " + precio + "\nAncho: " + ancho + "\nProfundidad: " + profundidad +"\nArea: " + calcularArea() +"m2"+ "\nEstado: " + estado + "\nUbicacion " + '{' + ubicacion +'}'+ "\nDescripcion: " + descripcion;
    }

   /**
    * Metodo que se utiliza para mostrar un mensaje presentable
    */
    public void mensaje(){
        System.out.printf("\n"+"%-10d"+"%-50s"+"%-30.2f"+"%-10.2f"+" %-40s"+"%-20s",codigo,descripcion,precio,calcularArea(),ubicacion,"");
    }
    
    /**
     * Metodo get de Precio
     * @return 
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Metodo get de Ancho
     * @return 
     */

    public double getAncho() {
        return ancho;
    }
    
    /**
     * Metodo get de Profundidad
     * @return 
     */

    public double getProfundidad() {
        return profundidad;
    }
    
    /**
     * Metodo get de Codigo
     * @return 
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Metodo get de Estado
     * @return 
     */
    public EstadoPropiedad getEstado() {
        return estado;
    }
    
    /**
     * Metodo set de Estado
     * @param estado 
     */
    public void setEstado(EstadoPropiedad estado) {
        this.estado = estado;
    }
    
    /**
     * Metodo get de Ubicacion
     * @return 
     */
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    
    /**
     * Metodo get de Descripcion
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    
}
