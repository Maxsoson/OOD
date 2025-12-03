# Інтерфейс для планування обслуговування
class ServicePlanner:
    def plan_service(self):
        """Метод має бути реалізований у підкласі."""
        raise NotImplementedError("Метод plan_service() треба реалізувати в підкласі")

    def check_status(self) -> bool:
        """Метод має бути реалізований у підкласі."""
        raise NotImplementedError("Метод check_status() треба реалізувати в підкласі")
