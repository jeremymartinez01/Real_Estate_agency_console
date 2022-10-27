/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.Ubicacion;

/**
 *
 * @author wgcotera
 */
public class Alerta {
    private String tipoPropiedad;
    private double precioMin;
    private double precioMax;
    private Ubicacion ubicacion;

    public Alerta(String tipoPropiedad, double precioMin, double precioMax, Ubicacion ubicacion) {
        this.tipoPropiedad = tipoPropiedad;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
        this.ubicacion = ubicacion;
    }
    
     public boolean equals(Object obj){
//        Verifico que obj sea diferente de null
        if (obj != null){
//            verifico que obj sea una instancia de Alerta
            if (obj instanceof Alerta){
//                Hago un casting de Alerta para poder acceder a sus atributos.
                Alerta other = (Alerta) obj;
//                comparo todos los atributos, si todos son iguales la alerta ya existe 
                if (tipoPropiedad.equals(other.tipoPropiedad)){
                    if (precioMin == other.precioMin){
                        if (precioMax == other.precioMax){
                            if (ubicacion.equals(other.ubicacion)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public String getTipoPropiedad(){
        return tipoPropiedad.toUpperCase();
    }
    
    public double getPrecioMin(){
        return precioMin;
    }
    
    public double getPrecioMax(){
        return precioMax;
    }
    
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
}
