/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.Propiedad;
import Propiedades.Terreno;
import java.time.LocalDate;
import java.util.ArrayList;
import proyectopoo.Agencia;
import proyectopoo.CompraVenta;
import proyectopoo.Interaccion;
import static proyectopoo.StringFecha.enIntervalo;

import static proyectopoo.StringFecha.stringAFecha;

/**
 *
 * @author jjmg0
 */

public class Administrador extends Usuario {
    
    /**
     * Constructor de la clase Administrador
     * @param cedula
     * @param nombre
     * @param usuario
     * @param email
     * @param contrasenia 
     */
   
    public Administrador(String cedula, String nombre, String usuario, String email, String contrasenia) {
        super(cedula, nombre, usuario, email, contrasenia);
    } 
    
    /**
     * Metodo que permite registrar a un agente a la agencia, donde se ingresa como parametro solo el nombre,
     * cedula, correo del agente mas la agencia, ya que queremos obtener de ella la lista de Usuarios para que 
     * se genere el codigo
     * @param nombre
     * @param cedula
     * @param correo
     * @param agencia
     * @return 
     */
    
    public Usuario registrarAgente(String nombre,String cedula, String correo,Agencia agencia){
        String user=nombre;   
        String password="";
        int numeroVentas=0;
        Usuario agente= new Agente(cedula,nombre,user,correo,password,numeroVentas,agencia.getUsuarios());
        return agente;
    }
    
    /**
     * Metodo que ingresa como parametro un rango de fecha para asi mostrar un reporte de ventas
     * @param fechaInicio
     * @param fechaFinal
     * @param venta 
     */
    
    public void reporteContactosVentas(String fechaInicio,String fechaFinal,ArrayList<CompraVenta> venta){
        System.out.printf("%12s"+"%15s"+"%15s"+"\n","Agente","N° de Ventas","N° de respuestas");
        LocalDate fechIni=stringAFecha(fechaInicio);
        LocalDate fechFin=stringAFecha(fechaFinal);
        for(CompraVenta cv: venta){
            if(enIntervalo(fechIni, fechFin, cv.getFecha())){
                Usuario u=cv.getUsuario();
                Agente a=(Agente)u;
                System.out.printf("%12s"+"%15s"+"%15s"+"\n",a.getCodigo(),a.getNumeroVentas(),a.getNumeroRespuestas());
                
            }
        }      
    }

    /**
     * Metodo que muestra las ventas realizadas por el agente segun el codigo que se ingrese ademas
     * de las consultas atendidas por él
     * @param codigo
     * @param venta
     * @param consultas 
     */
    public void ventasConsultas(int codigo,ArrayList<CompraVenta> venta,ArrayList<Interaccion> consultas){
        System.out.println("VENTAS");
        for(CompraVenta cv: venta){
            Usuario u=cv.getUsuario();
            Agente a=(Agente)u;
            if(a.getCodigo()==codigo)
            System.out.println(cv);
        }
        System.out.println("CONSULTAS");
        for(Interaccion i: consultas){
            System.out.println(i.getPreguntaCliente());
            System.out.println(i.getRespuestaAgente());
        }
    }
    
  
}
