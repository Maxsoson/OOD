package com.ecomonitoring;

import com.google.inject.Inject;

public class Dispatcher extends Person {

    private String contactEmail;
    private EventService eventService;

    // Додаємо конструктор з анотацією @Inject
    @Inject
    public Dispatcher(String name, String contactEmail, EventService eventService) {
        super(name, contactEmail);  // Викликаємо конструктор батьківського класу
        this.contactEmail = contactEmail;
        this.eventService = eventService;
    }

    // Setter для впровадження залежності через Guice (не обов'язковий, якщо є конструктор)
    @Inject
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void receiveAlert(Event event) {
        System.out.println("Диспетчер " + getName()
                + " отримав сповіщення на " + contactEmail
                + ": тип події - " + event.getType()
                + ", значення = " + event.getMeasure().getValue()
                + ", ліміт = " + event.getMeasure().getLimit());

        // Збереження події через EventService
        eventService.saveEvent(event);
    }
}
