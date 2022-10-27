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
public class PrestamoFrances extends Prestamo{
    
    /**
     * COnstructor de Prestamo Frances
     * @param costocuota
     * @param tasainteres
     * @param numerocuotas 
     */
    public PrestamoFrances(double costocuota,double tasainteres, int numerocuotas){
      super(costocuota,tasainteres,numerocuotas);
    }
    
    /**
     * Metodo calcularPrestamo en este caso Frances, en este sistema las cuotas son constantes
     * Pero la amortizacion crece y los intereses decrecen
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
        double cuota=(costo*intereses)/(1-Math.pow(1+intereses, -numerocuotas));
        double amortiguacion=0;
        double inter=0;
        double montoFinal=0;
        for(int i=0;i<getNumerocuotas();i++){
            inter=montoInicial*intereses;
            amortiguacion=cuota-inter;
            montoFinal=montoInicial-amortiguacion; 
            System.out.printf("%10s"+"%20.2f"+"%20.2f"+"%20.2f"+"%20.2f"+"%20.2f",i+1,montoInicial,montoFinal,amortiguacion,inter,cuota);
            montoInicial=montoFinal; 
            System.out.println();  
        }    
    }
}
