/**
 * Клас Еколог
 */
public class Ecologist extends Person implements ServicePlanner {
    private String zone;

    public Ecologist(String name, String zone) {
        super(name, "Еколог");
        this.zone = zone;
    }

    public boolean checkExcess(Measure measure) {
        System.out.println("Еколог " + getName() + " перевіряє перевищення норм...");
        return measure.getValue() > 100; // імітація перевірки
    }

    @Override
    public void planService() {
        System.out.println("Еколог " + getName() + " планує сервісне обслуговування...");
    }

    @Override
    public boolean checkStatus() {
        System.out.println("Еколог " + getName() + " перевіряє статус...");
        return true;
    }
}