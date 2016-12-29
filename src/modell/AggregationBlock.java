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
public class AggregationBlock extends FuzzySet {
    
    InferenceBlock inferenceBlock;
    
    public AggregationBlock(InferenceBlock block) {
        super(block.name, block.getSeriesCount());
        
        inferenceBlock = block;
        range = inferenceBlock.range;
    }
    
    public void aggregate() {
        removeAllTerms();
        
        Term aggregatedTerm;
        
        if (inferenceBlock.getSeriesCount() == 1) {
            
            aggregatedTerm = inferenceBlock.getTermAt(0);
            aggregatedTerm.setKey(Power.OUTPUT);
            addTerm(aggregatedTerm);
            return;
        }
        
        aggregatedTerm = new Term(Power.OUTPUT);
        
        InferredTerm firstTerm = inferenceBlock.getTermAt(0);
        InferredTerm secondterm = inferenceBlock.getTermAt(1);
        
        double lower = firstTerm.a;
        double upper = secondterm.b;
        double offset = 0.03;
        
        for (double x = lower; x <= upper; x = x + offset) {
            double firstY = firstTerm.getMembershipValue(x);
            double secondY = secondterm.getMembershipValue(x);
            
            double yPoint = NumbersFormatter.instance.getMax(firstY, secondY);
            aggregatedTerm.add(x, yPoint);
            
            x = NumbersFormatter.instance.roundToDecimalPlaces(x, 2);
        }
        
        addTerm(aggregatedTerm);
    } 
}
