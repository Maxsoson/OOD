``
classDiagram
    class Person {
        -name: String
        -role: String
        +get_name(): String
        +get_role(): String
        +print_info(): void
    }

    class ServicePlanner {
        <<interface>>
        +plan_service(): void
        +check_status(): boolean
    }

    class Operator {
        -station_id: String
        +monitor(): void
        +report(): void
    }

    class Dispatcher {
        -contact_info: String
        +receive_alert(event: Event): void
    }

    class Ecologist {
        -zone: String
        +check_excess(measure: Measure): boolean
        +plan_service(): void
        +check_status(): boolean
    }

    class Measure {
        -_value: float
        +get_value(): float
    }

    class Event {
        -_type: String
        -_measure: Measure
        +get_type(): String
        +get_measure(): Measure
    }

    Person <|-- Operator
    Person <|-- Dispatcher
    Person <|-- Ecologist
    ServicePlanner <|.. Ecologist
    Event --> Measure

```
