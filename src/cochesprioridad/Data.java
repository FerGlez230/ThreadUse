/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cochesprioridad;

import java.util.concurrent.Semaphore;

/**
 *
 * @author maryf
 */
public class Data {
    private Semaphore mutex;
    private int norte;
    private int sur;
    
    public Data(){
        norte=0;
        sur=0;
        mutex=new Semaphore(1);
    }
    public void setNorte(int norte) {
        this.norte = norte;
    }
    public void setSur(int sur) {
        this.sur = sur;
    }
    public Semaphore getMutex() {
        return mutex;
    }
    public int getNorte() {
        return norte;
    }
    public int getSur() {
        return sur;
    }
    
}
