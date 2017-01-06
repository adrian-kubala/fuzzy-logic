/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import other.NumbersFormatter;
import other.SimulationDelegate;

/**
 *
 * @author adrian
 */
public class Simulation extends TimerTask {
    
    int lowestAmbientTemperature = -30;
    int highestAmbientTemperature = 5;
    int ambientTempCount = Math.abs(lowestAmbientTemperature) + 35;
    
    double ambientTemperature;
    double desiredBoilerTemperature;
    
    double minBoilerTemperature = 35;
    double maxBoilerTemperature = 75;
    double boilerTemperaturesRange = maxBoilerTemperature - minBoilerTemperature; 
    
    double temperatureDifference;
    
    double boilerTemperature = 7;
    
    public SimulationDelegate delegate;
    
    public Simulation() {
        initAmbientTemperature();
    }
    
    private void initAmbientTemperature() {
        ambientTemperature = ThreadLocalRandom.current().nextDouble(lowestAmbientTemperature, highestAmbientTemperature);
        ambientTemperature = NumbersFormatter.instance.roundToDecimalPlaces(ambientTemperature, 2);
        System.out.println(ambientTemperature);
        
        temperatureDifference = Math.abs(lowestAmbientTemperature) - Math.abs(ambientTemperature);
        System.out.println(temperatureDifference);
        desiredBoilerTemperature = maxBoilerTemperature - ((boilerTemperaturesRange / ambientTempCount) * temperatureDifference);
        System.out.println(desiredBoilerTemperature);
    }
    
    @Override
    public void run() {
        if (boilerTemperature >= desiredBoilerTemperature) {
            return;
        }
        
        double outputValue = delegate.systemDidStart(boilerTemperature);
        boilerTemperature += (Math.abs(ambientTempCount) + desiredBoilerTemperature) / 100 * outputValue;
    }
}
