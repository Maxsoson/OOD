package com.ecomonitoring;

import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.List;

// Вигляд: налаштовує маршрути Javalin і віддає HTML + JSON
public class EcomonitoringWebView {

    private final EventController controller;

    @Inject
    public EcomonitoringWebView(EventController controller) {
        this.controller = controller;
    }

    public void start(int port) {

        // статичні файли з classpath:/public -> /index.html, /script.js, /style.css
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        });

        // редірект з кореня на index.html
        app.get("/", ctx -> ctx.redirect("/index.html"));

        // API, яке віддає всі події в JSON
        app.get("/api/events", ctx -> {
            List<Event> events = controller.getAllEvents();
            ctx.json(events);
        });

        app.start(port);
        System.out.println("Веб-інтерфейс запущено на http://localhost:" + port + "/");
    }
}
