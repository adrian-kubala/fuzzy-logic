/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author adrian
 */
public interface SimulationDelegate {
    double inputValueDidChange(double input);
    void outsideTemperatureDidChange(double temperature);
    void desiredTemperatureDidChange(double temperature); 
}
