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
    
    /**
     *
     * @param value
     * @param termType
     * @param crispValue
     */
    public MembershipValue(double value, Enum termType, double crispValue) {
        this.value = value;
        this.termType = termType;
        forCrispValue = crispValue;
    }
    
    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }
    
    /**
     *
     * @return
     */
    public String getTermName() {
        return termType.name();
    }
    
    /**
     *
     * @return
     */
    public Enum getTermType() {
        return termType;
    }
    
    /**
     *
     * @return
     */
    public double getCrispValue() {
        return forCrispValue;
    }
}
