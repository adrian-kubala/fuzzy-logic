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
    Boiler boiler;

    Timer timer = new Timer();
    public SimulationDelegate delegate;

    public Simulation() {
        initOutsideTemperature();
        initBoiler();
        initTimer();
    }

    private void initTimer() {
        timer.schedule(this, 0, 1000);
    }

    private void initOutsideTemperature() {
        outsideTemperature = new OutsideTemperature(new Range(-30, 5));
    }

    private void initBoiler() {
        boiler = new Boiler(new Range(35, 75));
        boiler.specifyDesiredTemperatureBasedOn(outsideTemperature);
    }

    @Override
    public void run() {
        if (boiler.didReachDesiredTemperature()) {
            return;
        }

        double outputValue = delegate.inputValueDidChange(boiler.temperature);
        boiler.temperature += (Math.abs(outsideTemperature.range.getLength()) + boiler.desiredTemperature) / 100 * outputValue;
    }
}
