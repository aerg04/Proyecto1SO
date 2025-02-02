package classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import primitivas.*;
import main.*;

public class Dispatcher {
    private List readyList;
    private List blockedList;
    private List exitList;
    private W1 window;
    
    public Process getProcess(){
        Process output = null;
        if(!this.readyList.isEmpty()){
        window.getSelectAlgorithm();
        switch(window.getSelectAlgorithm()){
            case 1 -> {
                //FCFS
                output = this.FCFS();
                }
            case 2 -> {
                //round robin
                }
            case 3 -> {
                // SPN
                }
            case 4 -> {
                //SRT
                }
            case 5 -> {
                //HRR
                }
            
        }
        }
         //aqui hay que actulizar la interfaz
        return output;    
    }
    private Process FCFS(){
        NodoList pAux = this.readyList.getHead();
        this.readyList.delete(pAux);
       
        Process output = (Process) pAux.getValue();
        output.getpCB().setStatus("running");
        //asi nunca se saldra hasta que haya interrupción
        output.setQuantum(-1);
        return output;

        //while(pAux!=null){
            
            //aplicar algoritmo
            
            //pAux = pAux.getpNext();
        //}
    }
    public Process RoundRobin(){
        NodoList pAux = this.readyList.getHead();
        this.readyList.delete(pAux);
        //aqui hay que actulizar la interfaz
        Process output = (Process) pAux.getValue();
        output.getpCB().setStatus("running");
        //asi nunca se saldra hasta que haya interrupción
        output.setQuantum(5);
        return output;
    }
    public void uptadeInterfaces(){
        
    }
    
    public void updatePCB(Process process,int programCounter,int memoryAddressRegister,String state){
        PCB pcb = process.getpCB();
        pcb.setStatus(state);
        pcb.setProgramCounter(programCounter);
        pcb.setMemoryAddressRegister(memoryAddressRegister);
        if(state=="bloked"){
            this.blockedList.appendLast(process);   
        }else if(state=="ready"){
            this.readyList.appendLast(process);
        }else{
            this.exitList.appendLast(process);
        }
    }
}
