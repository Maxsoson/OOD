/**
 * Клас для представлення події в системі
 */
public class Event {
    private String type;
    private Measure measure;

    public Event(String type, Measure measure) {
        this.type = type;
        this.measure = measure;
    }

    public String getType() {
        return type;
    }

    public Measure getMeasure() {
        return measure;
    }
}