/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import org.jfree.data.Range;
import other.NumbersFormatter;
import other.SimulationDelegate;

/**
 *
 * @author adrian
 */
public class Simulation extends TimerTask {
    
    OutsideTemperature outsideTemperature;
    double temperatureDifference;
    
    double minBoilerTemperature = 35;
    double maxBoilerTemperature = 75;
    double boilerTemperaturesRange = maxBoilerTemperature - minBoilerTemperature;
    double boilerTemperature = 7;
    double desiredBoilerTemperature;
    
    public SimulationDelegate delegate;
    
    Timer timer = new Timer();
    
    public Simulation() {
        initOutsideTemperature();
        initBoiler();
        timer.schedule(this, 0, 1000);
    }
    
    private void initOutsideTemperature() {
        outsideTemperature = new OutsideTemperature(new Range(-30, 5));
        
        temperatureDifference = Math.abs(outsideTemperature.range.getLowerBound()) - Math.abs(outsideTemperature.value);
        System.out.println(temperatureDifference);
    }
    
    private void initBoiler() {
        desiredBoilerTemperature = maxBoilerTemperature - ((boilerTemperaturesRange / outsideTemperature.range.getLength()) * temperatureDifference);
        System.out.println(desiredBoilerTemperature);
    }
    
    @Override
    public void run() {
        if (boilerTemperature >= desiredBoilerTemperature) {
            return;
        }
        
        double outputValue = delegate.inputValueDidChange(boilerTemperature);
        boilerTemperature += (Math.abs(outsideTemperature.range.getLength()) + desiredBoilerTemperature) / 100 * outputValue;
    }
}
