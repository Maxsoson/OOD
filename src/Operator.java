/**
 * Клас Оператор станції
 */
public class Operator extends Person {
    private String stationId;

    public Operator(String name, String stationId) {
        super(name, "Оператор станції");
        this.stationId = stationId;
    }

    public void monitor() {
        System.out.println("Оператор " + getName() + " проводить моніторинг станції " + stationId);
    }

    public void report() {
        System.out.println("Оператор " + getName() + " формує звіт по станції " + stationId);
    }
}