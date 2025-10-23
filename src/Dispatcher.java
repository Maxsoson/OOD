/**
 * Клас Диспетчер ДСНС
 */
public class Dispatcher extends Person {
    private String contactInfo;

    public Dispatcher(String name, String contactInfo) {
        super(name, "Диспетчер ДСНС");
        this.contactInfo = contactInfo;
    }

    public void receiveAlert(Event event) {
        System.out.println("Диспетчер " + getName() + " отримав сповіщення про подію типу: " + event.getType());
        System.out.println("Значення: " + event.getMeasure().getValue());
    }
}