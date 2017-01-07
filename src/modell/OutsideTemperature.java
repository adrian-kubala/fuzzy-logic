/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.concurrent.ThreadLocalRandom;
import org.jfree.data.Range;
import other.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class OutsideTemperature {
    public Range range;
    public double value;
    public double temperatureDifference;

    public OutsideTemperature(Range range) {
        this.range = range;
        
        value = ThreadLocalRandom.current().nextDouble(range.getLowerBound(), range.getUpperBound());
        value = NumbersFormatter.instance.roundToDecimalPlaces(value, 2);
        System.out.println(value);
        
        temperatureDifference = Math.abs(range.getLowerBound()) - Math.abs(value);
        System.out.println(temperatureDifference);
    }
    
    
}
