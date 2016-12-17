package modell;

/**
 * Created by adrian on 13.12.2016.
 */
public enum Power {
    NONE("brak ogrzewania"),
    LOW("nieco ogrzewaj"),
    MEDIUM("ogrzewaj"),
    HIGH("bardzo ogrzewaj");
    
    private final String value;
    
    Power(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
