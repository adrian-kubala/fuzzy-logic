/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modell.FuzzySet;
import modell.MembershipValue;
import modell.Power;
import modell.Temperature;
import modell.Term;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataItem;
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
    
    public FuzzySet inferenceBlock;
    public FuzzySetView inferenceBlockView;

    public FuzzySetController() {
        setupBoilerTemperature();
        setupHeatingPower();
        setupInferenceBlock();
    }
    
    private void setupBoilerTemperature() {
        boilerTemperature = new FuzzySet(INPUT_SET_NAME, 5);
        boilerTemperature.range = new Range(7, 75);
        
        Term veryLow = new Term(Temperature.VERY_LOW);
        veryLow.setShape(3, 7, 11, 15);
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
        veryHigh.setShape(50, 62.5, 75, 87.5);
        boilerTemperature.addSeries(veryHigh);
        
        boilerTemperatureView = new FuzzySetView(boilerTemperature, 3);
    }
    
    private void setupHeatingPower() {
        heatingPower = new FuzzySet(OUTPUT_SET_NAME, 5);
        heatingPower.range = new Range(0, 4);
        
        Term none = new Term(Power.NONE);
        none.setShape(-1, 0, 0, 1);
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
        veryHigh.setShape(3, 4, 4, 5);
        heatingPower.addSeries(veryHigh);
        
        heatingPowerView = new FuzzySetView(heatingPower, 1);        
    }
    
    private void setupInferenceBlock() {
        inferenceBlock = new FuzzySet(OUTPUT_SET_NAME, 5);
        inferenceBlock.range = heatingPower.range;
    }
    
    public void infer() {
        inferenceBlock.removeAllSeries();
        
        int valuesCount = boilerTemperature.membershipValues.length - 1;
        for (int i = valuesCount; i >= 0; i--) {
            MembershipValue value = boilerTemperature.membershipValues[i];
            if (value != null) {
                Enum currentType = value.termType;
                
                Term inferedTerm;
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
                
                inferedTerm = heatingPower.copyTermOfType(inferedTermType);
                inferedTerm.setMinimum(boilerTemperature.getMembershipValueOfType(currentType));
                inferenceBlock.addSeries(inferedTerm);
            }
        }
        
        inferenceBlockView = new FuzzySetView(inferenceBlock, 1);
        inferenceBlockView.deleteLegend();
    }   
    
    public void joinTerms() {
        if (inferenceBlock.getSeriesCount() == 2) {
            return;
        }
        
        ArrayList<XYDataItem> points = new ArrayList<>();
        
        Term firstTerm = inferenceBlock.getTermAt(0);
        Term secondterm = inferenceBlock.getTermAt(1);
        
        double lower = firstTerm.a;
        double upper = secondterm.b;
        double offset = 0.05;
        
        for (double i = lower; i <= upper; i = i + offset) {
            double firstY = firstTerm.getMembershipValueAfterMin(i);
            double secondY = secondterm.getMembershipValueAfterMin(i);
            System.out.println("pierwszy a = " + firstTerm.a + " x0 = " + firstTerm.x0 + " x1 = " + firstTerm.x1 + " b = " + firstTerm.b);
            System.out.println("drugi a = " + secondterm.a + " x0 = " + secondterm.x0 + " x1 = " + secondterm.x1 + " b = " + secondterm.b);
            System.out.println(firstY + " " + secondY + " dla x = " + i);
            
            double yPoint;
            if (firstY > secondY) {
                yPoint = firstY;
            } else {
                yPoint = secondY;
            }
            
            System.out.println("najwiekszy y = " + yPoint + "\n");
            
            points.add(new XYDataItem(i, yPoint));
                
            i = Math.round(i * 100.0) / 100.0;   
        }
        
        Term term = new Term(Power.VERY_HIGH);
        for (XYDataItem item : points) {
            term.add(item);
        }
        
        inferenceBlock.removeAllSeries();
        inferenceBlock.addSeries(term);
        
        inferenceBlockView = new FuzzySetView(inferenceBlock, 1);
        
    }
    
    public double defuzzify() {
        ArrayList<Double> yPoints = new ArrayList<>();
        
        double nominator = 0;
        double denominator = 0;
        
        for (Object series : inferenceBlock.getSeries()) {
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
        
        double outputCrispValue = nominator / denominator;
        outputCrispValue = Math.round(outputCrispValue * 100.0) / 100.0;
        inferenceBlockView.showSingleton(outputCrispValue);
        return outputCrispValue;
    }
}
