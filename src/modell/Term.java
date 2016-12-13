package modell;

import org.jfree.data.xy.XYSeries;

/**
 * Created by adrian on 04.12.2016.
 * @param <E>
 */
public class Term <E extends Enum<E>> extends XYSeries {

    private final Enum<E> type;

    public Term(String name, Enum<E> type) {
        super(name);

        this.type = type;

    }

    public void setShape(double a, double x0, double x1, double b) {
        add(a, 0);
        add(x0, 1);
        addOrUpdate(x1, 1);
        add(b, 0);
    }
}
