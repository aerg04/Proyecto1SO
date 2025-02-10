/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;


import classes.*;
import classes.ProcessImage;
import classes.ProcessImageCSV;
import primitivas.List;
import java.util.concurrent.Semaphore;

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
        List readyList = new List();
        
        W1 w1 = new W1(onPlay,onPlayClock,readyList);
        w1.setVisible(true);

        
        List<ProcessImage> processes = new List<>();

        // Crear procesos de ejemplo y agregarlos a la lista
        processes.appendLast(new ProcessImage(null, "System", 1, "Running", "Process1", 100, 200, 50));
        processes.appendLast(new ProcessImage(null, "User", 2, "Waiting", "Process2", 150, 250, 30));

        // Guardar en CSV
        ProcessImageCSV.saveProcessesToCSV(processes, "procesos.csv");
        Semaphore mutexDispatcher = new Semaphore(1);
        Clock clock = new Clock(mutexDispatcher, onPlayClock);
        TimeHandler timeHandler = new TimeHandler(w1);
        //colas del disptcher
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
