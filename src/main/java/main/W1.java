/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import primitivas.*;
import classes.*;
import java.util.concurrent.Semaphore;
/**
 *
 * @author DELL
 */
public class W1 extends javax.swing.JFrame {
    public Semaphore onPlay;
    public Semaphore onPlayClock;
    public List readyList;
    /**
     * Creates new form W1
     */
    
    public W1(Semaphore onPlay,Semaphore onPlay1,List readyList) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.onPlay = onPlay;
        this.onPlayClock = onPlay1;
        this.readyList = readyList;
    }
    public W1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public synchronized void createNewProcess(List list,String name,String type,int duration ){
        ProcessImage newProcess = new ProcessImage(list,type,readyList.getSize(),"ready",name,1,0,duration);
        readyList.appendLast(newProcess);
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
        String display = "\n ----------------------------------\n ID: " + currentProcess.getId() + 
                "\n Status: " + currentProcess.getStatus()+ 
                "\n Nombre: " + currentProcess.getName() +
                "\n PC: " + currentProcess.getProgramCounter() + 
                "\n MAR: " + currentProcess.getMemoryAddressRegister() ;
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
    
    public int getSelectAlgorithm(){
        return this.selectDispatcher1.getSelectedIndex();
    }
    public void updateReady(String text){
        this.blockedTextArea.setText(text);
    } 
    public void updateBlock(String text){
        this.blockedTextArea.setText(text);
    } 
    public void updateProcess(String text){
        this.jTextArea3.setText(text);
    }
    public int getTime(){
        return this.timeSlider2.getValue();
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
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        selectDispatcher1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        readyList1 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        playButton = new javax.swing.JButton();
        createProcess1 = new javax.swing.JButton();
        timeSlider2 = new javax.swing.JSlider();
        instructionTime2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
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
        blockedTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        showUsageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 10, 160));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectDispatcher1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FSFC", "Round Robin", "SPN", "SRT", "HRR" }));
        selectDispatcher1.setToolTipText("");
        selectDispatcher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDispatcher1ActionPerformed(evt);
            }
        });
        jPanel2.add(selectDispatcher1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 190, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("CPU2");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("CPU3");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        readyList1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        readyList1.setViewportView(jTextArea4);

        jPanel2.add(readyList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, 250));

        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        jPanel2.add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 70, -1));

        createProcess1.setText("Create Process");
        createProcess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProcess1ActionPerformed(evt);
            }
        });
        jPanel2.add(createProcess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, -1, -1));

        timeSlider2.setMaximum(10000);
        timeSlider2.setValue(5000);
        timeSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSlider2StateChanged(evt);
            }
        });
        jPanel2.add(timeSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        instructionTime2.setText("5000");
        jPanel2.add(instructionTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 100, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("CPU1");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 500, 10));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("Blocked");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 10, 160));

        jLabel15.setText("Instruction Time");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, 20));

        jLabel16.setText("CPUs");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, 20));

        cpusSlider.setMaximum(3);
        cpusSlider.setMinimum(1);
        cpusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cpusSliderStateChanged(evt);
            }
        });
        jPanel2.add(cpusSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 150, -1));

        cpuUnits.setText("3");
        jPanel2.add(cpuUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 10, -1));

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

        blockedTextArea.setColumns(20);
        blockedTextArea.setRows(5);
        blockedList.setViewportView(blockedTextArea);

        jPanel2.add(blockedList, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 130, 250));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane2.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 130, 250));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Ready");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("PCBs");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        showUsageButton.setText("Show Usage");
        showUsageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsageButtonActionPerformed(evt);
            }
        });
        jPanel2.add(showUsageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 100, -1));

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
        this.createProcess1.setEnabled(false);
        this.cpusSlider.setEnabled(false);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cpusSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cpusSliderStateChanged
        // TODO add your handling code here:
        this.cpuUnits.setText(this.cpusSlider.getValue()+ " units");
    }//GEN-LAST:event_cpusSliderStateChanged

    private void showUsageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsageButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_showUsageButtonActionPerformed

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
    private javax.swing.JTextArea blockedTextArea;
    private javax.swing.JTextArea cpu1TextArea;
    private javax.swing.JTextArea cpu2TextArea;
    private javax.swing.JTextArea cpu3TextArea;
    private javax.swing.JLabel cpuUnits;
    private javax.swing.JSlider cpusSlider;
    private javax.swing.JButton createProcess1;
    private javax.swing.JLabel instructionTime2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton playButton;
    private javax.swing.JScrollPane readyList1;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> selectDispatcher1;
    private javax.swing.JButton showUsageButton;
    private javax.swing.JSlider timeSlider2;
    // End of variables declaration//GEN-END:variables
}
