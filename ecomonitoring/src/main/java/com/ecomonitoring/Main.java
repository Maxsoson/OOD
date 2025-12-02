package com.ecomonitoring;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        // Створення Injector для впровадження залежностей
        Injector injector = Guice.createInjector(new EcomonitoringModule());

        // 1) Консольний (імітаційний) режим
        runConsoleMode(injector);

        // 2) Веб-режим перегляду подій
        runWebMode(injector);
    }

    // Те, що в тебе було раніше в main – переносимо сюди
    private static void runConsoleMode(Injector injector) {
        // Створення учасників системи
        Operator operator = new Operator("Іван Петренко", "ST001");
        Ecologist ecologist = new Ecologist("Марія Коваленко", "Зона A");

        // Dispatcher через Guice (в нього інʼєктиться EventService)
        Dispatcher dispatcher = injector.getInstance(Dispatcher.class);

        System.out.println("=== Початок моніторингу ===");

        // Імітація моніторингу
        operator.monitor();

        // Імітація отримання даних з датчика
        Measure measure = new Measure(150.0);

        // Перевірка перевищення норм екологом
        if (ecologist.checkExcess(measure)) {
            System.out.println("Виявлено перевищення норм!");
            Event event = new Event("Перевищення ГДК", measure);
            dispatcher.receiveAlert(event); // збереження події в БД
        }

        // Планування сервісу
        ecologist.planService();
        operator.report();

        System.out.println("=== Кінець моніторингу (консольний режим) ===");
    }

    // Те, що вимагає п. 2.6 – запуск веб-вигляду
    private static void runWebMode(Injector injector) {
        EcomonitoringWebView webView = injector.getInstance(EcomonitoringWebView.class);
        webView.start(1488);
    }
}
