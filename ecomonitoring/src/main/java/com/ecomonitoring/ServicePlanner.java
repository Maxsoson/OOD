package com.ecomonitoring;

import com.google.inject.Inject;
import java.util.List;

/**
 * Клас-модель, який планує сервіс та працює зі списком подій.
 * Аналог класу Payroll з прикладу: тут є метод getAllEvents(),
 * який використовує EventService для читання з бази.
 */
public class ServicePlanner {

    private final EventService eventService;

    @Inject
    public ServicePlanner(EventService eventService) {
        this.eventService = eventService;
    }

    // те, що вже було в інтерфейсі
    public void planService() {
        System.out.println("Планування сервісу екологічного моніторингу...");
        // тут можеш додати свою логіку планування
    }

    public void checkStatus() {
        System.out.println("Перевірка статусу сервісу...");
        // тут можеш додати власну логіку перевірки
    }

    // НОВИЙ метод класу-моделі (аналог Payroll.getAllPaychecks())
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}
