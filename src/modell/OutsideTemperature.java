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
    public double value;
    public double temperatureDifference;

    public OutsideTemperature(Range range) {
        RANGE = range;

        randomizeTemperature();
        calculateDifference();
    }

    private void randomizeTemperature() {
        value = ThreadLocalRandom.current().nextDouble(RANGE.getLowerBound(), RANGE.getUpperBound());
        value = NumbersFormatter.instance.roundToDecimalPlaces(value, 2);
        System.out.println("Temperatura zewnętrzna: " + value);
    }

    private void calculateDifference() {
        temperatureDifference = Math.abs(RANGE.getLowerBound()) - Math.abs(value);
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
