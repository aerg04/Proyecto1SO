/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Clock extends Thread {
    private Semaphore mutex;
    private TimeHandler timeHandler;
    private Dispatcher dispatcher;
    public Clock(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    /**
     * Actualiza la canitdad de ciclos de instrución de espera de cada proceso
     */
    @Override
    public void run() {
        while(true){
            try {
                mutex.acquire();
                this.dispatcher.updateWaitingTime();
                mutex.release();
                sleep(timeHandler.getInstructionTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
