package proyectopoo;

import Propiedades.EstadoPropiedad;
import Propiedades.Propiedad;
import Usuarios.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompraVenta {
    private LocalDate fecha;
    private Usuario usuario;
    private Propiedad propiedad;
  
    /**
     * Constructor de CompraVenta
     * @param usuario
     * @param propiedad 
     */

    public CompraVenta(Usuario usuario, Propiedad propiedad) {
        this.fecha = LocalDate.now();
        this.usuario = usuario;
        propiedad.setEstado(EstadoPropiedad.NODISPONIBLE);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    
    
}
