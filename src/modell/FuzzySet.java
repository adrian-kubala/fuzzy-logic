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
    public double membershipValues[];

    public FuzzySet(String name) {
        super();

        this.name = name;
    }

    public XYDataset getDataSet() {
        return (XYDataset) this;
    }
    
    public void fuzzify(double x) {
        membershipValues = new double[getSeriesCount()];
        for (int i = 0; i < getSeriesCount(); i++) {
            Term<?> term = (Term<?>) getSeries(i);
            if (x >= term.a && x <= term.x0) {
                membershipValues[i] = (x - term.a) / (term.x0 - term.a);
            } else if (x >= term.x0 && x <= term.x1) {
                membershipValues[i] = 1;
            } else if (x >= term.x1 && x <= term.b) {
                membershipValues[i] = (term.b - x) / (term.b - term.x1);
            } else {
                membershipValues[i] = 0;
            }
        }
    }
}
