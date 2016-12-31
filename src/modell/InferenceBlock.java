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
    
    private final FuzzySet outputSet;
    
    public InferenceBlock(FuzzySet outputSet) {
        super("Blok wnioskowania", outputSet.getVariableName(), outputSet.getSeriesCount());
        
        range = outputSet.range;
        this.outputSet = outputSet;
    }
    
    public void infer(FuzzySet inputSet) {
        removeAllTerms();
        
        int valuesCount = inputSet.getMembershipValuesLastIndex();
        for (int i = valuesCount; i >= 0; i--) {
            MembershipValue value = inputSet.getMembershipValueAt(i);
            if (value != null) {
                Enum currentType = value.getTermType();
                
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
                
                addTerm(inferredTerm);
            }
        }
    }
    
    @Override
    public InferredTerm getTermAt(int index) {
        return (InferredTerm) super.getTermAt(index);
    }
}
