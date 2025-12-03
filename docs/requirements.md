# Звіт за UML-діаграмами для системи екологічного моніторингу

Архітектор проаналізував Java- та Python-код імітаційного прототипу системи екологічного моніторингу:

- Person
- ServicePlanner
- Operator
- Ecologist
- Dispatcher
- Measure
- Event
- Main / main.py

На основі цього коду згенеровано набір UML-діаграм.

## Діаграма варіантів використання (PlantUML)

Нижче наведено код діаграми варіантів використання у форматі PlantUML. Замість класу Main/Application використано актора Application.

```plantuml
@startuml
' Актори
actor Application
actor "Operator" as OperatorActor
actor "Ecologist" as EcologistActor
actor "Dispatcher" as DispatcherActor

' Варіанти використання
usecase "Моніторинг станції" as UC_Monitor
usecase "Перевірка\nперевищення норм" as UC_Check
usecase "Отримання сповіщення\nпро перевищення" as UC_Alert
usecase "Планування сервісного\nобслуговування" as UC_Service
usecase "Формування звіту" as UC_Report

' Зв’язки Application з варіантами використання
Application --> UC_Monitor
Application --> UC_Check
Application --> UC_Alert
Application --> UC_Service
Application --> UC_Report

' Зв’язки доменних акторів з варіантами використання
OperatorActor --> UC_Monitor
OperatorActor --> UC_Report

EcologistActor --> UC_Check
EcologistActor --> UC_Service

DispatcherActor --> UC_Alert
@enduml
