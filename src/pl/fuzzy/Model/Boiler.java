/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.fuzzy.Model;

/**
 *
 * @author adrian
 */
public class Boiler {
    public int temperature;
    private final double waterCapacity;
    private int power;
    
    public Boiler(double capacity) {
        waterCapacity = capacity;
    }
    
    public void setHeatingLevel(int power) {
        this.power = power;
    }
}
