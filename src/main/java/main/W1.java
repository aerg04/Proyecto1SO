/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import primitivas.*;
import classes.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class W1 extends javax.swing.JFrame {
    public Semaphore onPlay;
    public Semaphore onPlayClock;
    public List readyList;
    public List allProcessList;
    public UtilityGraph w2;
    /**
     * Creates new form W1
     */
    
    private void loadConfig() {
    String filePath = "configuracion.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line = reader.readLine(); // Leer la única línea del archivo

        if (line != null) {
            String[] values = line.split(",");
            if (values.length < 3) {
                System.out.println("Error: El archivo de configuración no tiene el formato correcto.");
                return;
            }

            // Convertir los valores a enteros
            int selectedAlgorithm = Integer.parseInt(values[0]);
            int numberOfInstructions = Integer.parseInt(values[1]);
            int numberOfCPUs = Integer.parseInt(values[2]);

            // Aplicar los valores en la interfaz gráfica
            selectDispatcher1.setSelectedIndex(selectedAlgorithm);
            timeSlider2.setValue(numberOfInstructions);
            cpusSlider.setValue(numberOfCPUs);

            System.out.println("Configuración cargada desde CSV.");
        }
    } catch (IOException e) {
        System.out.println("No se encontró el archivo de configuración. Se usarán valores por defecto.");
    }
}
    
    public W1(Semaphore onPlay,Semaphore onPlay1,List readyList,List allProcess) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.onPlay = onPlay;
        this.onPlayClock = onPlay1;
        this.readyList = readyList;
        this.allProcessList = allProcess;
        w2 = new UtilityGraph("CPUs usage");
        
        // Cargar configuración desde CSV al iniciar
        loadConfig();
        this.updatePCBs();
    }
    public W1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public synchronized void createNewProcess(List list,String name,String type,int duration ){
        ProcessImage newProcess = new ProcessImage(list,type,readyList.getSize(),"ready",name,1,0,duration);
        readyList.appendLast(newProcess);
        allProcessList.appendLast(newProcess);
        updatePCBs();
    }
    public void updatePCBs(){
        NodoList pAux = readyList.getHead();
        String display = "";
        while(pAux!=null){
            ProcessImage process=(ProcessImage) pAux.getValue();
            display += this.makeString(process);
            pAux = pAux.getpNext();
        }
        this.updateProcess(display);
    }
    private String makeString(ProcessImage currentProcess){
        String display = Dispatcher.makeString(currentProcess);
        return display;
    }
    public void updateCPUs(String input, int id){
        switch(id){
            case 1 -> {
                this.cpu1TextArea.setText(input);
                }
            case 2 -> {
                this.cpu2TextArea.setText(input);
                }
            case 3 -> {
                this.cpu3TextArea.setText(input);
                }           
        }
    }
    public synchronized void updateDataset(int instruction, String type,int cpu){
        w2.updateDataset(cpu,type, instruction);
    }
    
    public int getSelectAlgorithm(){
        return this.selectDispatcher1.getSelectedIndex();
    }
    public void updateReady(String text){
        this.readyTextArea.setText(text);
    } 
    public void updateBlock(String text){
        this.blockedTextArea.setText(text);
    }
    public void updateExit(String text){
        this.exitTextArea.setText(text);
    }
    
    public void updateProcess(String text){
        this.jTextArea3.setText(text);
    }
    public int getTime(){
        return this.timeSlider2.getValue();
    }
    public void updateCycle(int in){
        this.insntrucionTextArea.setText(in+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        selectDispatcher1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        readyList1 = new javax.swing.JScrollPane();
        readyTextArea = new javax.swing.JTextArea();
        playButton = new javax.swing.JButton();
        createProcess1 = new javax.swing.JButton();
        timeSlider2 = new javax.swing.JSlider();
        instructionTime2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cpusSlider = new javax.swing.JSlider();
        cpuUnits = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cpu2TextArea = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        cpu1TextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        cpu3TextArea = new javax.swing.JTextArea();
        blockedList = new javax.swing.JScrollPane();
        exitTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        showUsageButton = new javax.swing.JButton();
        insntrucionTextArea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        blockedList1 = new javax.swing.JScrollPane();
        blockedTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectDispatcher1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FSFC", "Round Robin", "SPN", "SRT", "HRR" }));
        selectDispatcher1.setToolTipText("");
        selectDispatcher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDispatcher1ActionPerformed(evt);
            }
        });
        jPanel2.add(selectDispatcher1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 190, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("CPU2");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("CPU3");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        readyList1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        readyTextArea.setColumns(20);
        readyTextArea.setRows(5);
        readyList1.setViewportView(readyTextArea);

        jPanel2.add(readyList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 120));

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        jPanel2.add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 140, -1));

        createProcess1.setText("Create Process");
        createProcess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProcess1ActionPerformed(evt);
            }
        });
        jPanel2.add(createProcess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 140, -1));

        timeSlider2.setMaximum(10000);
        timeSlider2.setValue(5000);
        timeSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSlider2StateChanged(evt);
            }
        });
        jPanel2.add(timeSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        instructionTime2.setText("5000 ms");
        jPanel2.add(instructionTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 140, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("CPU1");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("Exit");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 10, 460));

        jLabel15.setText("Instruction Time");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, 20));

        jLabel16.setText("CPUs");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, 20));

        cpusSlider.setMajorTickSpacing(1);
        cpusSlider.setMaximum(3);
        cpusSlider.setMinimum(1);
        cpusSlider.setMinorTickSpacing(1);
        cpusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cpusSliderStateChanged(evt);
            }
        });
        jPanel2.add(cpusSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 200, -1));

        cpuUnits.setText("3 units");
        jPanel2.add(cpuUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 60, -1));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cpu2TextArea.setEditable(false);
        cpu2TextArea.setColumns(20);
        cpu2TextArea.setRows(8);
        jScrollPane5.setViewportView(cpu2TextArea);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 100));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cpu1TextArea.setEditable(false);
        cpu1TextArea.setColumns(20);
        cpu1TextArea.setRows(8);
        jScrollPane6.setViewportView(cpu1TextArea);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 100));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cpu3TextArea.setEditable(false);
        cpu3TextArea.setColumns(20);
        cpu3TextArea.setRows(8);
        jScrollPane3.setViewportView(cpu3TextArea);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 110, 100));

        blockedList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        exitTextArea.setColumns(20);
        exitTextArea.setRows(5);
        blockedList.setViewportView(exitTextArea);

        jPanel2.add(blockedList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 150, 90));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane2.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 150, 400));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Ready");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("PCBs");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        showUsageButton.setText("Show Usage");
        showUsageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsageButtonActionPerformed(evt);
            }
        });
        jPanel2.add(showUsageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 140, -1));

        insntrucionTextArea.setEditable(false);
        insntrucionTextArea.setText("0");
        insntrucionTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insntrucionTextAreaActionPerformed(evt);
            }
        });
        jPanel2.add(insntrucionTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 110, -1));

        jLabel2.setText("Cycle:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel17.setText("Blocked");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        blockedList1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        blockedTextArea.setColumns(20);
        blockedTextArea.setRows(5);
        blockedList1.setViewportView(blockedTextArea);

        jPanel2.add(blockedList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, 110));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectDispatcher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDispatcher1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDispatcher1ActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        onPlay.release(cpusSlider.getValue());
        onPlayClock.release();
        ProcessImageCSV.saveProcessesToCSV(readyList, "procesos.csv");
        this.createProcess1.setEnabled(false);
        this.cpusSlider.setEnabled(false);
        this.playButton.setEnabled(false);
    }//GEN-LAST:event_playButtonActionPerformed

    private void createProcess1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProcess1ActionPerformed
        // TODO add your handling code here:
        CreateProcess newProcess = new CreateProcess(this);
        newProcess.setVisible(true);
    }//GEN-LAST:event_createProcess1ActionPerformed

    private void timeSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_timeSlider2StateChanged
        // TODO add your handling code here:
        this.instructionTime2.setText(this.timeSlider2.getValue()+ " ms");
    }//GEN-LAST:event_timeSlider2StateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // Obtener los valores seleccionados
    int selectedAlgorithm = selectDispatcher1.getSelectedIndex(); // Algoritmo seleccionado
    int numberOfInstructions = timeSlider2.getValue(); // Número de instrucciones
    int numberOfCPUs = cpusSlider.getValue(); // Número de CPUs

    // Ruta del archivo
    String filePath = "configuracion.csv"; 

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        // Guardar los valores en una sola línea
        writer.write(selectedAlgorithm + "," + numberOfInstructions + "," + numberOfCPUs);
        writer.newLine();
        
        JOptionPane.showMessageDialog(this, "Configuración guardada en " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar la configuración");
    }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cpusSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cpusSliderStateChanged
        // TODO add your handling code here:
        this.cpuUnits.setText(this.cpusSlider.getValue()+ " units");
    }//GEN-LAST:event_cpusSliderStateChanged

    private void showUsageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsageButtonActionPerformed
        // TODO add your handling code here:
        w2.setSize(800, 400);
        w2.setLocationRelativeTo(null);
        w2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w2.setVisible(true);
    }//GEN-LAST:event_showUsageButtonActionPerformed

    private void insntrucionTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insntrucionTextAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insntrucionTextAreaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(W1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(W1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(W1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(W1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                W1 w1 = new W1();
                w1.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane blockedList;
    private javax.swing.JScrollPane blockedList1;
    private javax.swing.JTextArea blockedTextArea;
    private javax.swing.JTextArea cpu1TextArea;
    private javax.swing.JTextArea cpu2TextArea;
    private javax.swing.JTextArea cpu3TextArea;
    private javax.swing.JLabel cpuUnits;
    private javax.swing.JSlider cpusSlider;
    private javax.swing.JButton createProcess1;
    private javax.swing.JTextArea exitTextArea;
    private javax.swing.JTextField insntrucionTextArea;
    private javax.swing.JLabel instructionTime2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton playButton;
    private javax.swing.JScrollPane readyList1;
    private javax.swing.JTextArea readyTextArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> selectDispatcher1;
    private javax.swing.JButton showUsageButton;
    private javax.swing.JSlider timeSlider2;
    // End of variables declaration//GEN-END:variables
}
