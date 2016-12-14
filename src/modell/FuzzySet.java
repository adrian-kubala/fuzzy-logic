package modell;

import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by adrian on 13.12.2016.
 */
public class FuzzySet extends XYSeriesCollection {

    public String name;
    public Range range;
    double membershipValues[];

    public FuzzySet(String name) {
        super();

        this.name = name;
    }

    public XYDataset getDataSet() {
        return (XYDataset) this;
    }
    
    public void fuzzify(double x) {
        Term<Temperature>[] tempTerms = (Term<Temperature>[]) getSeries().toArray();
        
        membershipValues = new double[tempTerms.length];
        for (int i = 0; i < tempTerms.length; i++) {
            
            double a = tempTerms[i].a;
            double x0 = tempTerms[i].x0;
            double x1 = tempTerms[i].x1;
            double b = tempTerms[i].b;

            if (x >= a && x <= x0) {
                membershipValues[i] = (x - a) / (x0 - a);
            } else if (x >= x0 && x <= x1) {
                membershipValues[i] = 1;
            } else if (x >= x1 && x <= b) {
                membershipValues[i] = (b - x) / (b - x1);
            } else {
                membershipValues[i] = 0;
            }
        }
    }
}
