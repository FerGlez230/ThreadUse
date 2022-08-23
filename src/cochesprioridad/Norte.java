/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochesprioridad;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author maryf
 */
public class Norte implements Runnable{
    private Data data;
    private Ventana ventana;
    public Norte(Data data, Ventana v){
        this.data=data;
        this.ventana=v;
    }
    @Override
    public void run() {
        while(true){
        try {
            data.getMutex().acquire();
        } catch (InterruptedException ex) {
            System.out.println("Excepcion norte"+ex);
        }
        while(data.getNorte()>0){
            System.out.println("Carro norte pasando");
            System.out.println("Carros restantes norte"+data.getNorte());
            System.out.println("Carros sur"+data.getSur());
            data.setNorte(data.getNorte()-1);
          
            
            try {
                ventana.urlAnimacion="cocheNorte.png";
                
                for(int i=210; i<550; i+=10){
                    
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
