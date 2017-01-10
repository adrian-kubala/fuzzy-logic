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
    
    public Boiler(Range range) {
        RANGE = range;
    }
    
    public Boiler(Range range, double startingTemperature) {
        RANGE = range;
        temperature = startingTemperature;
    }
    
    public double getLowerRange() {
        return RANGE.getLowerBound();
    }
    
    public double getRangeLength() {
        return RANGE.getLength();
    }
    
    public double getUpperRange() {
        return RANGE.getUpperBound();        
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public void increaseTemperature(double value) {
        value = NumbersFormatter.instance.roundToDecimalPlaces(value, 2);
        temperature += value;
    } 
    
    public double getDesiredTemperature() {
        return desiredTemperature;
    }
    
    public void specifyDesiredTemperatureBasedOn(OutsideTemperature outsideTemp) {
        desiredTemperature = getUpperRange() - (outsideTemp.temperatureDifference / 2);
        desiredTemperature = NumbersFormatter.instance.roundToDecimalPlaces(desiredTemperature, 2);
    }
    
    public boolean didReachDesiredTemperature() {
        return temperature >= desiredTemperature;
    }
}
