package lab2;

class BusBuilder implements Builder {
    private Bus _bus = null;

    BusBuilder() {
        _bus = new Bus();
    }

    @Override
    public void BoardDriver() {
        _bus.BoardDriver(new BusDriver("D"));
    }

    @Override
    public void BoardPassenger(Passenger passenger) {
        _bus.BoardPassenger((BusPassenger) passenger);
        _bus._overallCost += 100;

    }

    @Override
    public void BoardChildPassenger(Passenger passenger) {
        _bus.BoardPassenger((BusPassenger) passenger);
        _bus._overallCost += 50;
    }

    @Override
    public void BoardDiscountPassenger(Passenger passenger) {
        _bus.BoardPassenger((BusPassenger) passenger);
        _bus._overallCost += 25;
    }

    @Override
    public void AddChildSeat() {}

    Bus GetResult() {
        var old_taxi = _bus;
        _bus = null;
        return old_taxi;
    }
}
