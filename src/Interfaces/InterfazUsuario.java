/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Sistema.Main;
import Usuarios.Administrador;
import Usuarios.Agente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import java.util.Scanner;
import proyectopoo.Agencia;
import static proyectopoo.StringFecha.edad;
import static proyectopoo.StringFecha.stringAFecha;

/**
 *
 * @author ERWIN AURIA
 */
public class InterfazUsuario {

    private Scanner sc;

    public InterfazUsuario(){
        sc = new Scanner(System.in);         
    }
    
    /**
     * Menu Principal de la Interfaz Usuario
     * @param agencia 
     */
    public void menuPrincipal(Agencia agencia){
        String op = "";
        System.out.println("--- BIENVENIDO(A) A NUESTRA AGENCIA DE BIENES RAICES ---");
        do{
            System.out.println("1. Iniciar  Sesión");
            System.out.println("2. Registrarse");
            System.out.println("Ingrese opcion: ");
            op = sc.nextLine();
            
            switch(op){
                case "1":
                    opcion1(agencia);
                    System.out.println("Credenciales incorrectas.Vuelva a ingresar\nSi no tiene cuenta, proceda a registrarse\n");
                    break;
                case "2":
                    opcion2(agencia);
                    System.out.println("¿Desea volver al menu anterior? (si/no)");
                    String respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si")){
                        menuPrincipal(agencia);
                    }  
                    break;
                default:
                    System.out.println("Opcion invalida\n");
                    break;
            }
        }while(!op.equals("2")); 
        
    }
   
    /**
     * Opcion 1 que permite a un usuario Iniciar Sesion
     * @param agencia 
     */
    private void opcion1(Agencia agencia){
        System.out.println("Ingrese Usuario: ");
        String username = sc.nextLine();
        System.out.println("Ingrese Contraseña : ");
        String password = sc.nextLine();
        for(Usuario u: agencia.getUsuarios()){
            if(username.equals(u.getUsuario())&& password.equals(u.getContrasenia())){
                if(u instanceof Administrador){
                    Administrador admin=(Administrador)u;
                    InterfazAdministrador administrador = new InterfazAdministrador();
                    administrador.menuPrincipal(admin,agencia);
                    break;
                }
                else if(u instanceof Cliente){
                    Cliente cliente=(Cliente)u;
                    InterfazCliente iCliente = new InterfazCliente();
                    iCliente.menuPrincipal(agencia, cliente);
                    break;
                }
                else if(u instanceof Agente){
                    Agente agente=(Agente)u;
                    InterfazAgente iAgente = new InterfazAgente();
                    iAgente.menuPrincipal(agencia, agente);
                    break;
                }  
            }
        }      
    }
    
    /**
     * Opcion 2, permite a un cliente registrarse
     * @param agencia 
     */
    private void opcion2(Agencia agencia){
        System.out.println("Ingrese Nombre y Apellido: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Cedula: ");
        String ci = sc.nextLine();
        System.out.println("Ingrese Correo: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese Fecha de nacimiento (DD/MM/AAAA): ");
        String fecha= sc.nextLine();
        Usuario usuarioNuevo;
        if(edad(fecha)>=18){
            System.out.println("Ingrese Usuario: ");
            String user = sc.nextLine();
            System.out.println("Ingrese Contraseña: ");
            String contrasenia = sc.nextLine();   
            usuarioNuevo= new Cliente(ci,nombre,user,correo,contrasenia,stringAFecha(fecha));
            agencia.agregarUsuario(usuarioNuevo);
      
        }else{
            System.out.println("No cumple los requerimientos");
            }        
    }

    public static void main(String[] args){
        Main n= new Main();
    }   
}

