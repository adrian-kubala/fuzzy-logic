/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import controller.FuzzySetController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.FuzzySet;
import modell.MembershipValue;

/**
 *
 * @author adrian
 */
public class MainFrame extends javax.swing.JFrame {
    FuzzySetController controller;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        placeOnCenter();
        initController();
    }
    
    private void placeOnCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
    }
    
    private void initController() {
        controller = new FuzzySetController();
        fuzzySetsPanel.add(controller.boilerTemperatureView);
        fuzzySetsPanel.add(controller.heatingPowerView);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fuzzySetsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        crispValueTextArea = new javax.swing.JTextArea();
        fuzzifyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fuzzyOutputTextArea = new javax.swing.JTextArea();
        inferenceBlockPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fuzzySetsPanel.setBackground(new java.awt.Color(255, 0, 0));
        fuzzySetsPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        crispValueTextArea.setColumns(20);
        crispValueTextArea.setRows(5);
        jScrollPane1.setViewportView(crispValueTextArea);

        fuzzifyButton.setText("Rozmyj");
        fuzzifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzifyButtonActionPerformed(evt);
            }
        });

        fuzzyOutputTextArea.setColumns(20);
        fuzzyOutputTextArea.setRows(5);
        jScrollPane2.setViewportView(fuzzyOutputTextArea);

        inferenceBlockPanel.setBackground(new java.awt.Color(255, 0, 0));
        inferenceBlockPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(fuzzySetsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fuzzifyButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(fuzzifyButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fuzzySetsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fuzzifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuzzifyButtonActionPerformed
        FuzzySet boilerTemperature = controller.boilerTemperature;
        boilerTemperature.fuzzify(Double.parseDouble(crispValueTextArea.getText()));
        
        int termsCount = boilerTemperature.getSeriesCount();
        fuzzyOutputTextArea.setText("");
        for (int i = 0; i < termsCount; i++) {
            String name = (String) boilerTemperature.getSeriesKey(i);
            double value;
            MembershipValue membershipValue = boilerTemperature.membershipValues[i];
            if (membershipValue != null) {
                value = membershipValue.value;
            } else {
                value = 0;
            }
            fuzzyOutputTextArea.append("u" + name + " (" + boilerTemperature.name + ") = " + value + "\n");
        }
        inferenceBlockPanel.removeAll();
        try {
            controller.infer();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        inferenceBlockPanel.add(controller.inferenceBlockView);
        inferenceBlockPanel.revalidate();
        inferenceBlockPanel.repaint();
    }//GEN-LAST:event_fuzzifyButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea crispValueTextArea;
    private javax.swing.JButton fuzzifyButton;
    private javax.swing.JTextArea fuzzyOutputTextArea;
    private javax.swing.JPanel fuzzySetsPanel;
    private javax.swing.JPanel inferenceBlockPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
