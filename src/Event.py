# Клас для представлення події в системі
class Event:
    def __init__(self, type_: str, measure):
        self._type = type_
        self._measure = measure

    def get_type(self) -> str:
        return self._type

    def get_measure(self):
        return self._measure
