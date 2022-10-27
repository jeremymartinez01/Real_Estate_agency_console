/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

import java.util.ArrayList;
import proyectopoo.Agencia;

/**
 *
 * @author jjmg0
 */
public class Casa extends Propiedad{
    public int pisos;
    public int habitaciones;
    
    /**
     * Constructor de la clase hija Casa
     * @param precio
     * @param ancho
     * @param profundidad
     * @param ubicacion
     * @param descripcion
     * @param p
     * @param pisos
     * @param habitaciones 
     */

    public Casa(double precio, double ancho,  double profundidad, Ubicacion ubicacion, String descripcion,ArrayList<Propiedad> p, int pisos, int habitaciones) {
        super(precio, ancho, profundidad, ubicacion, descripcion,p);
        this.pisos = pisos;
        this.habitaciones = habitaciones;
    }   
}
