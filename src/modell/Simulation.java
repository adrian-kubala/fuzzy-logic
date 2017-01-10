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

/**
 *
 * @author adrian
 */
public class Simulation extends TimerTask {

    public OutsideTemperature outsideTemperature;
    public Boiler boiler;

    public SimulationDelegate delegate;

    public Simulation() {
        initOutsideTemperature();
        initBoiler();
        initTimers();
    }

    private void initOutsideTemperature() {
        outsideTemperature = new OutsideTemperature(new Range(-30, 35));
    }

    private void initBoiler() {
        boiler = new Boiler(new Range(7, 75));
        boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
    }

    private void initTimers() {
        new Timer().schedule(this, 0, 80);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (willRandomNewOutsideTemperature()) {
                    randomizeOutsideTemperature();
                }
            }
        }, 0, 400);
        
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                outsideTemperature.randomizeTemperatureGrowth(20);
                delegate.outsideTemperatureDidChange(outsideTemperature.getValue());
            }
        }, 0, 15000);
    }

    @Override
    public void run() {
        if (delegate != null) {

            if (boiler.didReachDesiredTemperature()) {
                boiler.increaseTemperature(-0.2);
                delegate.inputValueDidChange(boiler.getTemperature());
            } else {
                double outputValue = delegate.inputValueDidChange(boiler.getTemperature());
                double growthRate = calculateGrowthRate(outputValue);
                boiler.increaseTemperature(growthRate);
            }
        }
    }

    private double calculateGrowthRate(double factor) {
        return (Math.abs(outsideTemperature.getValue()) + boiler.getDesiredTemperature()) / 700 * factor;
    }

    private boolean willRandomNewOutsideTemperature() {
        return new Random().nextBoolean();
    }

    private void randomizeOutsideTemperature() {
        outsideTemperature.randomizeTemperatureGrowth();
        delegate.outsideTemperatureDidChange(outsideTemperature.getValue());

        updateDesiredTemperature();
    }

    private void updateDesiredTemperature() {
        boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
        delegate.desiredTemperatureDidChange(boiler.getDesiredTemperature());
    }
}
