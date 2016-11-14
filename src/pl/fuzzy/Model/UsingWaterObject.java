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
public class UsingWaterObject {
    int usage;
    
    public UsingWaterObject(int usage) {
        setMaxUsage(usage);
    }
    
    public void setMaxUsage(int usage) {
        this.usage = usage;
    }
}
