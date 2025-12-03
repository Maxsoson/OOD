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
