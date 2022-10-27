package proyectopoo;

import Correo.EnviaMail;
import java.util.ArrayList;
import Usuarios.*;
import Propiedades.*;
import java.time.LocalDate;
import static proyectopoo.StringFecha.stringAFecha;

public class Agencia {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<CompraVenta> compraVenta;
    private ArrayList<Interaccion> interacciones;
    
    /**
     * Constructor donde se inicializan los ArrayList y se crearon los usuarios y las propiedades
     */
        
    public Agencia(){
     usuarios=new ArrayList<>();
     propiedades=new ArrayList<>();
     interacciones=new ArrayList<>();
     compraVenta=new ArrayList<>();
     Usuario admin=new Administrador("0951978055","Damian Morgan","admin","morgan08@gmail.com","admin");
     usuarios.add(admin);
     Usuario cliente1=new Cliente("0953875412","Eliana Auria","eauria","eauria12@gmail.com","123",stringAFecha("12/08/2001"));
     usuarios.add(cliente1);
     Usuario agente1=new Agente("0942874485","Washington Cotera","wgcotera","wgcotera@gmail.com","aeiou",10,usuarios);
     usuarios.add(agente1);
     Usuario agente2=new Agente("0950943201","Jeremy Martinez ","jjmartinez","jjmartin@gmail.com","a1e2",5,usuarios);
     usuarios.add(agente2);
     Ubicacion u1= new Ubicacion("Guayas","Guayaquil","Norte","Coop.La Gaviota");
     Propiedad terreno1= new Terreno(950000,40,60,u1,"Espacioso terreno para una actividad comercial",propiedades,TipoTerreno.COMERCIAL);
     propiedades.add(terreno1); 
     Ubicacion u2= new Ubicacion("Manabi","Manta","Sur","Calle 13 entre avenidas 7 y 8");
     Propiedad terreno2= new Terreno(355000,10,30,u2,"Terreno ene el valle",propiedades,TipoTerreno.VIVIENDA);
     propiedades.add(terreno2);  
     Ubicacion u3= new Ubicacion("Guayas","Guayaquil","Norte","Coop.Juan Montalvo");
     Propiedad casa1= new Casa(20000,7,15,u3,"Casa con jardin",propiedades,2,4);
     propiedades.add(casa1);  
     Ubicacion u4= new Ubicacion("Guayas","Duran","Centro","Cdla. Abel Gilbert III");
     Propiedad casa2= new Casa(25000,10,30,u4,"Casa grande con 3 pisos y 8 habitaciones",propiedades,3,8);
     propiedades.add(casa2);  
     
   }
    
    public void chequearlista(){
        if ( !(propiedades.isEmpty()) ){
            
                for (Propiedad p: propiedades){
                    String tipo;    
                
                     if (p instanceof Casa){
                         tipo = "Casa";
                     }else if (p instanceof Terreno){
                         tipo = "Terreno";
                     }
                     double precio = p.getPrecio();
                     Ubicacion ubicacion = p.getUbicacion();
                
                    for (Usuario u: usuarios){
                        if (u instanceof Cliente){
                            for (Alerta a: ((Cliente) u).getAlertas()){
                                double precio_referencial = a.getPrecioMax()-a.getPrecioMin();
                                //Alerta a2 = new Alerta(tipo,precio_referencial,precio_referencial,ubicacion);
                                //if (a.equals(a2)){
                                    //EnviaMail.sendMail(u.getEmail());
                                //}
                            }
                        
                        }

                    }
            
            
        }
        
        }
    }
    
    /**
     * Metodo que agrega un usuario en un ArrayList de Usuarios de la agencia
     * @param user 
     */

    public void agregarUsuario(Usuario user){
        if(!usuarios.contains(user)){
            usuarios.add(user);
        }
    }
    /**
     * Metodo que agrega una venta en un ArrayList donde se efectua una compra y por lo tanto, 
     * una venta en la agencia
     * @param cv 
     */
    public void agregarCompraVenta(CompraVenta cv){
        compraVenta.add(cv);
    }
    
    /**
     * Metodo que agrega un nueva interaccion es decir, una consulta del cliente 
     * y la respuesta del agente 
     * @param interaccion 
     */
    
    public void agregarInteraccion(Interaccion interaccion){
        interacciones.add(interaccion);
    }
    /**
     * Metodo que agrega una propiedad ya sea terreno o casa a la agencia
     * @param p 
     */
    public void agregarPropiedad(Propiedad p){
        propiedades.add(p);
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Interaccion> getInteracciones() {
        return interacciones;
    }

    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public ArrayList<CompraVenta> getCompraVenta() {
        return compraVenta;
    }
    
}