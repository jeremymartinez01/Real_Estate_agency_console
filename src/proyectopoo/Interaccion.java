package proyectopoo;

import Propiedades.Propiedad;
import Usuarios.Agente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Interaccion {
    private int id;
    private String preguntaCliente;
    private String respuestaAgente;
    private LocalDateTime fechapre;
    private LocalDateTime fechares;
    private Propiedad propiedad;
    private Usuario agente;
    private Cliente cliente;
    private String estado = "No Respondida";
    
    /**
     * Constructor de Interaccion
     */
    public Interaccion() {
        this.respuestaAgente = "";
    }

    public int getId() {
        return id;
    }

    public String getPreguntaCliente() {
        return preguntaCliente;
    }

    public String getRespuestaAgente() {
        return respuestaAgente;
    }

    public LocalDateTime getFechapre() {
        return fechapre;
    }

    public LocalDateTime getFechares() {
        return fechares;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public Usuario getAgente() {
        return agente;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreguntaCliente(String preguntaCliente) {
        this.preguntaCliente = preguntaCliente;
    }

    public void setRespuestaAgente(String respuestaAgente) {
        this.respuestaAgente = respuestaAgente;
    }

    public void setFechapre(LocalDateTime fechapre) {
        this.fechapre = fechapre;
    }

    public void setFechares(LocalDateTime fechares) {
        this.fechares = fechares;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente =cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Interaccion{ ID = " + id + ", Pregunta Cliente = " + preguntaCliente + ", Fecha Pregunta = " + fechapre + ", Codigo de Propiedad = " + propiedad.getCodigo() + ", Estado:" + estado + '}';
    }
    
    /*public void mensaje1(){
        System.out.printf("\n"+"%10s"+"%-50d"+"%-30s"+"%-10s"+" %-40s",fechapre,propiedad.getCodigo(),agente.getUsuario(),preguntaCliente,estado);
    }*/
    
}
