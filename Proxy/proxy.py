from tkinter import Tk, Canvas, BOTH, RIGHT

from PIL import Image
from abc import ABC, abstractmethod


class Subject(ABC):
    """
    Интерфейс Субъекта объявляет общие операции как для Реального Субъекта, так
    и для Заместителя. Пока клиент работает с Реальным Субъектом, использу
    этот интерфейс, вы сможете передать ему заместителя вместо реального
    субъекта.
    """

    @abstractmethod
    def get_image_size(self) -> None:
        pass

    @abstractmethod
    def draw(self) -> None:
        pass


class RealSubject(Subject):
    """
    Реальный Субъект содержит некоторую базовую бизнес-логику. Как правило,
    Реальные Субъекты способны выполнять некоторую полезную работу, которая к
    тому же может быть очень медленной или точной – например, коррекция входных
    данных. Заместитель может решить эти задачи без каких-либо изменений в коде
    Реального Субъекта.
    """

    def get_image_size(self) -> None:
        print("RealSubject: get_image_size.")
        im = Image.open("TestImage.jpg")
        (width, height) = im.size
        print(f"Размер изображения: {width} {height}")

        return width, height

    @staticmethod
    def draw(width, height):
        master = Tk()
        im = Image.open("TestImage.jpg")
        w = Canvas(master, width=width*2, height=height*2)
        w.pack(expand=1)
        w.create_rectangle(0, 0, width, height, fill="black", outline='blue')
        master.mainloop()


class Proxy(Subject):
    """
    Интерфейс Заместителя идентичен интерфейсу Реального Субъекта.
    """

    def __init__(self, real_subject: RealSubject) -> None:
        self._real_subject = real_subject

    def get_image_size(self):
        """
        Наиболее распространёнными областями применения паттерна Заместитель
        являются ленивая загрузка, кэширование, контроль доступа, ведение
        журнала и т.д. Заместитель может выполнить одну из этих задач, а затем,
        в зависимости от результата, передать выполнение одноимённому методу в
        связанном объекте класса Реального Субъекта.
        """

        if self.check_access():
            self._real_subject.get_image_size()
            self.log_access()
            width, height = self._real_subject.get_image_size()
        return width, height

    def draw(self, width, height) -> None:
        if self.check_access():
            self._real_subject.draw(width, height)
            self.log_access()

    def check_access(self) -> bool:
        print("Proxy: Checking access prior to firing a real request.")
        return True

    def log_access(self) -> None:
        print("Proxy: Logging the time of request.", end="")


def client_code(subject: Subject) -> None:
    """
    Клиентский код должен работать со всеми объектами (как с реальными, так и
    заместителями) через интерфейс Субъекта, чтобы поддерживать как реальные
    субъекты, так и заместителей. В реальной жизни, однако, клиенты в основном
    работают с реальными субъектами напрямую. В этом случае, для более простой
    реализации паттерна, можно расширить заместителя из класса реального
    субъекта.
    """

    # ...

    width, height = subject.get_image_size()
    subject.draw(width, height)

    # ...


if __name__ == "__main__":

    print("Client: Executing the client code with a real subject:")
    real_subject = RealSubject()
    client_code(real_subject)

    print("")

    print("Client: Executing the same client code with a proxy:")
    proxy = Proxy(real_subject)
    # client_code(proxy)
