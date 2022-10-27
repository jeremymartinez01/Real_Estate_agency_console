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
public class PrestamoAleman extends Prestamo {
    
    /**
     * Constructor de PrestamoAleman
     * @param costo
     * @param tasainteres
     * @param numerocuotas 
     */
    public PrestamoAleman(double costo,double tasainteres, int numerocuotas){
        super(costo,tasainteres,numerocuotas);
    }
    
    /**
     * Metodo calcularPrestamo en este caso Aleman, en este sistema la amortizacion es constante
     * Tanto los intereses como las cuotas decrecen
     * @param costo
     * @param tasainteres
     * @param numerocuotas 
     */
    
    @Override
    public void calcularPrestamo(double costo,double tasainteres, int numerocuotas){
        System.out.printf("%12s"+"%20s"+"%20s"+"%20s"+"%20s"+"%17s"+"\n","N°Cuotas","Monto Inicial","Monto Final","Amortización",
                          "Intereses","Cuota");
        double montoInicial=costo;
        double intereses=(tasainteres/100)/12;
        double amortiguacion=costo/numerocuotas;
        double inter=0;
        double cuota=0;
        double montoFinal=0;
        for(int i=0;i<getNumerocuotas();i++){
            inter=montoInicial*intereses;
            cuota=amortiguacion+inter;
            montoFinal=montoInicial-amortiguacion; 
            System.out.printf("%10s"+"%20.2f"+"%20.2f"+"%20.2f"+"%20.2f"+"%20.2f",i+1,montoInicial,montoFinal,amortiguacion,inter,cuota);
            montoInicial=montoFinal; 
            System.out.println();    
        }
        
    }
}
