/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.SimulationDelegate;
import modell.FuzzySet;
import modell.MembershipValue;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author adrian
 */
public class MainViewController extends javax.swing.JFrame implements SimulationDelegate {

    private FuzzySetController fuzzySetcontroller;
    private SimulationController simulationController;

    /**
     * Creates new form MainFrame
     */
    public MainViewController() {
        initComponents();
        centerOnScreen();
        
        initFuzzySetController();
        initSimulationController();
    }

    private void centerOnScreen() {
        RefineryUtilities.centerFrameOnScreen(this);
    }

    private void initFuzzySetController() {
        fuzzySetcontroller = new FuzzySetController();
        inputSetPanel.add(fuzzySetcontroller.boilerTemperatureView);
        inferenceBlockPanel.add(fuzzySetcontroller.heatingPowerView);
        inferenceBlockPanel.add(fuzzySetcontroller.inferenceBlockView);
        inferenceBlockPanel.add(fuzzySetcontroller.aggregationBlockView);
    }
    
    private void initSimulationController() {
        simulationController = new SimulationController(this);
    }

    @Override
    public double inputValueDidChange(double input) {
        if (simulationController.simulationViewIsNull()) {
            simulationController.initSimulationView(simulationView);
        }
        simulationController.setBoilerTemperatureView(input);
        
        return fuzzySetcontroller.runSystem(input);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputSetPanel = new javax.swing.JPanel();
        inferenceBlockPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fuzzyOutputTextArea = new javax.swing.JTextArea();
        simulationView = new view.SimulationView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputSetPanel.setBackground(new java.awt.Color(255, 0, 0));
        inputSetPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        inferenceBlockPanel.setBackground(new java.awt.Color(255, 0, 0));
        inferenceBlockPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        fuzzyOutputTextArea.setColumns(20);
        fuzzyOutputTextArea.setRows(5);
        fuzzyOutputTextArea.setPreferredSize(new java.awt.Dimension(240, 190));
        jScrollPane2.setViewportView(fuzzyOutputTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputSetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(simulationView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simulationView, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainViewController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea fuzzyOutputTextArea;
    private javax.swing.JPanel inferenceBlockPanel;
    private javax.swing.JPanel inputSetPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private view.SimulationView simulationView;
    // End of variables declaration//GEN-END:variables
}
