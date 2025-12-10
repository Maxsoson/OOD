```
stateDiagram-v2
    [*] --> ApplicationStart

    ApplicationStart --> Initialization: main() запущено

    Initialization --> Monitoring: Operator/Ecologist/Dispatcher\nсоздані

    Monitoring : operator.monitor()

    Monitoring --> MeasureCreation: вимірювання отримане

    MeasureCreation : measure = Measure(150.0)

    MeasureCreation --> ExcessCheck: перевірка перевищення

    ExcessCheck : ecologist.check_excess(measure)

    ExcessCheck --> ExceededState: measure.get_value() > 100\nповертає true

    ExcessCheck --> NormalState: measure.get_value() <= 100\nповертає false

    ExceededState --> EventCreation: виявлено перевищення

    EventCreation : event = Event("Перевищення ГДК", measure)

    EventCreation --> AlertDispatching: повідомлення диспетчеру

    AlertDispatching : dispatcher.receive_alert(event)

    AlertDispatching --> ServicePlanning

    NormalState --> ServicePlanning

    ServicePlanning : ecologist.plan_service()

    ServicePlanning --> Reporting

    Reporting : operator.report()

    Reporting --> ApplicationEnd

    ApplicationEnd : завершення main()

    ApplicationEnd --> [*]
```
