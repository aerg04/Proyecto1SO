/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import classes.*;
import java.util.concurrent.Semaphore;
import primitivas.List;
/**
 *
 * @author DELL
 */
public class Proyecto1 {

    public static void main(String[] args) {
        //aqui hay que cargar los procesos de las lista
        
        //para sincronizar los cpu al iniciar la simulación
        Semaphore onPlay = new Semaphore(0);
        Semaphore onPlayClock = new Semaphore(0);
        
        W1 w1 = new W1(onPlay,onPlayClock);
        w1.setVisible(true);
        Semaphore mutexDispatcher = new Semaphore(1);
        Clock clock = new Clock(mutexDispatcher, onPlayClock);
        TimeHandler timeHandler = new TimeHandler(w1);
        //colas del disptcher
        List readyList = new List();
        List blockedList = new List();
        List exitList = new List();
        Dispatcher dispatcher = new Dispatcher(readyList,blockedList,exitList,w1);
        
        // para los cpus
        CPU cpu1 = new CPU(timeHandler,dispatcher,1,mutexDispatcher,onPlay,w1);
        CPU cpu2 = new CPU(timeHandler,dispatcher,2,mutexDispatcher, onPlay,w1);
        CPU cpu3 = new CPU(timeHandler,dispatcher,3,mutexDispatcher, onPlay,w1);
        clock.start();
        cpu1.start();
        cpu3.start();
        cpu2.start();
    }
}
