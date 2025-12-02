package com.ecomonitoring;

public class Ecologist {

    private String name;
    private String zone;

    public Ecologist(String name, String zone) {
        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public String getZone() {
        return zone;
    }

    // Перевірка перевищення норм
    public boolean checkExcess(Measure measure) {
        System.out.println("Еколог " + name + " перевіряє показник...");
        return measure.getValue() > measure.getLimit();
    }

    // Планування сервісу (імітація)
    public void planService() {
        System.out.println("Еколог " + name + " планує сервіс у зоні " + zone);
    }

    // Додатковий метод (імітація)
    public void report() {
        System.out.println("Еколог " + name + " формує звіт...");
    }
}
