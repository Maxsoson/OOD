package com.ecomonitoring;

public class Operator extends Person {

    public Operator(String name, String staffId) {
        super(name, "Оператор");
    }

    public void monitor() {
        System.out.println("Оператор " + getName() + " здійснює моніторинг системи...");
    }

    public void report() {
        System.out.println("Оператор " + getName() + " сформував звіт про стан екологічної системи.");
    }
}
