package modell;

import org.jfree.data.xy.XYSeries;

/**
 * Created by adrian on 04.12.2016.
 */
public class Term extends XYSeries {

    final Enum type;
    public double a, x0, x1, b;
    public double height = 1;
    public double newX0, newX1;
    

    public Term(Enum type) {
        super(type.toString());

        this.type = type;
    }

    public void setShape(double a, double x0, double x1, double b) {
        this.a = a;
        this.x0 = x0;
        this.x1 = x1;
        this.b = b;
        
        add(a, 0);
        add(x0, 1);
        addOrUpdate(x1, 1);
        add(b, 0);
    }
    
    public double getMembershipValue(double x) {
        double value;
        if (x >= a && x <= x0) {
            value = (x - a) / (x0 - a);
        } else if (x >= x0 && x <= x1) {
            value = height;
        } else if (x >= x1 && x <= b) {
            value = (b - x) / (b - x1);
        } else {
            value = 0;
        }
        value = Math.round(value * 1000.0) / 1000.0;
        return value;
    }
    
    public double getMembershipValueAfterMin(double x) {
        double value;
        if (x >= a && x <= newX0) {
            value = (x - a) / (x0 - a);
        } else if (x >= newX0 && x <= newX1) {
            value = height;
        } else if (x >= newX1 && x <= b) {
            value = (b - x) / (b - x1);
        } else {
            value = 0;
        }
        value = Math.round(value * 1000.0) / 1000.0;
        return value;
    }
    
    public void setMinimum(double y) {
        newX0 = getNewX0(y);
        newX1 = getNewX1(y);
        
        clear();
        
        add(a, 0);
        add(newX0, y);
        addOrUpdate(newX1, y);
        add(b, 0);
        
        height = y;
    }
    
    private double getNewX0(double y) {
        return y * (x0 - a) + a;
    }
    
    private double getNewX1(double y) {
        return y * (x0 - b) + b;
    }
    
    public String getTypeName() {
        return type.name();
    }
    
    public String getTitle() {
        return type.toString();
    }
}
