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
