package com.ecomonitoring;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventRepository {

    private final Connection connection;

    @Inject
    public EventRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Event event) {
        String sql = "INSERT INTO events(type, measure_value, measure_limit) VALUES(?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, event.getType());
            ps.setDouble(2, event.getMeasure().getValue());
            ps.setDouble(3, event.getMeasure().getLimit());
            ps.executeUpdate();
            System.out.println("Подію з типом '" + event.getType()
                    + "' збережено в базу даних (value="
                    + event.getMeasure().getValue()
                    + ", limit=" + event.getMeasure().getLimit() + ").");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save event", e);
        }
    }
}
