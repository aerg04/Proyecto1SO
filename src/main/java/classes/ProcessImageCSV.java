/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author kraik
 */
public class ProcessImageCSV {
  
    // Método para guardar una lista de procesos en un archivo CSV
    public static void saveProcessesToCSV(List<ProcessImage> processes, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Escribir la cabecera del CSV
            writer.write("ID,Name,Type,Status,ProgramCounter,MemoryAddressRegister,Duration,Quantum");
            writer.newLine();

            // Escribir cada proceso en una línea
            for (ProcessImage process : processes) {
                writer.write(formatProcessAsCSV(process));
                writer.newLine();
            }
            System.out.println("Procesos guardados correctamente en " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para convertir un proceso en formato CSV
    private static String formatProcessAsCSV(ProcessImage process) {
        return process.getId() + "," +
               process.getName() + "," +
               process.getType() + "," +
               process.getStatus() + "," +
               process.getProgramCounter() + "," +
               process.getMemoryAddressRegister() + "," +
               process.getDuration() + "," +
               process.getQuantum();
    }
}
