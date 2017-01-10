/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.SimulationDelegate;
import modell.Simulation;
import view.SimulationView;

/**
 *
 * @author adrian
 */
public class SimulationController {
    private Simulation simulation;
    private SimulationView simulationView;
    
    /**
     *
     * @param delegate
     */
    public SimulationController(SimulationDelegate delegate) {
        initSimulation(delegate); 
    }
        
    private void initSimulation(SimulationDelegate delegate) {
        simulation = new Simulation();
        simulation.delegate = delegate;
    }
    
    /**
     *
     * @param view
     */
    public void initSimulationView(SimulationView view) {
        simulationView = view;
        simulationView.setData(simulation);
    }
    
    /**
     *
     * @param value
     */
    public void setBoilerTemperatureView(double value) {
        simulationView.setBoilerTemperatureView(value);
    }
    
    /**
     *
     * @param value
     */
    public void setOutsideTemperatureView(double value) {
        simulationView.setOutsideTemperatureView(value);
    }
    
    /**
     *
     * @param value
     */
    public void setDesiredTemperatureLabel(double value) {
        simulationView.setDesiredBoilerTemperature(value);
    }
    
    /**
     *
     * @return
     */
    public boolean simulationViewIsNull() {
        return simulationView == null;
    }
}
