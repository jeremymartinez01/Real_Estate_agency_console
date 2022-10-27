/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jjmg0
 */
public class Validacion {
        public static boolean ValidarMail(String email) {
                // Patron para validar el email
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                Matcher mather = pattern.matcher(email);
                return mather.find();
            }
    
}
