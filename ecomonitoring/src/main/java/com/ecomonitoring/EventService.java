package com.ecomonitoring;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventService {

    private final Connection connection;

    @Inject
    public EventService(Connection connection) {
        this.connection = connection;
    }

    public void saveEvent(Event event) {
        String sql = "INSERT INTO events(type, measure_value, measure_limit) VALUES(?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, event.getType());
            ps.setDouble(2, event.getMeasure().getValue());
            ps.setDouble(3, event.getMeasure().getLimit());
            ps.executeUpdate();
            System.out.println("Подія '" + event.getType() + "' збережена в базу даних.");
        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося зберегти подію", e);
        }
    }
}
