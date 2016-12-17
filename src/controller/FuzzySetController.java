/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modell.FuzzySet;
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

    public FuzzySetController() {
        setupBoilerTemperature();
        setupHeatingPower();
    }
    
    private void setupBoilerTemperature() {
        boilerTemperature = new FuzzySet("temperatura bojlera");
        boilerTemperature.range = new Range(7, 75);
        
        Term<Temperature> veryLow = new Term<>(Temperature.VERY_LOW);
        veryLow.setShape(7, 7, 11, 15);
        boilerTemperature.addSeries(veryLow);

        Term<Temperature> low = new Term<>(Temperature.LOW);
        low.setShape(10, 15, 15, 20);
        boilerTemperature.addSeries(low);

        Term<Temperature> medium = new Term<>(Temperature.MEDIUM);
        medium.setShape(18, 26, 26, 33);
        boilerTemperature.addSeries(medium);

        Term<Temperature> high = new Term<>(Temperature.HIGH);
        high.setShape(30, 45, 45, 60);
        boilerTemperature.addSeries(high);

        Term<Temperature> veryHigh = new Term<>(Temperature.VERY_HIGH);
        veryHigh.setShape(50, 62.5, 75, 75);
        boilerTemperature.addSeries(veryHigh);
        
        boilerTemperatureView = new FuzzySetView(boilerTemperature.name, boilerTemperature, boilerTemperature.range);
    }
    
    private void setupHeatingPower() {
        heatingPower = new FuzzySet("moc ogrzewania");
        heatingPower.range = new Range(0, 4);
        
        Term<Power> none = new Term<>(Power.NONE);
        none.setShape(0, 0, 0, 1);
        heatingPower.addSeries(none);

        Term<Power> low = new Term<>(Power.LOW);
        low.setShape(0, 1, 1, 2);
        heatingPower.addSeries(low);

        Term<Power> medium = new Term<>(Power.MEDIUM);
        medium.setShape(1, 2, 2, 3);
        heatingPower.addSeries(medium);

        Term<Power> high = new Term<>(Power.HIGH);
        high.setShape(2, 3, 3, 4);
        heatingPower.addSeries(high);
        
        heatingPowerView = new FuzzySetView(heatingPower.name, heatingPower, heatingPower.range);        
    }
}