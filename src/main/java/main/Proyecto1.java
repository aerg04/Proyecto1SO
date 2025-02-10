/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.ProcessImage;
import classes.ProcessImageCSV;
import primitivas.List;

/**
 *
 * @author DELL
 */
public class Proyecto1 {

    public static void main(String[] args) {
        W1 w1 = new W1();
        w1.setVisible(true);
        
        List<ProcessImage> processes = new List<>();

        // Crear procesos de ejemplo y agregarlos a la lista
        processes.appendLast(new ProcessImage(null, "System", 1, "Running", "Process1", 100, 200, 50));
        processes.appendLast(new ProcessImage(null, "User", 2, "Waiting", "Process2", 150, 250, 30));

        // Guardar en CSV
        ProcessImageCSV.saveProcessesToCSV(processes, "procesos.csv");
    }
}
