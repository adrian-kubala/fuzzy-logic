package pl.fuzzy;

import org.jfree.data.xy.XYSeries;
import java.lang.reflect.Field;

/**
 * Created by adrian on 04.12.2016.
 */
public class TriangularTerm extends XYSeries {
    double a;
    double x0;
    double b;

    public TriangularTerm(String name, double a, double x0, double b) {
        super(name);

        this.a = a;
        this.x0 = x0;
        this.b = b;
    }

    public void createShape() {
        add(a, 0);
        add(x0, 1);
        try {
            Field x1Field = getClass().getDeclaredField("x1");
            x1Field.setAccessible(true);
            double x1 = (double) x1Field.get(this);
            add(x1, 1);
        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        }
        add(b, 0);
    }
}


