/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import controller.FuzzySetController;
import modell.FuzzySet;
import modell.MembershipValue;
import org.jfree.ui.RefineryUtilities;

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
        
        centerOnScreen();
        initController();
    }
    
    private void centerOnScreen() {
        RefineryUtilities.centerFrameOnScreen(this);
    }
    
    private void initController() {
        controller = new FuzzySetController();
        inputSetPanel.add(controller.boilerTemperatureView);
        inferenceBlockPanel.add(controller.heatingPowerView);
        inferenceBlockPanel.add(controller.inferenceBlockView);
        inferenceBlockPanel.add(controller.aggregationBlockView);
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
        jPanel1 = new javax.swing.JPanel();
        fuzzifyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fuzzyOutputTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        crispValueTextArea = new javax.swing.JTextArea();
        aggregateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputSetPanel.setBackground(new java.awt.Color(255, 0, 0));
        inputSetPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        inferenceBlockPanel.setBackground(new java.awt.Color(255, 0, 0));
        inferenceBlockPanel.setPreferredSize(new java.awt.Dimension(450, 200));

        fuzzifyButton.setText("Rozmyj");
        fuzzifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzifyButtonActionPerformed(evt);
            }
        });

        fuzzyOutputTextArea.setColumns(20);
        fuzzyOutputTextArea.setRows(5);
        jScrollPane2.setViewportView(fuzzyOutputTextArea);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        crispValueTextArea.setColumns(20);
        crispValueTextArea.setRows(5);
        jScrollPane1.setViewportView(crispValueTextArea);

        aggregateButton.setText("Agreguj");
        aggregateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggregateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fuzzifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aggregateButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fuzzifyButton)
                            .addComponent(aggregateButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputSetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inferenceBlockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(152, 152, 152))))
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
        
//        inferenceBlockPanel.remove(1);
        controller.infer();
//        inferenceBlockPanel.add(controller.inferenceBlockView, 1);
        
        inferenceBlockPanel.revalidate();
    }//GEN-LAST:event_fuzzifyButtonActionPerformed

    private void aggregateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggregateButtonActionPerformed
        controller.aggregate();
        fuzzyOutputTextArea.append("\n" + "Moc ogrzewania ustawić na: " + controller.defuzzify());
    }//GEN-LAST:event_aggregateButtonActionPerformed

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
    private javax.swing.JButton aggregateButton;
    private javax.swing.JTextArea crispValueTextArea;
    private javax.swing.JButton fuzzifyButton;
    private javax.swing.JTextArea fuzzyOutputTextArea;
    private javax.swing.JPanel inferenceBlockPanel;
    private javax.swing.JPanel inputSetPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
