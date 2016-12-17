package modell;

/**
 * Created by adrian on 13.12.2016.
 */
public enum Temperature {
    VERY_LOW("bardzo niska"),
    LOW("niska"),
    MEDIUM("średnia"),
    HIGH("wysoka"),
    VERY_HIGH("bardzo wysoka");
    
    private final String value;

    Temperature(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
