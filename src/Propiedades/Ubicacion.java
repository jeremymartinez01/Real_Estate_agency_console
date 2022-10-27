/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propiedades;

/**
 *
 * @author ERWIN AURIA
 */
public class Ubicacion {

    private String provincia;
    private String ciudad;
    private String sector;
    private String direccion;
    
    /**
     * Constructor de la clase Ubicacion
     * @param provincia
     * @param ciudad
     * @param sector
     * @param direccion 
     */

    public Ubicacion(String provincia, String ciudad, String sector, String direccion) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.sector = sector;
        this.direccion = direccion;
    }
    
    /**
     * Constructor de la clase Ubicacion que recibe 2 parametroa
     * @param ciudad
     * @param sector 
     */
    
    public Ubicacion(String ciudad, String sector){
        this("", ciudad, sector, "");
    }

    @Override
    public String toString() {
        return "Provincia: " + provincia + ", Ciudad: " + ciudad + ", Sector: " + sector + ", Direccion: " + direccion;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj != null){
            if (obj instanceof Ubicacion){
                Ubicacion other = (Ubicacion) obj;
                if (other.ciudad.isEmpty() && sector.isEmpty()){
                    return true;
                }
                else if (ciudad.equals(other.ciudad) && other.sector.isEmpty()){
                    return true;                    
                }
                else if (other.ciudad.isEmpty() && sector.equals(other.sector)){
                    return true;
                }
                else if (ciudad.equals(other.ciudad) && sector.equals(other.sector)){
                    return true;
                }
                else{
                    return false; 
                }
            }
            return false;
        }
        return false;
    }

   /**
    * Metodo get de Provincia
    * @return 
    */
    public String getProvincia() {
        return provincia;
    }
    
    /**
     * metodo get de Ciudad
     * @return 
     */
    public String getCiudad() {
        return ciudad;
    }
    
    /**
     * Metodo get de Sector
     * @return 
     */
    public String getSector() {
        return sector;
    }
    
    /**
     * Metodo get de Direccion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }
    
    
    
}
