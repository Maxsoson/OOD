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
