/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Correo.EnviaMail;
import Sistema.Main;
import Usuarios.Administrador;
import java.util.Scanner;
import Propiedades.Propiedad;
import Propiedades.Terreno;
import Propiedades.Casa;
import Propiedades.TipoTerreno;
import Propiedades.Ubicacion;
import Usuarios.Usuario;
import Usuarios.Cliente;
import Usuarios.Alerta;
import java.util.ArrayList;
import proyectopoo.Agencia;
import proyectopoo.CompraVenta;
import proyectopoo.Interaccion;

/**
 *
 * @author ERWIN AURIA
 */
public class InterfazAdministrador {

    private Scanner sc;
    
    /**
     * Constructor de InterfazAdministrador
     */
    
    public InterfazAdministrador(){
        sc = new Scanner(System.in);
    }
        
    /**
     * Menu principal de la interfaz del Administrador
     * @param admin
     * @param agencia 
     */
    public void menuPrincipal(Administrador admin, Agencia agencia){
        String op = "";
        String respuesta="";
        System.out.println("\n--- BIENVENIDO SR(A). "+admin.getUsuario().toUpperCase()+" ---");
        do{
            System.out.println("1. Registrar propiedad");
            System.out.println("2. Registrar Agente");
            System.out.println("3. Reporte Contactos y Ventas");
            System.out.println("4. Salir");
            System.out.println("Ingrese opcion: ");
            op = sc.nextLine();
            
            switch(op){
                case "1":
                    opcion1(agencia);
                    System.out.println("\n¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(admin,agencia);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                    break;
                case "2":
                    opcion2(admin,agencia);
                    System.out.println("\n¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(admin,agencia);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                    
                    break;
                case "3":
                    opcion3(admin,agencia);
                    break;
                case "4":
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!op.equals("4")); 
        
    }
    
   /**
    * Realiza la opcion 1 que es registrar una propiedad ya sea terreno o casa
    * @param agencia 
    */
    private void opcion1(Agencia agencia){
        String op = "";
        System.out.printf("\n"+"%12s"+"\n","*** Registrar Propiedad ***");
        System.out.println("Ingrese el precio: ");
        Double precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el ancho: ");
        Double ancho = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la profundidad: ");
        Double profundidad = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la provincia: ");
        String provincia = sc.nextLine();
        System.out.println("Ingrese la ciudad: ");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese la direccion: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese el sector: ");
        String sector = sc.nextLine();
        System.out.println("Ingrese una pequeña descripcion: ");
        String d = sc.nextLine();
        Ubicacion ubicacion=new Ubicacion(provincia,ciudad,direccion,sector);
        System.out.println("Escoja el tipo de propiedad: ");
        String tipo="";
        Propiedad p=null;
        System.out.println("1. Terreno");
        System.out.println("2. Casa");
        System.out.println("Ingrese opcion: ");
        op = sc.nextLine();
        //sc.nextLine();
        switch(op){
                case "1":
                    System.out.println("Ingrese tipo de terreno: ");
                    tipo = sc.nextLine().toUpperCase();
                    TipoTerreno t = TipoTerreno.valueOf(tipo);
                    p= new Terreno(precio,ancho,profundidad,ubicacion,d,agencia.getPropiedades(),t);
                    agencia.agregarPropiedad(p);
                    if(agencia.getPropiedades().contains(p)){
                        System.out.println("\nSe registro exitosamente");
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el numero de pisos: ");
                    Integer nPisos = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el numero de habitaciones: ");
                    Integer nHabitaciones = sc.nextInt();
                    sc.nextLine();
                    p= new Casa(precio,ancho,profundidad,ubicacion,d,agencia.getPropiedades(),nPisos,nHabitaciones);
                    agencia.agregarPropiedad(p); 
                    if(agencia.getPropiedades().contains(p)){
                        System.out.println("\nSe registro exitosamente");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

            for (Usuario usu: agencia.getUsuarios()){
                if (usu instanceof Cliente){
                    for(Alerta alert: usu.getAlertas() ){
                        if (alert.getTipoPropiedad().equals(tipo)){
                            if (precio>= alert.getPrecioMin() && precio<= alert.getPrecioMax()){
                                if(ubicacion.equals(alert.getUbicacion())){
                                    EnviaMail.enviarcorreo(usu.getEmail(), p.toString());
                                }
                            }
                        }
                        
                    }
                }
            }
        
    }
    
    
    /**
     * Realiza la opcion 2 que es registrar agentes, en la cual se ingresara como parametro el administrador
     * ya que él es el encargado de registrarlo para proceder a guardarlo en la agencia
     * @param admin
     * @param agencia 
     */

    private void opcion2(Administrador admin, Agencia agencia){
        System.out.printf("\n"+"%12s"+"\n","*** Registrar Agentes ***");
        System.out.println("Ingrese el nombre del agente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la cedula del agente: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el correo: ");
        String correo = sc.nextLine();
        
        Usuario newAgente=admin.registrarAgente(nombre, cedula, correo,agencia);
        agencia.agregarUsuario(newAgente); 
        if(agencia.getUsuarios().contains(newAgente)){
            System.out.println("Se registro exitosamente");
        }
        
    }
    
    /**
     * realiza la opcion 3 que le muestra al administrador un reporte de contactos y ventas 
     * @param ad
     * @param a 
     */

    private void opcion3(Administrador ad,Agencia a){
        System.out.printf("\n"+"%12s"+"\n","*** Reporte Contacto y Ventas ***");
        
        System.out.println("Ingrese la fecha inicial: ");
        String fechaInicial = sc.nextLine();
        System.out.println("Ingrese la fecha inicial: ");
        String fechaFinal = sc.nextLine();
        ad.reporteContactosVentas(fechaInicial,fechaFinal,a.getCompraVenta());
        System.out.println("Ingrese el codigo del Agente: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        ad.ventasConsultas(codigo,a.getCompraVenta(),a.getInteracciones());
    }
    
    
    public static void main(String[] args){
        Main n= new Main();
        /*Agencia agencia = new Agencia();
        Administrador admin=new Administrador("0951978055","Damian Morgan","admin","morgan08@gmail.com","admin");
        InterfazAdministrador u= new InterfazAdministrador();
        u.menuPrincipal(admin, agencia);*/
    }
    
    
}
