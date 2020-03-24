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
        switch (((BusPassenger) passenger).GetBusPassengerType()){
            case ADULT:
                _bus._overallCost += 100;
                break;
            case CHILD:
                _bus._overallCost += 50;
                break;
            case DISCOUNT:
                _bus._overallCost += 25;
                break;
        }
    }

    @Override
    public void AddChildSeat() {}

    public Bus GetResult() {
        var old_taxi = _bus;
        _bus = null;
        return old_taxi;
    }
}
