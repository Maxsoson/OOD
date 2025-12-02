package com.ecomonitoring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

// ОТУТ головне — правильний пакет:
import com.ecomonitoring.webserver.JavalinWebServer;
import com.ecomonitoring.webserver.WebServer;

public class EcomonitoringModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class)
            .annotatedWith(Names.named("JDBC_URL"))
            .toInstance("jdbc:sqlite:target/ecomonitoring.db");
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC_URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    @Provides
    @Singleton
    WebServer provideWebServer() {
        return new JavalinWebServer();
    }

    private void createTableIfNotExists(Connection connection) {
        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS events (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "type TEXT NOT NULL, " +
                "measure_value REAL NOT NULL, " +
                "measure_limit REAL NOT NULL" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}
