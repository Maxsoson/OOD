package com.ecomonitoring;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        // Створення Injector для впровадження залежностей
        Injector injector = Guice.createInjector(new EcomonitoringModule());

        // Отримуємо EventService через Guice
        EventService eventService = injector.getInstance(EventService.class);

        // Створення учасників системи через Guice
        Operator operator = new Operator("Іван Петренко", "ST001");
        Ecologist ecologist = new Ecologist("Марія Коваленко", "Зона A");

        // Створення Dispatcher через Guice
        Dispatcher dispatcher = injector.getInstance(Dispatcher.class);  // Використовуємо Guice для створення Dispatcher

        System.out.println("=== Початок моніторингу ===");

        // Імітація моніторингу
        operator.monitor();

        // Імітація отримання даних з датчика
        Measure measure = new Measure(150.0);

        // Перевірка перевищення норм екологом
        if (ecologist.checkExcess(measure)) {
            System.out.println("Виявлено перевищення норм!");
            Event event = new Event("Перевищення ГДК", measure);
            dispatcher.receiveAlert(event); // Викликаємо метод, який зберігає подію
        }

        // Планування сервісу
        ecologist.planService();
        operator.report();

        System.out.println("=== Кінець моніторингу ===");
    }
}
