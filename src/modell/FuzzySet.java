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
            
            double value = term.getMembershipValue(x);
            if (value > 0) {
                MembershipValue membershipValue = new MembershipValue();
                membershipValue.termType = term.type;
                membershipValue.value = term.getMembershipValue(x);
                membershipValue.forCrispValue = x;

                membershipValues[i] = membershipValue;
            }
        }
    }
    
    public Term getTermAt(int i) {
        return (Term) getSeries(i);
    }
    
    public Term getCopiedTermOfType(Enum type) {
        Term copy = null;
        for (int i = 0; i < getSeriesCount(); i++) {
            Term term = getTermAt(i);
            if (term.getTypeName().equals(type.name())) {
                try {
                    copy = (Term) term.createCopy(0, term.getItemCount() - 1);
                } catch (CloneNotSupportedException ex) { }
            }
        }
        return copy;
    }
    
    public double getMembershipValueOfType(Enum type) {
        double value = 0;
        for (MembershipValue membershipValue : membershipValues) {
            if (membershipValue == null) {
                continue;
            }
            
            if (membershipValue.termType.name().equals(type.name())) {
                value = membershipValue.value;
            }
        }
        return value;
    } 
}
