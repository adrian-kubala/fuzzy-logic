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

    public FuzzySet(String name) {
        super();

        this.name = name;
    }

    public XYDataset getDataSet() {
        return (XYDataset) this;
    }
}
