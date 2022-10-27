/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Propiedades.Propiedad;
import java.time.LocalDate;
import java.util.ArrayList;
import Propiedades.Terreno;
import Propiedades.Casa;
import static Propiedades.EstadoPropiedad. *;
import Propiedades.Ubicacion;
import java.time.LocalDateTime;
import proyectopoo.Agencia;
import proyectopoo.Interaccion;
import static proyectopoo.StringFecha.capitalize;
/**
 *
 * @author jjmg0
 */
public class Cliente extends Usuario {
    private final LocalDate fechanacimiento;
    private ArrayList<Propiedad> propiedadesConsultadasCliente;
    private static ArrayList<Alerta> alertas;    
   
    /**
     * Constructor de cliente
     * @param cedula
     * @param nombre
     * @param usuario
     * @param email
     * @param contrasenia
     * @param fechanacimiento 
     */
    public Cliente(String cedula, String nombre, String usuario, String email, String contrasenia, LocalDate fechanacimiento) {
        super(cedula, nombre, usuario, email, contrasenia);
        this.fechanacimiento = fechanacimiento;
        propiedadesConsultadasCliente = new ArrayList<>();
        alertas = new ArrayList<>();
    }
    
    /**
     * Metodo que consulta las propiedades cuando no se ingresa un paramtro a excepcion del ArrayList
     * @param propiedades 
     */
    public void consultarPropiedades(ArrayList<Propiedad> propiedades){
        
        for (Propiedad p: propiedades){            
            if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                p.mensaje();
                System.out.printf("%s"+"\n","Si");
                //System.out.println(p.toString()+"Si");
            }
            else if (p.getEstado().equals(DISPONIBLE) ){
                //System.out.println(p.toString()+"No");
                p.mensaje(); 
                System.out.printf("%s"+"\n","No");
            }    
        }
    }
    
    public void consultarPropiedades(ArrayList<Propiedad> propiedades, double precioMin, double precioMax){
        for (Propiedad p: propiedades){
            if (p.getPrecio()>=precioMin && p.getPrecio()<= precioMax){
                if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","Si");
                }
                else if (p.getEstado().equals(DISPONIBLE)){
                    p.mensaje(); 
                    System.out.printf("%s"+"\n","No");
                }
            }
        }
    }
    
    public void consultarPropiedades(ArrayList<Propiedad> propiedades, String tipo){
        for (Propiedad p: propiedades){
            if (tipo.equals("terreno") && p instanceof Terreno){
                if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","Si");
                    //System.out.println(p.toString()+" Consultada: Si");
                }
                else if (p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","No");
                    //System.out.println(p.toString()+" Consultada: No");
                }
            } 
            else if (tipo.equals("casa") && p instanceof Casa){
                if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                    p.mensaje(); 
                    System.out.printf("%s"+"\n","Si");
                }
                else if (p.getEstado().equals(DISPONIBLE)){
                    p.mensaje(); 
                    System.out.printf("%s"+"\n","No");
                }
            }            
        }
    }

    public void consultarPropiedades(ArrayList<Propiedad> propiedades, Ubicacion ubicacion){
        for (Propiedad p: propiedades){
            if (ubicacion.equals(p.ubicacion)){
                if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","Si");
                }
                else if (p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","No");
                }
            }           
        }
    }

    public void consultarPropiedades(ArrayList<Propiedad> propiedades, double precioMin, double precioMax, String tipo){
        for (Propiedad p: propiedades){
            if (p.getPrecio()>= precioMin && p.getPrecio()<= precioMax){
                if (tipo.equals("terreno") && p instanceof Terreno){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                } 
                else if (tipo.equals("casa") && p instanceof Casa){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                }
            }
        }
    }
    
    public void consultarPropiedades(ArrayList<Propiedad> propiedades, double precioMin, double precioMax, Ubicacion ubicacion){
        for (Propiedad p: propiedades){
            if (p.getPrecio()>= precioMin && p.getPrecio()<= precioMax && ubicacion.equals(p.ubicacion)){
                if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","Si");
                }
                else if (p.getEstado().equals(DISPONIBLE)){
                    p.mensaje();
                    System.out.printf("%s"+"\n","No");
                }       
            }
        }
    }
    
    public void consultarPropiedades(ArrayList<Propiedad> propiedades, String tipo, Ubicacion ubicacion){
        for (Propiedad p: propiedades){
            if (ubicacion.equals(p.ubicacion)){
                if (tipo.equals("terreno") && p instanceof Terreno){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                } 
                else if (tipo.equals("casa") && p instanceof Casa){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                }
            }
        }
    }
        
    public void consultarPropiedades(ArrayList<Propiedad> propiedades, double precioMin, double precioMax, String tipo, Ubicacion ubicacion){
        for (Propiedad p: propiedades){
            if (p.getPrecio()>= precioMin && p.getPrecio()<= precioMax && ubicacion.equals(p.ubicacion)){
                if (tipo.equals("terreno") && p instanceof Terreno){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                } 
                else if (tipo.equals("casa") && p instanceof Casa){
                    if(propiedadesConsultadasCliente.contains(p) && p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","Si");
                    }
                    else if (p.getEstado().equals(DISPONIBLE)){
                        p.mensaje();
                        System.out.printf("%s"+"\n","No");
                    }
                }
            }
        }
    }
    
    
   
    public Propiedad consultarPropiedad(ArrayList<Propiedad> propiedades, int codigo){        
        for (Propiedad p: propiedades){
            if (p.getCodigo() == codigo && p.getEstado().equals(DISPONIBLE)){
                if (p instanceof Terreno){
                    if(!propiedadesConsultadasCliente.contains(p)){
                    Terreno terreno = (Terreno)p;                  
                    propiedadesConsultadasCliente.add(p);
                    return p;
                    } 
                } 
                else if (p instanceof Casa){
                   if(!propiedadesConsultadasCliente.contains(p)){
                    Casa casa = (Casa)p;
                    propiedadesConsultadasCliente.add(p);
                    return p;
                   }
                }
            }
        }
        return null;
    }
    
    /**
     * Metodo en el cual el cliente puede hacer una pregunta al agente
     * @param agencia
     * @param p
     * @param preguntaCliente
     * @param u 
     */
    public void hacerPregunta(Agencia agencia, Propiedad p, String preguntaCliente,Usuario u){
        Interaccion interaccion = new Interaccion();
        interaccion.setPreguntaCliente(preguntaCliente);
        interaccion.setFechapre(LocalDateTime.now()); 
        interaccion.setPropiedad(p);
        interaccion.setId(agencia.getInteracciones().size()+1);
        agencia.agregarInteraccion(interaccion);
    }
    
    /**
     * Crea una alerta a partir de 3 parametros ingresados
     * @param tipoPropiedad
     * @param precioMin
     * @param precioMax
     * @param ubicacion 
     */
    public void crearAlerta(String tipoPropiedad, double precioMin, double precioMax, Ubicacion ubicacion){
        
        System.out.println("Tipo: " +capitalize(tipoPropiedad)+ "\nRango Precio: " +precioMin+ "-" +precioMax+
                           "\nUbicacion: " +ubicacion.toString());
        
        Alerta alerta= new Alerta(tipoPropiedad,precioMin,precioMax,ubicacion);
        
        if (alertas.contains(alerta)){
            
            System.out.println("Esta alerta ya ha sido agregada");
            
        }else{
            System.out.println("Alerta agregada exitosamente");
                alertas.add(alerta);
        }
    }
    
    
    
    
    public ArrayList<Alerta> getAlertas(){
        return alertas;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public ArrayList<Propiedad> getPropiedadesConsultadasCliente() {
        return propiedadesConsultadasCliente;
    }
    
    


}