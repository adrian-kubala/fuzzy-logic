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
    
    public SimulationController(SimulationDelegate delegate) {
        initSimulation(delegate); 
    }
        
    private void initSimulation(SimulationDelegate delegate) {
        simulation = new Simulation();
        simulation.delegate = delegate;
    }
    
    public void initSimulationView(SimulationView view) {
        simulationView = view;
        simulationView.setData(simulation);
    }
    
    public void setBoilerTemperatureView(double value) {
        simulationView.setBoilerTemperatureView(value);
    }
    
    public boolean simulationViewIsNull() {
        return simulationView == null;
    }
}
