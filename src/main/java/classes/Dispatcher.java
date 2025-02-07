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
    
    public ProcessImage getProcess(){
        ProcessImage output = null;
        if(!this.readyList.isEmpty()){
        window.getSelectAlgorithm();
        switch(window.getSelectAlgorithm()){
            case 1 -> {
                //FCFS
                output = this.FCFS();
                }
            case 2 -> {
                //round robin
                 output = this.RoundRobin();
                }
            case 3 -> {
                output = this.SPN();
                // SPN
                }
            case 4 -> {
                 output = this.SRT();
                //SRT
                }
            case 5 -> {
                //HRR
                 output = this.HRR();
                }
            
        }
        }
         //aqui hay que actulizar la interfaz
        return output;    
    }
    private ProcessImage FCFS(){
        NodoList pAux = this.readyList.getHead();
        this.readyList.delete(pAux);
       
        ProcessImage output = (ProcessImage) pAux.getValue();
        output.setStatus("running");
        //asi nunca se saldra hasta que haya interrupción
        output.setQuantum(-1);
        output.setWaitingTime(0);
        return output;

        //while(pAux!=null){
            
            //aplicar algoritmo
            
            //pAux = pAux.getpNext();
        //}
    }
    public ProcessImage RoundRobin(){
        NodoList pAux = this.readyList.getHead();
        this.readyList.delete(pAux);
        //aqui hay que actulizar la interfaz
        ProcessImage output = (ProcessImage) pAux.getValue();
        output.setStatus("running");
        output.setQuantum(5);
        output.setWaitingTime(0);
        return output;
    }
    public void uptadeInterfaces(){
        
    }
    private ProcessImage SPN(){
        // Implement SPN algorithm
        NodoList shortestJob = this.readyList.getHead();
        NodoList current = this.readyList.getHead();
        while (current != null) {
            if (((ProcessImage) current.getValue()).getDuration() < ((ProcessImage) shortestJob.getValue()).getDuration()) {
                shortestJob = current;
            }
            current = current.getpNext();
        }
        this.readyList.delete(shortestJob);
        ProcessImage output = (ProcessImage) shortestJob.getValue();
        output.setStatus("running");
        output.setQuantum(-1);
        output.setWaitingTime(0);
        return output;
    }
    private ProcessImage SRT(){
        // Implement SPN algorithm
        //es expulsiva
        NodoList shortestJob = this.readyList.getHead();
        NodoList current = this.readyList.getHead();
        while (current != null) {
            if (((ProcessImage) current.getValue()).getDuration() - ((ProcessImage) current.getValue()).getMemoryAddressRegister() < 
                    ((ProcessImage) shortestJob.getValue()).getDuration()- ((ProcessImage) shortestJob.getValue()).getMemoryAddressRegister() ) {
                shortestJob = current;
            }
            current = current.getpNext();
        }
        this.readyList.delete(shortestJob);
        ProcessImage output = (ProcessImage) shortestJob.getValue();
        output.setStatus("running");
        output.setQuantum(-1);
        output.setWaitingTime(0);
        return output;
    }
    
    private ProcessImage HRR(){
        // Implement HRR algorithm
        NodoList bestJob = this.readyList.getHead();
        NodoList current = this.readyList.getHead();
        double highestRatio = 0;
        while (current != null) {
            ProcessImage proc = (ProcessImage) current.getValue();
            double responseRatio = (proc.getWaitingTime() + proc.getDuration()) / (double) proc.getDuration();
            if (responseRatio > highestRatio) {
                highestRatio = responseRatio;
                bestJob = current;
            }
            current = current.getpNext();
        }
        this.readyList.delete(bestJob);
        ProcessImage output = (ProcessImage) bestJob.getValue();
        output.setStatus("running");
        output.setQuantum(-1);
        output.setWaitingTime(0);
        return output;
    }

    public void updatePCB(ProcessImage process,int programCounter,int memoryAddressRegister,String state){
        
        process.setStatus(state);
        process.setProgramCounter(programCounter);
        process.setMemoryAddressRegister(memoryAddressRegister);
        if(state=="bloked"){
            this.blockedList.appendLast(process);   
        }else if(state=="ready"){
            this.readyList.appendLast(process);
        }else{
            this.exitList.appendLast(process);
        }
    }
    public void updatePCB(ProcessImage process,String state){
        
        process.setStatus(state);
        if(state=="bloked"){
            this.blockedList.appendLast(process);   
        }else if(state=="ready"){
            this.readyList.appendLast(process);
        }else{
            this.exitList.appendLast(process);
        }
    }
    
    public void updateWaitingTime(){
        NodoList pAux = this.readyList.getHead();
        while(pAux!=null){
            int waitingTime = ((ProcessImage) pAux.getValue()).getWaitingTime();
            ((ProcessImage) pAux.getValue()).setWaitingTime(waitingTime++);
            pAux = pAux.getpNext();
        }
    }
}
