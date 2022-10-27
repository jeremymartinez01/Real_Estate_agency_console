/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Propiedades.Propiedad;
import Sistema.Main;
import Usuarios.Agente;
import Usuarios.Usuario;
import java.time.LocalDateTime;
import java.util.Scanner;
import proyectopoo.Agencia;
import proyectopoo.CompraVenta;
import proyectopoo.Interaccion;

/**
 *
 * @author ERWIN AURIA
 */
public class InterfazAgente {

    private Scanner sc;
    
    /**
     * Constructor de la Interfaz Agente
     */
    public InterfazAgente(){
        sc = new Scanner(System.in);
    }
        
    /**
     * Menu principal de la Interfaz del Agente
     * @param agencia
     * @param user 
     */
    public void menuPrincipal(Agencia agencia, Agente user){
        String op = "";
        String respuesta="";
        System.out.println("\n--- BIENVENIDO SR(A). "+user.getUsuario().toUpperCase()+" ---");
        do{
            System.out.println("1. Revisar Buzón");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Salir");
            System.out.println("Ingrese opcion: ");
            op = sc.nextLine();
            
            switch(op){
                case "1":
                    opcion1(agencia, user);
                    break;
                case "2":
                    opcion2(agencia, user);
                    System.out.println("\n¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(agencia,user);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                    break;
                case "3":
                    System.out.println("Adios");      
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!op.equals("3")); 
        
    }
    
    /**
     * Opcion 1, permite al agente revisar el buzon y responder los mensajes
     * @param agencia
     * @param user 
     */
    private void opcion1(Agencia agencia, Agente user){
        System.out.printf("\n"+"%12s"+"\n","*** Revisar Buzon***");
        user.mostrarInteracciones(agencia);
        String op = "";
        do{
            System.out.println("¿Desea responder una consulta? (si o no): ");
            op = sc.nextLine().toLowerCase();
            switch(op){
                case "si":
                    System.out.println("Ingrese el ID de la consulta que desea responder: ");
                    String idInteraccion = sc.nextLine();
                    System.out.println(agencia.getInteracciones());
                    for (Interaccion i: agencia.getInteracciones()){
                        System.out.println("Ingrese su respuesta: ");
                        String respuesta = sc.nextLine();
                        user.responderInteraccion(agencia, respuesta, Integer.parseInt(idInteraccion));
                        break;
                    }
                case "no":
                    menuPrincipal(agencia, user);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    menuPrincipal(agencia, user);
                    break;
            }
        }while(op.equals("si")); 
        
    }
    
    /**
     * Opcion 2, permite al agente registrar una venta 
     * @param agencia
     * @param user 
     */
    private void opcion2(Agencia agencia, Agente user){
        System.out.printf("\n"+"%12s"+"\n","*** Registrar Venta ***");
        System.out.println("Ingrese cedula del Cliente: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el codigo de la propiedad: ");
        String cod = sc.nextLine();
        int codigo = Integer.parseInt(cod);
        for (Usuario u: agencia.getUsuarios()){
            if(cedula.equals(u.getCedula())){
                for(Propiedad p: agencia.getPropiedades()){
                    if(codigo == p.getCodigo()){
                        CompraVenta venta = user.registrarVenta(u, p);
                        agencia.agregarCompraVenta(venta);
                        System.out.println("La venta se ha registrado con exito");
                        break;
                    }
                    
                }   
            }
        }           
    }
    

    public static void main(String[] args){
        Main n= new Main();  
        Agencia agencia = new Agencia();
        Agente agente1=new Agente("0942874485","Washington Cotera","wgcotera","wgcotera@gmail.com","aeiou",10,agencia.getUsuarios());
        InterfazAgente u= new InterfazAgente();
        u.menuPrincipal(agencia, agente1);
    }
    
    
}
