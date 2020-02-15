from __future__ import annotations
from abc import ABC, abstractmethod


class AbstractFactory(ABC):
    """
    Интерфейс Абстрактной Фабрики объявляет набор методов, которые возвращают
    различные абстрактные продукты. Эти продукты называются семейством и
    связаны темой или концепцией высокого уровня. Продукты одного семейства
    обычно могут взаимодействовать между собой. Семейство продуктов может
    иметь несколько вариаций, но продукты одной вариации несовместимы с
    продуктами другой.
    """
    @abstractmethod
    def create_driver(self):
        pass

    @abstractmethod
    def create_transport(self):
        pass


class TaxiFactory(AbstractFactory):
    """
    Фабрика Такси

    Имеет 2 метода: создание водителя такси и создание такси
    """

    def create_driver(self) -> TaxiDriver:
        "Создается водитель такси"
        return TaxiDriver()

    def create_transport(self) -> Taxi:
        "Создается такси"
        return Taxi()


class BusFactory(AbstractFactory):
    """
    Фабрика Автобусов

    Имеет 2 метода: создание водителя автобуса и создание автобуса
    """

    def create_driver(self) -> BusDriver:
        "Создается водитель автобуса"
        return BusDriver()

    def create_transport(self) -> Bus:
        "Создается автобус"
        return Bus()


class AbstractDriver(ABC):
    """
    Каждый отдельный продукт семейства продуктов должен иметь
    базовый интерфейс. Все вариации продукта должны реализовывать
    этот интерфейс.
    """

    drivers_license = None


class TaxiDriver(AbstractDriver):
    AbstractDriver.drivers_license = "B"


class BusDriver(AbstractDriver):
    AbstractDriver.drivers_license = "D"


class AbstractTransport(ABC):
    """
    Абстрактный транспорт (класс)
    """

    _capacity = None
    _drivers_license = None
    _driver = None

    def put_the_passenger(self, passenger: Passenger) -> None:
        """
        Посадить посажира в транспорт
        """
        print("Taxi: выполняется посадка посажира")
        if self._capacity > 0:
            print("Taxi: Вместимость уменьшилась на 1")
            self._capacity -= 1
            print("Осталось мест: ", self._capacity)
        else:
            print("Все места заняты")

    def put_the_driver(self, driver: TaxiDriver) -> None:
        """
        Посадить водителя в транспорт
        """
        print("выполняется посадка водителя")
        if self._driver is False:
            self._driver = True
            print("Водитель посажен")
        else:
            print("Место водителя занято")


class Bus(AbstractTransport):
    _capacity = 30
    _drivers_license = "D"
    _driver = False

    def put_the_driver(self, driver):
        if driver == BusDriver:
            return super().put_the_driver(driver)

    def put_the_passenger(self, passenger):
        return super().put_the_passenger(passenger)


class Taxi(AbstractTransport):
    _capacity = 4
    _drivers_license = "B"
    _driver = False

    def put_the_driver(self, driver):
        if driver == TaxiDriver:
            return super().put_the_driver(driver)

    def put_the_passenger(self, passenger):
        return super().put_the_passenger(passenger)


class Passenger():
    pass


def client_code(factory: AbstractFactory) -> None:
    """
    Клиентский код работает с фабриками и продуктами только через абстрактные
    типы: Абстрактная Фабрика и Абстрактный Продукт. Это позволяет передавать
    любой подкласс фабрики или продукта клиентскому коду, не нарушая его.
    """
    passenger1 = Passenger()
    passenger2 = Passenger()
    passenger3 = Passenger()
    passenger4 = Passenger()
    passenger5 = Passenger()

    transport = factory.create_transport()
    transport.put_the_passenger(passenger1)
    transport.put_the_passenger(passenger2)
    transport.put_the_passenger(passenger3)
    transport.put_the_passenger(passenger4)
    transport.put_the_passenger(passenger5)

    driver = factory.create_driver()
    transport.put_the_driver(driver)


if __name__ == "__main__":
    """
    Клиентский код может работать с любым конкретным классом фабрики.
    """

    print("Автобус", end='\n\n')
    client_code(BusFactory())

    print("\nТеперь такси", end='\n\n')
    client_code(TaxiFactory())
