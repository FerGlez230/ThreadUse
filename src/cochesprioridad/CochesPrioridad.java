/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochesprioridad;

/**
 *
 * @author maryf
 */
public class CochesPrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data data=new Data();
        Ventana ventana=new Ventana(data);
        Norte norte=new Norte(data, ventana);
        Sur sur=new Sur(data, ventana);
        Thread hiloNorte=new Thread(norte);
        Thread hiloSur=new Thread(sur);
        
        hiloNorte.start();
        hiloSur.start();
    }
    
}
