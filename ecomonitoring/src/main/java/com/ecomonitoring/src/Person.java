/**
 * Базовий клас для всіх дійових осіб системи
 */
public abstract class Person {
    protected String name;
    protected String role;

    public Person(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void printInfo() {
        System.out.println("Особа: " + name + ", Роль: " + role);
    }
}