package com.ecomonitoring;

import com.google.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    private final Connection connection;

    @Inject
    public EventService(Connection connection) {
        this.connection = connection;
    }

    // збереження події (як було)
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

    // новий метод: читає всі події з бази
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        String sql = "SELECT type, measure_value, measure_limit FROM events";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("type");
                double value = rs.getDouble("measure_value");
                double limit = rs.getDouble("measure_limit");

                Measure measure = new Measure(value, limit);
                Event event = new Event(type, measure);
                events.add(event);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Не вдалося прочитати події з бази даних", e);
        }

        return events;
    }
}
