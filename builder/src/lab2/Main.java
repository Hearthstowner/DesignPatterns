package lab2;

public class Main {

    public static void main(String[] args) {

        var taxi = new TaxiBuilder().
                BoardDriver().
                BoardPassenger(new TaxiPassenger(true)).
                BoardPassenger(new TaxiPassenger(true)).
                BoardPassenger(new TaxiPassenger(true)).
                AddChildSeat().
                BoardPassenger(new TaxiPassenger(false)).
                GetTaxi();
        taxi.Run();


        var bus2 = new BusBuilder().
                BoardDriver().
                BoardPassenger(
                        new BusPassenger(BusPassengerType.ADULT),
                        new BusPassenger(BusPassengerType.ADULT),
                        new BusPassenger(BusPassengerType.ADULT)
                ).
                GetBus();
        System.out.println(bus2.GetOverallCost());

        var bus = new BusBuilder().
                BoardDriver().
                BoardPassenger(new BusPassenger(BusPassengerType.ADULT)).
                BoardPassenger(new BusPassenger(BusPassengerType.CHILD)).
                BoardPassenger(new BusPassenger(BusPassengerType.DISCOUNT)).
                GetBus();
        bus.Run();

        System.out.println(bus.GetOverallCost());
    }
}
