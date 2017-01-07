/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import modell.Simulation;

/**
 *
 * @author adrian
 */
public class SimulationView extends JPanel {
    public JLabel processTitle;
    public JProgressBar outsideTemperatureView;
    public JProgressBar boilerTemperatureView;
    
    public SimulationView(Simulation simulation) {
        processTitle = new JLabel("Trwa ogrzewanie");
        outsideTemperatureView = new JProgressBar(1, (int) simulation.outsideTemperature.getLowerRange(), (int) simulation.outsideTemperature.getUpperRange());
        boilerTemperatureView = new JProgressBar(1, (int) simulation.boiler.getLowerRange(), (int) simulation.boiler.getUpperRange());
    }
}
