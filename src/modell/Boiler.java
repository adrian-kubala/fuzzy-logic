/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import org.jfree.data.Range;
import singleton.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class Boiler {
    private final Range RANGE;
    private double temperature = 7;
    private double desiredTemperature;
    
    /**
     *
     * @param range
     */
    public Boiler(Range range) {
        RANGE = range;
    }
    
    /**
     *
     * @param range
     * @param startingTemperature
     */
    public Boiler(Range range, double startingTemperature) {
        RANGE = range;
        temperature = startingTemperature;
    }
    
    /**
     *
     * @return
     */
    public double getLowerRange() {
        return RANGE.getLowerBound();
    }
    
    /**
     *
     * @return
     */
    public double getRangeLength() {
        return RANGE.getLength();
    }
    
    /**
     *
     * @return
     */
    public double getUpperRange() {
        return RANGE.getUpperBound();        
    }
    
    /**
     *
     * @return
     */
    public double getTemperature() {
        return temperature;
    }
    
    /**
     *
     * @param value
     */
    public void increaseTemperature(double value) { 
        temperature += value;
    } 
    
    /**
     *
     * @return
     */
    public double getDesiredTemperature() {
        return desiredTemperature;
    }
    
    /**
     *
     * @param outsideTemp
     */
    public void specifyDesiredTemperatureBasedOn(OutsideTemperature outsideTemp) {
        desiredTemperature = getUpperRange() - (outsideTemp.getDifferenceBetweenLowerBound() / 2);
    }
    
    /**
     *
     * @return
     */
    public boolean didReachDesiredTemperature() {
        return temperature >= desiredTemperature;
    }
}
