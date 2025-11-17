package com.ecomonitoring;

public class Ecologist extends Person implements ServicePlanner {

    private String zone;

    public Ecologist(String name, String zone) {
        super(name, "Еколог");
        this.zone = zone;
    }

    public boolean checkExcess(Measure measure) {
        System.out.println("Еколог " + getName() +
            " аналізує показники у зоні " + zone + "...");

        return measure.getValue() > measure.getLimit();
    }

    @Override
    public void planService() {
        System.out.println("Еколог " + getName() +
            " планує сервісне обслуговування у зоні " + zone + "...");
    }

    @Override
    public void checkStatus() {
        System.out.println("Еколог " + getName() +
            " перевіряє статус екологічної системи...");
    }
}
