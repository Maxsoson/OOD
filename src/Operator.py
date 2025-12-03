# Клас Оператор станції
class Operator(Person):
    def __init__(self, name: str, station_id: str):
        super().__init__(name, "Оператор станції")
        self.station_id = station_id

    def monitor(self):
        print(f"Оператор {self.get_name()} проводить моніторинг станції {self.station_id}")

    def report(self):
        print(f"Оператор {self.get_name()} формує звіт по станції {self.station_id}")
