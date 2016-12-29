/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

/**
 *
 * @author adrian
 */
public class MembershipValue {
    private final double value;
    private final Enum termType;
    private final double forCrispValue;
    
    public MembershipValue(double value, Enum termType, double crispValue) {
        this.value = value;
        this.termType = termType;
        forCrispValue = crispValue;
    }
    
    public double getValue() {
        return value;
    }
    
    public String getTermName() {
        return termType.name();
    }
    
    public Enum getTermType() {
        return termType;
    }
    
    public double getCrispValue() {
        return forCrispValue;
    }
}
