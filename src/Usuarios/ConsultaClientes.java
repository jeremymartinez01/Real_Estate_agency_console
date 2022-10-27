/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 *
 * @author ERWIN AURIA
 */
public class ConsultaClientes {
    private LocalDateTime fecha;
    private int codigo;
    private String pregunta;
    
    public ConsultaClientes(){
        fecha=LocalDateTime.now();    
    }
    
}
