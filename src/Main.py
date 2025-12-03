# Система екологічного моніторингу на Python

# Базовий клас для всіх дійових осіб системи
class Person:
    def __init__(self, name: str, role: str):
        self.name = name
        self.role = role

    def get_name(self) -> str:
        return self.name

    def get_role(self) -> str:
        return self.role

    def print_info(self):
        print(f"Особа: {self.name}, Роль: {self.role}")


# "Інтерфейс" для планування обслуговування
class ServicePlanner:
    def plan_service(self):
        """Метод має бути реалізований у підкласі."""
        raise NotImplementedError("Метод plan_service() треба реалізувати в підкласі")

    def check_status(self) -> bool:
        """Метод має бути реалізований у підкласі."""
        raise NotImplementedError("Метод check_status() треба реалізувати в підкласі")


# Клас Оператор станції
class Operator(Person):
    def __init__(self, name: str, station_id: str):
        super().__init__(name, "Оператор станції")
        self.station_id = station_id

    def monitor(self):
        print(f"Оператор {self.get_name()} проводить моніторинг станції {self.station_id}")

    def report(self):
        print(f"Оператор {self.get_name()} формує звіт по станції {self.station_id}")


# Клас Диспетчер ДСНС
class Dispatcher(Person):
    def __init__(self, name: str, contact_info: str):
        super().__init__(name, "Диспетчер ДСНС")
        self.contact_info = contact_info

    def receive_alert(self, event):
        print(
            "Диспетчер "
            + self.get_name()
            + " отримав сповіщення про подію типу: "
            + event.get_type()
        )
        print("Значення: " + str(event.get_measure().get_value()))


# Клас Еколог
class Ecologist(Person, ServicePlanner):
    def __init__(self, name: str, zone: str):
        super().__init__(name, "Еколог")
        self.zone = zone

    def check_excess(self, measure):
        print(f"Еколог {self.get_name()} перевіряє перевищення норм...")
        # імітація перевірки
        return measure.get_value() > 100

    def plan_service(self):
        print(f"Еколог {self.get_name()} планує сервісне обслуговування...")

    def check_status(self) -> bool:
        print(f"Еколог {self.get_name()} перевіряє статус...")
        return True


# Клас для представлення вимірювання
class Measure:
    def __init__(self, value: float):
        self._value = float(value)

    def get_value(self) -> float:
        return self._value


# Клас для представлення події в системі
class Event:
    def __init__(self, type_: str, measure):
        self._type = type_
        self._measure = measure

    def get_type(self) -> str:
        return self._type

    def get_measure(self):
        return self._measure


# Головний модуль для демонстрації роботи системи

def main():
    # Створення учасників системи
    operator = Operator("Іван Петренко", "ST001")
    ecologist = Ecologist("Марія Коваленко", "Зона A")
    dispatcher = Dispatcher("Петро Сидоренко", "emergency@dsns.gov.ua")

    # Імітація роботи системи
    print("=== Початок моніторингу ===")

    operator.monitor()

    # Імітація отримання даних з датчика
    measure = Measure(150.0)

    # Перевірка перевищення норм екологом
    if ecologist.check_excess(measure):
        print("Виявлено перевищення норм!")
        event = Event("Перевищення ГДК", measure)
        dispatcher.receive_alert(event)

    # Планування сервісу
    ecologist.plan_service()
    operator.report()

    print("=== Кінець моніторингу ===")


if __name__ == "__main__":
    main()
