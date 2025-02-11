package classes;

import primitivas.List;
import primitivas.NodoList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessImageCSV {

    // Método para guardar procesos en CSV (ya implementado)
    public static void saveProcessesToCSV(List<ProcessImage> processes, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Type,Status,ProgramCounter,MemoryAddressRegister,Duration,Quantum");
            writer.newLine();

            NodoList<ProcessImage> current = processes.getHead();
            while (current != null) {
                writer.write(formatProcessAsCSV(current.getValue()));
                writer.newLine();
                current = current.getpNext();
            }

            System.out.println("Procesos guardados correctamente en " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer procesos desde CSV
    public static List<ProcessImage> readProcessesFromCSV(String filePath) {
        List<ProcessImage> processes = new List<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Para omitir la cabecera

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Omitimos la primera línea
                    continue;
                }

                String[] values = line.split(",");

                if (values.length < 8) {
                    System.out.println("Error al leer línea CSV: " + line);
                    continue; // Evita errores si hay datos incompletos
                }

                int id = Integer.parseInt(values[0]);
                String name = values[1];
                String type = values[2];
                String status = values[3];
                int programCounter = Integer.parseInt(values[4]);
                int memoryAddressRegister = Integer.parseInt(values[5]);
                int duration = Integer.parseInt(values[6]);
                int quantum = Integer.parseInt(values[7]);

                // Crear el objeto ProcessImage
                ProcessImage process = new ProcessImage(null, type, id, status, name, programCounter, memoryAddressRegister, duration);
                process.setQuantum(quantum);

                // Agregarlo a la lista
                processes.appendLast(process);
            }

            System.out.println("Procesos cargados desde " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return processes;
    }

    // Método para formatear un proceso como CSV
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
