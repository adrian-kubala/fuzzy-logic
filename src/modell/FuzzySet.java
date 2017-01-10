package modell;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Created by adrian on 13.12.2016.
 */
public class FuzzySet extends XYSeriesCollection {

    private final String NAME;
    private final String VARIABLE_NAME;

    /**
     *
     */
    public Range range;
    private MembershipValue[] membershipValues;

    /**
     *
     * @param name
     * @param variableName
     * @param termsCount
     */
    public FuzzySet(String name, String variableName, int termsCount) {
        super();
        
        NAME = name;
        VARIABLE_NAME = variableName;
        membershipValues = new MembershipValue[termsCount];
    }
    
    /**
     *
     * @param x
     */
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
    
    /**
     *
     * @param i
     * @return
     */
    public Term getTermAt(int i) {
        return (Term) getSeries(i);
    }
    
    /**
     *
     * @param type
     * @return
     */
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
    
    /**
     *
     * @param i
     * @return
     */
    public Term copyTermAt(int i) {
        Term term = getTermAt(i);
        Term copy = null;
        try {
            copy = (Term) term.createCopy(0, term.getItemCount() - 1);
        } catch (CloneNotSupportedException ex) { }
        return copy;
    }
    
    /**
     *
     * @param type
     * @return
     */
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
    
    /**
     *
     * @param term
     */
    public void addTerm(Term term) {
        addSeries(term);
    }
    
    /**
     *
     */
    public void removeAllTerms() {
        removeAllSeries();
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return NAME;
    }
    
    /**
     *
     * @return
     */
    public String getVariableName() {
        return VARIABLE_NAME;
    }
    
    /**
     *
     * @return
     */
    public int getMembershipValuesLastIndex() {
        return membershipValues.length - 1;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public MembershipValue getMembershipValueAt(int i) {
        return membershipValues[i];
    }
    
    /**
     *
     * @return
     */
    public int getMembershipValuesLength() {
        return membershipValues.length;
    }
}
