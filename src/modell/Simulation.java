/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.Timer;
import java.util.TimerTask;
import org.jfree.data.Range;
import interfaces.SimulationDelegate;
import java.util.Random;
import singleton.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class Simulation extends TimerTask {

    public OutsideTemperature outsideTemperature;
    public Boiler boiler;

    Timer timer = new Timer();
    public SimulationDelegate delegate;

    public Simulation() {
        initOutsideTemperature();
        initBoiler();
        initTimer();
    }

    private void initTimer() {
        timer.schedule(this, 0, 60);
    }

    private void initOutsideTemperature() {
        outsideTemperature = new OutsideTemperature(new Range(-30, 35));
    }

    private void initBoiler() {
        boiler = new Boiler(new Range(7, 75));
        boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
    }

    @Override
    public void run() {
        if (boiler.didReachDesiredTemperature()) {
            randomizeTemperatures();
            return;
        }

        if (delegate != null) {
            boolean willRandomNewOutsideTemperature = new Random().nextBoolean();
            if (willRandomNewOutsideTemperature) {
                outsideTemperature.randomizeTemperatureGrowth();
                boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
            }
            delegate.outsideTemperatureDidChange(outsideTemperature.value);
            
            delegate.desiredTemperatureDidChange(boiler.desiredTemperature);
            
            double outputValue = delegate.inputValueDidChange(boiler.temperature);
            double growthRate = (Math.abs(outsideTemperature.value) + boiler.desiredTemperature) / 700 * outputValue;
            if (growthRate == 0) {
                randomizeTemperatures();
            }
            boiler.temperature += growthRate;
            boiler.temperature = NumbersFormatter.instance.roundToDecimalPlaces(boiler.temperature, 2);
        }
    }
    
    private void randomizeTemperatures() {
            outsideTemperature.randomizeTemperatureGrowth();
            delegate.outsideTemperatureDidChange(outsideTemperature.value);
            
            boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
            delegate.desiredTemperatureDidChange(boiler.desiredTemperature);

            boiler.temperature -= 0.2;
            delegate.inputValueDidChange(boiler.temperature);
    }
}
