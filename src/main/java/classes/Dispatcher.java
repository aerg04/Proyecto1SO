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

    public Dispatcher(List readyList, List blockedList, List exitList, W1 window) {
        this.readyList = readyList;
        this.blockedList = blockedList;
        this.exitList = exitList;
        this.window = window;
    }
    
    public ProcessImage getProcess(){
        ProcessImage output = null;
        if(this.readyList.isEmpty()){
        window.getSelectAlgorithm();
        switch(window.getSelectAlgorithm()){
            case 0 -> {
                //FCFS
                output = this.FCFS();
                }
            case 1 -> {
                //round robin
                 output = this.RoundRobin();
                }
            case 2 -> {
                output = this.SPN();
                // SPN
                }
            case 3 -> {
                 output = this.SRT();
                //SRT
                }
            case 4 -> {
                //HRR
                 output = this.HRR();
                }
            
        }
        }
         //aqui hay que actulizar la interfaz
        this.updateReadyList();
        this.updateProcessList();
        if(output == null){
            System.out.println("process null") ;
            System.out.println(readyList.isEmpty()+"");
            System.out.println(readyList.getHead()+"");
        }
        return output;    
    }
    private ProcessImage FCFS(){
        NodoList pAux = this.readyList.getHead();
        this.readyList.delete(pAux);
       
        ProcessImage output = (ProcessImage) pAux.getValue();
        output.setStatus("running");
        //asi nunca se saldra hasta que haya interrupción
        output.setQuantum(-1);
        //output.setWaitingTime(0);
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
        //output.setWaitingTime(0);
        return output;
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
        //output.setWaitingTime(0);
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
        //output.setWaitingTime(0);
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
        //output.setWaitingTime(0);
        return output;
    }
    
    public boolean ifSRT(ProcessImage process){
        if(window.getSelectAlgorithm() == 4){
        NodoList current = this.readyList.getHead();
        while (current != null) {
            if (((ProcessImage) current.getValue()).getDuration() - ((ProcessImage) current.getValue()).getMemoryAddressRegister() < 
                    process.getDuration()- process.getMemoryAddressRegister()) {
                return true;
            }
            current = current.getpNext();
        }    
        }
        return false;
    }

    public void updatePCB(ProcessImage process,int programCounter,int memoryAddressRegister,String state){ 
        process.setStatus(state);
        process.setProgramCounter(programCounter);
        process.setMemoryAddressRegister(memoryAddressRegister);
        process.setWaitingTime(0);
        if(state=="blocked"){
            this.blockedList.appendLast(process);   
        }else if(state=="ready"){
            this.readyList.appendLast(process);
        }else{
            this.exitList.appendLast(process);
        }
        this.updateReadyList();
        this.updateBlockedList();
        this.updateProcessList();
    }
    public void updatePCB(ProcessImage process,String state){
        process.setStatus(state);
        process.setWaitingTime(0);
        if(state=="blocked"){
            this.blockedList.appendLast(process);   
        }else if(state=="ready"){
            this.readyList.appendLast(process);
        }else{
            this.exitList.appendLast(process);
        }
        this.updateReadyList();
        this.updateBlockedList();
        this.updateProcessList();
    }
    
    public void updateWaitingTime(){
        NodoList pAux = this.readyList.getHead();
        while(pAux!=null){
            int waitingTime = ((ProcessImage) pAux.getValue()).getWaitingTime();
            ((ProcessImage) pAux.getValue()).setWaitingTime(waitingTime++);
            pAux = pAux.getpNext();
        }
    }
    
    public void updateBlockToReady(int id){
        NodoList pAux = this.blockedList.getHead();
        while(pAux!=null){
            if(id== ((ProcessImage)pAux.getValue()).getId()){
                blockedList.delete(pAux);
                readyList.appendLast(pAux);                
            }
            pAux = pAux.getpNext();
        }
        this.updateBlockedList();
        this.updateProcessList();
    }
    
    public void updateProcessList(){
        NodoList pAux = readyList.getHead();
        String display = "";
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            display += this.makeString(process);
            pAux = pAux.getpNext();
        }
        pAux = blockedList.getHead();
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            display += this.makeString(process);
            pAux = pAux.getpNext();
        }
        pAux = exitList.getHead();
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            display += this.makeString(process);
            pAux = pAux.getpNext();
        }
        window.updateProcess(display);
    }
    
    public void updateReadyList(){
        NodoList pAux = readyList.getHead();
        String display = "";
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            
            display += "\n ----------------------------------\n "
                    + "ID: " + process.getId() +
                      "\n Nombre: " + process.getName();
            pAux = pAux.getpNext();
        }
        window.updateReady(display);
    }
    public void updateBlockedList(){
        NodoList pAux = blockedList.getHead();
        String display = "";
        System.out.println(pAux);
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            
            display += "\n ----------------------------------\n "
                    + "ID: " + process.getId() +
                      "\n Nombre: " + process.getName();
            pAux = pAux.getpNext();
        }
        window.updateBlock(display);
    }
    
    private String makeString(ProcessImage currentProcess){
        String display = "\n ----------------------------------\n ID: " + currentProcess.getId() + 
                "\n Status: " + currentProcess.getStatus()+ 
                "\n Nombre: " + currentProcess.getName() +
                "\n PC: " + currentProcess.getProgramCounter() + 
                "\n MAR: " + currentProcess.getMemoryAddressRegister() ;
        return display;
    }
}
