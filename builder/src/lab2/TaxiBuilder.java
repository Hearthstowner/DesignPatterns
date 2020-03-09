package lab2;

public class TaxiBuilder {
    public AbstractCar taxi;
    private Taxi _taxi = null;

    TaxiBuilder() {
        _taxi = new Taxi();
    }

    public TaxiBuilder Taxi() {
        return this;
    }

    TaxiBuilder BoardDriver() {
        _taxi.BoardDriver(new TaxiDriver());
        return this;
    }

    TaxiBuilder BoardPassenger(TaxiPassenger passenger) {
        _taxi.BoardPassenger(passenger);
        return this;
    }

    public TaxiBuilder BoardPassenger(Iterable<TaxiPassenger> passengers) {
        for (var passenger : passengers
        ) {
            _taxi.BoardPassenger(passenger);
        }
        return this;
    }

    TaxiBuilder AddChildSeat() {
        _taxi.AddChildSit();
        return this;
    }

    Taxi GetTaxi() {
        var old_taxi = _taxi;
        _taxi = null;
        return old_taxi;
    }
}
