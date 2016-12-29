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
public class AggregationBlock extends FuzzySet {
    
    public AggregationBlock(InferenceBlock inferenceBlock) {
        super(inferenceBlock.name, inferenceBlock.getSeriesCount());
        
        range = inferenceBlock.range;
    }
    
}
