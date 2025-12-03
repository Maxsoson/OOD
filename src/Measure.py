# Клас для представлення вимірювання
class Measure:
    def __init__(self, value: float):
        self._value = float(value)

    def get_value(self) -> float:
        return self._value
