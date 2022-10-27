/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ERWIN AURIA
 */

public class StringFecha {
    
    /**
     * Metodo que recibe un String y retorna una fecha
     * @param c
     * @return 
     */
    
    public static LocalDate stringAFecha(String c){
        if(c!=null){
            DateTimeFormatter f = DateTimeFormatter.ofPattern("d'/'M'/'yyyy");
            LocalDate nuevafecha = LocalDate.parse(c,f);  
            return nuevafecha;
         }
        return null;
    }
    
    /**
     * Metodo que recibe un String y retorna la edad 
     * @param f
     * @return 
     */
    
    public static int edad(String f){
        
        LocalDate hoy=LocalDate.now();
        LocalDate fechaNacimiento= stringAFecha(f);
        Period edad= Period.between(fechaNacimiento, hoy);
        return edad.getYears();
    }
    
    /**
     * Retorna verdadero si el objeto buscar se encunetra 
     * en el intervalo de tiempo entre inicio y fin. Caso contrario retorna falso
     * @param inicio
     * @param fin
     * @param buscar
     * @return 
     */
    
    public static boolean enIntervalo(LocalDate inicio, LocalDate fin, LocalDate buscar){
        return buscar.isAfter(inicio) && buscar.isBefore(fin);
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);    
    }
    
}
