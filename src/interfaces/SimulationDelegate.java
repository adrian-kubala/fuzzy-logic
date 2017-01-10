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

    /**
     *
     * @param input
     * @return
     */
    double inputValueDidChange(double input);

    /**
     *
     * @param temperature
     */
    void outsideTemperatureDidChange(double temperature);

    /**
     *
     * @param temperature
     */
    void desiredTemperatureDidChange(double temperature); 
}
