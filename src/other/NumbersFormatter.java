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
    
    public double getMax(double... numbers) {
        double max = numbers[0];
        int length = numbers.length;
        if (length == 1) {
            return max;
        }
        
        for (int i = 1; i < length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        return max;
    }
}
