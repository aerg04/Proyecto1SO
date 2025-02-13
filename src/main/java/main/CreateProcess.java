/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class CreateProcess extends javax.swing.JFrame {

    public List<Integer> instructions;
    public W1 father;
    /**
     * Creates new form CreateProcess
     */
    public CreateProcess(W1 w1){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        father = w1;
        instructions = new List();
        //this.jTextArea1.setEnabled(false);
        
    }
    public CreateProcess(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    
    private boolean validateTextAreaInput(String input) {
    instructions = new List<>();
    StringBuilder numberBuilder = new StringBuilder();

    try {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ',') {
                if (numberBuilder.length() > 0) {
                    int number = Integer.parseInt(numberBuilder.toString().trim());
                    if (number <= 0) {
                        return false; // All numbers must be greater than 0
                    }
                    instructions.appendLast(number);
                    numberBuilder.setLength(0); // Reset the StringBuilder
                }
            } else if (Character.isDigit(currentChar)) {
                numberBuilder.append(currentChar);
            } else {
                return false; // Invalid character found
            }
        }

        // Add the last number
        if (numberBuilder.length() > 0) {
            int number = Integer.parseInt(numberBuilder.toString().trim());
            if (number <= 0) {
                return false; // All numbers must be greater than 0
            }
            instructions.appendLast(number);
        }
    } catch (NumberFormatException e) {
        return false; // Input must be integers
    }

    //verificar que sea par
    if(instructions.getSize()%2 == 1){
        return false;
    }
    // Check if even-indexed values are in ascending order
    for (int i = 2; i < instructions.getSize(); i += 2) {
        if ((int)instructions.getNodoById(i).getValue() <= (int) instructions.getNodoById(i - 2).getValue()) {
            return false; // Even-indexed values must be in ascending order
        }
    }

    return true;
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
        typeComboBox = new javax.swing.JComboBox<>();
        durationTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I/O Bound", "CPU Bound" }));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(typeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 390, -1));

        durationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(durationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 390, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 450, 160));

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 390, 20));

        jLabel2.setText("Type:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, 20));

        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setText("Duration:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if (this.validateTextAreaInput(this.jTextArea1.getText()) && typeComboBox.getSelectedIndex() == 1){
            if (!nameTextField.getText().trim().isEmpty()) {
                    try{
                        father.createNewProcess(instructions, nameTextField.getText(), (String) typeComboBox.getSelectedItem(), Integer.parseInt(durationTextField.getText().trim()));
                        this.dispose(); 
                    }catch(NumberFormatException e){
                        javax.swing.JOptionPane.showMessageDialog(this, "Duration must be a number", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "Name cannot be empty", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Text Area eror ex. 1,2,3,8,", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_saveButtonActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
        if (nameTextField.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Name cannot be empty", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void durationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationTextFieldActionPerformed
        // TODO add your handling code here:
        // Validate that the duration is a number
        try {
            int number = Integer.parseInt(durationTextField.getText().trim());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Duration must be a number", "Validation Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_durationTextFieldActionPerformed

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
        if(typeComboBox.getSelectedIndex() == 1){
            this.jTextArea1.setEnabled(false);
            this.jTextArea1.setText("");
        }else{
            this.jTextArea1.setEnabled(true);
        }
    }//GEN-LAST:event_typeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CreateProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateProcess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField durationTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
