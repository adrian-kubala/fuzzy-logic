/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import modell.enums.Power;
import other.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class InferredTerm extends Term {
    public double newX0, newX1;
    enum Blank {
        BLANK
    }
    
    public InferredTerm() {
        super(Blank.BLANK);
    }
    
    @Override
    public double getMembershipValue(double x) {
        double value;
        if (x >= a && x <= newX0) {
            value = (x - a) / (x0 - a);
        } else if (x >= newX0 && x <= newX1) {
            value = height;
        } else if (x >= newX1 && x <= b) {
            value = (b - x) / (b - x1);
        } else {
            value = 0;
        }
        value = NumbersFormatter.instance.roundToDecimalPlaces(value, 2);
        return value;
    }
    
    public void setMinimum(double y) {
        newX0 = getNewX0(y);
        newX1 = getNewX1(y);
        
        clear();
        
        add(a, 0);
        add(newX0, y);
        addOrUpdate(newX1, y);
        add(b, 0);
        
        height = y;
    }
    
    private double getNewX0(double y) {
        return y * (x0 - a) + a;
    }
    
    private double getNewX1(double y) {
        return y * (x0 - b) + b;
    }
    
    public void assignDataOfTerm(Term term) {
        setShape(term.a, term.x0, term.x1, term.b);
        type = term.type;
        height = term.height;
    }
}
