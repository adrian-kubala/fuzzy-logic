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
    public MembershipValue[] membershipValues;

    public FuzzySet(String name) {
        super();

        this.name = name;
    }

    public XYDataset getDataSet() {
        return (XYDataset) this;
    }
    
    public void fuzzify(double x) {
        membershipValues = new MembershipValue[getSeriesCount()];
        for (int i = 0; i < getSeriesCount(); i++) {
            Term<Temperature> term = (Term<Temperature>) getSeries(i);
            membershipValues[i] = new MembershipValue();
            membershipValues[i].membership = (Temperature) term.type;
            
            double value;
            if (x >= term.a && x <= term.x0) {
                value = (x - term.a) / (term.x0 - term.a);
            } else if (x >= term.x0 && x <= term.x1) {
                value = 1;
            } else if (x >= term.x1 && x <= term.b) {
                value = (term.b - x) / (term.b - term.x1);
            } else {
                value = 0;
            }
            value = Math.round(value * 1000.0) / 1000.0;
            membershipValues[i].value = value;
        }
    }
}
