package com.ecomonitoring;

import com.google.inject.Inject;

import java.util.List;

// Контролер: між веб-виглядом і сервісом/БД
public class EventController {

    private final EventService eventService;

    @Inject
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // метод, який буде викликати веб-вигляд
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}
