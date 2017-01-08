/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import modell.Simulation;

/**
 *
 * @author adrian
 */
public class SimulationView extends javax.swing.JPanel {

    private Simulation simulation;

    /**
     * Creates new form SimulationView
     */
    public SimulationView() {
        initComponents();
    }
    
    public void setData(Simulation simulation) {
        this.simulation = simulation;
        
        initOutsideTemperatureView();
        initBoilerTemperatureView();
    }
    
    private void initOutsideTemperatureView() {
        outsideTemperatureView.setMinimum((int) simulation.outsideTemperature.getLowerRange());
        outsideTemperatureView.setMaximum((int) simulation.outsideTemperature.getUpperRange());
        
        outsideTemperatureView.setValue((int) simulation.outsideTemperature.value);
    }
    
    private void initBoilerTemperatureView() {
        boilerTemperatureView.setMinimum((int) simulation.boiler.getLowerRange());
        boilerTemperatureView.setMaximum((int) simulation.boiler.getUpperRange());
        
        boilerTemperatureView.setValue((int) simulation.boiler.temperature);
    }
    
    public void setOutsideTemperatureView(double value) {
        outsideTemperatureView.setValue((int) value);
    }
    
    public void setBoilerTemperatureView(double value) {
        boilerTemperatureView.setValue((int) value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressName = new javax.swing.JLabel();
        outsideTemperatureView = new javax.swing.JProgressBar();
        boilerTemperatureView = new javax.swing.JProgressBar();
        outsideTemperatureViewUpperRangeLabel = new javax.swing.JLabel();
        boilerTemperatureViewUpperRangeLabel = new javax.swing.JLabel();
        outsideTemperatureViewLowerRangeLabel = new javax.swing.JLabel();
        boilerTemperatureViewLowerRangeLabel = new javax.swing.JLabel();

        progressName.setFont(new java.awt.Font("LiHei Pro", 0, 15)); // NOI18N
        progressName.setText("Trwa ogrzewanie...");

        outsideTemperatureView.setOrientation(1);

        boilerTemperatureView.setOrientation(1);

        outsideTemperatureViewUpperRangeLabel.setText("0");

        boilerTemperatureViewUpperRangeLabel.setText("0");

        outsideTemperatureViewLowerRangeLabel.setText("0");

        boilerTemperatureViewLowerRangeLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outsideTemperatureViewUpperRangeLabel)
                    .addComponent(outsideTemperatureViewLowerRangeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outsideTemperatureView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boilerTemperatureViewUpperRangeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boilerTemperatureView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(progressName)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(boilerTemperatureViewLowerRangeLabel)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressName)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outsideTemperatureViewUpperRangeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outsideTemperatureViewLowerRangeLabel))
                    .addComponent(boilerTemperatureView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outsideTemperatureView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boilerTemperatureViewUpperRangeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boilerTemperatureViewLowerRangeLabel)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar boilerTemperatureView;
    private javax.swing.JLabel boilerTemperatureViewLowerRangeLabel;
    private javax.swing.JLabel boilerTemperatureViewUpperRangeLabel;
    private javax.swing.JProgressBar outsideTemperatureView;
    private javax.swing.JLabel outsideTemperatureViewLowerRangeLabel;
    private javax.swing.JLabel outsideTemperatureViewUpperRangeLabel;
    private javax.swing.JLabel progressName;
    // End of variables declaration//GEN-END:variables
}
