/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import org.jfree.data.Range;

/**
 *
 * @author adrian
 */
public class Boiler {
    public double temperature = 7;
    public double desiredTemperature;
    private final Range RANGE;
    
    public Boiler(Range range) {
        RANGE = range;
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
}
