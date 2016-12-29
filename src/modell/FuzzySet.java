package modell;

import org.jfree.data.Range;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by adrian on 13.12.2016.
 */
public class FuzzySet extends XYSeriesCollection {

    private final String name;
    public Range range;
    private MembershipValue[] membershipValues;

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
                MembershipValue membershipValue = new MembershipValue(value, term.getType(), x);

                membershipValues[i] = membershipValue;
            }
        }
    }
    
    public Term getTermAt(int i) {
        return (Term) getSeries(i);
    }
    
    public Term copyTermOfType(Enum type) {
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
            
            if (membershipValue.getTermName().equals(type.name())) {
                value = membershipValue.getValue();
            }
        }
        return value;
    }
    
    public void addTerm(Term term) {
        addSeries(term);
    }
    
    public void removeAllTerms() {
        removeAllSeries();
    }
    
    public String getName() {
        return name;
    }
    
    public int getMembershipValuesLastIndex() {
        return membershipValues.length - 1;
    }
    
    public MembershipValue getMembershipValueAt(int i) {
        return membershipValues[i];
    }
    
    public int getMembershipValuesLength() {
        return membershipValues.length;
    }
}
