/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import modell.enums.Power;

/**
 *
 * @author adrian
 */
public class InferenceBlock extends FuzzySet {
    
    FuzzySet outputSet;
    
    public InferenceBlock(FuzzySet outputSet) {
        super(outputSet.name, outputSet.getSeriesCount());
        
        range = outputSet.range;
        this.outputSet = outputSet;
    }
    
    public void infer(FuzzySet inputSet) {
        removeAllSeries();
        
        int valuesCount = inputSet.membershipValues.length - 1;
        for (int i = valuesCount; i >= 0; i--) {
            MembershipValue value = inputSet.membershipValues[i];
            if (value != null) {
                Enum currentType = value.termType;
                
                Enum inferedTermType = null;
                switch (currentType.name()) {
                    case "VERY_LOW":
                        inferedTermType = Power.VERY_HIGH;
                        break;
                    case "LOW":
                        inferedTermType = Power.HIGH;
                        break;
                    case "MEDIUM":
                        inferedTermType = Power.MEDIUM;
                        break;
                    case "HIGH":
                        inferedTermType = Power.LOW;
                        break;
                    case "VERY_HIGH":
                        inferedTermType = Power.NONE;
                        break;
                }
                
                Term outputTerm = outputSet.copyTermOfType(inferedTermType);
                InferredTerm inferredTerm = new InferredTerm(outputTerm);
                
                double membershipValue = inputSet.getMembershipValueOfType(currentType);
                inferredTerm.setMinimum(membershipValue);
                
                addSeries(inferredTerm);
            }
        }
    }
    
}
