/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;


import classes.*;
import classes.ProcessImage;
import classes.ProcessImageCSV;
import java.util.Scanner;
import primitivas.*;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;


/**
 *
 * @author DELL
 */
public class Proyecto1 {

    public static void main(String[] args) {
        
        // Crear lista de procesos
        List<ProcessImage> processList = new List<>();

        // Crear lista de instrucciones para cada proceso
        List<Integer> instructions1 = new List<>();
        instructions1.appendLast(10);
        instructions1.appendLast(20);
        instructions1.appendLast(30);

        List<Integer> instructions2 = new List<>();
        instructions2.appendLast(5);
        instructions2.appendLast(15);
        instructions2.appendLast(25);
        instructions2.appendLast(35);

        List<Integer> instructions3 = new List<>();
        instructions3.appendLast(1);
        instructions3.appendLast(2);
        instructions3.appendLast(3);
        instructions3.appendLast(4);
        instructions3.appendLast(5);

        // Crear procesos con instrucciones
        ProcessImage p1 = new ProcessImage(instructions1, "System", 1, "Running", "Process1", 100, 200, 50);
        ProcessImage p2 = new ProcessImage(instructions2, "User", 2, "Waiting", "Process2", 150, 250, 30);
        ProcessImage p3 = new ProcessImage(instructions3, "Kernel", 3, "Blocked", "Process3", 200, 300, 40);

        // Agregar procesos a la lista
        processList.appendLast(p1);
        processList.appendLast(p2);
        processList.appendLast(p3);

        // Guardar procesos en CSV
        String filePath = "procesos.csv";
        ProcessImageCSV.saveProcessesToCSV(processList, filePath);

        // Leer procesos desde CSV
        List<ProcessImage> loadedProcesses = ProcessImageCSV.readProcessesFromCSV(filePath);

        // Mostrar los procesos cargados
        NodoList<ProcessImage> current = loadedProcesses.getHead();
        while (current != null) {
            ProcessImage p = current.getValue();
            System.out.println("ID: " + p.getId() + ", Nombre: " + p.getName() + ", Estado: " + p.getStatus());
            current = current.getpNext();
        }
        
        //para sincronizar los cpu al iniciar la simulación
        Semaphore onPlay = new Semaphore(0);
        Semaphore onPlayClock = new Semaphore(0);
        List readyList = new List();
        
        W1 w1 = new W1(onPlay,onPlayClock,readyList);
        w1.setVisible(true);
      
        Semaphore mutexDispatcher = new Semaphore(1);
        TimeHandler timeHandler = new TimeHandler(w1);
        //colas del disptcher
        List blockedList = new List();
        List exitList = new List();
        Dispatcher dispatcher = new Dispatcher(readyList,blockedList,exitList,w1);
        
        // para los cpus
        Clock clock = new Clock(mutexDispatcher, onPlayClock, w1, dispatcher,timeHandler);
        CPU cpu1 = new CPU(timeHandler,dispatcher,1,mutexDispatcher,onPlay,w1);
        CPU cpu2 = new CPU(timeHandler,dispatcher,2,mutexDispatcher, onPlay,w1);
        CPU cpu3 = new CPU(timeHandler,dispatcher,3,mutexDispatcher, onPlay,w1);
        clock.start();
        cpu1.start();
        cpu3.start();
        cpu2.start();

    }
//    public static void main(String[] args) {
//        UtilityGraph example = new UtilityGraph("Bar Chart Example");
//        example.setSize(800, 400);
//        example.setLocationRelativeTo(null);
//        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        example.setVisible(true);
//        Scanner s = new Scanner(System.in);
//
//        String s1 = s.nextLine();
//        // Example of dynamically updating the dataset
//        example.updateDataset("PCPU 5", 100, 200);
//        example.updateDataset("PCPU 6", 120, 150);
//    }
}
