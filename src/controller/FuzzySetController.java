/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modell.FuzzySet;
import modell.MembershipValue;
import modell.Power;
import modell.Temperature;
import modell.Term;
import org.jfree.data.Range;
import view.FuzzySetView;

/**
 *
 * @author adrian
 */
public class FuzzySetController {
    
    public FuzzySet boilerTemperature;
    public FuzzySetView boilerTemperatureView;
            
    public FuzzySet heatingPower;
    public FuzzySetView heatingPowerView;
    
    public FuzzySet inferenceBlock;
    public FuzzySetView inferenceBlockView;

    public FuzzySetController() {
        setupBoilerTemperature();
        setupHeatingPower();
        setupInferenceBlock();
    }
    
    private void setupBoilerTemperature() {
        boilerTemperature = new FuzzySet("temperatura bojlera", 5);
        boilerTemperature.range = new Range(7, 75);
        
        Term veryLow = new Term(Temperature.VERY_LOW);
        veryLow.setShape(7, 7, 11, 15);
        boilerTemperature.addSeries(veryLow);

        Term low = new Term(Temperature.LOW);
        low.setShape(10, 15, 15, 20);
        boilerTemperature.addSeries(low);

        Term medium = new Term(Temperature.MEDIUM);
        medium.setShape(18, 26, 26, 33);
        boilerTemperature.addSeries(medium);

        Term high = new Term(Temperature.HIGH);
        high.setShape(30, 45, 45, 60);
        boilerTemperature.addSeries(high);

        Term veryHigh = new Term(Temperature.VERY_HIGH);
        veryHigh.setShape(50, 62.5, 75, 75);
        boilerTemperature.addSeries(veryHigh);
        
        boilerTemperatureView = new FuzzySetView(boilerTemperature, 3);
    }
    
    private void setupHeatingPower() {
        heatingPower = new FuzzySet("moc ogrzewania", 5);
        heatingPower.range = new Range(0, 4);
        
        Term none = new Term(Power.NONE);
        none.setShape(0, 0, 0, 1);
        heatingPower.addSeries(none);

        Term low = new Term(Power.LOW);
        low.setShape(0, 1, 1, 2);
        heatingPower.addSeries(low);

        Term medium = new Term(Power.MEDIUM);
        medium.setShape(1, 2, 2, 3);
        heatingPower.addSeries(medium);

        Term high = new Term(Power.HIGH);
        high.setShape(2, 3, 3, 4);
        heatingPower.addSeries(high);
        
        Term veryHigh = new Term(Power.VERY_HIGH);
        veryHigh.setShape(3, 4, 4, 4);
        heatingPower.addSeries(veryHigh);
        
        heatingPowerView = new FuzzySetView(heatingPower, 1);        
    }
    
    private void setupInferenceBlock() {
        inferenceBlock = new FuzzySet("Blok wnioskowania", 5);
        inferenceBlock.range = heatingPower.range;
    }
    
    public void infer() throws CloneNotSupportedException {
        inferenceBlock.removeAllSeries();
        
        for (MembershipValue value : boilerTemperature.membershipValues) {
            if (value != null) {
                String typeName = value.termType.name();
                Enum termType = null;
                Term term = null;
                int index = 0;
                switch (typeName) {
                    case "VERY_LOW":
                        termType = Power.VERY_HIGH;
                        index = 0;
                        break;
                    case "LOW":
                        termType = Power.HIGH;
                        index = 1;
                        break;
                    case "MEDIUM":
                        termType = Power.MEDIUM;
                        index = 2;
                        break;
                    case "HIGH":
                        termType = Power.LOW;
                        index = 3;
                        break;
                    case "VERY_HIGH":
                        termType = Power.NONE;
                        index = 4;
                        break;
                }
                term = heatingPower.getCopiedTermOfType(termType);
                term.setMinimum(boilerTemperature.membershipValues[index].value);
                inferenceBlock.addSeries(term);
            }
        }
        
        inferenceBlockView = new FuzzySetView(inferenceBlock, 1);
    }    
}
