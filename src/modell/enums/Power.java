package modell.enums;

/**
 * Created by adrian on 13.12.2016.
 */
public enum Power {
    NONE("brak ogrzewania"),
    LOW("niska"),
    MEDIUM("średnia"),
    HIGH("wysoka"),
    VERY_HIGH("bardzo wysoka"),
    OUTPUT("zbiór wynikowy");
    
    private final String value;
    
    Power(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
