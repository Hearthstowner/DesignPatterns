package lab2;

public class Main {

    public static void main(String[] args) {

        var taxi_builder = new TaxiBuilder();
        taxi_builder.BoardDriver();
        taxi_builder.BoardPassenger(new Passenger());
        taxi_builder.BoardPassenger(new Passenger());
        taxi_builder.BoardPassenger(new Passenger());
//        taxi_builder.AddChildSeat();
        taxi_builder.BoardChildPassenger(new Passenger());
        var taxi = taxi_builder.GetResult();
        taxi.Run();

        var bus_builder = new BusBuilder();
        bus_builder.BoardDriver();
        bus_builder.BoardPassenger(new Passenger());
        bus_builder.BoardChildPassenger(new Passenger());
        bus_builder.BoardDiscountPassenger(new Passenger());
        var bus = bus_builder.GetResult();
        bus.Run();

        System.out.println(bus.GetOverallCost());
    }
}
