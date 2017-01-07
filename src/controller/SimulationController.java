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
    
    public SimulationController(SimulationView view, SimulationDelegate delegate) {
        initSimulation(delegate);
        initSimulationView(view);
    }
        
    private void initSimulation(SimulationDelegate delegate) {
        simulation = new Simulation();
        simulation.delegate = delegate;
    }
    
    private void initSimulationView(SimulationView view) {
        simulationView = view;
        simulationView.setData(simulation);
    }
}
