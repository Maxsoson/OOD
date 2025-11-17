package com.ecomonitoring;

public class Dispatcher extends Person {

    private String email;

    public Dispatcher(String name, String email) {
        super(name, "Диспетчер ДСНС");
        this.email = email;
    }

    public void receiveAlert(Event event) {
        System.out.println("Диспетчер " + getName() +
            " отримав сповіщення про подію: " + event.getType() +
            ". Контакт: " + email);
    }
}
