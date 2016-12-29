/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modell;

/**
 *
 * @author adrian
 */
public class InferenceBlock extends FuzzySet {
    
    public InferenceBlock(FuzzySet outputSet) {
        super(outputSet.name, outputSet.getSeriesCount());
        
        range = outputSet.range;
    }
    
}
