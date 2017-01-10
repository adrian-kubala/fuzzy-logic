/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.concurrent.ThreadLocalRandom;
import org.jfree.data.Range;
import singleton.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class OutsideTemperature {

    private final Range RANGE;
    private double value;
    public double temperatureDifference;

    public OutsideTemperature(Range range) {
        RANGE = range;

        initValue();
        calculateDifference();
    }

    private void initValue() {
        value = randomizeValue(RANGE.getLowerBound(), RANGE.getUpperBound());
    }
    
    private double randomizeValue(double lowerBound, double upperBound) {
        double temperature = ThreadLocalRandom.current().nextDouble(lowerBound, upperBound);
        temperature = NumbersFormatter.instance.roundToDecimalPlaces(temperature, 2);
        
        return temperature;
    }

    private void calculateDifference() {
        temperatureDifference = new Range(RANGE.getLowerBound(), value).getLength();
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
    
    public double getValue() {
        return value;
    }
    
    public void randomizeTemperatureGrowth() {
        double span = 0.5;
        double newTemperature = randomizeValue(value - span, value + span);
        while(newTemperature < getLowerRange() || newTemperature > getUpperRange()) {
            newTemperature = randomizeValue(value - span, value + span);
        }
        
        value = newTemperature;
        calculateDifference();
    }

}
