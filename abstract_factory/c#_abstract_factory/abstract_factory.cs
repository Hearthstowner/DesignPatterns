using System;

namespace AbstractFactory
{
    public interface AbstractFactory
    {
        AbstractDriver CreateDriver();

        AbstractTransport CreateTransport();
    }

    class TaxiFactory : AbstractFactory
    {
        public AbstractDriver CreateDriver()
        {
            return new TaxiDriver();
        }

        public AbstractTransport CreateTransport()
        {
            return new Taxi();
        }
    }

    // Каждая Конкретная Фабрика имеет соответствующую вариацию продукта.
    class BusFactory : AbstractFactory
    {
        public AbstractDriver CreateDriver()
        {
            return new BusDriver();
        }
        public AbstractTransport CreateTransport()
        {
            return new Bus();
        }
    }
    public class AbstractDriver
    {
        public string drivers_license = null;
    }
    public class TaxiDriver : AbstractDriver
    {
        public TaxiDriver(){
            drivers_license = "B";
        }
    }
    public class BusDriver : AbstractDriver
    {
        public BusDriver(){
            drivers_license = "D";
        }
    }
    public interface AbstractTransport
    {
        void PutThePassenger(Passenger passenger);
        void PutTheDriver(AbstractDriver driver);
    }
    // Конкретные Продукты создаются соответствующими Конкретными Фабриками.
    class Bus : AbstractTransport
    {
        int capacity = 30;
        string drivers_license = "D";
        bool driver = false;
        public void PutThePassenger(Passenger passenger)
        {
            Console.WriteLine("Выполняется посадка пассажира");
            if (this.capacity > 0)
            {
                Console.WriteLine("Вместимость уменьшилась на 1");
                this.capacity -= 1;
                Console.WriteLine($"Осталось мест: {this.capacity}");
            }
            else
            {
                Console.WriteLine("Все места заняты");
            }
        }
        public void PutTheDriver(AbstractDriver driver)
        {
            Console.WriteLine("Выполняется посадка водителя");
            if ((this.driver == false) & (driver is BusDriver))
            {
                this.driver = true;
                Console.WriteLine("Водитель посажен");
            }
            else
            {
                Console.WriteLine("Место водителя занято");
            }
        }
    }
    class Taxi : AbstractTransport
    {
        int capacity = 4;
        string drivers_license = "B";
        bool driver = false;
        public void PutThePassenger(Passenger passenger)
        {
            Console.WriteLine("Выполняется посадка пассажира");
            if (this.capacity > 0)
            {
                Console.WriteLine("Вместимость уменьшилась на 1");
                this.capacity -= 1;
                Console.WriteLine($"Осталось мест: {this.capacity}");
            }
            else
            {
                Console.WriteLine("Все места заняты");
            }
        }
        public void PutTheDriver(AbstractDriver driver)
        {
            Console.WriteLine("Выполняется посадка водителя");
            if ((this.driver == false) & (driver is TaxiDriver))
            {
                this.driver = true;
                Console.WriteLine("Водитель посажен");
            }
            else
            {
                Console.WriteLine("Место водителя занято");
            }
        }

    }

    public class Passenger { }
    class Client
    {
        public void Main()
        {
            Console.WriteLine("Автобус");
            ClientMethod(new BusFactory());
            Console.WriteLine();
            Console.WriteLine("Теперь такси");
            ClientMethod(new TaxiFactory());
        }

        public void ClientMethod(AbstractFactory factory)
        {
            Passenger passenger1 = new Passenger();
            Passenger passenger2 = new Passenger();
            Passenger passenger3 = new Passenger();
            Passenger passenger4 = new Passenger();
            Passenger passenger5 = new Passenger();
            var transport = factory.CreateTransport();
            transport.PutThePassenger(passenger1);
            transport.PutThePassenger(passenger2);
            transport.PutThePassenger(passenger3);
            transport.PutThePassenger(passenger4);
            transport.PutThePassenger(passenger5);

            var driver = factory.CreateDriver();
            transport.PutTheDriver(driver);
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            new Client().Main();
        }
    }
}