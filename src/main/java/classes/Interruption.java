/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import primitivas.*;

/**
 *
 * @author DELL
 */
public class Interruption extends Thread {
//la idea es que la clase interruption llame a interruptHandler para que la ultima 
//cambie del esado al proceso que la creo
    private int originCPU;
    private int interruptionCycle; // indica el numero de ciclos de instruccion que dura
    private TimeHandler timeHandler;    //clase para maneja el tiempo de ejecucion de una isntrucciíon
    private int processId;
    private List interruptionList;
    private Semaphore mutex;
    /**
     * Hola
     */
    @Override
    public void run(){
 
        for(int i = 1; i <= this.interruptionCycle;i++){
            try {
                sleep(timeHandler.getInstructionTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(Interruption.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        try {
            //Aqui va un semaforo
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Interruption.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.interruptionList.appendLast(this);
        mutex.release();
        
    }

}

