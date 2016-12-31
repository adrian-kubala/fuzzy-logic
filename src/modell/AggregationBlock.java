/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

import java.util.ArrayList;
import modell.enums.Power;
import other.NumbersFormatter;

/**
 *
 * @author adrian
 */
public class AggregationBlock extends FuzzySet {
    
    private final InferenceBlock inferenceBlock;
    private double crispValue;
    
    public AggregationBlock(InferenceBlock block) {
        super("Blok agregacji", block.getVariableName(), block.getSeriesCount());
        
        inferenceBlock = block;
        range = inferenceBlock.range;
    }
    
    public void aggregate() {
        removeAllTerms();
        
        Term aggregatedTerm;
        
        if (inferenceBlock.getSeriesCount() == 1) {
            
            aggregatedTerm = inferenceBlock.copyTermAt(0);
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
    
    public void defuzzify() {
        ArrayList<Double> yPoints = new ArrayList<>();
        
        double nominator = 0;
        double denominator = 0;
        
        for (Object series : getSeries()) {
            Term term = (Term) series;
            int count = term.getItemCount();
            for (int i = 0; i < count; i++) {
                double x = term.getX(i).doubleValue();
                double y = term.getY(i).doubleValue();
                
                nominator += x * y;
                yPoints.add(y);
            }
        }
        
        for (Double yPoint : yPoints) {
            denominator += yPoint;
        }
        
        crispValue = nominator / denominator;
        crispValue = NumbersFormatter.instance.roundToDecimalPlaces(crispValue, 2);
    }
    
    public double getCrispValue() {
        return crispValue;
    }
}
