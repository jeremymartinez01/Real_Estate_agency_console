/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prestamo;



/**
 *
 * @author jjmg0
 */
public abstract class Prestamo {
    private double costo;
    private double tasainteres;
    private int numerocuotas ;
    
    /**
     * Constructor de la clase abstracta Prestamo
     * @param costo
     * @param tasainteres
     * @param numerocuotas 
     */
    public Prestamo(double costo, double tasainteres, int numerocuotas){
        this.costo= costo;
        this.tasainteres= tasainteres;
        this.numerocuotas= numerocuotas;
    }
    
    /**
     * Metodo abstracto que permitira CalcularPrestamo tanto aleman como frances
     * @param costo
     * @param tasainteres
     * @param numerocuotas 
     */
    public abstract void calcularPrestamo(double costo,double tasainteres, int numerocuotas);

    /**
     * Metodo get de Costo
     * @return 
     */
    public double getCosto() {
        return costo;
    }
    
    /**
     * Metodo get de Tasainteres
     * @return 
     */

    public double getTasainteres() {
        return tasainteres;
    }
    
    /**
     * Metodo get de Numerocuotas
     * @return 
     */

    public int getNumerocuotas() {
        return numerocuotas;
    }
    
    
}
