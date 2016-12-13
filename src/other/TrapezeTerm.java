package other;

/**
 * Created by adrian on 04.12.2016.
 */
public class TrapezeTerm extends TriangularTerm {
    double x1;

    public TrapezeTerm(String name, double a, double x0, double x1, double b) {
        super(name, a, x0, b);

        this.x1 = x1;
    }
}
