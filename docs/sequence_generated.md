```
sequenceDiagram
    actor Application
    participant Operator
    participant Ecologist
    participant Dispatcher
    participant Measure
    participant Event

    Application->>Operator: create Operator("Іван Петренко", "ST001")
    Application->>Ecologist: create Ecologist("Марія Коваленко", "Зона A")
    Application->>Dispatcher: create Dispatcher("Петро Сидоренко", "emergency@dsns.gov.ua")

    Note over Application: === Початок моніторингу ===

    Application->>Operator: monitor()
    Operator->>Application: print моніторинг станції

    Application->>Measure: create Measure(150.0)
    Application->>Ecologist: check_excess(measure)
    Ecologist->>Measure: get_value()
    Measure-->>Ecologist: 150.0
    Ecologist->>Ecologist: compare 150.0 > 100
    Ecologist-->>Application: true

    alt Перевищення норм = true
        Note over Application: Виявлено перевищення норм!
        Application->>Event: create Event("Перевищення ГДК", measure)
        Application->>Dispatcher: receive_alert(event)
        Dispatcher->>Event: get_type()
        Event-->>Dispatcher: "Перевищення ГДК"
        Dispatcher->>Event: get_measure()
        Event-->>Dispatcher: measure
        Dispatcher->>Measure: get_value()
        Measure-->>Dispatcher: 150.0
        Dispatcher->>Dispatcher: print сповіщення
        Dispatcher-->>Application: повернення
    end

    Application->>Ecologist: plan_service()
    Ecologist->>Ecologist: print планування сервісу
    Ecologist-->>Application: повернення

    Application->>Operator: report()
    Operator->>Operator: print формування звіту
    Operator-->>Application: повернення

    Note over Application: === Кінець моніторингу ===
```
