/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author DELL
 */
public class PCB {
    private int id;
    private String status;
    private String name;
    private int programCounter;
    private int memoryAddressRegister;

    public PCB(int id, String status, String name, int programCounter, int memoryAddressRegister) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.programCounter = programCounter;
        this.memoryAddressRegister = memoryAddressRegister;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public int getMemoryAddressRegister() {
        return memoryAddressRegister;
    }

    public void setMemoryAddressRegister(int memoryAddressRegister) {
        this.memoryAddressRegister = memoryAddressRegister;
    }
    
}
