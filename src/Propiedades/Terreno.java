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
public class Terreno extends Propiedad{
    private TipoTerreno tipoTerreno;   
    
    /**
     * Constructor de la clase hija Terreno
     * @param precio
     * @param ancho
     * @param profundidad
     * @param ubicacion
     * @param descripcion
     * @param p
     * @param tipoTerreno 
     */

    public Terreno(double precio, double ancho, double profundidad, Ubicacion ubicacion, String descripcion,ArrayList<Propiedad> p, TipoTerreno tipoTerreno) {
        super(precio, ancho, profundidad, ubicacion, descripcion,p);
        this.tipoTerreno = tipoTerreno;
    }
}
