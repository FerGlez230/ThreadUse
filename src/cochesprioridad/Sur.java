/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochesprioridad;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maryf
 */
public class Sur implements Runnable{
    private Data data;
    private Ventana ventana;
    public Sur(Data data, Ventana v){
        this.data=data;
        this.ventana=v;
    }
    @Override
    public void run() {
        while(true){
        try {
            data.getMutex().acquire();
        } catch (InterruptedException ex) {
            System.out.println("Excepcion sur"+ex);
        }
        while(data.getSur()>0){
            System.out.println("\n Carro sur pasando");
            System.out.println("Carros restantes sur"+data.getSur());
            System.out.println("Carros norte"+data.getNorte());
            data.setSur(data.getSur()-1);
           
            try {
                ventana.urlAnimacion="cocheSur.png";
                
                for(int i=590; i>220; i-=10){
                    
                   ventana.xAnimacion=i;
                    
                   ventana.update(ventana.getGraphics());
                 
                    sleep(50);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Sur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        data.getMutex().release();
    
        ventana.urlAnimacion="";
        ventana.update(ventana.getGraphics());
        
    }
    }
}
   