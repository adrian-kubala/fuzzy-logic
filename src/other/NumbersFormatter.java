/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author adrian
 */
public class NumbersFormatter {
    public static final NumbersFormatter instance = new NumbersFormatter();
    
    private NumbersFormatter() { };
    
    public double roundToDecimalPlaces(double value, int places) {
        if (places == 0) {
            return value;
        }
        
        double factor = Math.pow(10, places);
        return Math.round(value * factor) / factor;
    }
}
