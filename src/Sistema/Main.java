/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;


import Interfaces.InterfazUsuario;
import proyectopoo.Agencia;


/**
 *
 * @author ERWIN AURIA
 */

/**
 * Clase que tiene el punto de entrada principal de la aplicacion
 * @author ERWIN AURIA
 */
public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        InterfazUsuario u= new InterfazUsuario();        
        u.menuPrincipal(agencia);         
    }  
}


