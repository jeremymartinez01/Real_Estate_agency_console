/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Sistema.Main;
import Prestamo.PrestamoAleman;
import Prestamo.PrestamoFrances;
import Propiedades.Propiedad;
import Propiedades.Ubicacion;
import Usuarios.Cliente;
import Usuarios.Usuario;
import java.util.Scanner;
import proyectopoo.Agencia;
import proyectopoo.Interaccion;
import static proyectopoo.StringFecha.capitalize;
import static proyectopoo.StringFecha.stringAFecha;

/**
 *
 * @author ERWIN AURIA
 */
public class InterfazCliente {

    private Scanner sc;
    
    public InterfazCliente(){
        sc = new Scanner(System.in);
    }
        
    /**
     * Menu principal del Interfaz Cliente
     * @param agencia
     * @param user 
     */
    public void menuPrincipal(Agencia agencia, Cliente user){
        String op = "";
        String respuesta="";
        System.out.println("\n--- BIENVENIDO SR(A). "+user.getUsuario().toUpperCase()+" ---");
        do{
            System.out.println("1. Consultar Propiedades");
            System.out.println("2. Buzón de Consultas");
            System.out.println("3. Crear Alerta");
            System.out.println("4. Simular Préstamo");
            System.out.println("5. Volver al menu principal");
            System.out.println("6. Salir");
            System.out.println("Ingrese opcion: ");
            op = sc.nextLine();
            
            switch(op){
                case "1":
                    opcion1(agencia, user);
                    break;
                case "2":
                    opcion2(agencia, user);
                    System.out.println("¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(agencia,user);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                    break;
                case "3":
                    opcion3(user);
                    System.out.println("¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(agencia,user);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                    break;
                case "4":
                    opcion4(agencia,user);
                    System.out.println("\n¿Desea volver al menu anterior? (si/no)");
                    respuesta = sc.nextLine();
                    if(respuesta.toLowerCase().equals("si"))
                        menuPrincipal(agencia,user);
                    else{
                        InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    }
                        
                    break;
                case "5":
                    InterfazUsuario u= new InterfazUsuario();        
                        u.menuPrincipal(agencia);  
                    break;
                case "6":
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida\n");
                    break;
            }
        }while(!op.equals("6")); 
        
    }
    
    /**
     * Opcion 1 permite al usuario buscar una propiedad de acuerdo a diferentes parametros
     * @param agencia
     * @param user 
     */
    
    private void opcion1(Agencia agencia, Cliente user){
        System.out.printf("\n"+"%12s"+"\n","*** Consultar Propiedades ***");
        System.out.println("Ingrese el precio minimo: ");
        String pMin = sc.nextLine();
        System.out.println("Ingrese el precio maximo: ");
        String pMax = sc.nextLine();
        System.out.println("Ingrese el tipo (terreno ó casa): ");
        String tipo = sc.nextLine().toLowerCase();
        System.out.println("Ingrese la ciudad: ");
        String ciudad = sc.nextLine();
        ciudad=capitalize(ciudad);
        System.out.println("Ingrese el sector: ");
        String sector = sc.nextLine();
        sector=capitalize(sector);
        System.out.println();
        
        System.out.printf("%-10s"+"%-50s"+"%-30s"+"%-10s"+" %40s"+"%60s"+"\n","Codigo","Descripcion","Precio","Tamaño","Ubicación"," Consultada");
        Propiedad p;
        //VALIDACION DE DATOS

        Double precioMin = 0.0;
        Double precioMax = Double.MAX_VALUE;
        
        //SI NO INGRESA NADA
        
        if (pMin.isEmpty() && pMax.isEmpty() && tipo.isEmpty() && ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades());
        }
        
        //SI INGRESA PRECIOS
        
        else if (pMax.isEmpty() && tipo.isEmpty() && ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), precioMax);
        }
        else if (pMin.isEmpty() && tipo.isEmpty() && ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), precioMin, Double.parseDouble(pMax));
        }
        else if (tipo.isEmpty() && ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), Double.parseDouble(pMax));
        }
        
        //SI INGRESA TIPO
        
        else if (pMin.isEmpty() && pMax.isEmpty() && ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), tipo);
        }
        
        //SI INGRESA UBICACION
        
        else if (pMin.isEmpty() && pMax.isEmpty() && tipo.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), new Ubicacion(ciudad, sector));
        }
        
        //SI INGRESA PRECIO Y UBICACION
        
        else if (tipo.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), Double.parseDouble(pMax), new Ubicacion(ciudad, sector));
        }
        
        //SI INGRESA PRECIO Y TIPO
        
        else if (ciudad.isEmpty() && sector.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), Double.parseDouble(pMax), tipo);
        }
        
        //SI INGREGA TIPO Y UBICACION
        
        else if (pMin.isEmpty() && tipo.isEmpty()){
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), Double.parseDouble(pMax), new Ubicacion(ciudad, sector));
        }
        
        //SI INGRESA TODO
        
        else{
            user.consultarPropiedades(agencia.getPropiedades(), Double.parseDouble(pMin), Double.parseDouble(pMax), tipo, new Ubicacion(ciudad, sector));
        }
        
        System.out.println("\nIngrese el código de la propiedad que desea mas detalle (o vacío para regresar)");
        String codigo = sc.nextLine();
        if (codigo.isEmpty()){
            menuPrincipal(agencia, user);
        }
        else{
            p = user.consultarPropiedad(agencia.getPropiedades(), Integer.parseInt(codigo));       
            System.out.println(p.toString());
            System.out.println("\n¿Desea realizar una consulta? (si/no): ");
            String respuesta = sc.nextLine().toLowerCase();
            String pregunta="";
            if(respuesta.equals("si")){
                System.out.println("Ingrese su Pregunta: ");
                pregunta = sc.nextLine();
                user.hacerPregunta(agencia, p, pregunta,user);
                System.out.println("Se ha registrado su consulta exitosamente");
                //System.out.println(agencia.getInteracciones());
                menuPrincipal(agencia, user);
            } 
            else{
                menuPrincipal(agencia, user);
            }
        }
    }
    
    /**
     * Opcion 2 permite al usuario consultar su buzon de consultas
     * @param agencia
     * @param user 
     */
    private void opcion2(Agencia agencia, Cliente user){
        System.out.printf("\n"+"%12s"+"\n","*** Buzon de Consultas ***");
        //System.out.println(agencia.getInteracciones());
        System.out.println("Ingrege el codigo de la Propiedad para ver los mensajes: ");
        String c = sc.nextLine();
        //System.out.printf("%-10s"+"%-50s"+"%-30s"+"%-10s"+" %40s"+"\n","Fecha Inicio","CodigoPropiedad","Agente","Pregunta","Estado");
        if (!c.isEmpty()){
            for(Interaccion i: agencia.getInteracciones()){
                if (i.getPropiedad().getCodigo() == Integer.parseInt(c)){
                    System.out.println(i.toString());
                }
            }
        }
    }  
    
    /**
     * Opcion 3 que crea una alerta cuando los 3 parametros ingresados coinciden
     * @param user 
     */
    
    private void opcion3(Cliente user){
        System.out.printf("\n"+"%12s"+"\n","*** Crear Alerta ***");
        System.out.println("Ingrese el tipo de propiedad:");
        String tp = sc.nextLine();
        System.out.println("Ingrese el precio minimo:");
        String p1 = sc.nextLine();
        System.out.println("Ingrese el precio maximo:");
        String p2 = sc.nextLine();
        System.out.println("A continuacion ingrese los datos de ubicacion :");
        System.out.println("Ingrese la provincia:");
        String prov = sc.nextLine();
        System.out.println("Ingrese la ciudad:");
        String city = sc.nextLine();
        System.out.println("Ingrese el sector:");
        String sect = sc.nextLine();
        System.out.println("Ingrese la direccion:");
        String direcc = sc.nextLine();
        
        Ubicacion ub = new Ubicacion(prov,city,sect,direcc);
        
        user.crearAlerta(tp,Double.parseDouble(p1),Double.parseDouble(p2),ub);  
    } 
       
       
    /**
     * Opcion 4 que le permite al usuario Simular un prestamo de acuerdo al sistema 
     * ya sea aleman o frances
     */
       
    private void opcion4(Agencia agencia,Cliente user){
        System.out.printf("\n"+"%30s"+"\n","***** Simular Préstamo *****\n");
        System.out.println("Ingrese el costo: ");
        Double costo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la tasa de interes(%): ");
        Double tasa= sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el numero de cuotas: ");
        Integer cuotas = sc.nextInt();
        sc.nextLine();
        String op = "";
        String r="";
        do{
            System.out.println("Elija el sistema de su preferencia:");
            System.out.println("   1. Sistema De Amortizacion Alemán");
            System.out.println("   2. Sistema De Amortizacion Francés");
            System.out.println("Ingrese opcion: ");
            op = sc.nextLine(); 
            switch(op){
                case "1":
                    PrestamoAleman prestAleman=new PrestamoAleman(costo,tasa,cuotas);
                    prestAleman.calcularPrestamo(costo,tasa,cuotas);
                    System.out.println("\n¿Desea probar los mismos datos con el otro sistema? (si/no)");
                    r = sc.nextLine();
                    break;
                case "2":
                    PrestamoFrances prestFrances=new PrestamoFrances(costo,tasa,cuotas);
                    prestFrances.calcularPrestamo(costo,tasa,cuotas);
                    System.out.println("\n¿Desea probar los mismos datos con el otro sistema? (si/no)");
                    r = sc.nextLine();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(r.equals("si"));
    }
    
    public static void main(String[] args){       
        Main n= new Main();
        /*Agencia agencia = new Agencia();
        Cliente cliente1=new Cliente("0951975555","Eliana Auria","eauria","eauria12@gmail.com","123",stringAFecha("12/08/2001"));
        InterfazCliente u= new InterfazCliente();        
        u.menuPrincipal(agencia,cliente1);*/
    }
}


