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
public class OutsideTemperature {
    public Range range;
    int ambientTempCount;

    public OutsideTemperature(Range range) {
        this.range = range;
        ambientTempCount = (int) (Math.abs(range.getLowerBound()) + 35);
    }
    
    
}
