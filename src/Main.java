/**
 * Головний клас для демонстрації роботи системи
 */
public class Main {
    public static void main(String[] args) {
        // Створення учасників системи
        Operator operator = new Operator("Іван Петренко", "ST001");
        Ecologist ecologist = new Ecologist("Марія Коваленко", "Зона A");
        Dispatcher dispatcher = new Dispatcher("Петро Сидоренко", "emergency@dsns.gov.ua");

        // Імітація роботи системи
        System.out.println("=== Початок моніторингу ===");
        
        operator.monitor();
        
        // Імітація отримання даних з датчика
        Measure measure = new Measure(150.0f);
        
        // Перевірка перевищення норм екологом
        if (ecologist.checkExcess(measure)) {
            System.out.println("Виявлено перевищення норм!");
            Event event = new Event("Перевищення ГДК", measure);
            dispatcher.receiveAlert(event);
        }
        
        // Планування сервісу
        ecologist.planService();
        operator.report();
        
        System.out.println("=== Кінець моніторингу ===");
    }
}