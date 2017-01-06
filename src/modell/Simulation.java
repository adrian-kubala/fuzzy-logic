/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import other.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class Simulation extends TimerTask {
    
    int lowestAmbientTemperature = -30;
    int highestAmbientTemperature = 5;
    
    double ambientTemperature;
    double desiredBoilerTemperature;
    
    double factor = 105;
    double temperatureDifference;
    
    double boilerTemperature = 7;
    
    public Simulation() {
        initAmbientTemperature();
    }
    
    private void initAmbientTemperature() {
        ambientTemperature = ThreadLocalRandom.current().nextDouble(lowestAmbientTemperature, highestAmbientTemperature);
        ambientTemperature = NumbersFormatter.instance.roundToDecimalPlaces(ambientTemperature, 2);
        
        temperatureDifference = Math.abs(lowestAmbientTemperature - ambientTemperature);
        desiredBoilerTemperature = factor - temperatureDifference;
    }
    
    @Override
    public void run() {
        
    }
    
}
