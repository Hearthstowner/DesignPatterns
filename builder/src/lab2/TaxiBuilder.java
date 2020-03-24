package lab2;

public class TaxiBuilder implements Builder{
    private Taxi _taxi = null;

    TaxiBuilder() {
        _taxi = new Taxi();
    }

    @Override
    public void BoardDriver() {
        _taxi.BoardDriver(new TaxiDriver("B"));
    }

    @Override
    public void AddChildSeat() {
        _taxi.AddChildSit();
    }

    @Override
    public void BoardPassenger(Passenger passenger) {
        _taxi.BoardPassenger(passenger);
    }

    Taxi GetResult() {
        var old_taxi = _taxi;
        _taxi = null;
        return old_taxi;
    }

    @Override
    public void BoardChildPassenger(Passenger passenger) {
        _taxi.BoardChildPassenger(passenger);
    }

    @Override
    public void BoardDiscountPassenger(Passenger passenger) {}
}
