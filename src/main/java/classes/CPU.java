/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class CPU extends Thread {
    private TimeHandler timeHandler;
    private int quantum;
    private int memoryAddressRegister;
    private int programCounter;
    private List interruptionsList;
    private Dispatcher dispatcher;
    private ProcessImage currentProcess;
    private int id;
    private Semaphore mutexExceptions;
    private Semaphore mutexCPUs;
    /**
     * Hola
     */
    @Override
    public void run(){
        while(true){
            //checkear interrupciones
            if(!this.interruptionsList.isEmpty()){
                
            }else{
                //checkear que el pocesso aun tiene tiempo de ejcución
                //revisar si hay un proceos de mayor prioridad para ploitica expulsivas
                if(this.quantum==0 && true){
                    this.useDispatcher("ready");
                    this.getProcess();
                    
                }else{
                    if(this.currentProcess.getDuration() < this.memoryAddressRegister){
                        //aqui hay que cambiar la interfas para mostrar que se esta ejecutando
                        //una componente del sistema operativo
                        this.useDispatcher("exit");
                        this.getProcess();
                    }else{
                        //checkear si el proceso termino

                        //aqui hay que cambiar la interfaz para mostrar al proceso

                        //se ejecuta la intruccion del proceso actual
                        try {
                            sleep(timeHandler.getInstructionTime());
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //checkear si hay que crear interrupción
                        if(this.isInterruption(memoryAddressRegister)){
                            this.useDispatcher("blocked");
                            this.getProcess();
                        }else{
                            // instrucciones inertes
                            //esto es si el proceso continua su ejecución
                            quantum--;
                            programCounter++;
                            this.memoryAddressRegister++;
                        }    
                    }
                }
            }
        }
    }
    public boolean isInterruption(int mar){
        for (int i = 0; i < this.currentProcess.getInstructions().getSize()-1; i++) {
            if(i%2==0 && this.currentProcess.getInstructions().getNodoById(i).getValue().equals(mar)){
                int j = (int) this.currentProcess.getInstructions().getNodoById(i+1).getValue();
                Exception exception = new Exception(id,j,this.timeHandler,this.currentProcess.getId(),this.interruptionsList,this.mutexExceptions);
                exception.start();
                return true;
            }
        }
        return false;
    }
    
    private void interruptHandler(){
        
    }
    private void useDispatcher(String state){
        try {
            //aqui hay que actuliazar el pcb
            mutexCPUs.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        //es posible que salva sin ser ejecutado
        if(quantum != currentProcess.getQuantum()){
            this.dispatcher.updatePCB(currentProcess, programCounter, memoryAddressRegister,state);
        }else{
            this.dispatcher.updatePCB(currentProcess,state);
        }
       mutexCPUs.release();
    }
    
    private void getProcess(){
        try {
            //Aqui va un semaforo
                mutexCPUs.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.currentProcess = this.dispatcher.getProcess();
            mutexCPUs.release();
            
            quantum = currentProcess.getQuantum();
            programCounter = currentProcess.getProgramCounter()+1;
            memoryAddressRegister = currentProcess.getProgramCounter();

            for (int i = 1; i < 4; i++) {
            try {
                sleep(timeHandler.getInstructionTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
}
