package modell;

import org.jfree.data.Range;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by adrian on 13.12.2016.
 */
public class FuzzySet extends XYSeriesCollection {

    public String name;
    public Range range;
    public MembershipValue[] membershipValues;

    public FuzzySet(String name, int termsCount) {
        super();

        this.name = name;
        membershipValues = new MembershipValue[termsCount];
    }
    
    public void fuzzify(double x) {
        membershipValues = new MembershipValue[getSeriesCount()];
        for (int i = 0; i < getSeriesCount(); i++) {
            Term term = getTermAt(i);
            membershipValues[i] = new MembershipValue();
            
            membershipValues[i].membership = term.type;
            membershipValues[i].value = term.getMembershipValue(x);
        }
    }
    
    public Term getTermAt(int i) {
        return (Term) getSeries(i);
    }
}
