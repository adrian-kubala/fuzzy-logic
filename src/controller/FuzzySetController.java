/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modell.AggregationBlock;
import modell.FuzzySet;
import modell.InferenceBlock;
import modell.enums.Power;
import modell.enums.Temperature;
import modell.Term;
import org.jfree.data.Range;
import view.FuzzySetView;

/**
 *
 * @author adrian
 */
public class FuzzySetController {
    
    private static final String INPUT_SET_NAME = "temperatura bojlera";
    private static final String OUTPUT_SET_NAME = "moc ogrzewania";
    
    public FuzzySet boilerTemperature;
    public FuzzySetView boilerTemperatureView;
            
    public FuzzySet heatingPower;
    public FuzzySetView heatingPowerView;
    
    public InferenceBlock inferenceBlock;
    public FuzzySetView inferenceBlockView;
    
    public AggregationBlock aggregationBlock;
    public FuzzySetView aggregationBlockView;

    public FuzzySetController() {
        setupBoilerTemperature();
        setupHeatingPower();
        setupInferenceBlock();
        setupAggregationBlock();
    }
    
    private void setupBoilerTemperature() {
        boilerTemperature = new FuzzySet(INPUT_SET_NAME, 5);
        boilerTemperature.range = new Range(7, 75);
        
        Term veryLow = new Term(Temperature.VERY_LOW);
        veryLow.setShape(3, 7, 11, 15);
        boilerTemperature.addTerm(veryLow);

        Term low = new Term(Temperature.LOW);
        low.setShape(10, 15, 15, 20);
        boilerTemperature.addTerm(low);

        Term medium = new Term(Temperature.MEDIUM);
        medium.setShape(18, 26, 26, 33);
        boilerTemperature.addTerm(medium);

        Term high = new Term(Temperature.HIGH);
        high.setShape(30, 45, 45, 60);
        boilerTemperature.addTerm(high);

        Term veryHigh = new Term(Temperature.VERY_HIGH);
        veryHigh.setShape(50, 62.5, 75, 87.5);
        boilerTemperature.addTerm(veryHigh);
        
        boilerTemperatureView = new FuzzySetView(boilerTemperature, 3);
    }
    
    private void setupHeatingPower() {
        heatingPower = new FuzzySet(OUTPUT_SET_NAME, 5);
        heatingPower.range = new Range(0, 4);
        
        Term none = new Term(Power.NONE);
        none.setShape(-1, 0, 0, 1);
        heatingPower.addTerm(none);

        Term low = new Term(Power.LOW);
        low.setShape(0, 1, 1, 2);
        heatingPower.addTerm(low);

        Term medium = new Term(Power.MEDIUM);
        medium.setShape(1, 2, 2, 3);
        heatingPower.addTerm(medium);

        Term high = new Term(Power.HIGH);
        high.setShape(2, 3, 3, 4);
        heatingPower.addTerm(high);
        
        Term veryHigh = new Term(Power.VERY_HIGH);
        veryHigh.setShape(3, 4, 4, 5);
        heatingPower.addTerm(veryHigh);
        
        heatingPowerView = new FuzzySetView(heatingPower, 1);        
    }
    
    private void setupInferenceBlock() {
        inferenceBlock = new InferenceBlock(heatingPower);
        inferenceBlockView = new FuzzySetView(inferenceBlock, 1);
    }
    
    private void setupAggregationBlock() {
        aggregationBlock = new AggregationBlock(inferenceBlock);
        aggregationBlockView = new FuzzySetView(aggregationBlock, 1);
    }
    
    public void infer() {
        boilerTemperatureView.showFuzzyValues();
        
        inferenceBlock.infer(boilerTemperature);
        inferenceBlockView.refresh();
    }   
    
    public void aggregate() {
        aggregationBlock.aggregate();
        aggregationBlockView.refresh();
    }
    
    public double defuzzify() {
       aggregationBlock.defuzzify();
        double outputCrispValue = aggregationBlock.getCrispValue();
        
        aggregationBlockView.refresh();
        aggregationBlockView.showSingleton(outputCrispValue);
        aggregationBlockView.fillView();
        
        return outputCrispValue;
    }
}
