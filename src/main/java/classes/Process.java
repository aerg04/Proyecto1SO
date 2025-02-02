/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class Process {
    private List instructions; //lista para saber cuales generan excepciones
    private PCB pCB;
    private int duration;
    private int quantum;
    public List getInstructions() {
        return instructions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }
    
    
    public void setInstructions(List instructions) {
        this.instructions = instructions;
    }

    public PCB getpCB() {
        return pCB;
    }

    public void setpCB(PCB pCB) {
        this.pCB = pCB;
    }
    
}
