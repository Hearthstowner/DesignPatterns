package lab2;

public class Main {

    public static void main(String[] args) {

        var taxi_builder = new TaxiBuilder();
        taxi_builder.BoardDriver();
        taxi_builder.BoardPassenger(new TaxiPassenger(true));
        taxi_builder.BoardPassenger(new TaxiPassenger(true));
        taxi_builder.BoardPassenger(new TaxiPassenger(true));
        taxi_builder.AddChildSeat();
        taxi_builder.BoardPassenger(new TaxiPassenger(false));
        var taxi = taxi_builder.GetResult();
        taxi.Run();

        var bus_builder = new BusBuilder();
        bus_builder.BoardDriver();
        bus_builder.BoardPassenger(new BusPassenger(BusPassengerType.ADULT));
        bus_builder.BoardPassenger(new BusPassenger(BusPassengerType.CHILD));
        bus_builder.BoardPassenger(new BusPassenger(BusPassengerType.DISCOUNT));
        var bus = bus_builder.GetResult();
        bus.Run();

        System.out.println(bus.GetOverallCost());
    }
}
